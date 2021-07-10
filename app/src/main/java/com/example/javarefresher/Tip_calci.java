package com.example.javarefresher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Tip_calci extends AppCompatActivity {

    private TextView Tip_cali_text;
    private TextView split_text;
    private int clr_y_n = 0;
    private SeekBar tip_input;
    private TextView Tip_display;
    private TextView Display_final_cut;
    private double final_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calci);
        Tip_cali_text = (TextView) findViewById(R.id.Display_main);
        split_text = (TextView) findViewById(R.id.Display_split);
        tip_input = (SeekBar) findViewById(R.id.Tip_bar);
        Tip_display = (TextView) findViewById(R.id.tip_percent);
        Display_final_cut = (TextView) findViewById(R.id.Display_final_amount);
        Display_final_cut.setText("0.0 Per Person");
        getSupportActionBar().setTitle("");

        double steps = 0.1;
        double max = 10;
        tip_input.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double value = (progress * steps);
                String dis_percentage = String.format("%.1f", value);
                Tip_display.setText(dis_percentage.concat("%"));
                 final_val = ((Double.parseDouble(dis_percentage)/100.0)*Double.parseDouble(Tip_cali_text.getText().toString()));
                String dis_final_val = String.format("%.1f", final_val);
                Display_final_cut.setText(""+dis_final_val+" Per Person");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        updateText_Tip();

    }

    public void updateText_Tip() {

        Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("key");
        Tip_cali_text.setText(str);
    }

    public void update_splits(String update_split) {
        if (clr_y_n == 0) {
            split_text.setText("");
        }
        clr_y_n++;

        String split_original_text = split_text.getText().toString();
        String finalText = split_original_text.concat(update_split);
        if (Integer.parseInt(finalText) <= 9999) {
            split_text.setText(finalText);
        } else {
            Toast.makeText(Tip_calci.this, "Above Limit", Toast.LENGTH_SHORT).show();
        }
    }

    public void zero_bt_tip(View view) {
        update_splits("0");
    }

    public void one_bt_tip(View view) {
        update_splits("1");
    }

    public void two_bt_tip(View view) {
        update_splits("2");
    }

    public void three_bt_tip(View view) {
        update_splits("3");
    }

    public void four_bt_tip(View view) {
        update_splits("4");
    }

    public void five_bt_tip(View view) {
        update_splits("5");
    }

    public void six_bt_tip(View view) {
        update_splits("6");
    }

    public void seven_bt_tip(View view) {
        update_splits("7");
    }

    public void eight_bt_tip(View view) {
        update_splits("8");
    }

    public void nine_bt_tip(View view) {
        update_splits("9");
    }

    public void delete_bt_tip(View view)
    {
        int split_length = split_text.getText().toString().length();
        if ( split_length>1)
        {
            split_text.setText(split_text.getText().toString().substring(0, split_text.getText().toString().length() - 1));
        }
        else
        {
            split_text.setText("");
            clr_y_n = -1 ;
            update_splits("1");
        }
    }
    public void enter(View view)
    {
        double final_with_split = final_val/Double.parseDouble(split_text.getText().toString());
        Display_final_cut.setText(""+String.format("%.2f",final_with_split)+" Per Person");
    }
}