package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.MybatisUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Select("select * from user where name=#{name}")
    MybatisUser findByName(@Param("name")String name);

    @Insert("INSERT INTO USER(NAME,AGE) VALUES(#{name},#{age})")
    int insert(@Param("name")String name,@Param("age")String age);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insertByUser(MybatisUser user);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<MybatisUser> findAll();
}
