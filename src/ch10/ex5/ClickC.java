package ch10.ex5;

import javax.swing.*;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickC extends JFrame {
    public ClickC(){
        setTitle("클릭하면 C출력");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(null);

        JLabel jl=new JLabel("C");
        jl.addMouseListener(new OnClick());
        jl.setSize(10,10);
        jl.setLocation(100,100);
        c.add(jl);

        setVisible(true);
    }
    class OnClick extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e){
            int x=(int)((Math.random())*280+10);
            int y=(int)((Math.random())*280+10);
            JLabel jl=(JLabel) e.getSource();
            jl.setLocation(x,y);
        }
    }

    public static void main(String[] args) {
        new ClickC();
    }
}
