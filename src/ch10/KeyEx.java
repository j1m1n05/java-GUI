package ch10;

import javax.swing.*;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyEx extends JFrame {
    private JLabel text=new JLabel("hello");
    public KeyEx(){
        super("키 이벤트 처리");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(null);
        text.setSize(60,20);
        text.setLocation(10,10);
        c.add(text);
        c.addKeyListener(new MyKey());
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();

    }

    class MyKey extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            int x=text.getX();
            int y=text.getY();
            int code=e.getKeyCode(); //가상키 리턴
            switch (code){
                case KeyEvent.VK_UP: text.setLocation(x,y-10); break;
                case KeyEvent.VK_DOWN: text.setLocation(x,y+10); break;
                case KeyEvent.VK_LEFT: text.setLocation(x-10,y); break;
                case KeyEvent.VK_RIGHT: text.setLocation(x+10,y); break;
                case KeyEvent.VK_Q: System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new KeyEx();
    }
}
