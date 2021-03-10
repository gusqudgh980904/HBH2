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
 * �� �� �� ä�ü���
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
		super("::::::::::::::::::::::::ä�ü���::::::::::::::::::::::::::::::::::::::::::::");
		jtfTalk=new JTextField();
		jbtnOpenServer=new JButton("��������");
		jtaTalkDisplay=new JTextArea();
		jtaTalkDisplay.setEditable(false);
		jtfTalk.setBackground(Color.WHITE);
		
		JScrollPane jspTalkDisplay=new JScrollPane( jtaTalkDisplay );
		jspTalkDisplay.setBorder(new TitledBorder("��ȭ����"));
		
		JPanel jpanel=new JPanel();
		jpanel.add(jbtnOpenServer);
		jtfTalk.setBorder(new TitledBorder("��ȭ�Է�"));
		
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
		//�������� ����
		server=new ServerSocket(10000);
		jtaTalkDisplay.setText("���� ���� �غ�Ϸ�\n");
		//������ ���� �ޱ�
		client=server.accept();
		jtaTalkDisplay.append("������ ���ӿϷ�\n");
		//�޽����� �ְ� �ޱ����� ��Ʈ�� ����
		readStream=new DataInputStream(client.getInputStream());//�޼����� ���� �� �ִ� ����
		writeStream=new DataOutputStream(client.getOutputStream());//�޼��������� �� �ִ� ����
		
		readMsg();//�޽����� �д´�.
	}//openServer
	
	
	/**
	 * �޽����� ������ �� ���� �б�(���ѷ���)
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
			String msg="[ȣ����]"+jtfTalk.getText();
			//��ȭâ�� �޽����� �ø��� 
			jtaTalkDisplay.append(msg+"\n");
			//�����ڿ��� ������
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
