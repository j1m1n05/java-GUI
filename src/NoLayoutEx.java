import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NoLayoutEx extends JFrame{
    public NoLayoutEx(){
        setTitle("절대위치 절대 크기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setVisible(true);

        Container c=getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(null);
        for(int i=0;i<10;i++){
            JButton b=new JButton(Integer.toString(i));
            b.setSize(80,20);  //b가 30, 20을 기억한다.
            b.setLocation(10+i*10,10+i*16);
            c.add(b);

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton ba=(JButton)(e.getSource());  //다운캐스팅
                    //ba는 눌린 버튼
                    ba.setBackground(Color.MAGENTA);
                }
            });
        }

        JLabel text=new JLabel("GUI  00");
        text.setSize(100,20);
        text.setLocation(200,300);
        c.add(text);
    }

    public static void main(String[] args) {
        new NoLayoutEx();
    }
}
