package day0310;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * 일 대 일 채팅클라이언트
 * @author user
 */
@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener {
	private JTextField jtfTalk;
	private JTextArea jtaTalkDisplay;
	private JButton jbtnConnectServer;
	
	private Socket client;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public SimpleChatClient() {
		super("::::::::::::::::::::::::채팅클라이언트::::::::::::::::::::::::::::::::::::::::::::");
		jtfTalk=new JTextField();
		jbtnConnectServer=new JButton("서버접속");
		jtaTalkDisplay=new JTextArea();
		jtaTalkDisplay.setEditable(false);
		jtfTalk.setBackground(Color.WHITE);
		
		JScrollPane jspTalkDisplay=new JScrollPane( jtaTalkDisplay );
		jspTalkDisplay.setBorder(new TitledBorder("대화내용"));
		
		JPanel jpanel=new JPanel();
		jpanel.add(jbtnConnectServer);
		jtfTalk.setBorder(new TitledBorder("대화입력"));
		
		
		add("North",jpanel);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);
		
		jtfTalk.addActionListener(this);
		
		setBounds(100,100,400,500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtfTalk.requestFocus();
	}//SimpleChatServer
	
	
	public void connectToServer()throws IOException {
		String ipAddr=JOptionPane.showInputDialog("접속서버의 주소를 입력해주세요.","211.63.89");
		
		client=new Socket(ipAddr,10000);
		
	}//connectToServer
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {

	}//actionPerformed

	public static void main(String[] args) {
		new SimpleChatClient();
	}//main

}//class
