package day0225;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *	�����ξ����� �и��� �̺�Ʈó�� Ŭ���� has a ����
 * @author user
 */
public class UseHasAEvent extends WindowAdapter { //UseHasAEvent�� HasADesign ���̷��� ������
	private UseHasADesign uhad;
	
	public UseHasAEvent(UseHasADesign uhad) {
		this.uhad = uhad;
	}//UseHasAEvent

	@Override
	public void windowClosing(WindowEvent e) {
//		dispose(); -> error �� -> HasADesign�� �����ؾߵ�
		uhad.dispose();
	}//windowClosing	
}//class
