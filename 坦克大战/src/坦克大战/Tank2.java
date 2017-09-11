package ̹�˴�ս;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Tank2 extends JFrame {
	MyPanel mp=null;
	public static void main(String[] args){
		Tank2 tk=new Tank2();
	}
	public Tank2(){
		mp=new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,300);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class MyPanel extends JPanel implements KeyListener,Runnable{
	MyTank3 mt=null;
	Vector<DiTank3> dtk=new Vector<DiTank3>();
	Vector<Baozha> bzjh=new Vector<Baozha>();
	int tksl=3;
	
	Image tp1=null;
	Image tp2=null;
	Image tp3=null;
	public MyPanel(){
		mt=new MyTank3(150,230);
		for(int i=0;i<tksl;i++){
			DiTank3 dt=new DiTank3((i)*180,0);
			dtk.add(dt);
		}
		tp1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bzxg1.gif"));
		tp2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bzxg2.gif"));
		tp3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bzxg3.gif"));
	}

	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0,0,400,300);
		this.drawTank3(mt.getX(), mt.getY(), g, mt.fangxiang, 0);
		for(int i=0;i<dtk.size();i++){
			DiTank3 dt=dtk.get(i);
			if(dt.shengming==true){
				this.drawTank3(dt.getX(),dt.getY(), g, 2, 1);
			}else if(dt.shengming==false){
				dtk.remove(dt);
			}
		}
		for(int i=0;i<mt.aa.size();i++){
			Zidan zd=mt.aa.get(i);
			if(zd!=null&&zd.shengming==true){
				g.setColor(Color.white);
				g.fill3DRect(zd.x, zd.y, 3, 3, false);
			}
			if(zd.shengming==false){
				mt.aa.remove(zd);
			}
		}
		for(int i=0;i<bzjh.size();i++){
			Baozha bz=bzjh.get(i);
			if(bz.shengcunqi>6){
				g.drawImage(tp1,bz.x,bz.y,30,30,this);
			}else if(bz.shengcunqi>3){
				g.drawImage(tp2,bz.x,bz.y,30,30,this);
			}else{
				g.drawImage(tp3, bz.x, bz.y, 30, 30, this);
			}
			bz.suqsd();
			if(bz.shengcunqi==0){
				bzjh.remove(bz);
			}
		}
	}
	public void drawTank3(int x,int y,Graphics g,int fangxiang,int leixing){
		switch(leixing){
		case 0:
			g.setColor(Color.yellow);
			break;
		case 1:
			g.setColor(Color.green);
			break;
		}
		switch(fangxiang){
		case 0:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y-3);
			break;
		case 1:
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x-3, y+10);
			break;
		case 2:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y+33);
			break;
		case 3:
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x+33, y+10);
			break;
		}
		this.repaint();
	}

	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W){
			this.mt.setFangxiang(0);
			this.mt.xiangshang();
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			this.mt.setFangxiang(1);
			this.mt.xiangzuo();
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			this.mt.setFangxiang(2);
			this.mt.xiangxia();
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			this.mt.setFangxiang(3);
			this.mt.xiangyou();
		}
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(mt.aa.size()<8){
				this.mt.fszd();
			}
		}
	}	
	public void jzdf(Zidan zd,DiTank3 dt){
		switch(dt.fangxiang){
		case 0:
		case 2:
			if(zd.x>dt.x&&zd.x<dt.x+20&&zd.y>dt.y&&zd.y<dt.y+30){
				zd.shengming=false;
				dt.shengming=false;
			}
			break;
		case 1:
		case 3:
			if(zd.x>dt.x&&zd.x<dt.x+30&&zd.y>dt.y&&zd.y<dt.y+20){
				zd.shengming=false;
				dt.shengming=false;
			}
		}
	}
	public void jzdf1(){
		for(int i=0;i<mt.aa.size();i++){
			Zidan zd=mt.aa.get(i);
			if(zd.shengming==true){
				for(int j=0;j<dtk.size();j++){
					DiTank3 dt=dtk.get(i);
					if(dt.shengming==true){
						this.jzdf(zd,dt);
					}
				}
			}
			this.repaint();
		}
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(100);
			}
			catch(Exception e){}
			this.jzdf1();
			this.repaint();
		}
	}
}

