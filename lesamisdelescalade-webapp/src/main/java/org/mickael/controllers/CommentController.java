package org.mickael.controllers;

import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.business.contract.manager.CommentManager;
import org.mickael.business.contract.manager.MemberManager;
import org.mickael.model.bean.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.validation.Valid;
import java.sql.Timestamp;



@Controller
public class CommentController {

    @Inject
    private ClimbingAreaManager climbingAreaManager;


    @Inject
    private MemberManager memberManager;


    @Inject
    private CommentManager commentManager;



    /** ======== Comments ======== */


    @GetMapping("/createNewComment/{climbId}")
    public String createNewComment(@PathVariable Integer climbId, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            Comment comment = new Comment();
            model.addAttribute("comment", comment);
            model.addAttribute("climbId", climbId);
            return "commentForm";

        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/createNewComment/saveCommentProcess/{climbId}")
    public String saveComment(@PathVariable Integer climbId, Model model,@Valid Comment comment, BindingResult bindingResult,
                              @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){

        if (memberInSessionId != null){
            if (bindingResult.hasErrors()){
                model.addAttribute("errorMessage", "Une erreur est survenue. Vérifiez les champs.");

                return "commentForm";
            } else {
                comment.setClimbingArea(climbingAreaManager.findClimbingArea(climbId));
                comment.setMember(memberManager.findMember(memberInSessionId));
                comment.setCreationDate (new Timestamp(System.currentTimeMillis()));
                commentManager.createComment(comment);
                model.addAttribute("climbId", climbId);
                return "redirect:/climbingArea/{climbId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/updateComment/{id}")
    public String updateComment(Model model, @PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId != null){

            Comment commentToUpdate = commentManager.findCommentById(id);
            model.addAttribute("memberInSessionId", memberInSessionId);
            model.addAttribute("commentToUpdate", commentToUpdate);
            return "updateCommentForm";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/updateComment/updatingCommentProcess/{id}")
    public String updatingComment(@Valid Comment comment, @PathVariable Integer id, Model model, BindingResult bindingResult, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId != null){
            if (bindingResult.hasErrors()){
                model.addAttribute("memberInSessionId", memberInSessionId);
                model.addAttribute("commentToUpdate", commentManager.findCommentById(id));
                return  "updateCommentForm";
            } else {
                model.addAttribute("climbId", commentManager.findCommentById(id).getClimbingArea().getId());
                model.addAttribute("memberInSessionId", memberInSessionId);
                comment.setUpdateDate (new Timestamp(System.currentTimeMillis()));
                commentManager.updateComment(comment);
                return "redirect:/climbingArea/{climbId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            model.addAttribute("climbId", commentManager.findCommentById(id).getClimbingArea().getId());
            model.addAttribute("memberInSessionId", memberInSessionId);
            commentManager.deleteComment(id);
            return "redirect:/climbingArea/{climbId}";
        } else {
            return "redirect:/doLogin";
        }
    }


}
