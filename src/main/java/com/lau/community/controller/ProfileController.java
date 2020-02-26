package com.lau.community.controller;

import com.lau.community.dto.PaginationDTO;
import com.lau.community.mapper.UserMapper;
import com.lau.community.model.User;
import com.lau.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-25
 * @description ：
 * @version: 1.0
 */
@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private User user;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          HttpServletRequest request,
                          Model model,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "2") Integer size) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "伟大言论");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "上奏");
        }

        PaginationDTO pagination = questionService.list(user.getAccountId(), page, size);
        model.addAttribute("pagination", pagination);
        return "profile";
    }
}