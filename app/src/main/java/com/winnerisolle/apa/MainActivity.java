package com.winnerisolle.apa;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Space;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void debugCreateNew(View view){
        View v = StatusDisplayer.addNewStatus(Calendar.getInstance().getTime(),"This is nice",getApplicationContext());
        LinearLayout ll = findViewById(R.id.statuslist);
        ll.addView(v);
        Space s = new Space(getApplicationContext());
        s.setMinimumHeight(30);
        ll.addView(s);
    }

    public void debugPopUp(View view){
        LayoutInflater li = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.report,null);

        final PopupWindow pw = new PopupWindow(getApplicationContext());
        pw.setContentView(v);

        Button sub = (Button) v.findViewById(R.id.submit);
        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });

    }

}
