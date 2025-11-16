package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ButtonActivate extends JFrame {
    private JButton test=new JButton("test button");

    public ButtonActivate(){
        setTitle("CheckBox");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        test.setSize(100,20);
        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox deActivate=new JCheckBox("버튼 비활성화");
        JCheckBox disButton=new JCheckBox("버튼 감추기");
        deActivate.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JCheckBox jc=(JCheckBox)e.getSource();
                if(jc.isSelected())
                    test.setEnabled(false);
                else
                    test.setEnabled(true);
            }
        });
        disButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JCheckBox jc=(JCheckBox)e.getSource();
                if(jc.isSelected())
                    test.setVisible(false);
                else
                    test.setVisible(true);
            }
        });

        add(deActivate);
        add(disButton);
        c.add(test);

        setVisible(true);
    }


    public static void main(String[] args) {
        new ButtonActivate();
    }
}
