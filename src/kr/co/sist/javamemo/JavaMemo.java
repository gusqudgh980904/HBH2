package kr.co.sist.javamemo;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import kr.co.sist.javamemo.evt.JavaMemoEvt;

@SuppressWarnings("serial")
public class JavaMemo extends JFrame {

	private JMenuItem jmiNew, jmiOpen, jmiSave, jmiNewSave, jmiEnd, jmiFont, jmiHelp;
	//����, ����,����, ���̸�����, ����, �۲�, ����
	private JTextArea jtaNote;
	
	public JavaMemo(Font initFont) {
		super("�޸���");
		
		//������Ʈ ����.
		JMenuBar jmb=new JMenuBar();
		
		JMenu jmFile=new JMenu("����");
		JMenu jmFormat=new JMenu("����");
		JMenu jmHelp=new JMenu("����");
		
		jmiNew=new JMenuItem("����");
		jmiOpen=new JMenuItem("����");
		jmiSave=new JMenuItem("����");
		jmiNewSave=new JMenuItem("���̸�����"); 
		jmiEnd=new JMenuItem("����"); 
		jmiFont=new JMenuItem("�۲�"); 
		jmiHelp=new JMenuItem("�޸�������");
		
		jtaNote=new JTextArea();
		//�о���� ��Ʈ�� �����Ѵ�
		if(initFont!=null) {//�о���� Font�� �����Ѵٸ� JTextArea�� Font�� �����Ѵ�
			jtaNote.setFont(initFont);
		}//if
		
		JScrollPane jspNote=new JScrollPane( jtaNote );//��ũ�ѹٰ� ���� ��ü�� ��ũ�ѹٸ� ���δ�.  
				
		//��ġ.
		//�޴�������->�޴� ��ġ ( ���м� �ʿ� : addSeparator() )
		jmFile.add(jmiNew); //����
		jmFile.addSeparator();
		jmFile.add(jmiOpen); //����
		jmFile.add(jmiSave); //����
		jmFile.add(jmiNewSave); //���̸�
		jmFile.addSeparator();
		jmFile.add(jmiEnd); //�ݱ�
		
		jmFormat.add(jmiFont); //����
		
		jmHelp.add(jmiHelp);//����
		
		//�޴�->�޴��� ��ġ
		jmb.add( jmFile );
		jmb.add( jmFormat );
		jmb.add( jmHelp );
		
		//�޴��� ������ ��ġ
		setJMenuBar(jmb);
		
		//JTextArea�� Frame�� ��ġ
		add("Center",jspNote);
		
		//�̺�Ʈ ó�� Ŭ������ ��ü����.
		JavaMemoEvt jme=new JavaMemoEvt(this);
		//������Ʈ�� �̺�Ʈ�� ����ϰ�, �̺�Ʈ �߻� �� ó���� ��ü �����Ѵ�
		jmiFont.addActionListener( jme );

		jmiNew.addActionListener( jme );
		jmiOpen.addActionListener( jme );
		jmiSave.addActionListener( jme );
		jmiNewSave.addActionListener( jme );
		jmiEnd.addActionListener( jme );

		jmiHelp.addActionListener( jme );
		
		
		addWindowListener( jme );
		
		//������ ũ�⼳��.
		setBounds(100, 100, 800, 700);
		//����ȭ
		setVisible(true);
		
	}//JavaMemo


	public JMenuItem getJmiNew() {
		return jmiNew;
	}

	public JMenuItem getJmiOpen() {
		return jmiOpen;
	}

	public JMenuItem getJmiSave() {
		return jmiSave;
	}

	public JMenuItem getJmiNewSave() {
		return jmiNewSave;
	}

	public JMenuItem getJmiEnd() {
		return jmiEnd;
	}

	public JMenuItem getJmiFont() {
		return jmiFont;
	}

	public JMenuItem getJmiHelp() {
		return jmiHelp;
	}

	public JTextArea getJtaNote() {
		return jtaNote;
	}
	
	
}//class
