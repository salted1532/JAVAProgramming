package ch08;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

	public MyFrame() {
		//setTitle("300x300 스윙 프레임 만들기");
		super("첫번째 프레임입니다.");
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new FlowLayout());
		JButton button = new JButton("Click");
		contentPane.add(button);
		
		setSize(300, 300);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}
