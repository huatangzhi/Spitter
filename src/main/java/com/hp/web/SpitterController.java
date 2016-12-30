package com.hp.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import com.hp.entity.SpitterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hp.entity.Spitter;
import com.hp.dao.SpitterRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new SpitterForm());
        return "registerForm";
    }

//  @RequestMapping(value="/register", method=POST)
//  public String processRegistration(
//      @RequestPart(value="profilePictures", required=false) Part fileBytes,
//      RedirectAttributes redirectAttributes,
//      @Valid Spitter spitter,
//      Errors errors) throws IOException {
//    if (errors.hasErrors()) {
//      return "registerForm";
//    }
//
//    spitterRepository.save(spitter);
//    redirectAttributes.addAttribute("username", spitter.getUsername());
//    redirectAttributes.addFlashAttribute(spitter);
//    return "redirect:/spitter/" + spitter.getUsername();
//  }

    @RequestMapping(value="/register", method=POST)
    public String processRegistration(
            @Valid SpitterForm spitterForm,
            Errors errors) throws IllegalStateException, IOException{

        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);
        MultipartFile profilePicture = spitterForm.getProfilePicture();
        File a = new File("/Users/hp/spittr/" + spitter.getUsername() + ".jpg");
        profilePicture.transferTo(a);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value="/{username}", method=GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        if (!model.containsAttribute("spitter")) {
            model.addAttribute(
                    spitterRepository.findByUsername(username));
        }
        return "profile";
    }

}
