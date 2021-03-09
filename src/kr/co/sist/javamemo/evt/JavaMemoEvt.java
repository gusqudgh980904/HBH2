package kr.co.sist.javamemo.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import kr.co.sist.javamemo.JavaMemo;
import kr.co.sist.javamemo.MemoFont;

/**
 * JavaMemo�������� �̺�Ʈó�� Ŭ����
 * @author user
 */
public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm; //has a
	private String flagNote; //����(����,����)�� �񱳸� �ϱ� ���� ���ڿ� ��.
	private String path;//���⳪ �����۾� ������ ������ ��θ� ����
	private String fileName;//���⳪ �����۾� ������ ���ϸ� ����
	
	public JavaMemoEvt( JavaMemo jm ) {
		this.jm=jm;
		flagNote = ""; //null�� JTextArea�� �ʱⰪ�� ��ġ��Ű������ �ʱ�ȭ ��
		path="";
		fileName="";
	}//javaMemoEvt
	
	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}//windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jm.getJmiFont()) {//�۲ÿ��� �̺�Ʈ�� �߻�.
			memoFont();
			}//end if
		
			if(ae.getSource() == jm.getJmiNew()) {//���ۿ��� �̺�Ʈ�� �߻�.
				newMemo();
			}//end if
			
			if(ae.getSource() == jm.getJmiOpen()) {//���⿡�� �̺�Ʈ�� �߻�.
				try {	
				openMemo();
				}catch(IOException ie) {
					JOptionPane.showMessageDialog(jm,"������ ���� ���� �����߻�");
					ie.printStackTrace();
				}//end catch
			}//end if
			
			if(ae.getSource() == jm.getJmiNewSave()) {//"�� �̸����� ����"���� �̺�Ʈ�� �߻�.
				newSaveMemo();
			}//end if

			if(ae.getSource() == jm.getJmiSave()) {//"����"���� �̺�Ʈ�� �߻�.
				saveMemo();
			}//end if
			
	}//actionPerformed

	
	/**
	 * �۲� ����
	 */
	public void memoFont() {
		new MemoFont( jm ); //�۲ü��� JDialog ����.
	}//memoFont
	
	
	/**
	 * ����
	 */
	public void newMemo() {
		JTextArea jtaMemo = jm.getJtaNote();
		
		boolean newMemoflag=false;
		if( !jtaMemo.getText().equals("") && !flagNote.equals(jtaMemo.getText())) {
			//�ؽ�Ʈ ���� ������ �����ϸ� ���忩�θ� ���´�
			//�����۾����� ����� �ٸ���
			switch (JOptionPane.showConfirmDialog(jm, "�����Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:saveMemo(); newMemoflag=false; break;//���� �� ����
			case JOptionPane.NO_OPTION:newMemoflag=false; break;//�������� �ʰ� ����
			case JOptionPane.CANCEL_OPTION:newMemoflag=true;//������� ����
			}//end switch
		}//end if
		
		if(!newMemoflag) {//����� ������ �ϰ� �Ʒ������� ���ุ �Ѵ�.
		jtaMemo.setText("");
		jm.setTitle("�޸��� - ����");
		//�����ߴ� ���ϸ� �Ǵ� �����ߴ� ��ο� ���ϸ��� �ʱ�ȭ�Ѵ�.
		path="";
		fileName="";
		}//if
		
	}//newMemo
	
	
	/**
	 * ����
	 */
	public void openMemo() throws IOException {
		
		//�����ߴ� ����� ���� JTextArea�� ������ ���ٸ� ���⸦ ������ �ٸ��ٸ� ���忩�θ� ���� ���⸦ ����
		boolean openFlag=false;
		if(!flagNote.equals(jm.getJtaNote().getText())) {
			switch(JOptionPane.showConfirmDialog(jm,"�����Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:saveMemo();openFlag=false;break;
			case JOptionPane.NO_OPTION:openFlag=true;break;
			case JOptionPane.CANCEL_OPTION:break;
			}//switch
		}//if
			
		if(!openFlag) {
			
		FileDialog fdOpen = new FileDialog(jm,"���� - �ڹٸ޸���", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path = fdOpen.getDirectory();
		String fileName = fdOpen.getFile();
		
		if(path != null) {//����ڰ� ������ �����ϰ� ���⸦ ������
			
			BufferedReader br = null; //������ �б����� ��Ʈ�� ����
			try {
				//������ ������ ������ �о���̱����� ���Ͽ� ��Ʈ�� ����
				br = new BufferedReader(new FileReader(path+fileName));
				String lineData = "";
				StringBuilder sbReadData = new StringBuilder();
				
				while( (lineData = br.readLine()) != null) {//���� �о�鿩 1
					sbReadData.append(lineData).append("\n"); //������ �����ϰ� 2
				}//end while
				
				jm.getJtaNote().setText(sbReadData.toString());//JTextArea�� ���� 3
				flagNote = jm.getJtaNote().getText(); //�������� ����� ������ ���� ���� ����
				this.path=path;//������ ���ϰ�θ� ����ϱ� ���� ����
				this.fileName=fileName;//������ ���ϸ��� ����ϱ� ���� ����
				
				jm.setTitle("�޸��� - ���� [" +fileName + "]");
				
			}finally {
				if( br != null ) { br.close(); }//end if
			}//end finally
		}//end if
	}//if
		
	}//openMemo
	
	
	/**
	 * ����
	 */
	public void saveMemo() {
		//������ �������� ���ų�,�� ���� ���� ���Ŀ��� ������ ���ϸ��� �����Ƿ� ���ϴ��̾�α׸� �����ϰ�,
		//������ ���Ȱų� ������ �Ǿ��ٸ� ������ ��ο� ���ϸ��� ����Ͽ� ����
		try {
		if(this.path.equals("")) {
			newSaveMemo();
		}else {
				saveFile(path,fileName);
		}//else
		
		} catch (IOException e) {
			JOptionPane.showMessageDialog(jm,"�����۾� �� �����߻�");
			e.printStackTrace();
		}//catch
		
		
	}//saveMemo
	
	
	/**
	 * ���̸����� ����
	 */
	public void newSaveMemo() {
		FileDialog fdSave=new FileDialog(jm,"����-�ڹٸ޸���",FileDialog.SAVE);
		fdSave.setVisible(true);
		
		String path=fdSave.getDirectory();//���
		String fileName=fdSave.getFile();//���ϸ�
		
		if(path!=null) {
			try {
				saveFile(path, fileName);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm,"�� �̸����� �����ϴ� �� ������ �߻�");
				e.printStackTrace();
			}//catch
		}//if
		
	}//newSaveMemo
	
	
	/**
	 * ��� ��Ʈ���� ����Ͽ� ���Ͽ� ����
	 * @param path
	 */
	private void saveFile(String path,String fileName) throws IOException {
		BufferedWriter bw=null;
		
		try {
			bw=new BufferedWriter(new FileWriter(path+fileName));
			//�ؽ�Ʈ������� ������ ���Ͽ� ����
			String text=jm.getJtaNote().getText();
			bw.write(text);//��Ʈ���� ���� ���
			bw.flush();//��Ʈ���� ��ϵ� ������ �������� ����
			
			this.path=path;//������ ���ϰ�θ� ����ϱ� ���� ����
			this.fileName=fileName;//������ ���ϸ��� ����ϱ� ���� ����
		
			jm.setTitle("�޸��� - ���� [" +fileName + "]");
			
		}finally {
			if(bw!=null) {bw.close();}//if
		}//finally
		
	}//saveFile
	 
	
	/**
	 * ����
	 */
	public void end() {
		
	}//end
	
}//class
