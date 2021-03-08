package day0225;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 *	Adapter 클래스를 사용하여 이벤트 처리 => inner class
 * @author user
 */
@SuppressWarnings("serial")
public class UseInnerclassEvt extends JFrame {
	
	public UseInnerclassEvt() {
		super("anonymous inner class");
		
		//inner 클래스를 사용한 종료 처리
		addWindowListener( this.new WindowEvt() ); //this 써도 되고 안써도 됨( 안쓰면 내제되어있으므로 어차피 가능 )
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseAnonymousEvt
	
	//////////////////////// 윈도우 종료 이벤트 처리 inner class 시작 //////////////////////////////////////////
	public class WindowEvt extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent we) {
			dispose(); //Window 에 존재하는 method. inner class에서는 바깥 클래스의 자원을 사용할 수 있다
		}//windowClosing
		
		
	}//class
	//////////////////////// 윈도우 종료 이벤트 처리 inner class 끝 //////////////////////////////////////////
	
	public static void main(String[] args) {
		new UseInnerclassEvt();
	}//main

}//class
