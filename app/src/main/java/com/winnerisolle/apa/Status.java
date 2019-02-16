package com.winnerisolle.apa;

public class Status{
    String update;
    String project;
    long timeStamp;

    Status(long timeStamp,String project,String update){
        this.update = update;
        this.project = project;
        this.timeStamp = timeStamp;
    }
}