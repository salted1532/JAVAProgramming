package ch08;
import javax.swing.*;
import java.awt.*;

public class MyFrame4 extends JFrame {

	public MyFrame4() {
		setTitle("프레임 예제");
		setSize(300, 300);
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(10,30));
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("sub"), BorderLayout.SOUTH);
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);
		c.add(new JButton("Calculate"), BorderLayout.CENTER);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame4();
	}
	
}