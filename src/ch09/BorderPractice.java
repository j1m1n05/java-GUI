package ch09;

import javax.swing.*;
import java.awt.*;

public class BorderPractice extends JFrame {
    public BorderPractice(){
        setTitle("BorderLayout 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        Container c=getContentPane();
        c.setLayout(new BorderLayout(5,7));
        c.setBackground(Color.YELLOW);
        c.add(new JButton("North"),BorderLayout.NORTH);
        c.add(new JButton("East"),BorderLayout.EAST);
        c.add(new JButton("South"),BorderLayout.SOUTH);
        c.add(new JButton("Center"),BorderLayout.CENTER);
        c.add(new JButton("West"),BorderLayout.WEST);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderPractice();
    }
}
