package ch10.ex03;

import javax.swing.*;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StringCirulate extends JFrame {
    String text=new String("Love Java");
    JLabel jl=new JLabel(text);
    public StringCirulate(){
        setTitle("Left로 글 순환시키기");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        JPanel jp=new NorthPanel();
        jp.addKeyListener(new Circulate());

        c.add(jp);

        setVisible(true);

        jp.setFocusable(true);
        jp.requestFocus();
    }

    class NorthPanel extends JPanel{
        public NorthPanel(){
            this.add(jl);
        }
    }
    class Circulate extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                String tmp=text.substring(0,1);
                text=text.substring(1)+tmp;
                jl.setText(text);
            }
            else return;
        }
    }
    public static void main(String[] args) {
        new StringCirulate();
    }

}
