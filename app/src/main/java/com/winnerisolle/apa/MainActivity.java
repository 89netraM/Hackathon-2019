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
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNewStatus(View v){
        CardView cardView = new CardView(getApplicationContext());

        LinearLayout lll = new LinearLayout(getApplicationContext());
        TextView tv1 = new TextView(getApplicationContext());
        tv1.setText("Hello Dude");
        TextView tv2 = new TextView(getApplicationContext());
        tv2.setText("Dude hello");

        lll.setOrientation(LinearLayout.VERTICAL);

        lll.addView(tv1);
        lll.addView(tv2);
        cardView.addView(lll);

        LinearLayout ll = findViewById(R.id.statuslist);

        ll.addView(cardView);
        ll.addView(new Space(getApplicationContext()));
    }
}
