package com.kabiuo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.NumberFormat;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;

public class Timer extends JPanel {
    JButton start;
    static JLabel UseTime;
    static String Time = "00：00：00";
    Start ss;

    public Timer() {
        /*
         * 当前用时标签
         * */
        UseTime = new JLabel(Time);
        UseTime.setBounds(30, 70, 80, 50);
        UseTime.setFont(new Font("微软雅黑", Font.BOLD, 15));
        UseTime.setHorizontalAlignment(JLabel.LEFT);

        /**********开始按钮**********/
        start = new JButton("开始");
        start.setBounds(30, 200, 100, 30);
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(false);
                ss=new Start(UseTime);
                ss.start();
            }
        });

        this.add(UseTime);
        this.setVisible(true);

    }

//    public static void main(String[] args) {
//        new Timer();
//    }
}

class Start extends Thread {
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

class Pause extends Thread {
    Start ss;

    public Pause(Start ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        ss.interrupt();
    }

}
