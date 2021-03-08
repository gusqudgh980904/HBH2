package day0225;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *	이름을 입력하고 버튼을 클릭하면, 입력된 이름이 TextArea 에 추가되는 일
 * @author user
 */
@SuppressWarnings("serial")
// < 1 > 윈도우 컴포넌트를 상속, 발생 이벤트를 처리할 수 있는 Listener를 구현
public class UseActionEvent2 extends JFrame implements ActionListener{
	//<2> 이벤트가 발생했을때 사용할 컴포넌트 선언
	private JTextField jtfName;
	private JTextArea jtaOutput;
	
	//2. 컴포넌트 생성
	public UseActionEvent2() {
		super("Container Component 사용");
		//3. 컴포넌트 생성 : 컴포넌트 종류 + 하는일
		JLabel jlblName = new JLabel("이름");
		jtfName = new JTextField(12);
		JButton jbtnInput = new JButton("입력");
		jtaOutput = new JTextArea();
		
		//4. 배치관리자 설정
		// 여러개의 컴포넌트를 한번에 배치하기 위한 Container Component => JPanel
		JPanel jpNorth = new JPanel();
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnInput);
		// 스크롤바가 필요한 객체에 스크롤바를 배치하기위한 Container Component => JScrollPane
		JScrollPane jspCenter = new JScrollPane(jtaOutput);
		
		//5. 배치
		add("North",jpNorth); //배치를 Panel로 해서 여러개의 컴포넌트가 배치될 수 있도록 합니다 
		
		add("Center", jspCenter);
		
		//버튼에서 발생한 이벤트를 처리할 수 있도록, 이벤트에 등록
		jbtnInput.addActionListener( this ); //버튼 클릭!
		jtfName.addActionListener( this ); //텍스트필드 엔터!
		
		//6. 크기 설정
		setSize(500, 400);
		setLocation(100,200);
		
		//7. 가시화
		setVisible(true);
		
		//8. 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//UseContainerComponent
	
	
	//< 2 > 이벤트처리를 할 수 있는 method Override
	@Override
	public void actionPerformed(ActionEvent ae) {
		//JTextField 의 입력 값을 가져와서
		String name = jtfName.getText();
		//JTextArea에 추가한다
		jtaOutput.append(name+"\n");//TextArea 에 존재하는 값 뒤에 붙임
//		jtaOutput.setText(name+"\n");//TextArea 에 존재하는 값을 초기화한 후 입력값을 기록
		
		//JTextField의 값을 초기화한다
		jtfName.setText("");
		//JTextField에
		jtfName.requestFocus();
		
	}//actionPerformed
	public static void main(String[] args) {
		new UseActionEvent2();
	}//main

}//class
