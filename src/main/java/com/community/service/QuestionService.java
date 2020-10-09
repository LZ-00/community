package com.community.service;

import com.community.entity.Question;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface QuestionService {

    /**
     * @param question 要插入的list
     */
    void insertQuestion(Question question);

    /**
     *  实现分页功能
     * @return 返回所有的question
     * @param offset
     * @param size
     */
    List<Question> listQuestion(Integer offset, Integer size);

    /**
     * 获取总记录数
     * @return
     */
    Integer getTotalCount();

    /**
     * 查询所有的question
     * @return
     */
    List<Question> list();

    /**
     * 分页查询question
     * @param page
     * @param size
     * @return
     */
    PageInfo<Question> listPaging(Integer page, Integer size);

    /**
     * 分页查询外加id约束
     * @param id
     * @param page
     * @param size
     * @return
     */
    PageInfo<Question> listPagingById(Integer id,Integer page,Integer size);

    /**
     * 根据id查询question
     * @return question
     */
    Question getById(Integer id);

    void insertOrUpdate(Question question);
}
