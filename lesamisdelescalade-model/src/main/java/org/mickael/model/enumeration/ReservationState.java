package org.mickael.model.enumeration;

public enum ReservationState {

    WAITING ("WAITING"), REFUSED("REFUSED"), CANCELLED("CANCELLED"), VALIDATE ("VALIDATE"), ENDED ("ENDED");

    protected String stateValue;

    //====  CONSTRUCTOR  ====

    ReservationState(String stateValue){
        this.stateValue = stateValue;
    }

    public String getStateValue(){
        return this.stateValue;
    }


}
