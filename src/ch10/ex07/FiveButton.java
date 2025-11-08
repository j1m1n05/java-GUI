package ch10.ex07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiveButton extends JFrame {
    int []count=new int[5];

    public FiveButton(){
        setTitle("클릭 횟수 카운트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        c.add(new NorthPanel(),BorderLayout.NORTH);

        setVisible(true);
    }

    class NorthPanel extends JPanel{
        public NorthPanel(){
            //this.setLayout(new FlowLayout(5,5,5));
            for(int i=0;i<5;i++){
                count[i]=0;
                JButton jb=new JButton(Integer.toString(count[i]));
                jb.addActionListener(new OnClick());
                this.add(jb);
            }

        }
    }
    class OnClick implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton tmp=(JButton) e.getSource();
            int i=Integer.parseInt(tmp.getText());
            tmp.setText(Integer.toString(++i));
        }
    }

    public static void main(String[] args) {
        new FiveButton();
    }
}
