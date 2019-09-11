package org.mickael.business.contract.manager;

import org.mickael.model.bean.ClimbingArea;

import java.util.List;

public interface ClimbingAreaManager {
    void createClimbingArea(ClimbingArea climbingArea);
    ClimbingArea findClimbingArea(Integer id);
    void updateClimbingArea(ClimbingArea climbingArea);
    void deleteClimbingArea(Integer id);
    List<ClimbingArea> findAllClimbingArea ();
}
