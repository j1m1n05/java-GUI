import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingFrame extends JFrame{
    public SwingFrame(){
        setTitle("Open Challenge9");
        setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        c.add(new NorthPanel(),BorderLayout.NORTH);
        c.add(new SouthPanel(),BorderLayout.SOUTH);
        c.add(new CenterPanel(),BorderLayout.CENTER);
        setVisible(true);

    }

    class NorthPanel extends JPanel {
        public NorthPanel(){
            this.setBackground(Color.LIGHT_GRAY);
            this.setLayout(new FlowLayout());
            this.add(new JLabel("단어를 클릭"));
            this.add(new JButton("New Text"));
        }
    }
    class SouthPanel extends JPanel{
        public SouthPanel(){
            this.setBackground(Color.YELLOW);
            this.setLayout(new FlowLayout());
            this.add(new JLabel("이름"));
            this.add(new JTextField(20));
        }
    }
    class CenterPanel extends JPanel{
        private String text="I can't help falling in love with you.";
        private String []words=null;
        private JLabel []labels=null;

        public CenterPanel(){
            this.setBackground(Color.WHITE);
            this.setLayout(null);
            String []words=text.split(" ");
            labels=new JLabel[words.length];
            for(int i=0;i<words.length;i++){
                labels[i]=new JLabel(words[i]);
                int x=(int)(Math.random()*280);
                int y=(int)(Math.random()*100);
                labels[i].setLocation(x,y);
                labels[i].setSize(50,20);
                add(labels[i]);
            }
            this.addMouseListener(new MyMouse());
        }
        class MyMouse extends MouseAdapter{
            @Override
            public void mousePressed(MouseEvent e){
                for(int i=0;i<labels.length;i++){
                    int x=(int)(Math.random()*280);
                    int y=(int)(Math.random()*100);

                    labels[i].setLocation(x,y);
                    add(labels[i]);
                }
            }
        }

    }


    public static void main(String[] args) {
        new SwingFrame();
    }
}
