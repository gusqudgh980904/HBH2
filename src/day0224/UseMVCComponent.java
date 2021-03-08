package day0224;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Scrollbar;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 	MVC������ ���ԵǾ� ���۵� Ŭ����
 * @author user
 */
@SuppressWarnings("serial")
public class UseMVCComponent extends JFrame {

	public UseMVCComponent() {
		super("MVC Pattern�� ���Ե� ������Ʈ�� ���");
		
		//1. �����͸� �����ϴ� Model��ü�� ����
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		// �����ʹ� Model��ü�� ����
		dcbm.addElement("�ڹ�");
		dcbm.addElement("����Ŭ");
		dcbm.addElement("JDBC");
		dcbm.addElement("HTML");
		dcbm.addElement("CSS");
		dcbm.addElement("JavaScript");
		dcbm.addElement("Servlet/JSP");
		dcbm.addElement("XML, JSON");
		dcbm.addElement("MyBatis, Spring");
		
		//2. �����͸� ������ view ��ü ����
		JComboBox<String> jcb = new JComboBox<String>(dcbm);
		
		//AWT������ �����ΰ�ü�� ���� �������� ���۵� ������Ʈ (Choice)������, 
		//Swing(JComboBox) ������ �������� �����Ͽ� ������Ʈ�� ������
		Choice cho = new Choice();
		cho.add("�ڹ� SE"); //������ ��ü�� ���� ����
		cho.add("����Ŭ");
		cho.add("JDBC");
		cho.add("Front-End ( HTML, CSS, JavaScript )");

		
		
		
		
		///////////////////////////////JList//////////////////////////////////////////////////////////////////////////////
		//���� ���� Model��ü�� ����
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		dlm.addElement("������");
		dlm.addElement("�ڱ��");
		dlm.addElement("�ǿ���");
		dlm.addElement("������");
		dlm.addElement("���μ�");
		dlm.addElement("������");
		dlm.addElement("�����");
		
		
		//Model ��ü�� ����Ͽ� View��ü ����
		JList<String> jl = new JList<String>(dlm);
		//��ũ�� �ٰ� �������� �����Ƿ� JScrollPane�� �Բ� ����Ѵ�
		//��ũ�ѹ� ����
		JScrollPane jspList = new JScrollPane( jl );
		
		///////////////////////////////JTable//////////////////////////////////////////////////////////////////////////////
		String[] colummNames = {"��ȣ","�̸�","����"};
		
//		DefaultTableModel dtm = new DefaultTableModel(colummNames, 5); //5��
		DefaultTableModel dtm = new DefaultTableModel(colummNames, 0); //0��
		//���ڵ� �߰�
		String[] data = {"1","������","20"}; //�迭�� �����͸� �����
		dtm.addRow(data); //�߰�
		
		Vector<String> vec = new Vector<String>(); //���ͷ� �����͸� �����
		vec.add("2");
		vec.add("������");
		vec.add("25");
		dtm.addRow(vec); //�߰�
		
		//�� ��ü ����
		JTable jt = new JTable( dtm );
		//ScrollBar ���� : �÷����� ����ڿ��� ��������
		JScrollPane jspTable = new JScrollPane( jt );
		
		setLayout(new FlowLayout());
		
		// ����ڿ��� �����ִ� ���ϴ� View ��ü�� ��ġ
		add(jcb);
		add(cho);
		add( jspList );
		add( jspTable );
		
		setBounds(100, 100, 900, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJComboBox
	
	public static void main(String[] args) {
		new UseMVCComponent();
	}//main

}//class
