package kr.co.sist.javamemo.run;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.co.sist.javamemo.JavaMemo;

/**
 * �޸����� �����ϱ� ���� Ŭ����
 * @author user
 */
public class RunJavaMemo {
	
	public RunJavaMemo() throws FileNotFoundException, IOException, ClassNotFoundException {
		//�۲������� ������ ���Ͽ��� �۲��� �о�鿩 ������ ��ü(JavaMemo)�� ����
		ObjectInputStream ois=null;
		Font font=null;
		
		try {
			//���Ͽ� ��Ʈ�� ����
			ois=new ObjectInputStream(new FileInputStream("c:/dev/memo/memo.dat"));
			//���Ͽ� ��ϵ� ��ü�� �б�
			font=(Font)ois.readObject();
		}finally {
			//��Ʈ�� ���� ����
			if(ois!=null) {ois.close();}
			//��Ʈ������ �о���̱⸦ �����ϴ��� ������ �ݵ�� ����,����ڿ��� ���α׷��� �����Ǿ�� �Ѵ�
			new JavaMemo(font); //�����ϴ� Ŭ������ RunJavaMemo�� �Ǿ���մϴ�.
		}//finally
		
	}//RunJavaMemo

	public static void main(String[] args) {
		try {
			new RunJavaMemo();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		
	}//main

}//class
