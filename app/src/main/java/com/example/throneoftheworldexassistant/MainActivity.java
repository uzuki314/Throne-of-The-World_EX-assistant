package com.example.throneoftheworldexassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.throneoftheworldexassistant.ui.charData;

import java.io.*;
import java.net.*;

public class MainActivity extends AppCompatActivity {
    private TextView tv_1;
    private RadioGroup rg_1;
    private Button bt_1;
    private TextView[][] output = new TextView[4][3];
    private String checker = "-";
    private String stayer = "";
    private Button copyButton;
    //private URLConnection conn;     //連接網站內角色規則頁面


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        rg_1 = findViewById(R.id.rg_1);
        bt_1 = findViewById(R.id.bt_1);
        copyButton = findViewById(R.id.main_copyButton);
        new charData();      //charData  陣列初始化
        outputIni();    //output    二維陣列初始化
        //getRule();      //charRule  陣列初始化並嘗試取得內容
        rg_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                checker = radioButton.getText().toString();
            }
        });

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stayer.compareTo("")==0){
                    Toast.makeText(MainActivity.this,"nothing to copy",Toast.LENGTH_SHORT).show();
                }
                else{
                    ClipboardManager myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                    ClipData myClip = ClipData.newPlainText("text", stayer);
                    myClipboard.setPrimaryClip(myClip);
                    Toast.makeText(MainActivity.this,"copy complete",Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker.charAt(0)!='-') {
                    int aim = 0;
                    String[] tmp = summonRandomCharacter(((int) checker.charAt(0)) - 48).split(" ");
                    for (int i = 0;i < tmp.length/3;i++){
                        for (int j = 0;j < 3;j++){
                            output[i][j].setText(tmp[aim]);
                            aim++;
                        }
                    }
                    for (int i = tmp.length/3;i < 4;i++){
                        for (int j = 0;j < 3;j++){
                            output[i][j].setText("");
                        }
                    }

                    for (int i = 0;i < 4;i++){
                        for (int j = 0;j < 3;j++){

                            View.OnClickListener buf = new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    TextView buf = (TextView)v;
                                    Intent intent = new Intent(MainActivity.this,FullscreenActivity.class);
                                    intent.putExtra("name", buf.getText().toString());  //此方式可以放所有基本型別
                                    startActivity(intent);
                                }
                            };
                            output[i][j].setOnClickListener(buf);
                        }
                    }


                }
                else{
                    Toast.makeText(MainActivity.this,"還沒指定人數喔~",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
/*
    private void getRule() {
        try {
            conn = new URL("http://http://owaridesu.ddns.net/next/rule.html").openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        try {
            conn.connect();
        } catch (IOException e) {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        String type = conn.getContentType();
        Intent intent = new Intent(MainActivity.this,FullscreenActivity.class);
        intent.putExtra("name", type);  //此方式可以放所有基本型別
        startActivity(intent);
    }
*/
    protected String summonRandomCharacter(int n){
        stayer = "";
        String rbuf = "";
        boolean[] map = new boolean[charData.Data.length];
        for (int i = 0;i<charData.Data.length;i++){
            map[i] = true;
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<3;j++){
                int temp = (int)(Math.random()*charData.Data.length);
                if (map[temp]){
                    rbuf = rbuf.concat(charData.Data[temp]);
                    stayer = stayer.concat(charData.Data[temp]);
                    map[temp] = false;
                }
                else{
                    j--;
                }
            }
            stayer = stayer.concat("\n");
        }
        return rbuf;
    }
    protected void outputIni(){
        output[0][0] = (TextView)findViewById(R.id.output_0_0);
        output[0][1] = (TextView)findViewById(R.id.output_0_1);
        output[0][2] = (TextView)findViewById(R.id.output_0_2);

        output[1][0] = (TextView)findViewById(R.id.output_1_0);
        output[1][1] = (TextView)findViewById(R.id.output_1_1);
        output[1][2] = (TextView)findViewById(R.id.output_1_2);

        output[2][0] = (TextView)findViewById(R.id.output_2_0);
        output[2][1] = (TextView)findViewById(R.id.output_2_1);
        output[2][2] = (TextView)findViewById(R.id.output_2_2);

        output[3][0] = (TextView)findViewById(R.id.output_3_0);
        output[3][1] = (TextView)findViewById(R.id.output_3_1);
        output[3][2] = (TextView)findViewById(R.id.output_3_2);
        for (int i = 0;i < 4;i++){
            for (int j = 0;j < 3;j++){
                output[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP,22);
            }
        }
    }

}
