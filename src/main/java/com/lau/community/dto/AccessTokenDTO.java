package com.lau.community.dto;

import lombok.Data;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-24
 * @description ：
 * @version: 1.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
