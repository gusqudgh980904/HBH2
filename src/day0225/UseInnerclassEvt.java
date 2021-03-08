package day0225;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 *	Adapter Ŭ������ ����Ͽ� �̺�Ʈ ó�� => inner class
 * @author user
 */
@SuppressWarnings("serial")
public class UseInnerclassEvt extends JFrame {
	
	public UseInnerclassEvt() {
		super("anonymous inner class");
		
		//inner Ŭ������ ����� ���� ó��
		addWindowListener( this.new WindowEvt() ); //this �ᵵ �ǰ� �Ƚᵵ ��( �Ⱦ��� �����Ǿ������Ƿ� ������ ���� )
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseAnonymousEvt
	
	//////////////////////// ������ ���� �̺�Ʈ ó�� inner class ���� //////////////////////////////////////////
	public class WindowEvt extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent we) {
			dispose(); //Window �� �����ϴ� method. inner class������ �ٱ� Ŭ������ �ڿ��� ����� �� �ִ�
		}//windowClosing
		
		
	}//class
	//////////////////////// ������ ���� �̺�Ʈ ó�� inner class �� //////////////////////////////////////////
	
	public static void main(String[] args) {
		new UseInnerclassEvt();
	}//main

}//class
