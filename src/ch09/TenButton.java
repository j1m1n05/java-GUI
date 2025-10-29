package ch09;

import javax.swing.*;
import java.awt.*;

public class TenButton extends JFrame {
    public TenButton(){
        super("버튼 10개 만들기");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(new GridLayout());
        setVisible(true);
        makeButton(c);
    }
    private void makeButton(Container c){
        Color []color={Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN,Color.BLUE,Color.MAGENTA,Color.DARK_GRAY,Color.PINK,Color.GRAY};
        for(int i=0;i<10;i++){
            JButton jb=new JButton();
            jb.setBackground(color[i]);
            jb.add(new JLabel(String.valueOf(i)));
            c.add(jb);
        }
    }



    public static void main(String[] args) {
        new TenButton();

    }
}
