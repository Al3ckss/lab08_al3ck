package it.unibo.deathnote.impl;
import java.util.HashMap;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

class Info{
    String cause;
    String details;

    public Info(String details){
        this.details = details;
        this.cause = "Heart attack";
    }

    public Info(String details, String cause) {
        this.details = details;
        this.cause = cause;
    }

}
public class DeathNoteImplementation implements DeathNote{
    

    private final Map<String, Info> people = new HashMap<>(); 
    private Long time;
    private String lastNameWritten;

    @Override
    public String getRule(int ruleNumber) {
        if(ruleNumber < 1 || ruleNumber > RULES.size()){
            throw new IllegalArgumentException();
        }

        return RULES.get(ruleNumber);
    }

    @Override
    public void writeName(String name) {
        if(name == null){
            throw new IllegalArgumentException();
        }
        people.put(name, new Info(""));
        this.time = System.currentTimeMillis();
        this.lastNameWritten = name;
    }
    
    @Override
    public boolean writeDeathCause(String cause) {
        if(people.isEmpty() || cause == null){
            throw new IllegalStateException();
        }
        
        if((System.currentTimeMillis() - this.time) <= 40){
            this.time = System.currentTimeMillis();
            Info tmpInfo = people.get(this.lastNameWritten);
            tmpInfo.cause = cause;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean writeDetails(String details) {
        if (people.isEmpty() || details == null) {
            throw new IllegalStateException();
        }
        
        if ((System.currentTimeMillis() - this.time) <= 6040){
            this.time = System.currentTimeMillis();
            Info tmpInfo = people.get(this.lastNameWritten);
            tmpInfo.details = details;
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String getDeathCause(String name) {
        if(!isNameWritten(name)){
            throw new IllegalStateException();
        }
        return people.get(name).cause;
    }

    @Override
    public String getDeathDetails(String name) {
        if (!isNameWritten(name)){
            throw new IllegalStateException();
        }
        return people.get(name).details;
    }
    @Override
    public boolean isNameWritten(String name) {
        return people.containsKey(name);
    }
}