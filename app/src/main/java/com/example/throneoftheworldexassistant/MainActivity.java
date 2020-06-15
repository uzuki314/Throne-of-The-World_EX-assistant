package com.example.throneoftheworldexassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg_1;
    private Button bt_1;
    private TextView output_reviewer;
    private String checker = "-";
    private String stayer = "";
    private String[] charData = new String[15];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        rg_1 = findViewById(R.id.rg_1);
        bt_1 = findViewById(R.id.bt_1);
        output_reviewer = findViewById(R.id.output_reviewer);
        dataIni();
        rg_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                checker = radioButton.getText().toString();
                Toast.makeText(MainActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker.charAt(0)!='-') {
                    output_reviewer.setText(summonRandomCharacter(((int) checker.charAt(0)) - 48));
                }
                else{
                    Toast.makeText(MainActivity.this,"還沒指定人數喔~",Toast.LENGTH_SHORT).show();
                }
            }
        });
        output_reviewer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData cd = ClipData.newPlainText("text",output_reviewer.getText());
                ClipboardManager cbm = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                cbm.setPrimaryClip(cd);
                Toast.makeText(MainActivity.this,"已將結果複製到Clipboard",Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }

    protected String summonRandomCharacter(int n){
        stayer = "";
        String rbuf = "";
        boolean[] map = new boolean[15];
        for (int i = 0;i<15;i++){
            map[i] = true;
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<3;j++){
                int temp = (int)(Math.random()*15);
                if (map[temp]){
                    rbuf = rbuf.concat(charData[temp]);
                    stayer = stayer.concat(charData[temp]);
                    map[temp] = false;
                }
                else{
                    j--;
                }
            }
            rbuf = rbuf.concat("\n");
        }
        return rbuf;
    }
    protected void dataIni(){
        charData[0] = "召喚師 ";
        charData[1] = "人馬 ";
        charData[2] = "巨人 ";
        charData[3] = "神族 ";
        charData[4] = "魔族 ";
        charData[5] = "可愛族 ";
        charData[6] = "機械族 ";
        charData[7] = "德魯伊 ";
        charData[8] = "商人 ";
        charData[9] = "吸血鬼 ";
        charData[10] = "特圖 ";
        charData[11] = "賴爾 ";
        charData[12] = "賭徒 ";
        charData[13] = "狂戰士 ";
        charData[14] = "海盜 ";
    }
}
