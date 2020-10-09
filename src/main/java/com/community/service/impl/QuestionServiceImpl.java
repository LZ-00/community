package com.community.service.impl;

import com.community.dao.QuestionMapper;
import com.community.entity.Question;
import com.community.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Transactional
    @Override
    public void insertQuestion(Question question) {
        questionMapper.insert(question);
    }

    @Override
    public List<Question> listQuestion(Integer offset, Integer size) {
        return questionMapper.listQuestion(offset,size);
    }

    @Override
    public Integer getTotalCount() {
        return questionMapper.getTotalCount();
    }

    @Override
    public List<Question> list() {
        return questionMapper.list();
    }

    @Override
    public PageInfo<Question> listPaging(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<Question> questions = list();
        PageInfo<Question> pageInfo = new PageInfo<>(questions,3);
        return pageInfo;
    }

    @Override
    public PageInfo<Question> listPagingById(Integer id,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<Question> questions = listByUserId(id);
        PageInfo<Question> pageInfo = new PageInfo<>(questions,3);
        return pageInfo;
    }

    @Override
    public Question getById(Integer id) {
        Question question = questionMapper.getById(id);
        System.out.println(question);
        return question;
    }

    @Override
    public void insertOrUpdate(Question question) {
        Integer id = question.getId();
        if(id!=null){
            //update
            question.setGmtModified(System.currentTimeMillis());
            questionMapper.update(question);
        }else{
            //insert
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            insertQuestion(question);
        }
    }

    private List<Question> listByUserId(Integer id) {
        return questionMapper.listByUserId(id);
    }


}
