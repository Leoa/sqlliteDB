package edu.pace.pcd.sqllitedatabase;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Positions {

    private long id;
    private String positions;


    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getPositions(){
        return positions;
    }

    public void setPositions(String positions){
        this.positions=positions;

    }


}
