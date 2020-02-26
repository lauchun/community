package com.lau.community.service.impl;

import com.lau.community.dto.GithubUser;
import com.lau.community.mapper.UserMapper;
import com.lau.community.model.User;
import com.lau.community.model.UserExample;
import com.lau.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(id);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() != 0) {
            return users.get(0);
        }
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
            UserExample userExample = new UserExample();
            userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
            userMapper.updateByExampleSelective(user,userExample);
            response.addCookie(new Cookie("token", token));
        }
    }
}
