package day0225;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import org.graalvm.compiler.nodes.NodeView.Default;


/**
 *	�̸��� JTextField �Է��ϰ� ��ư�� Ŭ��(ActionEvent)�ϸ�, �Էµ� �̸��� JList �� �߰��ǰ�,
 *	JList�� item�� ����(ListSelectionEvent)�ϸ� �ش� �������� ���� JTextField�� �����Ǵ� ��.
 * @author user
 */
@SuppressWarnings("serial")
// < 1 > ������ ������Ʈ�� ���, �߻� �̺�Ʈ�� ó���� �� �ִ� Listener�� ����
public class UseMVCEvt extends JFrame implements ActionListener, ListSelectionListener {
	//<2> �̺�Ʈ�� �߻������� ����� ������Ʈ ����
	private JTextField jtfName;
	private JList<String> jlName; //MVC Pattern�� ������ ���۵� ������Ʈ. View��ü (���� �����ִ� ��)
	
	private DefaultListModel<String>dlmName; //Model ��ü ( �� )
	
	//2. ������Ʈ ����
	public UseMVCEvt() {
		super("Container Component ���");
		//3. ������Ʈ ���� : ������Ʈ ���� + �ϴ���
		JLabel jlblName = new JLabel("�̸�");
		jtfName = new JTextField(12);
		JButton jbtnInput = new JButton("�Է�");
		
		dlmName = new DefaultListModel<String>(); //Model ��ü ����
		jlName = new JList<String>( dlmName ); //Model ��ü�� ����� View ��ü ����
		
		JScrollPane jspName = new JScrollPane( jlName ); //JList�� J.S.P�� �Ҵ�
		jspName.setBorder(new TitledBorder("�Է� �̸�"));
		
		//4. ��ġ������ ����
		// �������� ������Ʈ�� �ѹ��� ��ġ�ϱ� ���� Container Component => JPanel
		JPanel jpNorth = new JPanel();
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnInput);
		
		//5. ��ġ
		add("North",jpNorth); //��ġ�� Panel�� �ؼ� �������� ������Ʈ�� ��ġ�� �� �ֵ��� �մϴ� 
		
		add("Center", jspName);
		
		//��ư���� �߻��� �̺�Ʈ�� ó���� �� �ֵ���, �̺�Ʈ�� ���
		jbtnInput.addActionListener( this ); //��ư Ŭ��!
		jtfName.addActionListener( this ); //�ؽ�Ʈ�ʵ� ����!
		
		jlName.addListSelectionListener( this ); //����Ʈ�� ������ ����
		
		//6. ũ�� ����
		setSize(500, 400);
		setLocation(100,200);
		
		//7. ����ȭ
		setVisible(true);
		
		//8. ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//UseContainerComponent
	
	
	//< 2 > �̺�Ʈó���� �� �� �ִ� method Override
	@Override
	public void actionPerformed(ActionEvent ae) {
		//JTextField �� �Է� ���� �����ͼ�
		String name = jtfName.getText();

		//JLisdt�� �߰� ( View�� �ƴ� Model ��ü�� ����Ͽ� ���� �߰� )
		dlmName.addElement(name);
		
		//JTextField�� ���� �ʱ�ȭ�Ѵ�
		jtfName.setText("");
		//JTextField��
		jtfName.requestFocus();
		
	}//actionPerformed
	public static void main(String[] args) {
		new UseMVCEvt();
	}//main

//	int cnt = 0;
//	boolean flag; -> �̰� ����ϱ� (2������Ǵ°� ���°�)
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		//�ѹ��� ����ǵ��� ������
//		if( cnt % 2 == 0) {
//		if( flag ) {
		if(jlName.getValueIsAdjusting()) {
			//JTextField�� ���õ� ���� ����
			jtfName.setText( dlmName.getElementAt( jlName.getSelectedIndex() ));
			
//		System.out.println("������ �ε��� : " + jlName.getSelectedIndex());
//		//���õ� �ε����� ���� View�� Model�� ��
//		System.out.println("������ �ε����� �� : " +
//		dlmName.getElementAt( jlName.getSelectedIndex() ));
//		
//		System.out.println(jlName.getSelectedValue());
		}//end if
//		cnt ++;
//		flag =! flag;
	}//valueChanged

}//class
