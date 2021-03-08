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
		JOptionPane.showInputDialog("c:/dev ������ �Է��ϼ���"); //�Է��� �������� �޽��ϴ�.
		//�������� FileŬ������ �ְ� ��� ���Ϲ迭�� �޾ƿͼ� �ݺ����� �۾��� �ϰԵǿ�.;
		
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
			JOptionPane.showInputDialog(null, "������ ó���� �� �����ϴ�.");
		}//end else if
		 else {
			 JOptionPane.showInputDialog(null, "�������� �Է��ϼ���");
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
				JOptionPane.showMessageDialog(null, "�Է������� �������� �մϴ�");
			}//end else
		}catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "�Է��� ���� �߰����ּ���");
		}catch(NumberFormatException nfe) {
		JOptionPane.showMessageDialog(null, "���� ���ľ�� �մϴ�");
	}//end catch
		
	}//inputData
	
	public void printData() {
		
		StringBuilder sbOutputData = new StringBuilder();
		sbOutputData.append("�̸�\t������ ������\t����\tũ��\n");
		sbOutputData.append("----------------------------------------------------\n");
		if( dataList.isEmpty() ) {//�����Ͱ� �������� �ʴ� ���
			sbOutputData.append("�Էµ� �����Ͱ� �������� �ʽ��ϴ�");
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
		
		int selectExitBtn = JOptionPane.showConfirmDialog(null, "���α׷� �����Ͻ�?");
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
