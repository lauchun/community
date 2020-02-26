package com.lau.community.mapper;

import com.lau.community.dto.QuestionDTO;
import com.lau.community.model.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-25
 * @description ：
 * @version: 1.0
 */
@Mapper
@Repository
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title}," +
            "#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator = #{accountId} limit #{offset},#{size}")
    List<Question> listByAccountId(@Param(value = "accountId") Integer accountId,
                        @Param(value = "offset") Integer offset,
                        @Param(value = "size") Integer size);

    @Select("select count(1) from question where creator = #{accountId}")
    Integer countByAccountId(@Param(value = "accountId") Integer accountId);

    @Select("select * from question where id = #{id}")
    Question findById(@Param("id") Integer id);

    @Update("update question set title = #{title}, description = #{description}, gmt_modified = #{gmtModified}, tag = #{tag} where id = #{id}")
    void update(Question question);
}
