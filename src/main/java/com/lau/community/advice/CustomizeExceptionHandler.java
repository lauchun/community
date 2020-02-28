package com.lau.community.advice;

import com.lau.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.CEFormatException;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-28
 * @description ：
 * @version: 1.0
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model) {
        if (e instanceof CustomizeException) {
            model.addAttribute("message", e.getMessage());
        } else {
            model.addAttribute("message", "服务器炸了");
        }
        return new ModelAndView("error");
    }

}
