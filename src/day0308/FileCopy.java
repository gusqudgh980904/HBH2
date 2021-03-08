package day0308;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class FileCopy extends JFrame implements ActionListener {
	
	private JButton jbtn16bitStream, jbtn8bitStream;
	
	public FileCopy() {
		super("파일복사");
		
		jbtn16bitStream = new JButton("16bit 파일선택");
		jbtn8bitStream = new JButton("8bit 파일선택");
		
		JPanel panel = new JPanel();
		panel.add(jbtn16bitStream);
		panel.add(jbtn8bitStream);
		
		add("Center", panel);
		
		jbtn16bitStream.addActionListener(this);
		jbtn8bitStream.addActionListener(this);
		
		setBounds(100, 100, 500, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//FileCopy
	
	public void use16bit(String originalName, String cpName) throws IOException {
		//읽기 스트림 연결
		BufferedReader br = null;
		//쓰기 스트림 연결
		BufferedWriter bw = null;
		
		try {
			//읽기 스트림 연결
			br = new BufferedReader(new FileReader(originalName));
			//쓰기 스트림 연결
			bw = new BufferedWriter(new FileWriter(cpName));
			
			String data ="";
			
			while( (data=br.readLine()) != null ) {//스트림에서 읽기
				//스트림에서 읽어들인 내용을 스트림에 쓰기
				System.out.println(data);
				bw.write(data);
			}//end while
			//스트림에 있는 남은 내용을 목적지로 분출
			bw.flush();
		}finally {
			JOptionPane.showMessageDialog(this, cpName+"파일로 복사 되었습니다");
			//연결 끊기
			if( br != null ) {br.close();}//end if
			if( bw != null ) {bw.close();}//end if
		}
	}//use16bit
	
	public void use8bit(String originalName, String cpName) throws IOException {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			
			//읽기스트림 생성
			fis = new FileInputStream(originalName);
			//쓰기스트림 생성
			fos = new FileOutputStream(cpName);
			
			//////////////////////////////////////////////////DISK IO가 적게 발생하는 코드 //////////////////////////////////////////////////////////
				byte[] readData = new byte[512];
				int leng = 0; //배열에 채워진 갯수.
				
				while( (leng = fis.read(readData)) != -1 ) {//파일에서 읽어들인 갯수가 있다면
					fos.write(readData, 0, leng); //배열의 처음방에서 읽어들인 방까지 기록
					
				}//end while
				
			//////////////////////////////////////////////////DISK IO가 적게 발생하는 코드 //////////////////////////////////////////////////////////
				
			//////////////////////////////////////////////////DISK IO가 많이 발생하는 코드 //////////////////////////////////////////////////////////
//			int readData = 0; //연결된 파일에서 읽어들인 byte를 저장할 변수
//			
//			while( (readData = fis.read()) != -1 ) {//1byte씩 읽어들여
//				fos.write( readData ); //1byte씩 쓴다
//				System.out.println( readData ); //출력
//			}//end while
			//스트림에 존재하는 내용을 목적지로 분출
			
			//////////////////////////////////////////////////DISK IO가 많이 발생하는 코드 //////////////////////////////////////////////////////////
			fos.flush();
			
			JOptionPane.showMessageDialog(this, cpName +"파일로 생성 되었습니다");

		}finally {
			//스트림의 연결 끊기
			if( fis != null ){fis.close();}//end if
			if( fos != null ){fos.close();}//end if
		}//end finally
		
	}//use8bit
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//FileDialog를 읽기모드로 열기
		FileDialog fdOpen = new FileDialog(this, "복사할 파일 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path = fdOpen.getDirectory();
		String file = fdOpen.getFile();
		
		if( path != null ) {
			// 선택한 원본파일명을 사용하여 "파일명_cp.확장자" 형태의 이름을 만들어보기
			StringBuilder sbCpFileName = new StringBuilder( file ); //복사할 파일명을 생성할 S.B
			sbCpFileName.insert(sbCpFileName.lastIndexOf("."), "_cv");
			
			if(ae.getSource() == jbtn16bitStream) {
				try {
				use16bit(path + file, path + sbCpFileName.toString() );
				}catch(IOException e) {
					e.printStackTrace();
				}//end catch
			}//end if
			
			if(ae.getSource() == jbtn8bitStream) {
				try {
				use8bit(path + file , path + sbCpFileName.toString() );
				}catch(IOException e) {
					e.printStackTrace();
				}//end catch
			}//end if
			
		}//end if
		
		
	}//actionPerformed

	public static void main(String[] args) {

		new FileCopy();
		
	}//main

}//class
