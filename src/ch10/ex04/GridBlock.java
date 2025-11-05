package ch10.ex04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GridBlock extends JFrame {
    public GridBlock(){
        setTitle("상하좌우 키로 블록 움직이기");
        setSize(300,300);
        Container c=getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text=new JLabel("상하좌우 키로 블록을 이동시킬수 있습니다");
        text.setBackground(Color.lightGray);
        text.setOpaque(true);
        c.add(text, BorderLayout.NORTH);
        Mypanel mypanel=new Mypanel();
        c.add(mypanel,BorderLayout.CENTER);

        setVisible(true);

        mypanel.requestFocus();
        mypanel.setFocusable(true);
    }

    class Mypanel extends JPanel{
        private final int COLS =5;
        private final int ROWS =5;
        private int curRow =2;
        private int curCol =2;
        private JLabel [][]labels=new JLabel[ROWS][COLS];

        public Mypanel(){
            setBackground(Color.MAGENTA);
            setLayout(new GridLayout(ROWS,COLS,1,1));
            for(int i=0;i<labels.length;i++){
                for(int j=0;j<labels[i].length;j++){
                    labels[i][j]=new JLabel("");
                    labels[i][j].setBackground(Color.WHITE);
                    labels[i][j].setOpaque(true);
                    add(labels[i][j]);

                }
            }
            labels[curRow][curCol].setBackground(Color.BLUE);
            this.addKeyListener(new MyKey());
        }
        class MyKey extends KeyAdapter{
            @Override
            public void keyPressed(KeyEvent e){
                int key=e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        if(curCol==0)
                            return;
                        labels[curRow][curCol].setBackground(Color.WHITE);
                        curCol--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(curCol==COLS-1)
                            return;
                        labels[curRow][curCol].setBackground(Color.WHITE);
                        curCol++;
                        break;
                    case KeyEvent.VK_UP:
                        if(curRow==0)
                            return;
                        labels[curRow][curCol].setBackground(Color.WHITE);
                        curRow--;
                        break;
                    case KeyEvent.VK_DOWN:
                        if(curRow==ROWS-1)
                            return;
                        labels[curRow][curCol].setBackground(Color.WHITE);
                        curRow++;
                        break;
                    default:
                        return;
                }
                labels[curRow][curCol].setBackground(Color.BLUE);
                Container c= (Container) (e.getSource());
                c.repaint();
            }
        }
    }


    public static void main(String[] args) {
        new GridBlock();
    }
}
