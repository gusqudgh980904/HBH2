package day0225;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *	디자인업무와 분리된 이벤트처리 클래스 has a 관계
 * @author user
 */
public class UseHasAEvent extends WindowAdapter { //UseHasAEvent는 HasADesign 죽이려고 존재함
	private UseHasADesign uhad;
	
	public UseHasAEvent(UseHasADesign uhad) {
		this.uhad = uhad;
	}//UseHasAEvent

	@Override
	public void windowClosing(WindowEvent e) {
//		dispose(); -> error 남 -> HasADesign에 존재해야됨
		uhad.dispose();
	}//windowClosing	
}//class
