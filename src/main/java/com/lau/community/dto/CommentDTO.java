package com.lau.community.dto;

import lombok.Data;

/**
 * @author ：lauchun
 * @date ：Created in 2020-03-03
 * @description ：
 * @version: 1.0
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
