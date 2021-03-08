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
		super("수동배치");
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(12);
		//한번에 다할려고 하지마시고, 1. 윈도우를 만들어, 배치관리자를 해제하고, 윈도우의 크기를 설정하고, 가시화 해서 보여주는 것을 합니다.
		//그 후에 필요한 컴포넌트를 하나씩 생성하고, 좌표,크기 설정하고 배치해서 처리하시면 충분히 하실 수 있어요, 
		
		JLabel jlblAge = new JLabel("나이");//jlblName은 JLabel 입니다. JLabel은 자신을 포함 할 수 없어요
		JTextField jtfAge = new JTextField(12);
		JLabel jlblField = new JLabel("주소");
		JTextField jtfField = new JTextField(12);
		JLabel jlblMail = new JLabel("메일");
		JTextField jtfMail = new JTextField(12);
		JLabel jlblDot = new JLabel("@");
		
		JTextField jtf = new JTextField(12);		
		
		Vector<String> vec = new Vector<String>();
		vec.add("daum.net");
		vec.add("naver.com");
		vec.add("google.com");
		vec.add("nate.com");
		vec.add("hotmail.com");
		
		JComboBox<String> jcb = new JComboBox<String>( vec ); // 값을 가진 콤보박스 객체 생성
		
		JButton jbtn = new JButton("입력");
		JButton jbtn2 = new JButton("수정");
		JButton jbtn3 = new JButton("삭제");
		JButton jbtn4 = new JButton("종료");

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
