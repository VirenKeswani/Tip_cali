package com.example.javarefresher;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button Tip_bt;
    public TextView Initial_numbers;
    private TextView error_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tip_bt =findViewById(R.id.Tip);
        Initial_numbers = findViewById(R.id.textView);
        error_display = (TextView) findViewById(R.id.Error);
        getSupportActionBar().setTitle("");
        Tip_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToTipCali();
            }
        });

    }
    private void updateText(String StrToAdd)
    {
      //  Initial_numbers.setTextSize();
        String oldStr = Initial_numbers.getText().toString();
        Initial_numbers.setText(String.format("%s%s",oldStr,StrToAdd));
    }
    private void moveToTipCali()
    {
        int cnt = 0 ;
        int length_of_numbers = Initial_numbers.getText().length();
        for(int i =0 ; i < length_of_numbers ; i++) {
            char ch = Initial_numbers.getText().toString().charAt(i);
            if (Character.isDigit(ch)||ch=='.') {
                cnt++;
            }
        }
        if (cnt == length_of_numbers && cnt >=1) {

            Intent intent = new Intent(MainActivity.this, Tip_calci.class);
            intent.putExtra("key", Initial_numbers.getText().toString());
            startActivity(intent);
        }
        else
        {
            error_display.setText("Please Use Valid Number");
        }
    }

    public void zero_bt(View view)
    {
        updateText("0");
        error_display.setText("");

    }
    public void one_bt(View view)
    {
        updateText("1");
        error_display.setText("");

    }
    public void two_bt(View view)
    {
        updateText("2");
        error_display.setText("");

    }
    public void three_bt(View view)
    {
        updateText("3");
        error_display.setText("");

    }
    public void four_bt(View view)
    {
        updateText("4");
        error_display.setText("");

    }
    public void five_bt(View view)
    {
        updateText("5");
        error_display.setText("");

    }
    public void six_bt(View view)
    {
        updateText("6");
        error_display.setText("");

    }
    public void seven_bt(View view)
    {
        updateText("7");
        error_display.setText("");

    }
    public void eight_bt(View view)
    {
        updateText("8");
        error_display.setText("");

    }
    public void nine_bt(View view)
    {
        updateText("9");
        error_display.setText("");

    }
    public void Delete_bt(View view)
    {
        int length = Initial_numbers.getText().toString().length();
        if(length>=1)
        Initial_numbers.setText(Initial_numbers.getText().toString().substring(0,Initial_numbers.getText().toString().length()-1));
    }
    public void Clear_bt(View view)
    {
        Initial_numbers.setText("");
        error_display.setText("");

    }

    public void Divide_bt(View view)
    {
        updateText("÷");
        error_display.setText("");

    }
    public void Multiply_bt(View view)
    {
        updateText("*");
        error_display.setText("");

    }
    public void Add_bt(View view)
    {
        updateText("+");
        error_display.setText("");

    }
    public void Sub_bt(View view)
    {
        updateText("-");
        error_display.setText("");

    }
    public void Dot_bt(View view)
    {
        updateText(".");
        error_display.setText("");

    }
    public void Brackets_bt(View view)
    {
        int openBar = 0 ;
        int closeBar = 0 ;
        int textLen = Initial_numbers.getText().length();
        for(int i =0 ; i < textLen ; i++ )
        {
            char ch = Initial_numbers.getText().toString().charAt(i);
            if(ch=='(')
            {
                openBar ++;
            }
            if(ch==')')
            {
                closeBar++;
            }
        }
        if(openBar == closeBar || Initial_numbers.getText().toString().charAt(textLen - 1) == '(' || !Character.isDigit(Initial_numbers.getText().toString().charAt(textLen-1)))
        {
            updateText("(");
        }
        else if (openBar > closeBar && Character.isDigit(Initial_numbers.getText().toString().charAt(textLen-1)) && Initial_numbers.getText().toString().charAt(textLen - 1) != '(' )
        {
            updateText(")");
        }
        error_display.setText("");

    }
    public void Equal_bt(View view)
    {
       String userExp = Initial_numbers.getText().toString();
       userExp = userExp.replaceAll("÷","/");
       userExp = userExp.replaceAll("×","*");
       Expression exp = new Expression(userExp);
       String result = String.valueOf(exp.calculate());

       Initial_numbers.setText(result);
    }

}