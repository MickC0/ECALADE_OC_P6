package org.mickael.business.contract;

import org.mickael.business.contract.manager.*;

public interface ManagerFactory {


    ClimbingAreaManager getClimbingAreaManager();
    void setClimbingAreaManager(ClimbingAreaManager climbingAreaManager);

    CommentManager getCommentManager();
    void setCommentManager(CommentManager commentManager);

    GuidebookManager getGuidebookManager();
    void setGuidebookManager(GuidebookManager guidebookManager);

    PhotoManager getPhotoManager();
    void setPhotoManager(PhotoManager photoManager);

    ReservationRequestManager getReservationRequestManager();
    void setReservationRequestManager(ReservationRequestManager reservationRequestManager);

    RouteManager getRouteManager();
    void setRouteManager(RouteManager routeManager);

    SectorManager getSectorManager();
    void setSectorManager(SectorManager sectorManager);

    MemberManager getMemberManager();
    void setMemberManager(MemberManager memberManager);
}
