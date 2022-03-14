package com.thiago.petshop.service.exceptions;

public class DataIntegrityExcepetion extends RuntimeException{

    public DataIntegrityExcepetion(String msg){
        super(msg);
    }
    public DataIntegrityExcepetion(String msg, Throwable cause){
        super(msg, cause);
    }
}
