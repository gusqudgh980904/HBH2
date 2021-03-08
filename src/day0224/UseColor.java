package day0224;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseColor extends JFrame {
	
	public UseColor() {
		super("색 설정");
		
		JTextField jtf = new JTextField(20);
		JTextArea jta = new JTextArea();
		
		//jtf, jta의 글꼴을 궁서체, 진하게, 25로 설정
		//궁서와 궁서체의 차이
		//~체가 붙으면 모든 글자의 넓이가 같다 i가
		Font font = new Font("궁서체",Font.BOLD, 25 );
		jtf.setFont(font);
		jta.setFont(font);
		
		
		
		//상수사용
		jtf.setBackground(Color.cyan);
		jtf.setForeground(Color.gray);
		//생성
		jta.setBackground(new Color(0xD1B2FF)); //연보라
		jta.setForeground(new Color(0xEAEAEA)); //연회색
		
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder("입력"));
		
		JLabel jl = new JLabel("전화번호"); //투명도가 설정되어있어 바닥색이 그대로 배경색이 된다
		jl.setBorder(new TitledBorder("휴대폰"));
		jtf.setBorder(new TitledBorder("010만 입력"));
		jta.setBorder(new TitledBorder("휴대폰 리스트"));
		jl.setForeground(Color.red); //전경색은 적용된다
		
		//투명도를 해제하고
		jl.setOpaque(true);
		//바닥색을 설정한다
		jl.setBackground(Color.yellow);
		
		
		jp.add(jl);
		jp.add(jtf);
		
		
		add("North", jp);
		add("Center", jta);
		
		//윈도우 크기설정 w-600, h-500
		setBounds(100, 100, 600, 500);
		//가시화
		setVisible(true);
		//종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseColor

	public static void main(String[] args) {
		new UseColor();
	}//main

}//class
