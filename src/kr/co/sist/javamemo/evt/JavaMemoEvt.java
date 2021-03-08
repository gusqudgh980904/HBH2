package kr.co.sist.javamemo.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import kr.co.sist.javamemo.JavaMemo;
import kr.co.sist.javamemo.MemoFont;

/**
 * JavaMemo디자인의 이벤트처리 클래스
 * @author user
 */
public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm; //has a
	private String flagNote; //열기(새글)에 비교를 하기 위한 문자열 값. 
	
	public JavaMemoEvt( JavaMemo jm ) {
		this.jm=jm;
		flagNote = ""; //null을 JTextArea의 초기값과 일치시키기위한 초기화 값
	}//javaMemoEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}//windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jm.getJmiFont()) {//글꼴에서 이벤트를 발생.
			memoFont();
			}//end if
			if(ae.getSource() == jm.getJmiNew()) {//새글에서 이벤트를 발생.
				newMemo();
			}//end if
			if(ae.getSource() == jm.getJmiOpen()) {//에서 이벤트를 발생.
				try {	
				openMemo();
				}catch(IOException ie) {
					ie.printStackTrace();
				}//end catch
			}//end if
	}//actionPerformed

	/**
	 * 글꼴 설정
	 */
	public void memoFont() {
		new MemoFont( jm ); //글꼴설정 JDialog 생성.
	}//memoFont
	
	/**
	 * 새글
	 */
	public void newMemo() {
		JTextArea jtaMemo = jm.getJtaNote();
		
		
		if( !jtaMemo.getText().equals("") && !flagNote.equals(jtaMemo.getText())) {//텍스트 에어리어에 내용이 존재하면 저장여부를 묻는다
			//열기작업후의 내용과 다른지
			switch (JOptionPane.showConfirmDialog(jm, "저장하시겠습니까?")) {
			case JOptionPane.OK_OPTION:	 break;
			case JOptionPane.NO_OPTION: break;
			case JOptionPane.CANCEL_OPTION: break;
			}//end switch
		}//end if
		
		
		jtaMemo.setText("");
		jm.setTitle("메모장 - 새글");
		
	}//newMemo
	
	/**
	 * 열기
	 */
	public void openMemo() throws IOException {
		
		FileDialog fdOpen = new FileDialog(jm,"열기 - 자바메모장", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path = fdOpen.getDirectory();
		String fileName = fdOpen.getFile();
		
		if(path != null) {//사용자가 파일을 선택하고 열기를 했을때
			
			BufferedReader br = null; //파일을 읽기위한 스트림 연결
			try {
				//선택한 파일의 내용을 읽어들이기위해 파일에 스트림 생성
				br = new BufferedReader(new FileReader(path+fileName));
				String lineData = "";
				StringBuilder sbReadData = new StringBuilder();
				
				while( (lineData = br.readLine()) != null) {//한줄 읽어들여 
					sbReadData.append(lineData).append("\n"); //라인을 누적하고
				}//end while
				
				jm.getJtaNote().setText(sbReadData.toString());//JTextArea에 설정
				flagNote = jm.getJtaNote().getText(); //기준으로 사용할 변수에 현재 값을 설정
				jm.setTitle("메모장 - 열기 [" +fileName + "]");
			}finally {
				if( br != null ) { br.close(); }//end if
			}//end finally
			
		}//end if
		
	}//openMemo
	
	/**
	 * 저장
	 */
	public void saveMemo() {
		
	}//saveMemo
	
	/**
	 * 새이름으로 저장
	 */
	public void newSaveMemo() {
		
	}//newSaveMemo
	
	/**
	 * 종료
	 */
	public void end() {
		
	}//end
	
}//class
