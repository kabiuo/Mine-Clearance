package com.kabiuo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class ThunderPanel extends JPanel implements MouseListener{
	private static int row;
	private static int col;
	private static int thunderNumber;
	public static String tmp;
	int thunderSign = -1;
	
	Container container = new Container();
	JButton border[][];
	int count[][];
	
	public ThunderPanel(){
		Judge();

		System.out.println();
		this.removeAll();
		this.repaint();
		this.validate();
		
		border= new JButton[row][col];
		count= new int[row][col];

		this.setLayout(new BorderLayout());
		this.add(container, BorderLayout.CENTER);
		addThunderButtons();
		addThunder();
		addCalculatuonThunderNumber();
	}

	public void Judge(){
		if (tmp.equals("Simple")) {
			this.row = 9;
			this.col = 9;
			this.thunderNumber = 10;
		}
		if (tmp.equals("Easy")){
			this.row = 16;
			this.col = 16;
			this.thunderNumber = 40;
		}
		if (tmp.equals("Difficulty")){
			this.row = 16;
			this.col = 30;
			this.thunderNumber = 99;
		}

	}
	
	public void addThunderButtons(){
		container.setLayout(new GridLayout(row, col));
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				JButton Thunders = new JButton();
				//System.out.println(i + "," + j);
				//Thunders.setEnabled(false);
				Thunders.setOpaque(true);
				Thunders.addMouseListener(this);
				border[i][j] = Thunders;
				container.add(Thunders);
			}
		}
	}
	
	public void addThunder(){
		Random random = new Random();
		int randomRow, randomCol;
		for(int i = 0; i < thunderNumber; i++){
			randomRow = random.nextInt(row);
			randomCol = random.nextInt(col);
			
			//count[randomRow][randomCol] = thunderSign;
			if(count[randomRow][randomCol] == thunderSign){
				i--;
			} else {
				if(0 == randomRow){
					if(0 == randomCol){
						if(count[0][1] == thunderSign && count[1][0] == thunderSign && count[1][1] == thunderSign){
							i--;
							continue;
						}
					}
					if(col - 1 == randomCol){
						if(count[0][col - 2] == thunderSign && count[1][col - 2] == thunderSign && count[1][col - 1] == thunderSign){
							i--;
							continue;
						}
					}
				}
				if(row - 1 == randomRow){
					if(0 == randomCol){
						if(count[row - 1][1] == thunderSign && count[row - 2][0] == thunderSign && count[row - 2][1] == thunderSign){
							i--;
							continue;
						}
					}
					if(col - 1 == randomCol){
						if(count[row - 1][col - 2] == thunderSign && count[row - 2][col - 2] == thunderSign && count[row - 2][col - 1] == thunderSign){
							i--;
							continue;
						}
					}
				}
				count[randomRow][randomCol] = thunderSign;
				//border[randomRow][randomCol].setText("X");
			}
		}
	}
	
	public void loseGame(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				int counts = count[i][j];
				if(counts == thunderSign){
					border[i][j].setText("X");
					border[i][j].setEnabled(false);
					border[i][j].setBackground(Color.red);
				}else{
					border[i][j].setText(counts+"");
					border[i][j].setEnabled(false);
				}
			}
		}
		JOptionPane.showMessageDialog(null, "You Lose!");
	}
	
	public void openCell(int i, int j){
		if(border[i][j].isEnabled() == false) return;
		border[i][j].setEnabled(false);
		if(0 == count[i][j]){
			if(i > 0 && j > 0 && count[i-1][j-1] != thunderSign) openCell(i-1, j-1);
			if(i > 0 && count[i-1][j] != thunderSign) openCell(i-1, j);
			if(i > 0 && j < col - 1 && count[i-1][j+1] != thunderSign) openCell(i-1, j+1);
			if(j > 0 && count[i][j-1] != thunderSign) openCell(i, j-1);
			if(j < col - 1 && count[i][j+1] != thunderSign) openCell(i, j+1);
			if(i < row -1 && j > 0 && count[i+1][j-1] != thunderSign) openCell(i+1, j-1);
			if(i < row -1 && count[i+1][j] != thunderSign) openCell(i+1, j);
			if(i < row -1 && j < col - 1 && count[i+1][j+1] != thunderSign) openCell(i+1, j+1);
		} else {
			border[i][j].setText(count[i][j] +"");
		}
	}
	
	public void checkWin(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(border[i][j].isEnabled() == true && count[i][j] != thunderSign) return;
			}
		}
		
		JOptionPane.showMessageDialog(null, "You Win!");
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(count[i][j] == thunderSign){
					border[i][j].setText("X");
					border[i][j].setEnabled(false);
					border[i][j].setBackground(Color.red);
				}else{
					border[i][j].setText(count[i][j]+"");
					border[i][j].setEnabled(false);
				}
			}
		}
	}
	
	public void addCalculatuonThunderNumber(){
		int counts;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				counts = 0;
				if(count[i][j] == thunderSign) continue;
				
				if(i > 0 && j > 0 && count[i-1][j-1] == thunderSign) counts++;
				if(i > 0 && count[i-1][j] == thunderSign) counts++;
				if(i > 0 && j < col - 1 && count[i-1][j+1] == thunderSign) counts++;
				if(j > 0 && count[i][j-1] == thunderSign) counts++;
				if(j < col - 1 && count[i][j+1] == thunderSign) counts++;
				if(i < row -1 && j > 0 && count[i+1][j-1] == thunderSign) counts++;
				if(i < row -1 && count[i+1][j] == thunderSign) counts++;
				if(i < row -1 && j < col - 1 && count[i+1][j+1] == thunderSign) counts++;
				
				count[i][j] = counts;
				//border[i][j].setText(counts + "");
			}
		}
	}
	
	@Override
    public void mouseClicked(MouseEvent e) {
		JButton button = (JButton)e.getSource();
        //System.out.println("鼠标点击---"+"\t"); 
		int counts = -99;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(button.equals(border[i][j])){
					counts = count[i][j];
					if(counts == thunderSign){
						loseGame();
					} else {
						openCell(i, j);
						checkWin();
					}
				}
			}
		}
    }

    @Override
    public void mousePressed(MouseEvent e) {   
    }

    @Override
    public void mouseReleased(MouseEvent e) {   
    }

    @Override
    public void mouseEntered(MouseEvent e) { 
    }

    @Override
    public void mouseExited(MouseEvent e) { 
    }
}