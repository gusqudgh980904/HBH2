package day0222;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *	window Application �ۼ�
 * @author user
 */
//1. Window Component ���
@SuppressWarnings("serial")
public class HelloSwing extends JFrame{

	//2.�����ڿ��� ����� ������Ʈ�� ����
	public HelloSwing() {
		super("��������");//�θ�Ŭ������ �����ڸ� ȣ��
		
		JButton jbtn = new JButton("Hello Swing!!!");
		//3. ������ ������Ʈ�� ��ġ
		add(jbtn);
		
		//4. ������ ������Ʈ ũ�� ����
		setSize(400, 300);
		//5. ����ڿ��� �����ֱ�
		setVisible( true );
		
		//6. ����ó�� : anonymous inner class
		//addWindowListener method �� java.awt.Window Ŭ������ �����ϴ� method��
		//Window, JWindow, JFrame, Frame Ŭ�������� ��� ����� �� �ִ� (�ڵ��� �� ��뼺)
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				dispose(); //Ư�� ������ ����ó���ϰ�, JVM�� �����Ѵ�
//			}//windowClosing
//		});
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}//HelloSwing
	
	public static void main(String[] args) {
		new HelloSwing();
		
	}//main

}//class
