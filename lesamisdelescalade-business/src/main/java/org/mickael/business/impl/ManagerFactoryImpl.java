package org.mickael.business.impl;

import org.mickael.business.contract.ManagerFactory;
import org.mickael.business.contract.manager.*;

public class ManagerFactoryImpl implements ManagerFactory {

    private ClimbingAreaManager climbingAreaManager;
    private CommentManager commentManager;
    private GuidebookManager guidebookManager;
    private PhotoManager photoManager;
    private ReservationRequestManager reservationRequestManager;
    private RouteManager routeManager;
    private SectorManager sectorManager;
    private MemberManager memberManager;


    @Override
    public ClimbingAreaManager getClimbingAreaManager() {
        return climbingAreaManager;
    }

    @Override
    public void setClimbingAreaManager(ClimbingAreaManager climbingAreaManager) {
        this.climbingAreaManager = climbingAreaManager;
    }

    @Override
    public CommentManager getCommentManager() {
        return commentManager;
    }

    @Override
    public void setCommentManager(CommentManager commentManager) {
        this.commentManager = commentManager;
    }

    @Override
    public GuidebookManager getGuidebookManager() {
        return guidebookManager;
    }

    @Override
    public void setGuidebookManager(GuidebookManager guidebookManager) {
        this.guidebookManager = guidebookManager;
    }

    @Override
    public PhotoManager getPhotoManager() {
        return photoManager;
    }

    @Override
    public void setPhotoManager(PhotoManager photoManager) {
        this.photoManager = photoManager;
    }

    @Override
    public ReservationRequestManager getReservationRequestManager() {
        return reservationRequestManager;
    }

    @Override
    public void setReservationRequestManager(ReservationRequestManager reservationRequestManager) {
        this.reservationRequestManager = reservationRequestManager;
    }

    @Override
    public RouteManager getRouteManager() {
        return routeManager;
    }

    @Override
    public void setRouteManager(RouteManager routeManager) {
        this.routeManager = routeManager;
    }

    @Override
    public SectorManager getSectorManager() {
        return sectorManager;
    }

    @Override
    public void setSectorManager(SectorManager sectorManager) {
        this.sectorManager = sectorManager;
    }

    @Override
    public MemberManager getMemberManager() {
        return memberManager;
    }

    @Override
    public void setMemberManager(MemberManager memberManager) {
        this.memberManager = memberManager;
    }



}
