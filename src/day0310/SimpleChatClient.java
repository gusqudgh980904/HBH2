package day0310;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
 * �� �� �� ä��Ŭ���̾�Ʈ:Thread ������-�޼����� ���� ������ �о���̴� �ڵ幮���� �������� �ʴ´�.
 * @author user
 */
@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener {
	private JTextField jtfTalk;
	private JTextArea jtaTalkDisplay;
	private JButton jbtnConnectServer;
	
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	
	public SimpleChatClient() {
		super("::::::::::::::::::::::::ä��Ŭ���̾�Ʈ::::::::::::::::::::::::::::::::::::::::::::");
		jtfTalk=new JTextField();
		jbtnConnectServer=new JButton("��������");
		jtaTalkDisplay=new JTextArea();
		jtaTalkDisplay.setEditable(false);
		jtfTalk.setBackground(Color.WHITE);
		
		JScrollPane jspTalkDisplay=new JScrollPane( jtaTalkDisplay );
		jspTalkDisplay.setBorder(new TitledBorder("��ȭ����"));
		
		JPanel jpanel=new JPanel();
		jpanel.add(jbtnConnectServer);
		jtfTalk.setBorder(new TitledBorder("��ȭ�Է�"));
		
		
		add("North",jpanel);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);
		
		jtfTalk.addActionListener(this);
		jbtnConnectServer.addActionListener(this);
		
		
		setBounds(100,100,400,500);
		setVisible(true);
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				try {
					closeclient();
				} catch (IOException e) {
					e.printStackTrace();
				}//catch
				dispose();
			}//windowClosing
		});
		
		jtfTalk.requestFocus();
	}//SimpleChatServer
	
	
	/**
	 * ������ �����Ͽ� ���� ���Ͽ� ����õ�
	 * �����͸� �ְ� �ޱ� ���� ��Ʈ���� �����Ѵ�.
	 * @throws IOException
	 */
	public void connectToServer()throws IOException {
		String ipAddr=JOptionPane.showInputDialog("���Ӽ����� �ּҸ� �Է����ּ���.","211.63.89");
		
		client=new Socket(ipAddr,10000);//������ ����õ�
		//�����͸� �ְ� �ޱ� ���� ��Ʈ���� ����
		readStream=new DataInputStream(client.getInputStream());//�����͸� ���� �غ� �� ����
		writeStream=new DataOutputStream(client.getOutputStream());//�����͸� �� �غ� �� ����
		
		readMsg();
	}//connectToServer
	
	
	/**
	 * ��ȭ��밡 �������� �޽��� �б�
	 */
	public void readMsg() throws IOException {
		String msg="";
		while(true) {
		msg=readStream.readUTF();	
		jtaTalkDisplay.append(msg+"\n");//��ȭ����â�� �޽��� ���
		}//while
		
	}//readMsp
	
	
	/**
	 * �Էµ� �޽����� ������ �����ϴ� ��
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		//��ȭ������ �Է��ϴ� JTextField���� �Էµ� ����
		String sendMsg="[ȣ����]"+jtfTalk.getText();
		//��ȭ����â�� ��ȭ ����
		jtaTalkDisplay.append(sendMsg+"\n");
		//��Ʈ���� ���
		writeStream.writeUTF(sendMsg);
		//��Ʈ���� ������ �������� ����
		writeStream.flush();
		
	}//sendMsg
	
	
	public void closeclient() throws IOException {
		if(readStream!=null) {readStream.close();}//if
		if(writeStream!=null) {writeStream.close();}//if
		if(client!=null) {client.close();}//if
		
	}//closeclient
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jbtnConnectServer) {
			try {
				connectToServer();
			} catch (IOException e) {
				e.printStackTrace();
			}//catch
		}//if
		
		if(ae.getSource()==jtfTalk) {
			try {
				sendMsg();
			} catch (IOException e) {
				e.printStackTrace();
			}//catch
		}//if

	}//actionPerformed

	
	public static void main(String[] args) {
		new SimpleChatClient();
	}//main

}//class
