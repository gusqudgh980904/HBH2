package day0223;

import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *	BorderLayout �� ������Ʈ 
 * @author user
 */
@SuppressWarnings("serial")
//1. ������ ������Ʈ�� ���
public class UseBorderLayout extends JFrame {

	//2. �����ڿ��� ������Ʈ ����
	public UseBorderLayout() {
		super("BorderLayout ����"); //title bar ����
		JTextField jtfNorth = new JTextField("North");
		JPasswordField jpfSouth = new JPasswordField("South");//�Է¹��ڿ��� ���⹮�ڷ� ���δ�
		JLabel jlEast = new JLabel("East");
		JLabel JlWest = new JLabel("West");
		JTextArea jtaCenter = new JTextArea("Center");
		
		//3. ��ġ�����ڸ� ����. Window Component�� �⺻ ���̾ƿ��� BorderLayout�̹Ƿ� ��������
		setLayout(new BorderLayout());
		
		//4. ��ġ
		//String ���
		add("Center", jtaCenter );
		add("North", jtfNorth );
		add("South", jpfSouth );
		//BorderLayout ���
		add(BorderLayout.EAST, jlEast);
		add(BorderLayout.WEST, JlWest);
		
		//5. ������ ũ�� ����
		setSize(400,350);
		//6. ����ڿ��� �����ֱ�
		setVisible(true);
		//7. ������ ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseBorderLayout
	public static void main(String[] args) {
		new UseBorderLayout();
	}//main

}//class
