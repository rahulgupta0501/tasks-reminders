package com.inno.tasks.ExceptionHandeling;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String entityName,String fieldName, String value){
        super(String.format("%s with %s %s is not defined",entityName,fieldName,value));
    }
}
