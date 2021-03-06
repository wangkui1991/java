package 餐饮系统;

import zidingyi.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.event.*;

import javax.imageio.*;
import java.io.*;
//import com.sun.java.swing.plaf.windows.resources.windows;

public class Caozuo extends JFrame implements ActionListener,MouseListener
{
		Image titleIcon, timebg;
		JMenuBar jmb;
		JMenu jm1,jm2,jm3,jm4,jm5,jm6;
		JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5;
		ImageIcon jm1_icon1,jm1_icon2,jm1_icon3,jm1_icon4,jm1_icon5;
		JToolBar jtb;
		JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
		JPanel jp1,jp2,jp3,jp4,jp5;
		JPanel jp3_1,jp3_2,jp3_3,jp3_4,jp3_5,jp3_6,jp3_7;
		ImagePanel jp1_imgPanel;
		Image jp1_bg;
		JLabel jp1_lab1,jp1_lab2,jp1_lab3,jp1_lab4,jp1_lab5,jp1_lab6,jp1_lab7,jp1_lab8;
		JLabel jp2_lab1,jp2_lab2;
		Image jp3_bg;
		JLabel jp3_l1,jp3_l2,jp3_l3,jp3_l4,jp3_l5,jp3_l6,jp3_l7;
		CardLayout cardjp2,cardjp3;
		JSplitPane jsp1;
		JLabel timeNow;
		javax.swing.Timer t;
		
		public static void main(String[] args)
		{
			Caozuo cz=new Caozuo();
		}
		
		public void initMenu()
		{
			jm1_icon1=new ImageIcon("image/jm1_icon1.jpg");
			jm1_icon2=new ImageIcon("image/jm1_icon2.jpg");
			jm1_icon3=new ImageIcon("image/jm1_icon3.jpg");
			jm1_icon4=new ImageIcon("image/jm1_icon4.jpg");
			jm1_icon5=new ImageIcon("image/jm1_icon5.jpg");
			
			jmm1=new JMenuItem("切换用户",jm1_icon1);
			jmm1.setFont(MyFont.f2);
			jmm2=new JMenuItem("切换到收款界面",jm1_icon2);
			jmm2.setFont(MyFont.f2);
			jmm3=new JMenuItem("登录管理",jm1_icon3);
			jmm3.setFont(MyFont.f2);
			jmm4=new JMenuItem("万年历",jm1_icon4);
			jmm4.setFont(MyFont.f2);
			jmm5=new JMenuItem("退出",jm1_icon5);
			jmm5.setFont(MyFont.f2);
			
			jm1=new JMenu("系统管理");
			jm1.setFont(MyFont.f1);
			jm1.add(jmm1);
			jm1.add(jmm2);
			jm1.add(jmm3);
			jm1.add(jmm4);
			jm1.add(jmm5);
		
			
			jm2=new JMenu("人事管理");
			jm2.setFont(MyFont.f1);
			jm3=new JMenu("菜单服务");
			jm3.setFont(MyFont.f1);
			jm4=new JMenu("报表统计");
			jm4.setFont(MyFont.f1);
			jm5=new JMenu("成本及库房");
			jm5.setFont(MyFont.f1);
			jm6=new JMenu("帮助");
			jm6.setFont(MyFont.f1);
			
			jmb=new JMenuBar();
			jmb.add(jm1);
			jmb.add(jm2);
			jmb.add(jm3);
			jmb.add(jm4);
			jmb.add(jm5);
			jmb.add(jm6);
			
			this.setJMenuBar(jmb);
		}
		public void initToolBar()
		{
			jb1=new JButton(new ImageIcon("image/jb1.jpg"));
			jb2=new JButton(new ImageIcon("image/jb2.jpg"));
			jb3=new JButton(new ImageIcon("image/jb3.jpg"));
			jb4=new JButton(new ImageIcon("image/jb4.jpg"));
			jb5=new JButton(new ImageIcon("image/jb5.jpg"));
			jb6=new JButton(new ImageIcon("image/jb6.jpg"));
			jb7=new JButton(new ImageIcon("image/jb7.jpg"));
			jb8=new JButton(new ImageIcon("image/jb8.jpg"));
			jb9=new JButton(new ImageIcon("image/jb9.jpg"));
			jb10=new JButton(new ImageIcon("image/jb10.jpg"));
			
			jtb=new JToolBar();
			jtb.setFloatable(false);
			jtb.add(jb1);
			jtb.add(jb2);
			jtb.add(jb3);
			jtb.add(jb4);
			jtb.add(jb5);
			jtb.add(jb6);
			jtb.add(jb7);
			jtb.add(jb8);
			jtb.add(jb9);
			jtb.add(jb10);
			
			this.add(jtb,BorderLayout.NORTH);
		}
		public void initAllPanel()
		{
			jp1=new JPanel(new BorderLayout());
			try
			{
				jp1_bg=ImageIO.read(new File("image/jp1_bg.jpg"));
			}catch(Exception e){}
			Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);
			jp1_imgPanel=new ImagePanel(jp1_bg);
			this.jp1_imgPanel.setLayout(new GridLayout(8,1));
			jp1_lab1=new JLabel(new ImageIcon("image/label_1.gif"));
			jp1_imgPanel.add(jp1_lab1);
			jp1_lab2=new JLabel("人事管理",new ImageIcon("image/label_2.jpg"),0);
			jp1_lab2.setFont(MyFont.f4);
			jp1_lab2.setEnabled(false);
			jp1_lab2.setCursor(myCursor);
			jp1_lab2.addMouseListener(this);
			jp1_imgPanel.add(jp1_lab2);
			jp1_lab3=new JLabel("登陆管理",new ImageIcon("image/label_3.jpg"),0);
			jp1_lab3.setFont(MyFont.f4);
			jp1_lab3.setCursor(myCursor);
			jp1_lab3.setEnabled(false);
			jp1_lab3.addMouseListener(this);
			jp1_imgPanel.add(jp1_lab3);
			jp1_lab4=new JLabel("菜谱价格",new ImageIcon("image/label_4.jpg"),0);
			jp1_lab4.setFont(MyFont.f4);
			jp1_lab4.setCursor(myCursor);
			jp1_lab4.setEnabled(false);
			jp1_lab4.addMouseListener(this);
			jp1_imgPanel.add(jp1_lab4);
			jp1_lab5=new JLabel("报表统计",new ImageIcon("image/label_5.jpg"),0);
			jp1_lab5.setFont(MyFont.f4);
			jp1_lab5.setCursor(myCursor);
			jp1_lab5.setEnabled(false);
			jp1_lab5.addMouseListener(this);
			jp1_imgPanel.add(jp1_lab5);
			jp1_lab6=new JLabel("成本及库房",new ImageIcon("image/label_6.jpg"),0);
			jp1_lab6.setFont(MyFont.f4);
			jp1_lab6.setCursor(myCursor);
			jp1_lab6.setEnabled(false);
			jp1_lab6.addMouseListener(this);
			jp1_imgPanel.add(jp1_lab6);
			jp1_lab7=new JLabel("系统设置",new ImageIcon("image/label_7.jpg"),0);
			jp1_lab7.setFont(MyFont.f4);
			jp1_lab7.setCursor(myCursor);
			jp1_lab7.setEnabled(false);
			jp1_lab7.addMouseListener(this);
			jp1_imgPanel.add(jp1_lab7);
			jp1_lab8=new JLabel("动画帮助",new ImageIcon("image/label_8.jpg"),0);
			jp1_lab8.setFont(MyFont.f4);
			jp1_lab8.setCursor(myCursor);
			jp1_lab8.setEnabled(false);
			jp1_lab8.addMouseListener(this);
			jp1_imgPanel.add(jp1_lab8);
			
			jp1.add(jp1_imgPanel);
			
			jp4=new JPanel(new BorderLayout());
			this.cardjp2=new CardLayout();
			jp2=new JPanel(cardjp2);
			jp2_lab1=new JLabel(new ImageIcon("image/jp2_left.jpg"));
			jp2_lab1.addMouseListener(this);
			jp2_lab2=new JLabel(new ImageIcon("image/jp2_right.jpg"));
			jp2_lab2.addMouseListener(this);
			jp2.add(jp2_lab1,"0");
			jp2.add(jp2_lab2,"1");
			
			this.cardjp3=new CardLayout();
			jp3=new JPanel(cardjp3);
			try
			{
				jp3_bg=ImageIO.read(new File("image/jp3_5.jpg"));
			}catch(Exception e){}
			ImagePanel ip_jp3=new ImagePanel(jp3_bg);
			jp3_l1=new JLabel(new ImageIcon("image/jp3_1.jpg"));
			jp3_l2=new JLabel(new ImageIcon("image/jp3_2.jpg"));
			jp3_l3=new JLabel(new ImageIcon("image/jp3_3.jpg"));
			jp3_l4=new JLabel(new ImageIcon("image/jp3_4.jpg"));
			jp3_l5=new JLabel(new ImageIcon("image/jp3_5.jpg"));
			jp3_l6=new JLabel(new ImageIcon("image/jp3_6.jpg"));
			jp3_l7=new JLabel(new ImageIcon("image/jp3_7.jpg"));
			jp3_1=new JPanel();
			jp3_1.add(jp3_l1);
			jp3_2=new JPanel();
			jp3_2.add(jp3_l2);
			jp3_3=new JPanel();
			jp3_3.add(jp3_l3);
			jp3_4=new JPanel();
			jp3_4.add(jp3_l4);
			jp3_5=new JPanel();
			jp3_5.add(jp3_l5);
			jp3_6=new JPanel();
			jp3_6.add(jp3_l6);
			jp3_7=new JPanel();
			jp3_7.add(jp3_l7);
			jp3.add(ip_jp3,"0");
			jp3.add(jp3_1,"1");
			jp3.add(jp3_2,"2");
			jp3.add(jp3_3,"3");
			jp3.add(jp3_4,"4");
			jp3.add(jp3_5,"5");
			jp3.add(jp3_6,"6");
			jp3.add(jp3_7,"7");
			
			
			jp4.add(jp2,BorderLayout.WEST);
			jp4.add(jp3,BorderLayout.CENTER);
			jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
			jsp1.setDividerLocation(150);
			jsp1.setDividerSize(0);
			this.add(jsp1,BorderLayout.CENTER);
		}
		public void initJp5()
		{
			jp5=new JPanel();
			jp5.setLayout(new BorderLayout());
			t=new Timer(1000,this);
			t.start();
			timeNow=new JLabel(Calendar.getInstance().getTime().toLocaleString());
			timeNow.setFont(MyFont.f3);
			try
			{
				timebg=ImageIO.read(new File("image/time_bg.jpg"));
				
			}catch(Exception e){}
			ImagePanel ip1=new ImagePanel(timebg);
			ip1.setLayout(new BorderLayout());
			ip1.add(timeNow,BorderLayout.EAST);
			jp5.add(ip1);
			this.add(jp5,BorderLayout.SOUTH);
		}
		
		public Caozuo()
		{
			try
			{
				titleIcon=ImageIO.read(new File("image/title.gif"));
			}catch(Exception e){} 
			this.setIconImage(titleIcon);
			this.setTitle("满汉楼餐饮管理系统");
			this.setFont(MyFont.f0);
			this.initMenu();
			this.initToolBar();
			this.initAllPanel();
			this.initJp5();
			int width=Toolkit.getDefaultToolkit().getScreenSize().width;
			int height=Toolkit.getDefaultToolkit().getScreenSize().height;
			this.setSize(width,height-32);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
		public void actionPerformed(ActionEvent e)
		{
			this.timeNow.setText("当前系统时间："+Calendar.getInstance().getTime().toLocaleString()+"");
			
		}
		public void mouseEntered(MouseEvent e)
		{
			if(e.getSource()==this.jp1_lab2)
			{
				this.jp1_lab2.setEnabled(true);
			}
			else if(e.getSource()==this.jp1_lab3)
			{
				this.jp1_lab3.setEnabled(true);
			}
			else if(e.getSource()==this.jp1_lab4)
			{
				this.jp1_lab4.setEnabled(true);
			}
			else if(e.getSource()==this.jp1_lab5)
			{
				this.jp1_lab5.setEnabled(true);
			}
			else if(e.getSource()==this.jp1_lab6)
			{
				this.jp1_lab6.setEnabled(true);
			}
			else if(e.getSource()==this.jp1_lab7)
			{
				this.jp1_lab7.setEnabled(true);
			}
			else if(e.getSource()==this.jp1_lab8)
			{
				this.jp1_lab8.setEnabled(true);
			}
			
		}
		
		public void mouseExited(MouseEvent e)
		{
			if(e.getSource()==this.jp1_lab2)
			{
				this.jp1_lab2.setEnabled(false);
			}
			else if(e.getSource()==this.jp1_lab3)
			{
				this.jp1_lab3.setEnabled(false);
			}
			else if(e.getSource()==this.jp1_lab4)
			{
				this.jp1_lab4.setEnabled(false);
			}
			else if(e.getSource()==this.jp1_lab5)
			{
				this.jp1_lab5.setEnabled(false);
			}
			else if(e.getSource()==this.jp1_lab6)
			{
				this.jp1_lab6.setEnabled(false);
			}
			else if(e.getSource()==this.jp1_lab7)
			{
				this.jp1_lab7.setEnabled(false);
			}
			else if(e.getSource()==this.jp1_lab8)
			{
				this.jp1_lab8.setEnabled(false);
			}
			
		}
		public void mouseClicked(MouseEvent e)
		{
			if(e.getSource()==this.jp1_lab2)
			{
				this.cardjp3.show(jp3,"1");
			}
			else if(e.getSource()==this.jp1_lab3)
			{
				this.cardjp3.show(jp3,"2");
			}
			else if(e.getSource()==this.jp1_lab4)
			{
				this.cardjp3.show(jp3,"3");
			}
			else if(e.getSource()==this.jp1_lab5)
			{
				this.cardjp3.show(jp3,"4");
			}
			else if(e.getSource()==this.jp1_lab6)
			{
				this.cardjp3.show(jp3,"5");
			}
			else if(e.getSource()==this.jp1_lab7)
			{
				this.cardjp3.show(jp3,"6");
			}
			else if(e.getSource()==this.jp1_lab8)
			{
				this.cardjp3.show(jp3,"7");
			}
			else if(e.getSource()==jp2_lab1)
			{
				this.jsp1.setDividerLocation(0);
				this.cardjp2.show(jp2, "1");
			}
			else if(e.getSource()==jp2_lab2)
			{
				this.jsp1.setDividerLocation(150);
				this.cardjp2.show(jp2, "0");
			}
		}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
	
		
}