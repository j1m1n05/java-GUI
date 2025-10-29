package ch09;

import javax.swing.*;
import java.awt.*;

public class RandomLabel extends JFrame {
    public RandomLabel(){
        setTitle("Random Label");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        setSize(300,300);
        c.setLayout(null);

        for(int i=0;i<20;i++){
            JLabel jl=makeLabel();
            c.add(jl);
        }
        setVisible(true);
    }
    private JLabel makeLabel(){
        int r=(int)(Math.random()*256);
        int g=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);
        JLabel jl=new JLabel();
        jl.setOpaque(true);
        jl.setBackground(new Color(r,g,b));
        int x=(int)(Math.random()*240)+10;
        int y=(int)(Math.random()*240)+10;
        jl.setLocation(x,y);
        jl.setSize(10,10);
        return jl;
    }

    public static void main(String[] args) {
        new RandomLabel();
    }
}
