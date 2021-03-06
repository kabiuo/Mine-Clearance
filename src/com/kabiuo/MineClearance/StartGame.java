package com.kabiuo.MineClearance;

import com.kabiuo.Entity.ConfigFileseEntity;
import com.kabiuo.Util.BGM.BackgroundGameMusic;
import com.kabiuo.Util.FileCheck.FileCheck;
import com.kabiuo.Util.Md5CaculateUtil.Md5CaculateUtil;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.io.File;
import java.util.List;

import static com.kabiuo.Util.DownloadConfigFile.DownloadConfigFile.downLoadFromUrl;
import static com.kabiuo.Util.LoadingXMLFiles.ReadMainXMLFiles.readXml;

public class StartGame implements ActionListener {
    private static JFrame startJFrame = new JFrame("Mine Clearance");
    private int lww = -1;
    private int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
    private int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
    static String path = "d:/Mine-Clearance/";
    static JLabel first;
    static JMenu gameMenu;

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
        gameMenu = new JMenu("Option");
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
            first = new JLabel("请打开Option进行选择", JLabel.CENTER);
            startJFrame.add(first, BorderLayout.CENTER);
        }
    }

    public static void main(String args[]) {

        if (new FileCheck().FileChecks(path + "mainconfig.xml")){
            new StartGame();
        } else {
            new StartGame();
            gameMenu.setEnabled(false);
            startJFrame.remove(first);
            first = new JLabel("正在下载配置文件，请耐心等待！", JLabel.CENTER);
            startJFrame.add(first, BorderLayout.CENTER);
            try{
                downLoadFromUrl("https://github.com/kabiuo/Mine-Clearance/raw/master/config/mainconfig.xml", "mainconfig.xml","d:/Mine-Clearance/");
                List<ConfigFileseEntity> configFileseEntities = (List<ConfigFileseEntity>) readXml("D:/Mine-Clearance/mainconfig.xml");
                if (configFileseEntities != null){
                    int size = configFileseEntities.size(),num = 0;
                    for (ConfigFileseEntity cfe: configFileseEntities
                    ) {
//                        System.out.println(size+","+num);

                        startJFrame.remove(first);
                        first = new JLabel("正在下载配置文件，请耐心等待！" + "(" + num + "/" + size + ")", JLabel.CENTER);
                        startJFrame.add(first, BorderLayout.CENTER);
                        first.setVisible(true);
                        startJFrame.repaint();
                        startJFrame.validate();

                        downLoadFromUrl(cfe.getDownloadPath(), cfe.getSaveName(),cfe.getSavePath());
                        if ("" != cfe.getMd5() && null != cfe.getMd5()) {
                            System.out.println(!((new Md5CaculateUtil().getMD5(new File(cfe.getSavePath() + cfe.getSaveName()))).equals(cfe.getMd5())));
                            while(!((new Md5CaculateUtil().getMD5(new File(cfe.getSavePath() + cfe.getSaveName()))).equals(cfe.getMd5()))) {
                                downLoadFromUrl(cfe.getDownloadPath(), cfe.getSaveName(),cfe.getSavePath());
                            }
                        }
                        num++;
                    }
                }

            }catch (Exception e) {

            }
            startJFrame.remove(first);
            first = new JLabel("下载完成！请打开Option进行选择", JLabel.CENTER);
            startJFrame.add(first, BorderLayout.CENTER);
            gameMenu.setEnabled(true);
        }
    }
}