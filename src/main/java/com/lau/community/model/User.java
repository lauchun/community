package com.lau.community.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-24
 * @description ：
 * @version: 1.0
 */
@Repository
@Data
public class User {
    private Integer id;
    private String name;
    private Integer accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
