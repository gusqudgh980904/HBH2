package day0304;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *	HDD �� �����ϴ� File�� ������ ��� ���� ������� Ŭ������ ���
 * @author user
 */
public class UseFile {

	public UseFile() {
		//1.��ü����
		File file = new File("c:/dev/temp/java_read.txt");
		System.out.println( file );//��ü�� ������� �� �ּҰ� ������ �ʴ� ����? java.lang.Object Ŭ������ toString()�� Override�߱⶧��
		System.out.println("������ ����?"+file.exists());
		
		try {
			System.out.println("�Թ���� : " +file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		System.out.println("������ : "+file.getAbsolutePath());
		System.out.println("����� : "+file.getPath()); //������(AbsolutePath)�� �Ȱ�
		
		System.out.println("������ �ִ� ������ : " + file.getParent());
		System.out.println("���ϸ� : " + file.getName());
		
		System.out.println("����?  " + file.isFile());
		System.out.println("����?  " + file.isDirectory());
		
		System.out.println("���డ��?  " + file.canExecute());
		System.out.println("�бⰡ��?  " + file.canRead());
		System.out.println("���Ⱑ��?  " + file.canWrite()); //����Ұ����� ���� ODD
		
		System.out.println("��������?  " + file.isHidden());
		long lm = file.lastModified();
		System.out.println("���������� ������ ��¥ : " + lm);
		Date date = new Date(lm);
		System.out.println(date); //���������� ������ ��¥�� �� �� �ִ�=>���ϴ� ���ĺ�ȯ : SimpleDateFormat

		
//		System.out.println("���ϻ���?  " + file.delete());
		
		File mk = new File("c:/test/temp");
		mk.mkdir();
		System.out.println("��������?  " + mk.mkdir()); //make directory -������ �ϳ��̸� ���� ��������
																		//�ֻ����������� �����ϴµ� ���������� �����ϸ� ����
		System.out.println("��������?  " + mk.mkdirs()); //-������ �ϳ��̸� ���� ��������
																		// ���������� �����ϴ��� ��������
		
	}//UseFile
	
	public static void main(String[] args) {
		new UseFile();
	}//main

}//class
