package com.kabiuo.Util.Chronoscope;

import com.kabiuo.Util.Chronoscope.Start;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Timer extends JPanel {
    JButton start;
    public static JLabel UseTime;
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
                ss = new Start(UseTime);
                ss.start();
            }
        });

        this.add(UseTime);
        this.setVisible(true);

    }
}