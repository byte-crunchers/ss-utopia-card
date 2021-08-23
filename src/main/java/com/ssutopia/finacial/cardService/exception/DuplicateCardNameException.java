package com.ssutopia.finacial.cardService.exception;

public class DuplicateCardNameException extends IllegalStateException{
    private final String name;

    public DuplicateCardNameException(String name) {
        super("An Card type with the name '" + name + "' already exists.");
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
