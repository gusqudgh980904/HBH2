
package day0304;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *	16bit ��Ʈ���� ����Ͽ� ���ڿ� ���� �б�(�������� ������ ���� �ܼ� ���ڿ��� �о�鿩 Ȯ���� �� �ִ�)
 * @author user
 */
public class UseFileReader {
	public UseFileReader() throws FileNotFoundException, IOException {
		File file = new File("c:/dev/temp/java_read.txt"); //UTF-8
		//���ϰ� �����ϴ� ����� ���� ��Ʈ��
//		FileReader fr = new FileReader(file);
		//�ٴ����� �о���̴� ����� ���� ��Ʈ��
//		BufferedReader br = new BufferedReader(fr);
		
//		BufferedReader br = new BufferedReader(new FileReader(file)); //charset�� �����ʾ� �ѱ��� ����
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String lineData = "";
			
			while ( (lineData = br.readLine()) != null ) {//readLine() �ٴ����� �о� ���̴µ� \n������ �о����
				System.out.println( lineData );
			}//end while
		}finally {
			//�ݵ�� ���������Ѵ�
		if ( br != null ) { br.close(); }//end if 
	
		}//end finally
		
	}//UseFileReader
	
	public static void main(String[] args) {
		try {
			new UseFileReader();
		} catch (FileNotFoundException fnfe) {
			System.err.println("������ �������� �ʽ��ϴ�");
			fnfe.printStackTrace();
		} catch (IOException ie) {
			System.err.println("�����б� �۾� �� ���� �߻�");
			ie.printStackTrace();
		}//end catch
	}//main

}//class
