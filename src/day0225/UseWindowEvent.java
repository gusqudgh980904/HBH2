package day0225;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UseWindowEvent extends JFrame implements WindowListener {

	public UseWindowEvent() {
		super("������ �̺�Ʈ ó��");
		
		
		//�߻��� ������ �̺�Ʈ�� ó���� �� �ֵ��� �����ʿ� ���
		addWindowListener( this );
		
		setBounds(100, 100, 600, 400);
		setVisible(true);
		
	}//UseWindowEvent
	public static void main(String[] args) {
		new UseWindowEvent();
	}//main
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose();
//		System.exit(0);//�����찡 ������ ����� ���Ŀ� ó���ؾ��� �۾��� ���� �� �� ����
	}
	@Override
	public void windowClosed(WindowEvent e) {
		//�����찡 ������ ����� ���Ŀ� ó���ؾ��� �۾�
		System.out.println("windowClosed");
	}
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}

}//class
