package com.lau.community.controller;

import com.lau.community.model.User;
import lombok.Data;

/**
 * @author ：lauchun
 * @date ：Created in 2020-03-12
 * @description ：
 * @version: 1.0
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
