package ch09;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseListenerEx2 extends JFrame{
	
	public int x;
	public int y;
	public boolean a;
	JLabel la;
		public MouseListenerEx2() {
			
			la = new JLabel("Hello");
			
			setTitle("Mouse 이벤트 예제");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.addMouseMotionListener(new MyMouseListener2());
			c.addMouseListener(new MyMouseListener2());
			c.setLayout(null);
			la.setSize(500, 20);
			la.setLocation(30, 30);
			c.add(la);
			setSize(250, 250);
			setVisible(true);
	}
		
	class MyMouseListener2 extends MouseAdapter{
		
		
		public void mouseMoved(MouseEvent e){
			x = e.getX() - 20;
			y = e.getY() - 20;
			la.setLocation(x, y);
			if(a == true) {
				la.setText("(" + x + "," + y + ")");
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(la.getText().equals("Hello")) {
				a = true;
			}

			else {
				a = false;
				la.setText("Hello");
				
			}
		}
	}
	public static void main(String [] args) {
		new MouseListenerEx2();
	}
}

 
