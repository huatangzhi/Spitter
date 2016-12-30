package com.hp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hp on 2016/12/23.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle not found")
public class SpittleNotFoundException extends RuntimeException{
}
