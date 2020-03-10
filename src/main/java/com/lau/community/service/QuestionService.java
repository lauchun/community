package com.lau.community.service;

import com.lau.community.dto.PaginationDTO;
import com.lau.community.dto.QuestionDTO;
import com.lau.community.model.Question;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-25
 * @description ：
 * @version: 1.0
 */
public interface QuestionService {
    PaginationDTO list(Integer page, Integer size);

    PaginationDTO list(Integer id, Integer page, Integer size);

    QuestionDTO findById(Long id);

    void createOrUpdate(Question question);

    void incView(Long id);
}
