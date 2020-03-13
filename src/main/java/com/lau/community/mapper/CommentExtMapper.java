package com.lau.community.mapper;

import com.lau.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}