package jiemian;
import javax.swing.*;
import moshi.*;
import moshi.*;
import java.awt.*;
import java.awt.event.*;

public class Jiemian extends JFrame implements ActionListener
{

	JPanel jp1;
	JButton jb1,jb2;
	
	public static void main(String[] args)
	{
		Jiemian jm= new Jiemian();
	}
	public Jiemian()
	{
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("关闭服务器");
		jb2.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		
		
		this.add(jp1);
		this.setSize(186,168);
		this.setLocation(318,186);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jb1)
		{
			new Fuwu();
		}	
		else if(e.getSource()==jb2)
		{
			System.exit(0);
		}
	}
}