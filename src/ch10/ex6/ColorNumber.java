package ch10.ex6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorNumber extends JFrame {
    Color[]colors={Color.RED,Color.GRAY,Color.BLUE,Color.YELLOW,Color.CYAN,Color.DARK_GRAY,Color.PINK,Color.GREEN,Color.ORANGE,Color.magenta};
    Color intColor=Color.black;
    JLabel []jl=new JLabel[10];
    public ColorNumber(){
        setTitle("West Grid 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        WestPanel wp=new WestPanel();

        CenterPanel cp=new CenterPanel();
        cp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                for(int i=0;i<jl.length;i++){
                    int x=(int)((Math.random())*150)+50;
                    int y=(int)((Math.random())*150)+50;
                    jl[i].setLocation(x,y);
                }
            }
        });
        c.add(wp,BorderLayout.WEST);
        c.add(cp,BorderLayout.CENTER);

        setVisible(true);
    }
    class WestPanel extends JPanel{
        public WestPanel(){
            this.setLayout(new GridLayout(10,1));
            for(int i=0;i<colors.length;i++){
                JButton jl=new JButton("");
                jl.setBackground(colors[i]);
                jl.addActionListener(new ChangeColor(i));
                jl.setOpaque(true);
                //jl.setPreferredSize(new Dimension(40,99999));
                this.add(jl);
            }
        }
    }
    class CenterPanel extends JPanel{
        public CenterPanel(){
            this.setLayout(null);
            for(int i=0;i< colors.length;i++){
                int num=(int)((Math.random())*10);
                int x=(int)((Math.random())*150)+50;
                int y=(int)((Math.random())*150)+50;
                jl[i]=new JLabel(Integer.toString(num));
                jl[i].setLocation(x,y);
                jl[i].setSize(10,10);
                jl[i].setForeground(intColor);
                this.add(jl[i]);
            }
        }
    }
    class ChangeColor implements ActionListener{
        int colorNum;
        public ChangeColor(int i){
            colorNum=i;
        }
        public void actionPerformed(ActionEvent e){
            intColor=colors[colorNum];
            for(int i=0;i< jl.length;i++){
                jl[i].setForeground(intColor);
            }
        }
    }

    public static void main(String[] args) {
        new ColorNumber();
    }
}
