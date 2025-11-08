package ch10.ex08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeCard extends JFrame {
    private JLabel [][]cards=new JLabel[3][4];

    public ChangeCard(){
        setTitle("카드 스위치 게임");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.add(new CardsPanel());

        setVisible(true);
    }
    class CardsPanel extends JPanel{


        public CardsPanel(){
            this.setLayout(new GridLayout(3,4,5,5));
        for(int i=0;i<cards.length;i++){
                for(int j=0;j<cards[i].length;j++){
                    cards[i][j]=new JLabel(Integer.toString(4*i+j+1));
                    cards[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                    cards[i][j].setOpaque(true);
                    cards[i][j].setBackground(Color.YELLOW);
                    cards[i][j].addMouseListener(new OnClick());
                    this.add(cards[i][j]);
                }
            }
        }
    }
    JLabel checkedJL=null;
    class OnClick extends MouseAdapter{
        public void mouseReleased(MouseEvent e){
            JLabel jl=(JLabel)e.getSource();
            if(checkedJL==null){
                checkedJL=jl;
                for(int i=0;i<cards.length;i++){
                    for(int j=0;j<cards[i].length;j++){
                        cards[i][j].setBackground(Color.YELLOW);
                    }
                }
                jl.setBackground(Color.MAGENTA);
            }
            else{
                int tmp=Integer.parseInt(jl.getText());
                jl.setText(checkedJL.getText());
                checkedJL.setText(Integer.toString(tmp));
                jl.setBackground(Color.MAGENTA);
                checkedJL=null;
            }

        }
    }

    public static void main(String[] args) {
        new ChangeCard();
    }
}
