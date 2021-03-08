package day0224;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *	이미지가 들어간 버튼
 * @author user
 */
@SuppressWarnings("serial")
//1. 윈도우 컴포넌트를 상속
public class BtnImage extends JFrame {

	//2. 생성자에 컴포넌트를 생성
	public BtnImage() {
		super("이미지를 사용한 버튼");
		//이미지 객체생성
		ImageIcon ii1 = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0224/images/포챠코1.jpg");
		ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0224/images/포챠코2.jpg");
		ImageIcon ii3 = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0224/images/포챠코3.jpg");
		ImageIcon ii4 = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0224/images/포챠코4.jpg");
		//생성된 이미지 객체를 적용한 컴포넌트 생성
		JButton jbtn1 = new JButton("포챠코", ii1);
		JButton jbtn2 = new JButton("포챠코2", ii2);
		JButton jbtn3 = new JButton("포챠코3", ii3);
		
		//풍선도움말 설정
		jbtn1.setToolTipText("포챠코-강아지");
		jbtn2.setToolTipText("포챠코-강지");
		jbtn3.setToolTipText("포챠코-갱얼지");
		
		//마우스가 올라갔을 때, 이미지를 변경
		jbtn3.setRolloverIcon(ii4);
		
		//버튼 텍스트의 수직 위치 변경 - 탑 센터 바텀
		jbtn1.setVerticalTextPosition(JButton.BOTTOM);
		jbtn3.setVerticalTextPosition(JButton.BOTTOM);
		
		//버튼 텍스트의 수평위치 변경 - LEFT CENTER RIGHT
		jbtn2.setHorizontalTextPosition(JButton.LEFT);
		jbtn3.setHorizontalTextPosition(JButton.LEFT);
		
		//3. 배치관리자 설정
		setLayout(new GridLayout(1, 3));
		
		//4. 배치
		add(jbtn1);
		add(jbtn2);
		add(jbtn3);
		
		//5. 윈도우 크기 설정
		setBounds(100, 100, 800, 300);
		//6. 가시화
		setVisible(true);
		//7. 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//BtnImage
	
	public static void main(String[] args) {
		new BtnImage();
	}//main

}//class
