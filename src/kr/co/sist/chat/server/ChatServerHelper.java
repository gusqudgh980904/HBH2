package kr.co.sist.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;


/**
 * 접속자 소켓을 저장하고,스트림을 연결하여,접속자가 보내오는 메시지를 읽고,
 * 모든 접속자에게 보내는 일
 * @author user
 */
public class ChatServerHelper extends Thread {
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	
	private DefaultListModel<String> dlmClientStatus;
	private int connCnt; 
	
	private String nick;//접속자가 사용하는 닉네임.

	/**
	 * 서버에 접속한 소켓을 받아,스트림을 연결하는 일
	 * @param someClient 접속한 소켓
	 * @param dlmClientStatus 접속자의 상태를 서버창에 보내기 위한 Model객체
	 * @param connCnt 접속한 번째
	 */
	public ChatServerHelper  (Socket someClient,DefaultListModel<String> dlmClientStatus,int connCnt)throws IOException {
		this.someClient=someClient;
		this.dlmClientStatus=dlmClientStatus;
		this.connCnt=connCnt;
		
		//접속자 IP얻기(부인방지)
		InetAddress ia=someClient.getInetAddress();
		
		
		//소켓에서 스트림을 연결
		readStream=new DataInputStream(someClient.getInputStream());
		writeStream=new DataOutputStream(someClient.getOutputStream());
		
		//연결되자마자 클라이언트가 닉네임을 보내오니 닉네임을 받는다.
		nick=readStream.readUTF();

		StringBuilder sbConnMsg=new StringBuilder();
		sbConnMsg.append("[").append(connCnt).append("]번째 접속자 접속자로 ").append(nick).append("님이 접속하셨습니다.");
		//서버 관리창에 상태정보를 추가
		dlmClientStatus.addElement(sbConnMsg.toString()+"/"+ia.getHostAddress());
		//모든 접속자에게 접속자가 있다는 상태를 보여준다.
		broadcast(sbConnMsg.toString());
		
	}//ChatServerHelper
	
	
	/**
	 * 메시지 읽기를 동시에 수행
	 */
	public void run() {
		String revMsg="";
		
		try {
		while(true) {
			//접속자가 보내오는 메시지를 받고
			revMsg=readStream.readUTF();
			//받은 메시지를 모든 접속자에서 출력
			broadcast(revMsg);
		}//while
		} catch (IOException e) {
			//메시지를 읽거나 보내지 못하는 상태->접속자의 스트림이 끊어진 상태
			try {
				closeClient();
			} catch (IOException e1) {
				e1.printStackTrace();
			}//catch
			
			//서버창에 접속자의 상태를 기록
			StringBuilder sbMsg=new StringBuilder();
			sbMsg.append("[").append(nick).append("]님의 접속자가 접속이 종료되었습니다");
			dlmClientStatus.addElement(sbMsg.toString());
			//나를 제외한 모든 접속자에게 끊어진 상태를 출력
			ChatServerView.connList.remove(this);
			try {
				broadcast(sbMsg.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}//catch
			e.printStackTrace();
		}//catch
		
	}//run
	
	
	public void closeClient() throws IOException {
		if(readStream!=null) {readStream.close();}
		if(writeStream!=null) {writeStream.close();}
		if(someClient!=null) {someClient.close();}
		
	}//closeClient
	
	
	/**
	 * 접속자가 보내온 메세지를 읽어,모든 접속자에 보내는 일
	 * @param msg
	 * @throws IOException 
	 */
	public synchronized void broadcast(String msg) throws IOException {
		//static 리스트 (ArrayList=>Handler)를 받아왔다.
		List<ChatServerHelper> connList=ChatServerView.connList;
		
//		ChatServerHelper csh=null;
//		for(int i=0;i<connList.size();i++) {
//			csh=connList.get(i);//접속자에게 메세지를 보내기 위해 접속자를 받는다.
//			csh.writeStream.writeUTF(msg);//접속자의 스트림에 대화 기록
//			csh.writeStream.flush();//접속자 스트림에 기록된 내용을 분출
//		}//for
		
		//인덱스를 사용하지 않고, 출력 스트림만 사용한다.
		for(ChatServerHelper csh:connList) {
			csh.writeStream.writeUTF(msg);
			csh.writeStream.flush();
		}//for
		
	}//broadcast
	
	
}//class
