package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAllEx extends JFrame{
    private JLabel text=new JLabel("");
    public MouseAllEx() {
        super("마우스");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(null);
        c.add(text);
        text.setSize(100,20);
        text.setLocation(10,10);
        c.addMouseListener(new MyMouse());
        c.addMouseMotionListener(new MyMouse());

        setVisible(true);
    }

    class MyMouse extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            int x=e.getX();
            int y=e.getY();
            setTitle("pressed("+x+","+y+")");
            text.setText("("+x+","+y+")");
            text.setLocation(e.getPoint());
        }
        public void mouseReleased(MouseEvent e){
            int x=e.getX();
            int y=e.getY();
            setTitle("released("+x+","+y+")");
            text.setText("("+x+","+y+")");
            text.setLocation(e.getPoint());
        }
        public void mouseEntered(MouseEvent e){
            Container c=(Container)e.getSource();
            c.setBackground(Color.CYAN);

        }
        public void mouseExited(MouseEvent e){
            Component c=(Component)e.getSource();
            c.setBackground(Color.YELLOW);
        }
        public void mouseDragged(MouseEvent e){
            int x=e.getX();
            int y=e.getY();
            setTitle("dragged("+x+","+y+")");
            text.setText("("+x+","+y+")");
            text.setLocation(e.getPoint());
        }
        public void mouseMoved(MouseEvent e){
            int x=e.getX();
            int y=e.getY();
            setTitle("Moved("+x+","+y+")");
            text.setText("("+x+","+y+")");
            text.setLocation(e.getPoint());
        }
    }

    public static void main(String[] args) {
        new MouseAllEx();
    }
}
