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
		super("�� ����");
		
		JTextField jtf = new JTextField(20);
		JTextArea jta = new JTextArea();
		
		//jtf, jta�� �۲��� �ü�ü, ���ϰ�, 25�� ����
		//�ü��� �ü�ü�� ����
		//~ü�� ������ ��� ������ ���̰� ���� i��
		Font font = new Font("�ü�ü",Font.BOLD, 25 );
		jtf.setFont(font);
		jta.setFont(font);
		
		
		
		//������
		jtf.setBackground(Color.cyan);
		jtf.setForeground(Color.gray);
		//����
		jta.setBackground(new Color(0xD1B2FF)); //������
		jta.setForeground(new Color(0xEAEAEA)); //��ȸ��
		
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder("�Է�"));
		
		JLabel jl = new JLabel("��ȭ��ȣ"); //������ �����Ǿ��־� �ٴڻ��� �״�� ������ �ȴ�
		jl.setBorder(new TitledBorder("�޴���"));
		jtf.setBorder(new TitledBorder("010�� �Է�"));
		jta.setBorder(new TitledBorder("�޴��� ����Ʈ"));
		jl.setForeground(Color.red); //������� ����ȴ�
		
		//������ �����ϰ�
		jl.setOpaque(true);
		//�ٴڻ��� �����Ѵ�
		jl.setBackground(Color.yellow);
		
		
		jp.add(jl);
		jp.add(jtf);
		
		
		add("North", jp);
		add("Center", jta);
		
		//������ ũ�⼳�� w-600, h-500
		setBounds(100, 100, 600, 500);
		//����ȭ
		setVisible(true);
		//����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseColor

	public static void main(String[] args) {
		new UseColor();
	}//main

}//class
