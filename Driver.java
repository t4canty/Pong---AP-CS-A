import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Font;
import java.lang.Math;




public class Driver extends JPanel implements ActionListener, KeyListener {
    int table_width = 900; // width of the screen
    int table_height = 600; // height of the screen
    // ball variables
    int radius = 50;
    int g = 10;
    // ball position
    int b_x = 450; // ball x
    int b_y = 300; // ball y
    // ball movement
    int b_vx = 5;
    int b_vy = 5;

    // paddles
    int p1x = 20;
    int p2x = 870;
    int p1y = 0;
    int p2y = 0;
    int pw = 10;
    int ph = 150;

    // paddle velocity control variables
    boolean up1 = false;
    boolean up2 = false;
    boolean down1 = false;
    boolean down2 = false;

    // velocity for paddle 1 + 2
    int p1v = 0;
    int p2v = 0;

    // score variable intializations
    int p1score = 0;
    int p2score = 0;

    //drawing here
    public void paint(Graphics g) {

        super.paintComponent(g);
        //changing color before a paint method
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, table_width, table_height);
        //paint left paddle
        g.setColor(Color.red);
        g.drawRect(p1x, p1y, pw, ph);
        g.fillRect(p1x, p1y, pw, ph);
        // paint right paddle
        g.setColor(Color.red);
        g.drawRect(p2x, p2y, pw, ph);
        g.fillRect(p2x, p2y, pw, ph);
        // draw the ball based on its properties (variables)
        g.fillOval(b_x, b_y, radius, radius);
        // change font and font color
        Font myFont = new Font("Ubuntu", 1, 50);
        g.setColor(Color.white);
        g.setFont(myFont);
        // draw the score on the game screen
        g.drawString(p1score + " - " + p2score, 375, 100);


    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

        // update variables
        b_y += b_vy;
        b_x += b_vx;

        // makes ball bounce off top and bottom
        if (b_y >= table_height - radius || b_y == 0) {
            b_vy = -b_vy;
        }

        // resets ball to center after it goes off screen and updates score
        if (b_x >= table_width - radius) {
            b_x = 450;
            b_y = 300;
            p1score += 1;
        }
        if (b_x == 0) {
            b_x = 450;
            b_y = 300;
            p2score += 1;
        }

        // 4 if statements to keep consistent velocities and make sure paddles don't start speeding up when key is held down
        if (down1) {
            p1y += 10;
        }
        if (down2) {
            p2y += 10;
        }
        if (up1) {
            p1y += -10;
        }
        if (up2) {
            p2y += -10;
        }

        // paddle collision mechanics 
        if (b_x <= p1x + pw && b_x >= p1x && b_y >= p1y && b_y <= p1y + ph) {
            b_vx = -b_vx;
            b_vy = b_vy + Math.abs(p1v)*150;
        }

        if (b_x >= p2x - radius && b_x <= p2x + pw && b_y >= p2y && b_y <= p2y + ph) {
            b_vx = -b_vx;
            b_vy = b_vy + Math.abs(p1v)*150;
        }

        // 4 if statements to prevent paddles from moving off screen, so they stop at the borders of screen
        if (p1y < 0) {
            p1v = 0;
            p1y = 0;
        }
        if (p2y < 0) {
            p2v = 0;
            p2y = 0;
        }
        if (p1y > 430) {
            p1v = 0;
            p1y = 430;
        }
        if (p2y > 430) {
            p2v = 0;
            p2y = 430;
        }
        repaint();
    }


    public static void main(String[] arg) {
        Driver d = new Driver();
    }
    public Driver() {

        JFrame f = new JFrame();
        f.setTitle("Pong");
        f.setSize(table_width, table_height);
        f.setBackground(Color.BLACK);
        f.setResizable(false);

        f.addKeyListener(this);

        f.add(this);
        t = new Timer(17, this);
        t.start();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    Timer t;



    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println(arg0.getKeyCode());
        if (arg0.getKeyCode() == 83) { // p1 down
            //change position of paddle
            // using booleans to control velocity
            down1 = true;
        }
        if (arg0.getKeyCode() == 87) { // p1 up
            //change position of paddle
            // using booleans to control velocity
            up1 = true;
        }
        if (arg0.getKeyCode() == 40) { // p2 down
            //change position of paddle
            // using booleans to control velocity
            down2 = true;
        }
        if (arg0.getKeyCode() == 38) { // p2 up
            //change position of paddle
            // using booleans to control velocity
            up2 = true;
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
        // stops paddle when key released
        // using booleans to control velocity
        if (e.getKeyCode() == 83) {
            down1 = false;
        } else if (e.getKeyCode() == 87) {
            up1 = false;
        }
        if (e.getKeyCode() == 40) {
            down2 = false;
        } else if (e.getKeyCode() == 38) {
            up2 = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // pressed and released

    }
}