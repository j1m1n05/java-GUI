import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    public MyFrame(){
        //super("첫 GUI");  //JFrame 생성자 호출
        setTitle("첫 GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200,200);
        this.setSize(500,500);
        Container c=this.getContentPane(); //컨텐트팬 영역의 객체 알기
        c.setBackground(Color.ORANGE );
        c.setLayout(new FlowLayout());  //배치 관리자 붙여주기
        c.add(new JButton("OK"));
        c.add(new JButton("Cancel"));
        c.add(new JButton("Ignore"));
        c.add(new JLabel("안녕 하세요"));

        this.setVisible(true);  //화면에 그리라는 지시
    }

    public static void main(String[] args) {
        MyFrame f=new MyFrame();
        System.out.println("메인프레임 종료");

    }
}
