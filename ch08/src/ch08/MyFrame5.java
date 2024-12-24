package ch08;
import javax.swing.*;
import java.awt.*;

public class MyFrame5 extends JFrame {

	public MyFrame5() {
		setTitle("프레임 예제");
		setSize(500, 500);
		
		Container c = getContentPane();
		
		c.setLayout(new GridLayout(2,5 , 5, 5));
		
		for(int i =0; i<10; i++) {
			String text = Integer.toString(i);
			JButton button = new JButton(text);
			c.add(button);
		}
		
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame5();
	}
	
}