package com.winnerisolle.apa;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import java.util.Date;

public class StatusDisplayer {
    public static View addNewStatus(Date time,String status, Context ctx){
        CardView cardView = new CardView(ctx);

        LinearLayout lll = new LinearLayout(ctx);
        TextView tv1 = new TextView(ctx);
        tv1.setText(time.getHours()+":"+time.getMinutes());
        TextView tv2 = new TextView(ctx);
        tv2.setText(status);

        lll.setOrientation(LinearLayout.VERTICAL);

        lll.addView(tv1);
        lll.addView(tv2);
        cardView.addView(lll);
        return cardView;
    }
}
