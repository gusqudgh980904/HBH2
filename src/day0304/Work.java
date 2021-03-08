package day0304;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import day0303.DataVO;

public class Work {
	private List<WorkVO> dataList;
	File folder = new File(""); 

	public Work() {
		dataList = new ArrayList<WorkVO>();
	}//Work
	
	public void menu() {
		
		boolean exitFlag = false;
		do {
		JOptionPane.showInputDialog("c:/dev 폴더명 입력하세요"); //입력한 폴더명을 받습니다.
		//폴더명을 File클래스에 넣고 모든 파일배열을 받아와서 반복시켜 작업을 하게되요.;
		
		try { 
			boolean isDir = folder.isDirectory();
			boolean isFile = folder.isFile();
			if( isDir == true ) {
				inputData();
				printData();
			}//end if
			if(  folder.getName() != null ) {
				printData();
			}//end if
			if(  closeApp()) {
				  closeApp();
				  }//end if
		 else if(isFile == true){
			JOptionPane.showInputDialog(null, "파일은 처리할 수 없습니다.");
		}//end else if
		 else {
			 JOptionPane.showInputDialog(null, "폴더명을 입력하세요");
		 }//end else
		}catch(NullPointerException npe) {
			exitFlag = closeApp();
		}//end catch
		
		}while( !exitFlag );
	}//end menu
	
	public void inputData() {

		String[] tempData = null ;
		try {
			if( tempData.length == 1 ) {
				String folder = tempData[0];
				
				dataList.add(new WorkVO(folder));
			}else {
				JOptionPane.showMessageDialog(null, "입력형식은 폴더여야 합니다");
			}//end else
		}catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "입력할 값을 추가해주세요");
		}catch(NumberFormatException nfe) {
		JOptionPane.showMessageDialog(null, "폴더 형식어야 합니다");
	}//end catch
		
	}//inputData
	
	public void printData() {
		
		StringBuilder sbOutputData = new StringBuilder();
		sbOutputData.append("이름\t마지막 수정일\t유형\t크기\n");
		sbOutputData.append("----------------------------------------------------\n");
		if( dataList.isEmpty() ) {//데이터가 존재하지 않는 경우
			sbOutputData.append("입력된 데이터가 존재하지 않습니다");
		}//end if
		
			WorkVO wv = null;
			long lm = folder.lastModified();
			String op = folder.getPath();
			long sz = folder.getUsableSpace();
			for( int idx = 0; idx < dataList.size() ; idx ++ ) {
				wv = dataList.get(idx);
			
			sbOutputData.append(idx+1).append("\t").append(wv.getFolder()).append("\t")
			.append(lm).append("\t").append(op).append("\t").append(sz).append("\t");
			}//end for

			JTextArea jtaDataDisplay = new JTextArea(10, 60);
			jtaDataDisplay.setText(jtaDataDisplay.toString());
			jtaDataDisplay.setEditable(false);
			
		JOptionPane.showMessageDialog(null, jtaDataDisplay);
			
	}//printData
	
	public boolean closeApp() {
boolean flag = false;
		
		int selectExitBtn = JOptionPane.showConfirmDialog(null, "프로그램 종료하실?");
		System.out.println(selectExitBtn);
		switch (selectExitBtn) {
		case JOptionPane.OK_OPTION: flag = true;
		}//end switch
		return flag;
		
	}//closeApp
	
	public static void main(String[] args) {
		Work w = new Work();
		w.menu();
	}//main

}//class
