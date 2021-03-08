package day0305;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 *	JVM ������ �����͸� JVM �ܺη� ������������ ��Ʈ��
 * @author user
 */
public class UseFileOutputStream {

	public UseFileOutputStream() throws IOException{
		//c:/dev/temp1 �̶�� ������ �������� ������ ������ �����ϰ�
		//������ �����ϸ� ������ �������� �ʴ´�
		File dir = new File("c:/dev/temp1");
		
		if(!dir.exists()) {
			dir.mkdirs();
		}//end if
		
		File file = new File(dir.getAbsolutePath() + "/write_test.txt");
		//������ ���ٸ� ���� �����ϰ�, �����Ѵٸ� ����������� ConfirmDialog�� ����Ͽ� �����, "Yes"�� ��������
		//���Ͽ� ���� ����, �׷��� �ʴٸ� ���Ͽ� ����� �ʵ��� �ڵ� �ۼ�
		
		boolean overWriteFlag = false;
		
		if(file.exists()) {
			
		switch ( JOptionPane.showConfirmDialog(null, file+"�� ����. ����ڽ��ϱ�?")) {
		case JOptionPane.OK_OPTION: 
			overWriteFlag=true;
		}//end switch
		} else {//������ ���� ���
			overWriteFlag=true;
		}//end else
		
		if(overWriteFlag) {
			FileOutputStream fos = null;
		//		FileOutputStream fos = new FileOutputStream(file);
			try {
				//1.��Ʈ�� ����
				fos = new FileOutputStream(file);
				//2.��Ʈ���� ���Ϸ� ��� ���� ����
				fos.write(97);
				//3. ��Ʈ���� ��ϵ� ������ �������� ����
			}finally {
				//4. ��Ʈ�� ����� ����Ǿ����� ���� ��
				if( fos != null ) { fos.close();}//end if
			}//end finally
		}//end if
		
	}//UseFileOutputStream
	
	public static void main(String[] args) {
		
		try {
			new UseFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
	}//main

}//class
