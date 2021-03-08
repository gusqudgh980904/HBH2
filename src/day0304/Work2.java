package day0304;

import java.awt.FileDialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Work2 extends JFrame implements ActionListener  {
	
	private JButton jbtn;

	public Work2() {
		super("folder 열기");
		
		
		JButton jbtn = new JButton("열기");
		JTextArea jta = new JTextArea();
		JPanel panel = new JPanel();
		
		panel.add(jbtn);
		panel.add(jta);
		panel.add("Center",jta);
		panel.add("South",jbtn);
		
		jbtn.addActionListener(this);
//		jta.add(getOwner());
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//Work2
	public void UseFileReader() throws FileNotFoundException, IOException {
		File file = new File("c:/dev/temp/java_read.txt"); //UTF-8
		//파일과 연결하는 기능을 가진 스트림
//		FileReader fr = new FileReader(file);
		//줄단위로 읽어들이는 기능을 가진 스트림
//		BufferedReader br = new BufferedReader(fr);
		
//		BufferedReader br = new BufferedReader(new FileReader(file)); //charset이 맞지않아 한글이 깨짐
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String lineData = "";
			
			while ( (lineData = br.readLine()) != null ) {//readLine() 줄단위로 읽어 들이는데 \n전까지 읽어들임
				System.out.println( lineData );
			}//end while
		}finally {
			//반드시 끊어져야한다
		if ( br != null ) { br.close(); }//end if 
	
		}//end finally
		
	}//UseFileReader
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtn) {
			FileDialog fd = new FileDialog(this, "파일열기",FileDialog.LOAD);
			fd.setVisible(true);
			
			String fileName = fd.getFile();
			boolean ew = fileName.endsWith("txt");
			
			if( ew == true ) {
//				contents.setText(fileName);
			}
		}
	}

	public static void main(String[] args) {
		new Work2();
	}//main

	
}//class
