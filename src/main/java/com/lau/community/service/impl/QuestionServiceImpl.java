package com.lau.community.service.impl;

import com.lau.community.dto.PaginationDTO;
import com.lau.community.dto.QuestionDTO;
import com.lau.community.mapper.QuestionMapper;
import com.lau.community.mapper.UserMapper;
import com.lau.community.model.Question;
import com.lau.community.model.QuestionExample;
import com.lau.community.model.User;
import com.lau.community.model.UserExample;
import com.lau.community.service.QuestionService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-25
 * @description ：
 * @version: 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage, page);

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(new QuestionExample(),
                new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andAccountIdEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size() != 0) {
                QuestionDTO questionDTO = new QuestionDTO();
                BeanUtils.copyProperties(question, questionDTO);
                questionDTO.setUser(users.get(0));
                questionDTOList.add(questionDTO);
            }
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    @Override
    public PaginationDTO list(Integer accountId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andCreatorEqualTo(accountId);
        Integer totalCount = (int) questionMapper.countByExample(questionExample);

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage, page);

        Integer offset = size * (page - 1);
        QuestionExample example = new QuestionExample();
        example.createCriteria().andCreatorEqualTo(accountId);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(example,
                new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andAccountIdEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size() != 0) {
                QuestionDTO questionDTO = new QuestionDTO();
                BeanUtils.copyProperties(question, questionDTO);
                questionDTO.setUser(users.get(0));
                questionDTOList.add(questionDTO);
            }
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    @Override
    public QuestionDTO findById(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(question.getCreator());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() != 0) {
            questionDTO.setUser(users.get(0));
        }
        return questionDTO;
    }

    @Override
    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        } else {
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            QuestionExample example = new QuestionExample();
            example.createCriteria().andIdEqualTo(question.getId());
            questionMapper.updateByExampleSelective(updateQuestion, example);
        }
    }
}
