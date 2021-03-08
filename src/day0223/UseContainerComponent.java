package day0223;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *	�Ϲ� ������Ʈ �������� �ѹ��� ��ġ�� �� ����ϴ� Container Component<br>
 *	Panel: ����������
 *	JScrollPane : ��ũ�ѹٸ� �����ϴ� ������
 * @author user
 */
@SuppressWarnings("serial")
//1. ������ ������Ʈ�� ���
public class UseContainerComponent extends JFrame {
	//2. ������Ʈ ����
	public UseContainerComponent() {
		super("Container Component ���");
		//3. ������Ʈ ���� : ������Ʈ ���� + �ϴ���
		JLabel jlblName = new JLabel("�̸�");
		JTextField jtfName = new JTextField(12);
		JButton jbtnInput = new JButton("�Է�");
		JTextArea jtaOutput = new JTextArea();
		
		//4. ��ġ������ ����
		// �������� ������Ʈ�� �ѹ��� ��ġ�ϱ� ���� Container Component => JPanel
		JPanel jpNorth = new JPanel();
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnInput);
		// ��ũ�ѹٰ� �ʿ��� ��ü�� ��ũ�ѹٸ� ��ġ�ϱ����� Container Component => JScrollPane
		JScrollPane jspCenter = new JScrollPane(jtaOutput);
		
		//5. ��ġ
		add("North",jpNorth); //��ġ�� Panel�� �ؼ� �������� ������Ʈ�� ��ġ�� �� �ֵ��� �մϴ� 
		
		add("Center", jspCenter);
		
		//6. ũ�� ����
		setSize(500, 400);
		setLocation(100,200);
		
		//7. ����ȭ
		setVisible(true);
		
		//8. ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//UseContainerComponent
	
	public static void main(String[] args) {
		new UseContainerComponent();
	}//main

}//class
