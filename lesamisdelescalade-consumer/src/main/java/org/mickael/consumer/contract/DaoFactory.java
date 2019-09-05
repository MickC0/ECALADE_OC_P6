package org.mickael.consumer.contract;

import org.mickael.consumer.contract.dao.*;

public interface DaoFactory {

    ClimbingAreaDao getClimbingAreaDao();
    void setClimbingAreaDao(ClimbingAreaDao climbingAreaDao);

    CommentDao getCommentDao();
    void setCommentDao(CommentDao commentDao);

    GuidebookDao getGuidebookDao();
    void setGuidebookDao(GuidebookDao guidebookDao);

    ParkingDao getParkingDao();
    void setParkingDao(ParkingDao parkingDao);

    PhotoDao getPhotoDao();
    void setPhotoDao(PhotoDao photoDao);

    ReservationRequestDao getReservationRequestDao();
    void setReservationRequestDao(ReservationRequestDao reservationRequestDao);

    RouteDao getRouteDao();
    void setRouteDao(RouteDao routeDao);

    SectorDao getSectorDao();
    void setSectorDao(SectorDao sectorDao);

    StartingPointDao getStartingPointDao();
    void setStartingPointDao(StartingPointDao startingPointDao);

    MemberDao getMemberDao();
    void setMemberDao(MemberDao MemberDao);
}
