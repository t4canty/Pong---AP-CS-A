import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Driver extends JPanel implements ActionListener {
	int table_width = 900; //width of the screen "table"
	int table_height = 600;//height of the screen "table"
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		g.fillOval(0,0, 50,50);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	public Driver(){
		
		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(table_width,table_height);
		f.setBackground(Color.BLACK);
		f.setResizable(false);

		f.add(this);
		t = new Timer(17,this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	Timer t;
}
