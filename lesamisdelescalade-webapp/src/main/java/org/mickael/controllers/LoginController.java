package org.mickael.controllers;

import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.business.contract.manager.MemberManager;
import org.mickael.business.contract.manager.PasswordManager;
import org.mickael.model.bean.ClimbingArea;
import org.mickael.model.bean.LoginCommand;
import org.mickael.model.bean.Member;
import org.mickael.model.enumeration.Role;
import org.mickael.model.exceptions.MemberBlockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@SessionAttributes("memberInSession")
public class LoginController {

    @Inject
    private MemberManager memberManager;

    @Inject
    private PasswordManager passwordManager;

    @Inject
    private ClimbingAreaManager climbingAreaManager;

    private void addMemberInSession(Member member, HttpSession httpSession) {
        httpSession.setAttribute("memberInSession", member);
        httpSession.setAttribute("memberId", member.getId());
        httpSession.setAttribute("role", member.getRole());
    }

   /** @ModelAttribute("member")
    public Member setUpMemberForm(){
        return new Member();
    }*/

    @GetMapping("/doLogin")
    public String showLoginForm(/**@SessionAttribute(value = "memberInSession", required = false) Member memberInSession*/ Model model){
        //test session
        model.addAttribute("loginCommand", new LoginCommand());
        return "login";
    }

    @PostMapping("/loginProcess")
    public String doLogin(/**@ModelAttribute("member")Member memberInSession, WebRequest webRequest, SessionStatus sessionStatus,*/ @ModelAttribute("loginCommand") LoginCommand loginCommand, HttpSession httpSession, Model model) throws MemberBlockedException {
       /** //variable
        boolean checkPassword = false;

        //Objet
        Member memberBdd = new Member();
        System.out.println("memberInSession: " + memberInSession.toString());
        System.out.println("memberBdd: " + memberBdd.toString());

        //method to obtain the member in bdd
        if (memberInSession != null) {

            memberBdd = memberManager.findMemberByPseudo(memberInSession.getEmail());
            System.out.println("memberInSession: " + memberInSession.toString());
            System.out.println("memberBdd: " + memberBdd.toString());

            //Member not recognize on bdd
            if (memberBdd == null) {
                // for fix bug after deleting user (go to error page and clic home (old user is log)
                sessionStatus.setComplete();
                webRequest.removeAttribute("memberInSession", WebRequest.SCOPE_SESSION);
                return "_error/errorLogin";
            }
            //method for check if password is good
            checkPassword = passwordManager.matches(memberInSession.getPassword(), memberBdd.getPassword());
            System.out.println(checkPassword);

            if (checkPassword) {
                //populate memberInSession attributes
                memberInSession.setId(memberBdd.getId());
                memberInSession.setPseudo(memberBdd.getPseudo());
                model.addAttribute("memberInSession", memberInSession);
                System.out.println(memberInSession.toString());
            } else {
                sessionStatus.setComplete();
                webRequest.removeAttribute("memberInSession", WebRequest.SCOPE_SESSION);
                return "_error/errorLogin";
            }

        }
        //for display climbing site
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingArea();
        model.addAttribute("climbingAreaList", climbingAreaList);
        return "home";*/

       //test session
        if (loginCommand != null){
            Member memberInBdd = memberManager.findMemberByEmail(loginCommand.getEmail());
            boolean checkPassword = false;

            if (memberInBdd == null) {
                httpSession.invalidate();
                return "_error/errorLogin";
            }
            checkPassword = passwordManager.matches(loginCommand.getPassword(), memberInBdd.getPassword());
            if (checkPassword == true) {
                Member loggedInMember = memberInBdd;
                if (loggedInMember.getRole().equals(Role.ADMIN.getParam()) || loggedInMember.getRole().equals(Role.MEMBER.getParam()) || loggedInMember.getRole().equals(Role.USER.getParam())){
                    addMemberInSession(loggedInMember, httpSession);
                    return "redirect:home";
                } else {
                    MemberBlockedException memberBlockedException = new MemberBlockedException("Invalid Member Role");
                    model.addAttribute("errorMessage", memberBlockedException);
                    return "login";
                }
            } else {
                httpSession.invalidate();
                return "_error/errorLogin";
            }
        }
        //for display climbing site
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingArea();
        model.addAttribute("climbingAreaList", climbingAreaList);
        return "home";
    }

    @GetMapping("/doLogout")
    public String doLogout(@SessionAttribute("memberInSession") Member memberInSession, HttpSession httpSession, HttpServletResponse response, Model model){

        httpSession.invalidate();
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.setHeader("Progma","no-cache");
        response.setDateHeader("Expires",0);
        if (memberInSession == null){
            model.addAttribute("memberInSession", new Member());
            return "redirect:doLogin";
        }

        model.addAttribute("climbingArea", climbingAreaManager.findAllClimbingArea());
        return "redirect:home";
    }


}
