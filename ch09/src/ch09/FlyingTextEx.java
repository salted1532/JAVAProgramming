package ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlyingTextEx extends JFrame {

	private JLabel la = new JLabel("<html><body style='text-align:center;'>_O_<br>|<br>↙ ↘</html>");
	private JLabel hs = new JLabel("<html><body style='text-align:center;'>▲▲<br>□□</html>");
	private JLabel[] tr= new JLabel[100];
	private JLabel[] rk= new JLabel[100];
	final int FLYING_UNIT = 20;
	
	public FlyingTextEx() {
		setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		la.setLocation(50,50);
		la.setSize(60,60);
		
		hs.setLocation(200,200);
		hs.setSize(60,60);
		
		for(int i = 0; i< 20; i++) {
			tr[i] = new JLabel("<html><body style='text-align:center;'>♨<br>♨Y♨<br>|</html>");
			tr[i].setLocation((int)(Math.random() * 400), (int)(Math.random() * 400));
			tr[i].setSize(60,60);
			rk[i] = new JLabel("~");
			rk[i].setLocation((int)(Math.random() * 400), (int)(Math.random() * 400));
			rk[i].setSize(20,20);
			c.add(tr[i]);
			c.add(rk[i]);
		}

		c.add(la);
		c.add(hs);

		c.addKeyListener(new MyKeyListener());
		setSize(400, 400);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {			
			switch(e.getKeyCode()) {
				case KeyEvent.VK_NUMPAD8 :
					la.setLocation(la.getX(),la.getY() - FLYING_UNIT);
					break;
				case KeyEvent.VK_NUMPAD2 :
					la.setLocation(la.getX(),la.getY() + FLYING_UNIT);
					break;
				case KeyEvent.VK_NUMPAD4 :
					la.setLocation(la.getX() - FLYING_UNIT,la.getY());
					break;
				case KeyEvent.VK_NUMPAD6 :
					la.setLocation(la.getX() + FLYING_UNIT,la.getY());
					break;
				case KeyEvent.VK_NUMPAD7 :
					la.setLocation(la.getX()- 10,la.getY() - 10);
					break;
				case KeyEvent.VK_NUMPAD9 :
					la.setLocation(la.getX()+ 10,la.getY() - 10);
					break;
				case KeyEvent.VK_NUMPAD1 :
					la.setLocation(la.getX()- 10,la.getY() + 10);
					break;
				case KeyEvent.VK_NUMPAD3 :
					la.setLocation(la.getX()+ 10,la.getY() + 10);
					break;
				case 27 :
					System.exit(0);
			}
			
			if(la.getX() > 400) {
				la.setLocation(0, la.getY());
			}
			else if(la.getY() > 400) {
				la.setLocation(la.getX(), 0);
			}
			else if(la.getX() < 0) {
				la.setLocation(400, la.getY());
			}
			else if(la.getY() < 0) {
				la.setLocation(la.getX(), 400);
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlyingTextEx();
	}

}
