package day0305;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *	������ �Է������� �������� ���������� ���� ������ ����ϴ� ���α׷�
 * @author user
 */
public class Work0304 {
	
	/**
	 * ��θ� �Է¹޾� ��γ��� ���� ����, ������ file[]�� �޾ƿͼ� ��ȯ�ϴ� ��
	 * @return
	 */
	public File[] setPath() {
		File[] files = null;
		
		String path = JOptionPane.showInputDialog("��θ� �Է��ϼ��� \n ��) c:/dev/");
		
		if ( path != null && !path.equals("")) {//�ƹ��͵� �Է����� �ʾҴ��� ����
			
			File file = new File(path);
			
			if( file.exists() ) {//�Է��� ��ΰ� �����ϴ���?
				
				if(file.isDirectory()) {//��������?
					files = file.listFiles(); //������� ���� �ڿ��� ��� �����´�
				}else {
				JOptionPane.showMessageDialog(null, "������ ó�� �Ұ��� ���� �Է� ��");
				}
			}else {
				JOptionPane.showMessageDialog(null, "������� ���� ��� Ȯ�� ��");
			}//end else
			
		}else {
			JOptionPane.showMessageDialog(null, "��� �Է¤�");
		}//end else
				
		return files;
	}//setPath
	
	/**
	 * �Ű������� ����� file[]�� ����Ͽ� ����ϴ� ��
	 * @param contentFile
	 */
	public void printContent( File[] contentFile ) {
		//��µ����� ����
		StringBuilder sbContent = new StringBuilder();
		sbContent.append("�̸�\n ������ ������ \t ���� \t ũ�� \n ")
		.append("---------------------------------------------------------------------------------------\n");
		if( contentFile == null || contentFile.length == 0 ) {
			sbContent.append("������ ���� ������ ������ �������� �ʽ��ϴ�.");
		}//if
		
		if( contentFile != null ) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
			boolean fileFlag= false;
			
			for( File temp : contentFile ) {
				
				fileFlag = temp.isFile();
				sbContent.append( temp.getName() ).append("\t")
				.append(sdf.format(new Date(temp.lastModified()))).append("\t")
				.append( fileFlag ? "����":"����" );
				
				if(fileFlag) {//������ ��쿡�� ũ��(byte��) �� ���
					sbContent.append("\t").append(temp.length()).append("byte");
				}//end if
				
				sbContent.append("\n");
				
			}//end for
		}//end if

		
		JTextArea jtaContent = new JTextArea(sbContent.toString(), 15, 80);
		jtaContent.setEditable(false);
		
		JScrollPane jspContent = new JScrollPane(jtaContent);
		
		JOptionPane.showMessageDialog(null, jspContent);
	
	}//printContent

	public static void main(String[] args) {
		Work0304 work = new Work0304();
		File[] files =work.setPath();
		work.printContent(files);
	}//main

}//class
