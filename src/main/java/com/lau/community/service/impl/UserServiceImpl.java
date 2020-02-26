package com.lau.community.service.impl;

import com.lau.community.dto.GithubUser;
import com.lau.community.mapper.UserMapper;
import com.lau.community.model.User;
import com.lau.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-26
 * @description ：
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByAccountId(Integer id) {
        userMapper.findByAccountId(id);
        return null;
    }

    @Override
    public void createOrUpdate(User user, String token, GithubUser githubUser, HttpServletResponse response) {
        if (user == null) {
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(githubUser.getId());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userMapper.insert(user);
            response.addCookie(new Cookie("token", token));
        } else {
            user.setToken(token);
            userMapper.update(user);
            response.addCookie(new Cookie("token", token));
        }
    }
}
