import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Unit{
    int x,y;
    
    Unit(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class P extends JComponent implements ActionListener{
    
    int speedX=1,speedY=0;
    java.util.List<Unit> list=new ArrayList<Unit>();
    
    public void init(){
        int x=0;
        for(int i=1;i<=20;i++){
            list.add(new Unit(x,0));
            x+=5;
        }
    }
    
    javax.swing.Timer t=new javax.swing.Timer(5,this);
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        for(int i=0;i<list.size();i++){
            Unit u=list.get(i);
            g.fillRect(u.x,u.y,5,5);
        }
        t.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Unit u=list.get(list.size()-1);
        if(speedX==1){
       
            list.add(new Unit(u.x+5,u.y));
            list.remove(0);
        }
        else if(speedX==-1){
            list.add(new Unit(u.x-5,u.y));
            list.remove(0);
        }
        else if(speedY==1){
            list.add(new Unit(u.x,u.y+5));
            list.remove(0);
        }
        else if(speedY==-1){
            list.add(new Unit(u.x,u.y-5));
            list.remove(0);
        }
        if(new Rectangle(Snake.food.x,Snake.food.y,5,5).intersects(new Rectangle(u.x,u.y,5,5))){
            list.add(new Unit(u.x+5,u.y));
            Snake.food.x=(int)(Math.random()*Snake.width);
            Snake.food.y=(int)(Math.random()*Snake.height);
        }
        
        repaint();
    }
}

public class Snake extends KeyAdapter{
    P p=new P();
    static Rect food;
    static int width,height;
    static JFrame f=new JFrame("abhishek jawanpuria");
    public void setUp(){
        p.init();
        
        f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.addKeyListener(this);
        f.setVisible(true);
        width=f.getContentPane().getWidth();
        height=f.getContentPane().getHeight();
        food=new Rect((int)(Math.random()*width),(int)(Math.random()*height),Color.RED,5,5);
        f.add(food);
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            p.speedY=-1;
            p.speedX=0;
            break;
            case KeyEvent.VK_DOWN:
            p.speedY=1;
            p.speedX=0;
            break;
            case KeyEvent.VK_RIGHT:
            p.speedX=1;
            p.speedY=0;
            break;
            case KeyEvent.VK_LEFT:
            p.speedX=-1;
            p.speedY=0;
        }
    }
    
    /*@Override
    public void keyReleased(KeyEvent e){
        p.speedX=0;
        p.speedY=0;
    }*/
    
    public static void main(String args[]){
        new Snake().setUp();
        
    }
}

            
        
    
    
    