package com.winnerisolle.apa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Space;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    View back;
    Dialog dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void debugCreateNew(View view){

        EditText et = back.findViewById(R.id.statustext);
        String status = et.getText().toString();

        View v = StatusDisplayer.addNewStatus(Calendar.getInstance().getTime(),status,getApplicationContext());
        LinearLayout ll = findViewById(R.id.statuslist);
        ll.addView(v);
        Space s = new Space(getApplicationContext());
        s.setMinimumHeight(30);
        ll.addView(s);
        dia.cancel();
    }

    public void debugPopUp(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.report, null);
        back = v;
        builder.setView(v);
        Dialog d = builder.create();
        d.setCancelable(false);
        d.show();
        dia = d;
    }


}
