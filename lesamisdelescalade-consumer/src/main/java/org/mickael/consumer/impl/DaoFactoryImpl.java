package org.mickael.consumer.impl;

import org.mickael.consumer.contract.DaoFactory;
import org.mickael.consumer.contract.dao.*;

public class DaoFactoryImpl implements DaoFactory {

    private ClimbingAreaDao climbingAreaDao;
    private CommentDao commentDao;
    private GuidebookDao guidebookDao;
    private ParkingDao parkingDao;
    private PhotoDao photoDao;
    private ReservationRequestDao reservationRequestDao;
    private RouteDao routeDao;
    private SectorDao sectorDao;
    private StartingPointDao startingPointDao;
    private MemberDao memberDao;

    @Override
    public ClimbingAreaDao getClimbingAreaDao() {
        return climbingAreaDao;
    }

    @Override
    public void setClimbingAreaDao(ClimbingAreaDao climbingAreaDao) {
        this.climbingAreaDao = climbingAreaDao;
    }

    @Override
    public CommentDao getCommentDao() {
        return commentDao;
    }

    @Override
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public GuidebookDao getGuidebookDao() {
        return guidebookDao;
    }

    @Override
    public void setGuidebookDao(GuidebookDao guidebookDao) {
        this.guidebookDao = guidebookDao;
    }

    @Override
    public ParkingDao getParkingDao() {
        return parkingDao;
    }

    @Override
    public void setParkingDao(ParkingDao parkingDao) {
        this.parkingDao = parkingDao;
    }

    @Override
    public PhotoDao getPhotoDao() {
        return photoDao;
    }

    @Override
    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    @Override
    public ReservationRequestDao getReservationRequestDao() {
        return reservationRequestDao;
    }

    @Override
    public void setReservationRequestDao(ReservationRequestDao iReservationRequest) {
        this.reservationRequestDao = iReservationRequest;
    }

    @Override
    public RouteDao getRouteDao() {
        return routeDao;
    }

    @Override
    public void setRouteDao(RouteDao routeDao) {
        this.routeDao = routeDao;
    }

    @Override
    public SectorDao getSectorDao() {
        return sectorDao;
    }

    @Override
    public void setSectorDao(SectorDao sectorDao) {
        this.sectorDao = sectorDao;
    }

    @Override
    public StartingPointDao getStartingPointDao() {
        return startingPointDao;
    }

    @Override
    public void setStartingPointDao(StartingPointDao startingPointDao) {
        this.startingPointDao = startingPointDao;
    }

    @Override
    public MemberDao getMemberDao() {
        return memberDao;
    }

    @Override
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
