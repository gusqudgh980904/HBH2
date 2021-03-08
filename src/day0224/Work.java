package day0224;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Work extends JFrame {
	
	public Work() {
		super("글꼴");
		
		JLabel jl1= new JLabel("글꼴(F):");
		JLabel jl2= new JLabel("글꼴 스타일(Y):");
		JLabel jl3= new JLabel("크기(S):");
		JLabel jl4= new JLabel("스크립트(R):");
		
		JLabel jlGa= new JLabel("가나다AaBbYyZ");
		jlGa.setBorder(new TitledBorder("보기"));
		
		JTextField jtf1 = new JTextField(10);
		JTextField jtf2 = new JTextField(10);
		JTextField jtf3 = new JTextField(10);
		
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		dlm.addElement("Dialog");
		dlm.addElement("DialogInput");
		dlm.addElement("Monospaced");
		dlm.addElement("Serif");
		dlm.addElement("SansSerif");
		dlm.addElement("맑은 고딕");
		dlm.addElement("궁서체");
		JList<String> jList = new JList<String>(dlm);
		JScrollPane jspList = new JScrollPane( jList );
		
		DefaultListModel<String> dlm2 = new DefaultListModel<String>();
		dlm2.addElement("보통");
		dlm2.addElement("굵게");
		dlm2.addElement("기울임꼴");
		dlm2.addElement("굵은 기울임꼴");
		JList<String> jList2 = new JList<String>(dlm2);
		JScrollPane jspList2 = new JScrollPane( jList2 );

		JScrollPane jspTable = new JScrollPane( jList );
		JScrollPane jspTable2 = new JScrollPane( jList2 );
		
		
		Choice cho = new Choice();
		cho.add("한글"); //디자인 객체에 값이 저장
		cho.add("영어");
		
		JButton jb1 = new JButton("확인");
		JButton jb2 = new JButton("취소");

		setLayout(null);
		jl1.setBounds(10, 0, 50, 50);
		jl2.setBounds(150, 0, 900, 50);
		jl3.setBounds(300, 0, 50, 50);
		jl4.setBounds(150, 150, 240, 80);
		
		
		
		jtf1.setBounds(10, 35, 100, 20);
		jList.setBounds(10, 45, 100, 20);
		jtf2.setBounds(10, 45, 100, 20);
		jList2.setBounds(150, 35, 100, 20);
		jlGa.setBounds(500, 140, 100, 20);
		
		cho.setBounds(500, 500, 100, 50);
		jb1.setBounds(600, 600, 50, 50);
		jb2.setBounds(600, 650, 50, 50);
		
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jList);
		add(jList2);
		add(jlGa);
	
		add(jb1);
		add(jb2);
		
		add(jtf1);
		add(jtf2);
		add(jtf3);
		
		add( jspList );
		add( jspTable );
		add( jspList2 );
		add( jspTable2 );
		
		add(cho);
		
//		setSize(500, 700);
//		setLocation(150, 100);
		//윈도우 크기설정
		setBounds(100, 100, 450, 500);
		//가시화
		setVisible(true);
		//종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Work();
	}//main

}//class
