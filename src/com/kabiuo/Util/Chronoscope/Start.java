package com.kabiuo.Util.Chronoscope;

import javax.swing.*;
import java.text.NumberFormat;

public class Start extends Thread {
    JLabel UseTime;
    int time_s, time_m, time_h;

    public Start(JLabel UseTime) {
        this.UseTime = UseTime;
    }

    @Override
    public void run() {

        String text = UseTime.getText();
        hms(text);

        NumberFormat nf = NumberFormat.getInstance();   //调整时间的输出格式
        nf.setMinimumIntegerDigits(2);     //让时分秒都显示为两位数
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;  //如果中断此线程，跳出死循环从而结束线程
            }
            time_s++;
            if (time_s >= 60) {
                time_m++;
                time_s = 0;   //秒钟等于60，分钟加1，秒钟置0
                if (time_m >= 60) {
                    time_h++;
                    time_m = 0;
                    if (time_m >= 24) {
                        time_h = 0;
                    }
                }
            }

//            s.setText(nf.format(time_s));   //  格式化输出 e.g. 0:0:1——>00:00:01
//            m.setText(nf.format(time_m));
//            h.setText(nf.format(time_h));

            UseTime.setText(nf.format(time_h) + "："+ nf.format(time_m) + "：" + nf.format(time_s));

        }
    }

    public void hms(String text){

        String removStr = "：", textTmp, h = null, m = null, s = null;
        textTmp = text.replace(removStr, "");

        for (int i = 0;i < text.length();i++){
            //charAt是获取字符串第i个字符
            if (i <= 1){
                h += textTmp.charAt(i);
            }
            if (i <= 3 && i > 1){
                m += textTmp.charAt(i);
            }
            if (i <= 5 && i > 3){
                s += textTmp.charAt(i);
            }
        }
        time_h = Integer.parseInt(h.replace("null", ""));
        time_m = Integer.parseInt(m.replace("null", ""));
        time_s = Integer.parseInt(s.replace("null", ""));
    }

}
