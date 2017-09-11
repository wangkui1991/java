package jiemian;
import javax.swing.*;

import moxing.Lianjie;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import gonggong.*;

import java.util.*;
import gongju.*
;
public class Liaotian extends JFrame implements ActionListener
{
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String ownerId;
	String friendId;
	String xinxi;
		
	public Liaotian(String owner ,String friend)
	{
		this.ownerId=owner;
		this.friendId=friend;
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		this.setTitle(ownerId+"正在和"+friend+"聊天");
		this.setIconImage((new ImageIcon("image/qq.gif").getImage()));
		this.setSize(300, 200);
		this.setLocation(318,186);
		this.setResizable(false);
		this.setVisible(true);
	}
	public void showMessage(Message m)
	{
		String datatime=Calendar.getInstance().getTime().toLocaleString();
		xinxi=m.getSender()+"对我说："+m.getCon()+"    "+datatime+"\r\n";
		jta.append(xinxi);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jb)
		{
			Message m=new Message();
			m.setMesType(MessageType.message_comm_mes);
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setCon(jtf.getText());
			m.setSendTime(new Date().toString());
			try
			{
				ObjectOutputStream oos=new ObjectOutputStream(Glxc.getLjfwqxc(ownerId).getS().getOutputStream());
				oos.writeObject(m);
				String wodeneirong="我对"+m.getGetter()+"说：  "+jtf.getText()+"      "+Calendar.getInstance().getTime().toLocaleString()+"\r\n";
				jta.append(wodeneirong);
				jtf.setText("");
			}catch(Exception e2){}
			
		}
	}

	
	
	
	
}//this.timeNow.setText("当前系统时间："+Calendar.getInstance().getTime().toLocaleString()+" ");