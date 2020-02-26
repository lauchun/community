package com.lau.community.service;

import com.lau.community.dto.GithubUser;
import com.lau.community.model.User;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-26
 * @description ：
 * @version: 1.0
 */
public interface UserService {

    User findByAccountId(Integer id);

    void createOrUpdate(User user, String token, GithubUser githubUser, HttpServletResponse response);
}
