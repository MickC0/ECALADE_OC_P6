package org.mickael;

import org.mickael.consumer.impl.dao.ClimbingAreaDaoImpl;
import org.mickael.model.bean.ClimbingArea;
import org.mickael.model.bean.Member;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {
    public static void main(String[] args){
        ConfigurableApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bootstrapContext.xml");
        ClimbingAreaDaoImpl climbingAreaDao = (ClimbingAreaDaoImpl) classPathXmlApplicationContext.getBean("climbingAreaDaoImpl");
        ClimbingArea climbingArea = new ClimbingArea();

        Member member = new Member();
        member.setId(1);

        climbingArea.setApprouved(true);
        climbingArea.setDescription("prout");
        climbingArea.setHoldType("hold");
        climbingArea.setMaximumHeight(78.1F);
        climbingArea.setMember(member);

        climbingAreaDao.createClimbingArea(climbingArea);

        ClimbingArea climbingArea1 = climbingAreaDao.findClimbingArea(1);
        System.out.println(climbingArea1);
    }
}
