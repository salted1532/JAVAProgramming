package ch09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventAllEx extends JFrame {

	private JLabel la = new JLabel("   Move Me");
	
	public MouseEventAllEx() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		la.setLocation(100,80);
		la.setSize(80,20);
		c.setLayout(null);

		c.add(la);
		
		MyMouseListener listener = new MyMouseListener();
		
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
		
		setSize(320, 200);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseDragged(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseMoved(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getClickCount() == 2) {
				
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setLocation(e.getX(), e.getY());
			setTitle("mousePressed(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseReleased(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			//Component comp = (Component)e.getSource();
			//comp.setBackground(Color.cyan);
			getContentPane().setBackground(Color.cyan);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			//Component comp = (Component)e.getSource();
			//comp.setBackground(Color.yellow);
			getContentPane().setBackground(Color.yellow);
		}

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseEventAllEx();
	}

}
