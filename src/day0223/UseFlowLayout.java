package day0223;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//1.������������Ʈ�� ���
public class UseFlowLayout extends JFrame {

	//2. ������Ʈ�� ����
	public UseFlowLayout() {
		super("FlowLayout����");
		
		JButton jbtn = new JButton("��ư");
		JCheckBox jcbLang1 = new JCheckBox("Java");
		JCheckBox jcbLang2 = new JCheckBox("C/C++");
		JCheckBox jcbLang3 = new JCheckBox("Python");
		JCheckBox jcbLang4 = new JCheckBox("VB");
		
		Font font = new Font("�ü�ü", Font.PLAIN, 20 );
		jcbLang1.setFont(font);
		jcbLang2.setFont(font);
		jcbLang3.setFont(font);
		jcbLang4.setFont(font);
		
		JRadioButton jrbGender1 = new JRadioButton("����");
		JRadioButton jrbGender2 = new JRadioButton("����",true); //true�� üũ�� ���°� �ʱⰪ���� ����
		//��ư �׷����� ������ ���� ������ư�� �������� ���õȴ�
		//��ư �׷� ����
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbGender1); //�׷����� ���� ��ü
		bg.add(jrbGender2);
		
		JTextField jtf = new JTextField(10); //����ũ�Ⱑ 0
		//JTextField �� Font ����
		jtf.setFont(new Font("�޸�����ü", Font.ITALIC | Font.BOLD , 25));
		
		//3. ��ġ������ ���� ( BorderLayout => FlowLayout )
		setLayout( new FlowLayout() );
		
		//4. ������Ʈ ��ġ
		add( jbtn );
		add( jcbLang1 );
		add( jcbLang2 );
		add( jcbLang3 );
		add( jcbLang4 );
		add( jrbGender1 );
		add( jrbGender2 );
		
		add(jtf);
		
		//5. ������ ũ�⼳��
		setSize(500,250);
		
		//6. ����ڿ��� �����ֱ�
		setVisible(true);
		
		//7. ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseFlowLayout
	
	public static void main(String[] args) {
		new UseFlowLayout();
	}//main

}//class
