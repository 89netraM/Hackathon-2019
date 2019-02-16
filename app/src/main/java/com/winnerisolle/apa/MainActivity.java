package com.winnerisolle.apa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.winnerisolle.apa.Alarm.AlarmHandler;
import com.winnerisolle.apa.Alarm.RingtonePlayer;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private AlarmHandler alarmHandler;

    TextView timeText;

    View back;
    Dialog dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.textView);
        alarmHandler = new AlarmHandler(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getBoolean("isAlarm", false)) {
            RingtonePlayer.stop();
            debugPopUp();
        }
    }

    public void startTimer(View view) {
        alarmHandler.setAlarmIn(10_000);
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

    public void debugPopUp(){
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
