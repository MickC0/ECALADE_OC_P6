package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.model.bean.ClimbingArea;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
public class TestController {

    //Injection des Managers
    @Inject
    ClimbingAreaManager climbingAreaManager;

    @Inject
    CommentManager commentManager;

    @Inject
    GuidebookManager guidebookManager;

    @Inject
    MemberManager memberManager;

    @Inject
    ParkingManager parkingManager;

    @Inject
    PasswordManager passwordManager;

    @Inject
    PhotoManager photoManager;

    @Inject
    ReservationRequestManager reservationRequestManager;

    @Inject
    RouteManager routeManager;

    @Inject
    SectorManager sectorManager;

    @Inject
    StartingPointManager startingPointManager;



    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
    //Modifier l'objet à tester
    @GetMapping("/testaddform")
    public String showform(Model m){
        m.addAttribute("command", new ClimbingArea() /*new Comment()*/ /*new Guidebook()*/ /*new Member()*/ /*new Parking()*/ /*new Photo()*/ /*new ReservationRequest()*/ /*new Route()*/ /*new Sector()*/ /*new StartingPoint()*/);
        return "testaddform";
    }
    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/

    //Modifier l'objet à créer.
    @PostMapping(value="/save")
    public String save(@RequestParam("param") Member member, @ModelAttribute("emp") /**à changer*/ClimbingArea emp){
        //Pour les membres
        /**String hashPassword = passwordManager.hashPassword(emp.getPassword());
         emp.setPassword(hashPassword);
         emp.setAdmin(false);
         emp.setMember(false);
         memberManager.createMember(emp);*/

        //pour le reste
        member = memberManager.findMember(1);
        emp.setMember(member);
        climbingAreaManager.createClimbingArea(emp);
        //commentManager.createComment(emp);
        //guidebookManager.createGuidebook(emp);
        //parkingManager.createParking(emp);
        //photoManager.createPhoto(emp);
        //reservationRequestManager.createReservationRequest(emp);
        //routeManager.createRoute(emp);
        //sectorManager.createSector(emp);
        //startingPointManager.createStartingPoint(emp);

        return "redirect:/testlist";//will redirect to viewemp request mapping  
    }
    /* It provides list of employees in model object */
    @RequestMapping("/testlist")
    public String viewemp(Model m){
        List<ClimbingArea> list= climbingAreaManager.findAllClimbingArea();
        //List<Comment> list= commentManager.findAllComment();
        //List<Guidebook> list= guidebookManager.findAllGuidebook();
        //List<Member> list= memberManager.findAllMember();
        //List<Parking> list= parkingManager.findAllParking();
        //List<Photo> list= photoManager.findAllPhoto();
        //List<ReservationRequest> list= reservationRequestManager.findAllReservationRequest();
        //List<Route> list= routeManager.findAllRoute();
        //List<Sector> list= sectorManager.findAllSector();
        //List<StartingPoint> list= startingPointManager.findStartingPoint();

        m.addAttribute("list",list);
        return "testlist";
    }
    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value="/testedit/{id}")
    public String edit(@PathVariable int id, Model m){
        //Member emp = memberManager.findMember(id);
        ClimbingArea emp = climbingAreaManager.findClimbingArea(id);
        //A voir
        //Comment comment = commentManager.f(id);
        //Guidebook emp = guidebookManager.findGuidebook(id);
        //Parking emp = parkingManager.findParking(id);
        //Photo emp = photoManager.findPhoto(id);
        //A voir
        //ReservationRequest emp = reservationRequestManager.findReservationRequestByGuidebookId(id);
        //Route emp = routeManager.findRoute(id);
        //Sector emp = sectorManager.findSector(id);
        //StartingPoint emp = startingPointManager.findStartingPoint(id);
        m.addAttribute("command", emp);
        return "testeditform";
    }
    /* It updates model object. */
    @PostMapping(value="/editsave")
    public String editsave(@ModelAttribute("emp") /**à changer*/ClimbingArea emp){
        //Pour les membres
        /**String hashPassword = passwordManager.hashPassword(emp.getPassword());
         emp.setPassword(hashPassword);
         emp.setAdmin(false);
         emp.setMember(false);
         memberManager.createMember(emp);*/

        //pour le reste
        climbingAreaManager.updateClimbingArea(emp);
        //commentManager.updateComment(emp);
        //guidebookManager.updateGuidebook(emp);
        //parkingManager.updateParking(emp);
        //photoManager.updatePhoto(emp);
        //reservationRequestManager.updateReservationRequest(emp);
        //routeManager.updateRoute(emp);
        //sectorManager.updateSector(emp);
        //startingPointManager.updateStartingPoint(emp);
        return "redirect:/testlist";
    }
    /* It deletes record for the given id in URL and redirects to /viewemp */
    @GetMapping(value="/testdelete/{id}")
    public String delete(@PathVariable int id){
        //memberManager.deleteMember(id);
        climbingAreaManager.deleteClimbingArea(id);
        //commentManager.deleteComment(id);
        //guidebookManager.deleteGuidebook(id);
        //parkingManager.deleteParking(id);
        //photoManager.deletePhoto(id);
        //reservationRequestManager.deleteReservationRequest(id);
        //routeManager.deleteRoute(id);
        //sectorManager.deleteSector(id);
        //startingPointManager.deleteStartingPoint(id);
        return "redirect:/testlist";
    }
}
