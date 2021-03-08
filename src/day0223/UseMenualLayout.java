package day0223;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *	
 * @author user
 */
@SuppressWarnings("serial")
//1. ������ ������Ʈ ���
public class UseMenualLayout extends JFrame {
	//2. �����ڿ��� �Ϲ�������Ʈ ����
	public UseMenualLayout() {
		super("������ġ");
		
		JLabel jlblName = new JLabel("����");
		Vector<String> vec = new Vector<String>();
		vec.add("��ϼ���-�ѵ� ��");
		vec.add("���׵��-�ѵ� ��");
		vec.add("ź-�ѵ� �ڿ�");
		vec.add("�̽��ͱ��-�ѵ��� ����â ��");
		vec.add("��õ-�ѵ� ��");
		
		JComboBox<String> jcb = new JComboBox<String>( vec ); // ���� ���� �޺��ڽ� ��ü ����
		
		JButton jbtn = new JButton("�Է�");
		
		//3. ��ġ������ ���� :  BorderLayout => null
		setLayout( null );
		
		//4. ��ġ, ũ�� ����
//		jlblName.setBackground(Color.magenta);
//		jlblName.setOpaque(true);
//		jlblName.setLocation(10, 30);
//		jlblName.setSize(30, 30);
		jlblName.setBounds(10, 30, 30, 30);
		
		
//		jcb.setSize(200, 30);
//		jcb.setLocation(40,30);
		jcb.setBounds(40,30, 200, 30);
		
//		jbtn.setSize(70, 30);
//		jbtn.setLocation(245, 30); // �������� Ÿ��Ʋ�� �Ʒ� �»���� ������ǥ
		jbtn.setBounds(245, 30, 70, 30);
		
		//5. ��ġ
		add( jlblName );
		add( jcb );
		add( jbtn );
		
		//6. ������ ũ�⼳��
		setSize(450, 400);
		setLocation(150, 100); //Window Component => monitor�� �»���� ������ǥ
		
		//7. ����ȭ
		setVisible(true);
		
		//8. �����̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//UseMenualLayout
	
	
	public static void main(String[] args) {
		new UseMenualLayout();
	}//main

}//class
