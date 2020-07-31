package com.example.throneoftheworldexassistant.ui;
import android.content.Context;

import com.example.throneoftheworldexassistant.R;

public class charData {
    public static String[] Data = new String[16];
    public charData(){
        dataIni();
    }
    public static void dataIni(){
        Data[0] = "召喚師 ";
        Data[1] = "人馬 ";
        Data[2] = "巨人 ";
        Data[3] = "神族 ";
        Data[4] = "魔族 ";
        Data[5] = "可愛族 ";
        Data[6] = "機械族 ";
        Data[7] = "德魯伊 ";
        Data[8] = "商人 ";
        Data[9] = "吸血鬼 ";
        Data[10] = "特圖 ";
        Data[11] = "賴爾 ";
        Data[12] = "賭徒 ";
        Data[13] = "狂戰士 ";
        Data[14] = "海盜 ";
        Data[15] = "死靈族 ";
    }
    public static int getRuleID(int n){
        switch (n){
            case 0:
                return R.string.召喚師;
            case 1:
                return R.string.人馬;
            case 2:
                return R.string.巨人;
            case 3:
                return R.string.神族;
            case 4:
                return R.string.魔族;
            case 5:
                return R.string.可愛族;
            case 6:
                return R.string.機械族;
            case 7:
                return R.string.德魯伊;
            case 8:
                return R.string.商人;
            case 9:
                return R.string.吸血鬼;
            case 10:
                return R.string.特圖;
            case 11:
                return R.string.賴爾;
            case 12:
                return R.string.賭徒;
            case 13:
                return R.string.狂戰士;
            case 14:
                return R.string.海盜;
            case 15:
                return R.string.死靈族;
        }
        return R.string.我也不知道;
    }
}
