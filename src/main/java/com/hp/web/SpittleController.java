package com.hp.web;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.hp.dao.SpittleRepository;
import com.hp.entity.Spittle;
import com.hp.exception.DuplicateSpittleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    public static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm spittleForm, Model model) {
        try{
            spittleRepository.save(new Spittle(null, spittleForm.getMessage(), new Timestamp(System.currentTimeMillis()), spittleForm.getLatitude(), spittleForm.getLatitude()));
            return "redirect:/spittles";
        }
        catch (DuplicateSpittleException e) {
            return "error/dupicate";
        }
    }

    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleNotFound() {
        return "error/duplicate";
    }

}
