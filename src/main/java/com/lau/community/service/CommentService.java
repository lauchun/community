package com.lau.community.service;

import com.lau.community.controller.CommentDTO;
import com.lau.community.enums.CommentTypeEnum;
import com.lau.community.model.Comment;
import com.lau.community.model.User;

import java.util.List;

/**
 * @author ：lauchun
 * @date ：Created in 2020-03-03
 * @description ：
 * @version: 1.0
 */
public interface CommentService {

    void insert(Comment comment, User user);

    List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type);
}
