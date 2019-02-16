package com.winnerisolle.apa;

import java.util.ArrayList;

public class statusDB {
    ArrayList<Status> db;

    statusDB(){
        db = new ArrayList<Status>();
    }

    void insert(Status s){
        db.add(s);
    }

    ArrayList<Status> showAll(){
        return db;
    }
}
