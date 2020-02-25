package com.lau.community.service;

import com.lau.community.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-25
 * @description ：
 * @version: 1.0
 */
public interface QuestionService {
    List<QuestionDTO> list();
}
