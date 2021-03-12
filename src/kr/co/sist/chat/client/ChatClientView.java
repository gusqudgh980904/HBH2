package kr.co.sist.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author user
 *
 */
@SuppressWarnings("serial")
public class ChatClientView extends JFrame implements ActionListener, Runnable {

	private JTextField jtfServerIp, jtfNick, jtfTalkInput;
	private JTextArea jtaChatView;
	private JButton jbtnConn, jbtnCapture;
	
	private Socket someClient;//
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	
	private Thread connThread;//�޽����� �б����� Thread
	
	private JScrollPane jspChatView;
	private String nick;
	
	public ChatClientView() {
		super(":::::::::::ä�� Ŭ���̾�Ʈ::::::::::::::::");
		
		 jtfServerIp=new JTextField(10); 
		 jtfNick=new JTextField(10); 
		 jtfTalkInput=new JTextField(); 
		
		 jtaChatView=new JTextArea();
		
		 jbtnConn=new JButton("��������");
		 jbtnCapture=new JButton("ĸó");//������
		 		
		 JPanel jpControl=new JPanel();
		 jpControl.setBorder(new TitledBorder("��������"));
		 jpControl.add(new JLabel("�����ּ�"));
		 jpControl.add(jtfServerIp);
		 jpControl.add(new JLabel("��ȭ��"));
		 jpControl.add(jtfNick);
		 jpControl.add(jbtnConn);
		 jpControl.add(jbtnCapture);
		 
		 jspChatView=new JScrollPane(jtaChatView);
		  
		 
		 add("Center",jspChatView);
		 add("North",jpControl);
		 add("South",jtfTalkInput);
		 
		 jtfTalkInput.addActionListener(this);
		 jbtnConn.addActionListener(this);
		 jbtnCapture.addActionListener(this);
		 
		 addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				try {
					closeClient();
				} catch (IOException ie) {
					ie.printStackTrace();
				}finally {
					dispose();
				}//finally
			}//windowClosing
			 
		});
		 
		 setBounds(100, 100, 600, 400);
		 setVisible(true);
		 
	}//ChatClientView
	
	
	public void closeClient() throws IOException{
		if(readStream!=null) {readStream.close();}//if
		if(writeStream!=null) {writeStream.close();}//if
		if(someClient!=null) {someClient.close();}//if
	}//closeClient
	
	
	@Override
	public void run() {
		String revMsg="";
		try {
		while(true) {
			//�޽����� �о
			revMsg=readStream.readUTF();
			//��ȭâ�� ���
			jtaChatView.append(revMsg);
			jtaChatView.append("\n");
			//��ȭ�� �����Ǹ� �� Scrollbar�� ���� �缳���Ͽ� �ֽŴ�ȭ�� ���� �� �ֵ��� �����Ѵ�.
			jspChatView.getVerticalScrollBar().setValue(jspChatView.getVerticalScrollBar().getMaximum());
		}//while
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this,"������ ������ ������ϴ�.");
				e.printStackTrace();
			}//catch
		
	}//run
	
	
	/**
	 * ������ �����ϰ�,��Ʈ���� ������ ��,��ȭ�� �о� ���δ�.
	 * @param ipAddress
	 * @throws IOException
	 */
	public void connectToServer(String ipAddress) throws IOException {
		someClient=new Socket(ipAddress,2021);
		readStream=new DataInputStream(someClient.getInputStream());
		writeStream=new DataOutputStream(someClient.getOutputStream());
		//�������ڸ��� �г����� ������.
		nick=jtfNick.getText();
		writeStream.writeUTF(nick);
		writeStream.flush();
		
		jtaChatView.setText("������ ���� �Ͽ����ϴ�.\n");
		jtaChatView.append(nick+"(��)�� �����Ͽ����ϴ�.\n");
		
		
		connThread=new Thread(this);
		connThread.start();
		
		
	}//connectToServer
	

	/**
	 * ������ �޽����� ������ ��
	 * @throws IOException
	 */
	public void sendMsg(String msg) throws IOException {
		if(writeStream!=null) {
			
		//��Ʈ���� �޽����� ����
		writeStream.writeUTF(msg);
		//��Ʈ���� ��ϵ� ������ ������(����)�� ����
		writeStream.flush();
		}//if
		
	}//sendMsg
	
	
	/**
	 * ��ȭ���� ĸ��
	 */
	public void capture() throws IOException {
		File path=new File("c:/dev/capture");
		
		if(!path.exists()) {
			path.mkdirs();
		}//if
		
		BufferedWriter bw=null;
		
		try {
			bw=new BufferedWriter(new FileWriter(path+"/capture_"+System.currentTimeMillis()+".dat"));
			bw.write(jtaChatView.getText());
			bw.flush();
			JOptionPane.showMessageDialog(this,"��ȭ ������ ���� �Ǿ����ϴ�.");
		}finally {
			if(bw!=null) {bw.close();}//if
		}//finally
		
	}//capture
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==jbtnConn) {//���� ����
			String ipAddress=jtfServerIp.getText().replaceAll(" ","");
			
			if(ipAddress.equals("")) {
				JOptionPane.showMessageDialog(this,"������ IP�ּҸ� �Է��� �ּ���");
			}else {
				
			
			if(connThread==null) {
				try {
					connectToServer(ipAddress);
				} catch (IOException e) {
					e.printStackTrace();
				}//catch
			}else {
			JOptionPane.showMessageDialog(null,"�̹� ������ ���� ���Դϴ�.");	
			}//else
			
		}//else
		
	}//if
		
		if(ae.getSource()==jbtnCapture) {//ĸ��
			try {
				capture();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//if
		
		if(ae.getSource()==jtfTalkInput) {//��ȭ���� �Է�
//		String nick="["+jtfNick.getText()+"]:";
		String talk="["+nick+"]"+jtfTalkInput.getText();
		try {
			sendMsg(talk);//��ȭ�� ���� ��
			jtfTalkInput.setText("");//��ȭ ���� �ʱ�ȭ
		} catch (IOException e) {
			e.printStackTrace();
			}//catch
		}//if

	}//actionPerformed

	
	public static void main(String[] args) {
		new ChatClientView();
	}//main

}//class
