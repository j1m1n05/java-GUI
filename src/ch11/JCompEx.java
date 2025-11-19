package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCompEx extends JFrame {
    public JCompEx(){
        setTitle("공통 메소드");
        Container c=getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new FlowLayout());
        setSize(300,300);
        JButton b1=new JButton("Magent/Yellow");
        JButton b2=new JButton("Disabled Button");
        JButton b3=new JButton("getX(), getY()");
        c.add(b1);
        c.add(b2);
        c.add(b3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b2.isEnabled())
                    b2.setEnabled(false);
                else b2.setEnabled(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b=(JButton)e.getSource();
                JFrame f=(JFrame)b.getTopLevelAncestor();
                f.setTitle(b.getX()+", "+b.getY());
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b=(JButton)e.getSource();
                Container c=b.getParent();
                c.remove(b1);
                c.repaint();
                c.revalidate();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new JCompEx();
    }
}
