package org.mickael.controllers;

import org.mickael.business.contract.manager.MemberManager;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Controller
public class MemberController {

    @Inject
    MemberManager memberManager;

    @RequestMapping("/")
    public String display(){
        return "index";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView sayHello(){
        String now =(new Date()).toString();

        return new ModelAndView("hello", "now", now);
    }

    @RequestMapping(value = "/memberList", method = RequestMethod.GET)
    public ModelAndView memberList(){
        List<Member> members = memberManager.findAllMember();
        return new ModelAndView("memberList", "members", members);
    }
}
