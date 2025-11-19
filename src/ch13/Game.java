package ch13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame {
    private MyPanel myPanel=new MyPanel();
    public Game(){
        super("몬스터로부터 도망가기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(myPanel);
        setSize(600,600);
        setVisible(true);

        myPanel.setFocusable(true);
        myPanel.requestFocus();
    }
    class MyPanel extends JPanel{
        private  JLabel avatar=new JLabel("@");
        private  JLabel monster[]=new JLabel[30];
        private MyThread th[]=new MyThread[30];
        public MyPanel(){
            setLayout(null);
            avatar.setLocation(100,100);
            avatar.setSize(20,20);
            avatar.setForeground(Color.RED);

            for(int i=0;i< monster.length;i++){
                monster[i]=new JLabel("M");
                int x=(int)(Math.random()*450);
                int y=(int)(Math.random()*450);
                monster[i].setLocation(x,y);
                monster[i].setSize(20,20);
                add(monster[i]);
            }

            add(avatar);

            this.addKeyListener(new MyKey());
            for(int i=0;i<th.length;i++){
                th[i]=new MyThread(monster[i]);
                th[i].start();
            }

        }

        class MyThread extends Thread{
            private JLabel monster=null;
            public MyThread(JLabel monster){
                this.monster=monster;
            }
            @Override
            public void run(){
                while(true){
                    int x=avatar.getX();
                    int y=avatar.getY();

                    int newX=0,newY=0;
                    if(x<monster.getX())
                        newX =monster.getX()-10;
                    else
                        newX=monster.getX()+10;

                    if(y<monster.getY())
                        newY =monster.getY()-10;
                    else
                        newY=monster.getY()+10;
                    monster.setLocation(newX,newY);
                    try{
                        sleep(300);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        }

        class MyKey extends KeyAdapter{
            @Override
            public void keyPressed(KeyEvent e){
                int code = e.getKeyCode();
                switch (code){
                    case KeyEvent.VK_LEFT:
                        avatar.setLocation(avatar.getX()-10,avatar.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        avatar.setLocation(avatar.getX()+10,avatar.getY());
                        break;
                    case KeyEvent.VK_UP:
                        avatar.setLocation(avatar.getX(),avatar.getY()-10);
                        break;
                    case KeyEvent.VK_DOWN:
                        avatar.setLocation(avatar.getX(),avatar.getY()+10);
                        break;
                    case KeyEvent.VK_S:
                        for(int i=0;i<monster.length;i++){
                            int x=(int)(Math.random()*450);
                            int y=(int)(Math.random()*450);
                            monster[i].setLocation(x,y);
                        }
                    default:
                        return;
                }
                avatar.repaint();
            }
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
