package org.mickael.model.enumeration;

public enum ReservationSate {

    INITIATE (0), WAITING (1), VALIDATE (2), CLOSED (3);

    protected Integer code;

    //====  CONSTRUCTOR  ====

    ReservationSate(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return this.code;
    }


}
