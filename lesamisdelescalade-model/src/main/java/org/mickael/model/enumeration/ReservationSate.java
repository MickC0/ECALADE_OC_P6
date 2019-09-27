package org.mickael.model.enumeration;

public enum ReservationSate {

    INITIATE ("INITIATE"), NEW ("NEW"), WAITING ("WAITING"), VALIDATE ("VALIDATE"), CLOSED ("CLOSED");

    protected String stateValue;

    //====  CONSTRUCTOR  ====

    ReservationSate(String stateValue){
        this.stateValue = stateValue;
    }

    public String getStateValue(){
        return this.stateValue;
    }


}
