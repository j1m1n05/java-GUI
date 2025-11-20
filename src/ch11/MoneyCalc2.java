package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyCalc2 extends JFrame {
    private int []unit={50000,10000,1000,500,100,50,10,1};
    private String []text={"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
    private JTextField input=new JTextField(10);
    private JTextField []tf=new JTextField[8];
    private JCheckBox []cb=new JCheckBox[7];
    public MoneyCalc2(){
        setTitle("Money Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        JLabel jl=new JLabel("금액");
        Container c=getContentPane();
        c.setLayout(null);
        c.setBackground(Color.YELLOW);
        jl.setSize(50,20);
        jl.setLocation(20,20);
        add(jl);


        input.setSize(100,20);
        input.setLocation(100,20);
        add(input);

        JButton jb=new JButton("계산");
        jb.addActionListener(new Calc());
        jb.setSize(70,20);
        jb.setLocation(210,20);
        add(jb);

        for(int i=0;i<text.length;i++){
            JLabel la=new JLabel(text[i]);
            la.setHorizontalAlignment(JLabel.RIGHT);
            la.setSize(50,20);
            la.setLocation(50,50+i*20);
            add(la);
            tf[i]=new JTextField(30);
            tf[i].setSize(70,20);
            tf[i].setHorizontalAlignment(JLabel.CENTER);
            tf[i].setLocation(120,50+(i*20));
            add(tf[i]);
            if(i==7) continue;
            cb[i]=new JCheckBox();
            cb[i].setLocation(200,50+(i*20));
            cb[i].setSize(20,20);
            add(cb[i]);
        }

        setVisible(true);
    }
    class Calc implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JTextField jt=input;
            if(jt.getText().length()==0)
                return;
            int money=Integer.parseInt(jt.getText());
            for(int i=0;i<unit.length;i++){
                if(i==7){
                    tf[i].setText(Integer.toString(money));
                    break;
                }
                int tmp=0;
                if(cb[i].isSelected()){
                    tmp=money/unit[i];
                    tf[i].setText(Integer.toString(tmp));
                    if(tmp>0)
                        money=money%unit[i];
                }
                else{
                    tf[i].setText("0");
                }
                continue;
            }
        }
    }


    public static void main(String[] args) {
        new MoneyCalc2();
    }
}
