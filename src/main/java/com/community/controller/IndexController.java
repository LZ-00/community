package com.community.controller;

import com.community.entity.Question;
import com.community.service.impl.QuestionServiceImpl;
import com.community.service.impl.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    QuestionServiceImpl questionServiceImpl;
    @GetMapping("/")
    public String index(@RequestParam(value = "page",defaultValue = "1") Integer page,
                        @RequestParam(value = "size",defaultValue = "2") Integer size,
                        HttpServletRequest request,
                        Model model){

        /*Pagination pagination = new Pagination();
        Integer totalCount = questionServiceImpl.getTotalCount();

        pagination.setPagination(page,size,totalCount);

        page = page<1 ? 1 : page;
        page = page>pagination.getTotalPage() ? pagination.getTotalPage() : page;
        Integer offset = size*(page-1);
        List<Question> questions = questionServiceImpl.listQuestion(offset,size);

        pagination.setQuestions(questions);
        model.addAttribute("pagination",pagination);
        return "index";*/
        //


        PageInfo<Question> pageInfo = questionServiceImpl.listPaging(page, size);
        model.addAttribute("pageInfo",pageInfo);
        return "index";

    }
}
