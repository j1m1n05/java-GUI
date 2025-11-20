package ch11;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class JSliderEx extends JFrame {
    JSlider jSlider=new JSlider(JSlider.HORIZONTAL,100,200,150);
    JLabel valueLable =new JLabel("");
    public JSliderEx(){
        setTitle("JSlider practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        Container c=getContentPane();
        c.setLayout(new FlowLayout());
        valueLable.setBackground(Color.GREEN);
        valueLable.setOpaque(true);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value=jSlider.getValue();
                valueLable.setText(Integer.toString(value));
            }
        });
        jSlider.setMajorTickSpacing(20);
        jSlider.setPaintLabels(true);
        jSlider.setPaintTicks(true);

        c.add(jSlider);
        c.add(valueLable);
        setVisible(true);

    }

    public static void main(String[] args) {
        new JSliderEx();
    }
}
