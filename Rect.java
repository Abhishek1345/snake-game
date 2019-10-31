






import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
    
    class Rect extends JComponent implements ActionListener{ 
    int x,y,width,height;
    int speedX=0,speedY=0;
    Color color;
    Rect(int x,int y,Color color,int width,int height){
        this.x=x;
        this.y=y;
        this.color=color;
        this.width=width;
        this.height=height;
    }
    Timer t=new Timer(5,this);
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(x,y,width,height);
        t.start();
    }
    public void actionPerformed(ActionEvent e){
        x+=speedX;
        y+=speedY;
        repaint();}
    
}