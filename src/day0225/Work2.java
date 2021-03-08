package day0225;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Work2 extends JFrame implements ActionListener, ListSelectionListener {
	public Work2() {
		super("글꼴");
		//만들기
		JLabel jl1= new JLabel("글꼴(F):");
		JLabel jl2= new JLabel("글꼴 스타일(Y):");
		JLabel jl3= new JLabel("크기(S):");
		JLabel jl4= new JLabel("스크립트(R):");
		
		JLabel jlGa= new JLabel("가나다AaBbYyZ");
		jlGa.setBorder(new TitledBorder("보기"));
		Font font = new Font("맑은 고딕",Font.BOLD, 26 );
		jlGa.setFont(font);
		
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

		
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		JComboBox<String> jcb = new JComboBox<String>(dcbm);
		Vector<String> vec = new Vector<String>(); 
		vec.add("1");
		vec.add("2");
		vec.add("3");
		vec.add("4");
		vec.add("5");
		vec.add("6");
		vec.add("7");
		vec.add("8");
		vec.add("9");
		vec.add("10");
		vec.add("80");
		dcbm.addAll(vec);
		
		Choice cho = new Choice();
		cho.add("한글"); //디자인 객체에 값이 저장
		cho.add("영어");
		
		
		JButton jb1 = new JButton("확인");
		JButton jb2 = new JButton("취소");
		
		//수동배치
		setLayout(null);
		jl1.setBounds(10, 0, 50, 50);
		jl2.setBounds(150, 0, 900, 50);
		jl3.setBounds(300, 0, 50, 50);
		jl4.setBounds(200, 250, 240, 80);
		
		jlGa.setBounds(200, 200, 200, 70);
		
		
		jtf1.setBounds(10, 35, 100, 20);
		jtf2.setBounds(150, 35, 100, 20);
		jtf3.setBounds(300, 35, 70, 20);
		
		jList.setBounds(10, 55, 100, 100);
		jList2.setBounds(150, 55, 100, 100);
		
		jcb.setBounds(300, 55, 70, 20);
		
		cho.setBounds(200, 155, 150, 20);
		
		jb1.setBounds(220, 350, 70, 20);
		jb2.setBounds(300, 350, 70, 20);
		
		
		//붙이기
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		
		add(jlGa);
		
		add(jtf1);
		add(jtf2);
		add(jtf3);
		
		add(jList);
		add(jList2);
		
		add(jcb);
		add(cho);
		
		add(jb1);
		add(jb2);
		
		//윈도우 크기설정
		setBounds(100, 100, 450, 500);
		//가시화
		setVisible(true);
		//종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//Work2
	
	public static void main(String[] args) {
		new Work2();
	}//main

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}//class
