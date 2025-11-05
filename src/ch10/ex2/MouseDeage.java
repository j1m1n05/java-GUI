package ch10.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseDeage extends JFrame {
    private Container c=getContentPane();
    public MouseDeage(){
        setTitle("드래깅 동안 색 바꾸기");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setBackground(Color.GREEN);

        c.addMouseMotionListener(new Drag());
        c.addMouseListener(new Click());
        setVisible(true);
    }
    class Drag extends MouseMotionAdapter{
        @Override
        public void mouseDragged(MouseEvent e) {
            c.setBackground(Color.YELLOW);
        }
    }
    class Click extends MouseAdapter{
        @Override
        public void mouseReleased(MouseEvent e){
            c.setBackground(Color.GREEN);
        }
    }


    public static void main(String[] args) {
        new MouseDeage();
    }
}
