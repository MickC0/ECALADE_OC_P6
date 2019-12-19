package org.mickael.model.enumeration;

public enum ReservationState {

    PENDING ("En attente"), REFUSED("Refusée"), CANCELLED("Annulée"), ACCEPTED ("Acceptée"), CLOSED ("Clôturée");

    private final String stateValue;

    //====  CONSTRUCTOR  ====

    ReservationState(String stateValue){
        this.stateValue = stateValue;
    }

    public String getStateValue(){
        return this.stateValue;
    }


}
