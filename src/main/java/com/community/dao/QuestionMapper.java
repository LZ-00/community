package com.community.dao;

import com.community.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    /**
     * 插入一条记录question
     * @param question
     */
    void insert(Question question);


    /**
     * 自定义分页查询question
     * @return 返回所有的question
     * @param offset
     * @param size
     */
    List<Question> listQuestion(@Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question")
    Integer getTotalCount();

    /**
     * 使用pageHelper实现分页功能
     * @return
     */
    List<Question> list();

    /**
     * 根据用户id查询question
     * @param id
     * @return
     */
    List<Question> listByUserId(@Param("id") Integer id);

    /**
     * 根据id查询question
     * @param id
     * @return
     */
    Question getById(Integer id);

    /**
     * 根据id更新question
     * @param question
     */
    void update(Question question);
}
