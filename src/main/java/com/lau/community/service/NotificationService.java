package com.lau.community.service;

import com.lau.community.dto.NotificationDTO;
import com.lau.community.dto.PaginationDTO;
import com.lau.community.model.User;

/**
 * @author ：lauchun
 * @date ：Created in 2020-03-14
 * @description ：
 * @version: 1.0
 */
public interface NotificationService {
    PaginationDTO list(Long id, Integer page, Integer size);

    Long unreadCount(Long accountId);

    NotificationDTO read(Long id, User user);
}
