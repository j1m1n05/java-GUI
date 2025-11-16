package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ComboBoxEx extends JFrame {
    JComboBox<String> combo=new JComboBox<String>();
    public ComboBoxEx(){
        setTitle("JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        Container c=getContentPane();
        c.setLayout(new FlowLayout());



        JTextField input=new JTextField(10);
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField input=(JTextField)e.getSource();
                String text=input.getText();
                combo.addItem(text);
            }
        });

        add(input);
        add(combo);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBoxEx();
    }
}
