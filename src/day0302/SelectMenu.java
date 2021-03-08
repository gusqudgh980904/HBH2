package day0302;

import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SelectMenu extends JFrame implements Action{

	private JButton inputData;
	private JButton printData;
	private JButton closeApp;
	
	Map<String, Integer> info = new HashMap<>();
	
	public SelectMenu() {
		
		super("Menu");
		String InputData = JOptionPane.showInputDialog(this, "�޴�\n1.�Է� 2.��� 3.����");
		int menu = Integer.parseInt(InputData);
		switch (menu) {
		case 1 :
			String InputData1 = JOptionPane.showInputDialog(this, "�̸��� ���̸� �Է�\n ��) �̿���, 27");
			info.put(InputData1, null);
			inputData();
			
		case 2 :
			System.out.println( info );
			
		case 3 :
			int flag = JOptionPane.showConfirmDialog(this,
					"���α׷� ���� �Ͻðڽ��ϱ�?","����", JOptionPane.INFORMATION_MESSAGE);//��, �ƴϿ�, ��� ����
		
			switch( flag ){
				case JOptionPane.OK_OPTION : System.out.println("���α׷��� �����մϴ�");dispose();
				case JOptionPane.NO_OPTION : System.out.println("�޴�����");
				String InputData2 = JOptionPane.showInputDialog(this, "�޴�\n1.�Է� 2.��� 3.����");
				int menu1 = Integer.parseInt(InputData2) ;
				case JOptionPane.CANCEL_OPTION : System.out.println("�޴�����");
				String InputData3 = JOptionPane.showInputDialog(this, "�޴�\n1.�Է� 2.��� 3.����");
				int menu2 = Integer.parseInt(InputData3) ;			
			}//end switch
		}
		
		setBounds(100, 100 , 500, 250 );
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//Work

	public void inputData() {
//		String name , String age = JOptionPane.showInputDialog(this, "�̸� �Է����ּ���\n��)ȫ�浿,20");
//		
//		setTitle("�Է��̸� : " + name + age);
	}
	public void printData() {
		
	}
	public void closeApp() {
		
	}
	

	
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == inputData) {
			inputData();
		}//end if
		if(ae.getSource() == printData) {
			printData();
		}//end if
		if(ae.getSource() == closeApp) {
			closeApp();
		}//end if
		
	}//actionPerformed
		
	
	
	@Override
	public Object getValue(String key) {
		return null;
	}
	@Override
	public void putValue(String key, Object value) {	
	}

}//class
