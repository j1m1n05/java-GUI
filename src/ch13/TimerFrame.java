package ch13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerFrame extends JFrame {
    private Thread th=null;
    private Thread th2=null;
    public TimerFrame(){
        setTitle("타이머 만들기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c= getContentPane();
        c.setLayout(new FlowLayout());
        JLabel timerLabel=new JLabel("0");
        timerLabel.setFont(new Font("Gothic",Font.ITALIC,40));
        timerLabel.setForeground(Color.BLUE);
        th=new TimerThread(timerLabel,1000);  //스레드 생성
        th.start();
        c.add(timerLabel);

        JLabel timerLabel2=new JLabel("0");
        timerLabel2.setFont(new Font("Gothic",Font.ITALIC,40));
        c.add(timerLabel2);
        th2=new TimerThread(timerLabel2,100);  //스레드 생성
        th2.start();

        JButton btn=new JButton("종료");
        c.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                th.interrupt();  //th의 타이머 스레드에게 InterruptedException 보내는 함수
                                 //중단 명령
                JButton b=(JButton)e.getSource();
                b.setEnabled(false);
            }
        });
        setSize(300,300);
        setVisible(true);
    }

    class TimerThread extends Thread{
        private int delay=0;
        private JLabel label=null;
        public TimerThread(JLabel label, int delay){
            this.label=label;
            this.delay=delay;
        }
        public void run(){  //스레드 코드. 이 주소에서 실행을 시작하도록 TCB에 기록
            int n=1;
            while(true){
                label.setText(Integer.toString(n));
                n++;
                try{
                    Thread.sleep(delay);
                }catch (InterruptedException e){
                    //label 없애기. 컨텐트팬에서 떼어내기
                    Container c=label.getParent();
                    c.remove(label);  //컨테이너에서 컴포넌트 떼어내기
                    c.repaint();  //컨테이너에게 다시 그릴것을 지시
                    return;  //스레드 종료
                }

            }
        }
    }
    public static void main(String[] args) {
        new TimerFrame();
        long id=Thread.currentThread().getId();
        String name=Thread.currentThread().getName();
        System.out.println(id+":"+name);
    }
}
