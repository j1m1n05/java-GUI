package ch09;

import javax.swing.*;
import java.awt.*;

public class GridPractice extends JFrame {
    Color[] colors = {
            Color.RED,           // 0
            Color.GREEN,         // 1
            Color.BLUE,          // 2
            Color.YELLOW,        // 3
            Color.ORANGE,        // 4
            Color.PINK,          // 5
            Color.MAGENTA,       // 6
            Color.CYAN,          // 7
            Color.GRAY,          // 8
            Color.DARK_GRAY,     // 9
            Color.LIGHT_GRAY,    // 10
            new Color(128, 0, 128),   // 11 보라색(Purple)
            new Color(75, 0, 130),    // 12 인디고(Indigo)
            new Color(238, 130, 238), // 13 바이올렛(Violet)
            new Color(218, 112, 214), // 14 오키드(Orchid)
            new Color(230, 230, 250)  // 15 라벤더(Lavender)
    };
    public GridPractice(){
        setTitle("Grid 4x4");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(new GridLayout(4,4));
        for(int i=0;i<16;i++){
            JLabel jl=new JLabel(String.valueOf(i));
            jl.setBackground(colors[i]);
            jl.setOpaque(true);
            c.add(jl);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridPractice();
    }
}
