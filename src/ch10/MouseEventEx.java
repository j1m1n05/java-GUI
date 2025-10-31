package ch10;

import javax.swing.*;
import java.awt.Container;
import java.awt.event.MouseAdapter;
//import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseEventEx extends JFrame {
    private JLabel text=new JLabel("hello");
    public MouseEventEx(){
        setTitle("마우스로 문자열 이동");
        setSize(300,300);
        Container c=getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setLayout(null);
        c.add(text);
        text.setSize(60,20);
        text.setLocation(10,10);
        setVisible(true);
        c.addMouseListener(new MyMouse());
    }

    class MyMouse extends MouseAdapter {
        public void mousePressed(MouseEvent e){
            int x=e.getX();
            int y=e.getY();
            text.setLocation(x,y);
        }


    }

    public static void main(String[] args) {
        new MouseEventEx();
    }
}
