package com.kabiuo.MineClearance;

import com.kabiuo.Util.BGM.BackgroundGameMusic;
import com.kabiuo.Util.FileCheck.FileCheck;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

import static com.kabiuo.Util.DownloadConfigFile.DownloadConfigFile.downLoadFromUrl;

public class StartGame implements ActionListener {
    private static JFrame startJFrame = new JFrame("Mine Clearance");
    private int lww = -1;
    private int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
    private int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
    static String path = "d:/Mine-Clearance/";

    StartGame() {
        startJFrame.setSize(600, 400);
        startJFrame.setDefaultCloseOperation(3);
        startJFrame.setLocationRelativeTo(null);
        startJFrame.setLayout(new BorderLayout());
        CreatMenuBar();
        First();
        startJFrame.setVisible(true);
    }

    public void CreatMenuBar() {
        JMenuBar gameMenuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Option");
        JMenuItem gameItemSimple = new JMenuItem("Simple");
        JMenuItem gameItemEasy = new JMenuItem("Easy");
        JMenuItem gameItemDifficulty = new JMenuItem("Difficulty");
        gameItemSimple.addActionListener(this);
        gameItemEasy.addActionListener(this);
        gameItemDifficulty.addActionListener(this);
        //startJFrame.setJMenuBar(gameMenuBar);
        startJFrame.add(gameMenuBar, BorderLayout.NORTH);
        //gameMenuBar.setBackground(Color.red);
        gameMenuBar.add(gameMenu);
        gameMenu.add(gameItemSimple);
        gameMenu.add(gameItemEasy);
        gameMenu.add(gameItemDifficulty);

        startJFrame.add(new ShowMoreInfoPanel(), BorderLayout.WEST);

    }

    public void actionPerformed(ActionEvent e) {
        startJFrame.getContentPane().removeAll();
        startJFrame.repaint();
        startJFrame.validate();
        lww++;
        CreatMenuBar();
        String difficulty = e.getActionCommand();

        if (difficulty.equals("Simple")) {
            ThunderPanel.tmp = "Simple";
            startJFrame.setSize(600, 400);
        }

        if (difficulty.equals("Easy")) {
            ThunderPanel.tmp = "Easy";
            startJFrame.setSize(900, 700);
        }

        if (difficulty.equals("Difficulty")) {
            ThunderPanel.tmp = "Difficulty";
            startJFrame.setSize(screenWidth, screenHeight);
        }
        startJFrame.setLocationRelativeTo(null);
        startJFrame.add(new ThunderPanel(), BorderLayout.CENTER);
        startJFrame.setVisible(true);
        new BackgroundGameMusic().play("d:/Mine-Clearance/music/ThomasPrime-SkyHigh.mp3");
    }

    public void First(){
        if (lww == -1) {
            JLabel first = new JLabel("请打开Option进行选择", JLabel.CENTER);
            startJFrame.add(first, BorderLayout.CENTER);
        }
    }

    public static void main(String args[]) {
        if (new FileCheck().FileChecks(path + "rankinglist/rankinglist.xml")){
            new StartGame();
        } else {
            new StartGame();
            JLabel first = new JLabel("正在下载配置文件，程序关闭后再次打开即可", JLabel.CENTER);
            startJFrame.add(first, BorderLayout.CENTER);
            try{
                downLoadFromUrl("", "rankinglist.xml","d:/Mine-Clearance/rankinglist/");
                downLoadFromUrl("", "ThomasPrime-SkyHigh.mp3","d:/Mine-Clearance/music/");
            }catch (Exception e) {

            }
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.exit(0);
        }
    }
}