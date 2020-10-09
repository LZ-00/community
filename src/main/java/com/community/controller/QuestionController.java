package com.community.controller;

import com.community.entity.Question;
import com.community.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionServiceImpl;
    @GetMapping("/question/{id}")
    public String question(@PathVariable("id")Integer id, Model model){

        Question question = questionServiceImpl.getById(id);

        model.addAttribute("question",question);
        System.out.println(question.getCreator()+"creator");
        return "question";
    }

}
