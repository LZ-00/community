package com.community.controller;

import com.community.entity.Question;
import com.community.entity.User;
import com.community.service.impl.QuestionServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 乐。
 */
@Controller
public class ProfileController {

    @Autowired
    QuestionServiceImpl questionServiceImpl;

    @GetMapping("/profile/{action}")
    public String profileDeal(@PathVariable("action") String action,
                              @RequestParam(value = "page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "5") Integer size,
                              HttpServletRequest request,Model model){

        if("questions".equals(action)){

            User user = (User) request.getSession().getAttribute("user");
            if(user == null){
                return "redirect:/";
            }
            PageInfo<Question> pageInfo = questionServiceImpl.listPagingById(user.getId(), page, size);

            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");

        }else if("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","问题回复");
        }
        return "profile";

    }

}
