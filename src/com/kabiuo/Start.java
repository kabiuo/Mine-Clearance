package com.kabiuo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

//import com.kabiuo.ThunderPanel;

public class Start implements ActionListener{
	private JFrame startJFrame = new JFrame("Mine Clearance");
//	private JPanel jPanelBoderlayoutCenter = new JPanel();
	
	Start(){
		startJFrame.setSize(500,300);
		startJFrame.setDefaultCloseOperation(3);
		startJFrame.setLocationRelativeTo(null);
		startJFrame.setLayout(new BorderLayout());
//		jPanelBoderlayoutCenter.setLayout(new BorderLayout());
//		jPanelBoderlayoutCenter.setBackground(Color.red);
//		startJFrame.add(jPanelBoderlayoutCenter, BorderLayout.CENTER);
		CreatMenuBar();
		startJFrame.setVisible(true);
	}
	
	public void CreatMenuBar(){
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
		
	}

	public Component getJpanel(){
		Component component = null;
		int count = startJFrame.getComponentCount();
		for (int i = 0; i < count; i++) {
			component = startJFrame.getComponent(i);
			System.out.println(component instanceof JPanel);
			if (component instanceof JPanel) {
				JPanel jPanel = (JPanel) component;
				System.out.println(count + " , " + component);
				jPanel.remove(jPanel);
			}
		}
		return component;
	}
	
	//@Override
    public void actionPerformed(ActionEvent e){
		startJFrame.getContentPane().removeAll();
		startJFrame.repaint();
		startJFrame.validate();
		CreatMenuBar();
		String difficulty = e.getActionCommand();

		if(difficulty.equals("Simple")){
			ThunderPanel.tmp = "Simple";
			startJFrame.setSize(500,300);
			startJFrame.setLocationRelativeTo(null);
		}

		if(difficulty.equals("Easy")){
			ThunderPanel.tmp = "Easy";
			startJFrame.setSize(800,600);
			startJFrame.setLocationRelativeTo(null);
		}
		
		if(difficulty.equals("Difficulty")){
			ThunderPanel.tmp = "Difficulty";
			startJFrame.setSize(1280,720);
			startJFrame.setLocationRelativeTo(null);
		}
		startJFrame.add(new ThunderPanel(),BorderLayout.CENTER);

		startJFrame.setVisible(true);
	}
	
	public static void main(String args[]){
		new Start();
	}
}