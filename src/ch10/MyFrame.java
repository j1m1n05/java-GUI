package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    public MyFrame(){
        super("action 이벤트 리스너");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
        Container c=this.getContentPane();
        c.setLayout(new FlowLayout());
        JButton jb=new JButton("Action");
        jb.addActionListener(new MyAction());
        c.add(jb);
        jb=new JButton("Action");
        jb.addActionListener(new MyAction());
        c.add(jb);
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyAction implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JButton b=(JButton)e.getSource(); //다운캐스팅
        String text=b.getText();
        if(text.equals("Action"))
            b.setText("액션");
        else
            b.setText("Action");
    }
}
