package ch09;

import javax.swing.*;
import java.awt.*;

public class CardGrid extends JFrame {
    public CardGrid(){
        setTitle("16장 카드 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        Container c=getContentPane();
        c.setLayout(new BorderLayout(10,10));
        c.add(new NorthPanel(),BorderLayout.NORTH);
        c.add(new SouthPanel(),BorderLayout.SOUTH);
        JPanel jp=new JPanel();
        jp.setSize(50,400);
        jp.add(new JLabel(" "));
        c.add(jp,BorderLayout.WEST);
        c.add(jp,BorderLayout.EAST);
        c.add(new CenterPanel(),BorderLayout.CENTER);

        setVisible(true);
    }

    class NorthPanel extends JPanel{
        public NorthPanel(){
            this.add(new JLabel("숨겨진 이미지 찾기"));
            this.setBackground(Color.YELLOW);
        }
    }
    class SouthPanel extends JPanel{
        public SouthPanel(){
            this.add(new JButton("실행 시작"));
            this.setBackground(Color.YELLOW);
        }
    }
    class CenterPanel extends JPanel{
        public CenterPanel(){
            this.setBackground(Color.BLUE);
            JPanel jp=new JPanel();
            jp.setSize(400,400);
            jp.setLayout(new GridLayout(4,4,10,10));
            jp.setBackground(Color.BLACK);
            for(int i=0;i<16;i++){
                JLabel jl=new JLabel(String.valueOf(i));
                jl.setOpaque(true);
                jl.setBackground(Color.green);
                jl.setSize(50,50);
                jp.add(jl);
            }
            this.add(jp);
        }
    }

    public static void main(String[] args) {
        new CardGrid();
    }
}
