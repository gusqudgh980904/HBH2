package day0223;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Work extends JFrame {
	public Work() {
		super("������ġ");
		JLabel jlblName = new JLabel("�̸�");
		JTextField jtfName = new JTextField(12);
		//�ѹ��� ���ҷ��� �������ð�, 1. �����츦 �����, ��ġ�����ڸ� �����ϰ�, �������� ũ�⸦ �����ϰ�, ����ȭ �ؼ� �����ִ� ���� �մϴ�.
		//�� �Ŀ� �ʿ��� ������Ʈ�� �ϳ��� �����ϰ�, ��ǥ,ũ�� �����ϰ� ��ġ�ؼ� ó���Ͻø� ����� �Ͻ� �� �־��, 
		
		JLabel jlblAge = new JLabel("����");//jlblName�� JLabel �Դϴ�. JLabel�� �ڽ��� ���� �� �� �����
		JTextField jtfAge = new JTextField(12);
		JLabel jlblField = new JLabel("�ּ�");
		JTextField jtfField = new JTextField(12);
		JLabel jlblMail = new JLabel("����");
		JTextField jtfMail = new JTextField(12);
		JLabel jlblDot = new JLabel("@");
		
		JTextField jtf = new JTextField(12);		
		
		Vector<String> vec = new Vector<String>();
		vec.add("daum.net");
		vec.add("naver.com");
		vec.add("google.com");
		vec.add("nate.com");
		vec.add("hotmail.com");
		
		JComboBox<String> jcb = new JComboBox<String>( vec ); // ���� ���� �޺��ڽ� ��ü ����
		
		JButton jbtn = new JButton("�Է�");
		JButton jbtn2 = new JButton("����");
		JButton jbtn3 = new JButton("����");
		JButton jbtn4 = new JButton("����");

		JTextArea jtaOutput = new JTextArea();
		
		setLayout( null );
		
		jlblName.setBounds(10, 30, 30, 30);
		jtfName.setBounds(50, 30, 150, 30);
		jlblAge.setBounds(10, 80, 30, 30);
		jtfAge.setBounds(50,80, 150, 30);
		jlblField.setBounds(10, 130, 30, 30);
		jtfField.setBounds(50, 130, 150, 30);
		jlblMail.setBounds(10, 180, 30, 30);
		jtfMail.setBounds(50, 180, 50, 30);
		jlblDot.setBounds(100, 180, 30, 30);
		jcb.setBounds(130, 180, 70, 30);
		jtf.setBounds(245, 30, 170, 200 );
		jbtn.setBounds(70, 310, 70, 30);
		jbtn2.setBounds(150, 310, 70, 30);
		jbtn3.setBounds(230, 310, 70, 30);
		jbtn4.setBounds(310, 310, 70, 30);
		
		add( jlblName );
		add( jtfName );
		add( jlblAge );
		add( jtfAge );
		add( jlblField );
		add( jtfField );
		add( jlblMail );
		add( jtfMail );
		add(jlblDot);
		add( jtf );
		add( jcb );
		add( jbtn );
		add( jbtn2 );
		add( jbtn3 );
		add( jbtn4 );
		
		setSize(450, 400);
		setLocation(150, 100);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//Work
	
	public static void main(String[] args) {
		new Work();
	}//main

}//class
