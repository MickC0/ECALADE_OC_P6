package org.mickael.model.exceptions;

public class MemberBlockedException extends Exception{

    public MemberBlockedException(){}

    public MemberBlockedException(String errorDescription){
        super(errorDescription);
    }
}
