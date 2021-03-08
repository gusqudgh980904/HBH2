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
 * JavaMemo�������� �̺�Ʈó�� Ŭ����
 * @author user
 */
public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm; //has a
	private String flagNote; //����(����)�� �񱳸� �ϱ� ���� ���ڿ� ��. 
	
	public JavaMemoEvt( JavaMemo jm ) {
		this.jm=jm;
		flagNote = ""; //null�� JTextArea�� �ʱⰪ�� ��ġ��Ű������ �ʱ�ȭ ��
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
			if(ae.getSource() == jm.getJmiOpen()) {//���� �̺�Ʈ�� �߻�.
				try {	
				openMemo();
				}catch(IOException ie) {
					ie.printStackTrace();
				}//end catch
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
		
		
		if( !jtaMemo.getText().equals("") && !flagNote.equals(jtaMemo.getText())) {//�ؽ�Ʈ ���� ������ �����ϸ� ���忩�θ� ���´�
			//�����۾����� ����� �ٸ���
			switch (JOptionPane.showConfirmDialog(jm, "�����Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:	 break;
			case JOptionPane.NO_OPTION: break;
			case JOptionPane.CANCEL_OPTION: break;
			}//end switch
		}//end if
		
		
		jtaMemo.setText("");
		jm.setTitle("�޸��� - ����");
		
	}//newMemo
	
	/**
	 * ����
	 */
	public void openMemo() throws IOException {
		
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
				
				while( (lineData = br.readLine()) != null) {//���� �о�鿩 
					sbReadData.append(lineData).append("\n"); //������ �����ϰ�
				}//end while
				
				jm.getJtaNote().setText(sbReadData.toString());//JTextArea�� ����
				flagNote = jm.getJtaNote().getText(); //�������� ����� ������ ���� ���� ����
				jm.setTitle("�޸��� - ���� [" +fileName + "]");
			}finally {
				if( br != null ) { br.close(); }//end if
			}//end finally
			
		}//end if
		
	}//openMemo
	
	/**
	 * ����
	 */
	public void saveMemo() {
		
	}//saveMemo
	
	/**
	 * ���̸����� ����
	 */
	public void newSaveMemo() {
		
	}//newSaveMemo
	
	/**
	 * ����
	 */
	public void end() {
		
	}//end
	
}//class
