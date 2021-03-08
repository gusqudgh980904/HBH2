package day0225;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * 	������ �̺�Ʈ�� �ٸ� ������Ʈ(��ü)���� �߻� ��ų ��, �̺�Ʈ�� �߻���Ų ��ü�� ��
 * @author user
 */
//1. �̺�Ʈ�� ó���� �� �ִ� Listener�� ����
public class EventCompare extends JFrame implements ActionListener{
	//2. �̺�Ʈ ó���� ���õ� ������Ʈ�� ����
	private JButton jbtn1, jbtn2;
	private JLabel jlblOutput;
	
	public EventCompare() {
		super("�̺�Ʈ ��");
		
		jbtn1 = new JButton("����");
		jbtn2 = new JButton("����");
		
		jlblOutput = new JLabel("��� : ");
		jlblOutput.setBorder(new TitledBorder("���ð��"));
		
		JPanel jp = new JPanel();
		jp.add(jbtn1); //��ư�� ����ũ�⸦ ������ �����̳� ������Ʈ�� ��ġ
		jp.add(jbtn2); //��ư�� ����ũ�⸦ ������ �����̳� ������Ʈ�� ��ġ
		
		//������Ʈ���� ������� ������ ���� �� JVM���� û���� �� �ֵ��� �����ʿ� ����Ѵ�
		jbtn1.addActionListener( this );
		jbtn2.addActionListener( this );
		
		add("Center",jp); //�����̳� ������Ʈ�� ������ ������Ʈ�� ��ġ
		add("South",jlblOutput); //���ð�� ���� ��ġ
		
		setBounds(100,100, 400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	//2. Listener���� �����ϴ� abstract method�� Override
	 public void actionPerformed(ActionEvent ae) {
		 //������� ������ �־��� �� JVM���� ȣ�� (��ϵ� ������Ʈ������ ȣ�� ����)
//		 dispose();
		 //�� �� �ٸ� �̺�Ʈ (����) �̱� ������ ���� if�� ���� (else if ���°� �ƴ϶�)
		 if(ae.getSource() == jbtn1 ) {
			//������� ���ϴ��̾�α׸� ����
			 FileDialog fdOpen = new FileDialog(this, "���Ͽ���", FileDialog.LOAD);
			//����ڿ��� �����ֱ�
			 fdOpen.setVisible(true);
			 
			 //directory�� filename ���
			 String path = fdOpen.getDirectory();
			 String fileName = fdOpen.getFile();
			 
			 if( path != null ) {
			 jlblOutput.setText("��� : " +path + fileName);
			 setTitle("���ϸ� : " + fileName );
			 }//end if
		 }//end if
		 
		 if(ae.getSource() == jbtn2 ) {
			 //������� ���ϴ��̾�α׸� ����
			 FileDialog fdSave = new FileDialog(this, "��������", FileDialog.SAVE);
			 //����ڿ��� �����ֱ�
			 fdSave.setVisible(true);
			 
			 //���ϰ��, ���ϸ� ���
			 String path = fdSave.getDirectory();
			 String fileName = fdSave.getFile();
			 
			 jlblOutput.setText("��� : " + path + fileName );
			 setTitle("���� - " + fileName );
		 }//end if

		 
	 }//actionPerformed

	public static void main(String[] args) {
		new EventCompare();
	}//main

}//class
