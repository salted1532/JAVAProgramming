package ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyCharEx2 extends JFrame {

	private JLabel la = new JLabel("원하는 내용을 입력해주세요.");
	String a = "";
	
	public KeyCharEx2() {
		setTitle("KeyListener의 문자 키 입력 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(la);
		c.addKeyListener(new MyKeyListener());
		setSize(250, 250);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == 8) {
				int t = la.getText().length();
				if(t == 0) {
					
				}
				else if ( t > 0) {
					a = la.getText().substring(0, t - 1);
					la.setText(a);
				}
			}
			else {
				a += e.getKeyChar();
				la.setText(a);
			}
			
			if(e.getKeyCode() == 27) {
				System.exit(0);
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyCharEx2();
	}

}
