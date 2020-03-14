package com.lau.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：lauchun
 * @date ：Created in 2020-03-13
 * @description ：
 * @version: 1.0
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
