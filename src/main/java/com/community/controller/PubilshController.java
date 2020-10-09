package com.community.controller;

import com.community.entity.Question;
import com.community.entity.User;
import com.community.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PubilshController {

    @Autowired
    QuestionServiceImpl questionServiceImpl;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        model.addAttribute("id",id);
        model.addAttribute("question",new Question());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(Model model){
        model.addAttribute("question",new Question());
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(Question question, HttpServletRequest request, Model model,
                            @RequestParam(value = "id",required = false) Integer id){

        model.addAttribute("question",question);

        String title = question.getTitle();
        String description = question.getDescription();
        String tag = question.getTag();
        if(title == null || title.equals("")){
            model.addAttribute("error","title empty");
            return "publish";
        }
        if(description == null || description.equals("")){
            model.addAttribute("error","description empty");
            return "publish";
        }
        if(tag == null || tag.equals("")){
            model.addAttribute("error","tag empty");
            return "publish";
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("error","用户未登录，请先登录！");
            return "publish";
        }

        question.setId(id);
        question.setCreator(user.getId());


        questionServiceImpl.insertOrUpdate(question);

        return "redirect:/";

    }

}
