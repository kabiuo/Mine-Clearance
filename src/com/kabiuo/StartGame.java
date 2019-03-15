package com.kabiuo;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;

//import com.kabiuo.ThunderPanel;

public class StartGame implements ActionListener {
    private JFrame startJFrame = new JFrame("Mine Clearance");
    private int lww = -1;
//	private JPanel jPanelBoderlayoutCenter = new JPanel();
    private int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
    private int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);

    StartGame() {
        startJFrame.setSize(600, 400);
        startJFrame.setDefaultCloseOperation(3);
        startJFrame.setLocationRelativeTo(null);
        startJFrame.setLayout(new BorderLayout());
//		jPanelBoderlayoutCenter.setLayout(new BorderLayout());
//		jPanelBoderlayoutCenter.setBackground(Color.red);
//		startJFrame.add(jPanelBoderlayoutCenter, BorderLayout.CENTER);
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
        new BackgroundGameMusic().play("https://raw.githubusercontent.com/kabiuo/Mine-Clearance/master/music/ThomasPrime-SkyHigh.mp3");
    }

    public void First(){
        if (lww == -1) {
            JLabel first = new JLabel("请打开Option进行选择", JLabel.CENTER);
            startJFrame.add(first, BorderLayout.CENTER);
        }
    }

    public static void main(String args[]) {
        new StartGame();
    }
}