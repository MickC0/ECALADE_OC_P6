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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Inject
    private MemberManager memberManager;

    @Inject
    private PasswordManager passwordManager;

    @Inject
    private ClimbingAreaManager climbingAreaManager;

    private void addMemberInSession(Member member, HttpSession httpSession) {
        //httpSession.setAttribute("memberInSession", member);
        httpSession.setAttribute("memberInSessionId", member.getId());
        httpSession.setAttribute("memberInSessionPseudo", member.getPseudo());
        httpSession.setAttribute("memberInSessionEmail", member.getEmail());
        httpSession.setAttribute("memberInSessionRole", member.getRole());
    }

    @GetMapping("/doLogin")
    public String showLoginForm(Model model){
        //test session
        model.addAttribute("loginCommand", new LoginCommand());
        return "login";
    }

    @PostMapping("/loginProcess")
    public String doLogin(@ModelAttribute("loginCommand") LoginCommand loginCommand, HttpSession httpSession, Model model) throws MemberBlockedException {


       //test session
        if (loginCommand != null){
            Member memberInBdd = memberManager.findMemberByProperty("email", loginCommand.getEmail());
            boolean checkPassword = false;

            if (memberInBdd == null) {
                httpSession.invalidate();
                model.addAttribute("errorMessage", "Enter valid credentials");
                return "login";
            }
            checkPassword = passwordManager.matches(loginCommand.getPassword(), memberInBdd.getPassword());
            if (checkPassword == true) {
                Member loggedInMember = memberInBdd;
                if (loggedInMember.getRole().equals(Role.ADMIN.getParam()) || loggedInMember.getRole().equals(Role.MEMBER.getParam()) || loggedInMember.getRole().equals(Role.USER.getParam())){
                    addMemberInSession(loggedInMember, httpSession);
                    //model.addAttribute("memberInSessionId", loggedInMember.getId());
                    return "redirect:/showHome";
                } else {
                    MemberBlockedException memberBlockedException = new MemberBlockedException("Invalid Member Role");
                    model.addAttribute("errorMessage", memberBlockedException);
                    System.out.println("etape 3");
                    return "login";
                }
            } else {
                httpSession.invalidate();
                model.addAttribute("errorMessage", "Enter valid credentials");
                return "login";
            }
        }
        //for display climbing site
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingArea();
        model.addAttribute("climbingAreaList", climbingAreaList);
        return "redirect:/showHome";
    }

    @PostMapping("/doLogout")
    public String doLogout(HttpServletResponse httpServletResponse, HttpSession httpSession, WebRequest webRequest, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        webRequest.removeAttribute("memberInSessionId", WebRequest.SCOPE_SESSION);
        webRequest.removeAttribute("memberInSessionPseudo", WebRequest.SCOPE_SESSION);
        webRequest.removeAttribute("memberInSessionEmail", WebRequest.SCOPE_SESSION);
        webRequest.removeAttribute("memberInSessionRole", WebRequest.SCOPE_SESSION);
        httpServletResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        httpServletResponse.setHeader("Pragma","no-cache");
        httpServletResponse.setHeader("Expires","0");
        httpSession.invalidate();
        return "redirect:/showHome";
    }


}
