package ch08;
import javax.swing.*;
import java.awt.*;

public class MyFrame3 extends JFrame {

	public MyFrame3() {
		setTitle("프레임 예제");
		setSize(300, 300);
		
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout(FlowLayout.RIGHT, 30 , 50));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame3();
	}
	
}