package day0310;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * 일 대 일 채팅서버
 * @author user
 */
@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener {
	private JTextField jtfTalk;
	private JTextArea jtaTalkDisplay;
	private JButton jbtnOpenServer;
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	
	
	public SimpleChatServer() {
		super("::::::::::::::::::::::::채팅서버::::::::::::::::::::::::::::::::::::::::::::");
		jtfTalk=new JTextField();
		jbtnOpenServer=new JButton("서버실행");
		jtaTalkDisplay=new JTextArea();
		jtaTalkDisplay.setEditable(false);
		jtfTalk.setBackground(Color.WHITE);
		
		JScrollPane jspTalkDisplay=new JScrollPane( jtaTalkDisplay );
		jspTalkDisplay.setBorder(new TitledBorder("대화내용"));
		
		JPanel jpanel=new JPanel();
		jpanel.add(jbtnOpenServer);
		jtfTalk.setBorder(new TitledBorder("대화입력"));
		
		add("North",jpanel);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);
		
		jtfTalk.addActionListener(this);
		jbtnOpenServer.addActionListener(this);
		
		setBounds(100,100,400,500);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					closeServer();
				} catch (IOException e1) {
					e1.printStackTrace();
				}//catch
				dispose();
			}//windowClosing
			
		});
		jtfTalk.requestFocus();
		
	}//SimpleChatServer
	
	
	public void openServer() throws IOException {
		//서버소켓 생성
		server=new ServerSocket(10000);
		jtaTalkDisplay.setText("서버 가동 준비완료\n");
		//접속자 소켓 받기
		client=server.accept();
		jtaTalkDisplay.append("접속자 접속완료\n");
		//메시지를 주고 받기위한 스트림 연결
		readStream=new DataInputStream(client.getInputStream());//메세지를 읽을 수 있는 상태
		writeStream=new DataOutputStream(client.getOutputStream());//메세지를보낼 수 있는 상태
		
		readMsg();//메시지를 읽는다.
	}//openServer
	
	
	/**
	 * 메시지를 보내올 때 마다 읽기(무한루프)
	 * @throws IOException
	 */
	public void readMsg()throws IOException{
		String msg="";
		while(true) {
			msg=readStream.readUTF();
			jtaTalkDisplay.append(msg+"\n");
		}//while
		
	}//readMsg
	
	
	public void sendMsg()throws IOException{
		if(writeStream!=null) {
			String msg="[호날두]"+jtfTalk.getText();
			//대화창에 메시지를 올리고 
			jtaTalkDisplay.append(msg+"\n");
			//접속자에게 보낸다
			writeStream.writeUTF(msg);
		}//if
		
	}//sendMsg
	
	
	public void closeServer()throws IOException{
		if(readStream!=null) {readStream.close();}//if
		if(writeStream!=null) {writeStream.close();}//if
		if(client!=null) {client.close();}//if
		if(server!=null) {server.close();}//if
			
		
	}//closeServer
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jtfTalk) {
			try {
				sendMsg();
			} catch (IOException e) {
				e.printStackTrace();
			}//catch
		}//if
		
		if(ae.getSource()==jbtnOpenServer) {
			try {
				openServer();
			} catch (IOException e) {
				e.printStackTrace();
			}//catch
		}//if
		
	}//actionPerformed

	
	public static void main(String[] args) {
		new SimpleChatServer();
	}//main

}//class
