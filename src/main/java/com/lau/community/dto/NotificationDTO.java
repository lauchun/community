package com.lau.community.dto;

import com.lau.community.model.User;
import lombok.Data;

/**
 * @author ：lauchun
 * @date ：Created in 2020-03-14
 * @description ：
 * @version: 1.0
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
