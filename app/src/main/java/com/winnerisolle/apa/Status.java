package com.winnerisolle.apa;

// Class for storage of user written updates

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "Updates-table")
public class Status {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Update");

    long time;
    String update;

    Status(String update){
        this.update = update;
        time = System.currentTimeMillis();
    }

    String getStatus(){
        return update;
    }

    long getTime(){
        return time;
    }
}
