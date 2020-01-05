package org.mickael.business.contract.manager;

import org.mickael.model.bean.ClimbingArea;

import java.util.List;

public interface ClimbingAreaManager {
    void createClimbingArea(ClimbingArea climbingArea);
    ClimbingArea findClimbingArea(Integer id);
    ClimbingArea findClimbingAreaByProperty(String propertyName, Object propertyValue);
    void updateClimbingArea(ClimbingArea climbingArea);
    void deleteClimbingArea(Integer id);
    List<ClimbingArea> findAllClimbingArea ();
    List<ClimbingArea> findClimbingAreaByMemberId(Integer id);
    List<ClimbingArea> findAllClimbingAreaSearchRequest(String name, String region, String cotation, Integer numberSector);
    void deleteTag(Integer id);
    void addTag(Integer id);
}
