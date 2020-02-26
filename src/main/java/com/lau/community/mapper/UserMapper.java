package com.lau.community.mapper;

import com.lau.community.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-24
 * @description ：
 * @version: 1.0
 */
@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values(#{name},#{accountId}," +
            "#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") Integer accountId);

    @Update("update user set token = #{token} where id = #{id}")
    void update(User user);
}
