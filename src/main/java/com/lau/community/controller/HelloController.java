package com.lau.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-24
 * @description ：
 * @version: 1.0
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name")String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
