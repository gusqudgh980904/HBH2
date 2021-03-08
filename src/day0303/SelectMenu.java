package day0303;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//import org.graalvm.compiler.hotspot.stubs.NullPointerExceptionStub;

/**
 *	����ڿ��� �޴��� �����ϰ�, �޴��� ó���ϴ� �ڵ� ����
 * @author user
 */
public class SelectMenu {

	private List<DataVO> dataList; //����ڰ� �Է��� �����͸� ������ ������ JCF.
	
	public SelectMenu() {
		// ����ڰ� �Է��� �����͸� ������ ������ List�� ����
		dataList = new ArrayList<DataVO>();
	}//SelectMenu
	/**
	 * ����ڰ� �׸� �� ������ ������ �޴�
	 * 1. ������ �Է�, 2. ������ ���, 3. ����
	 */
	public void menu() {

		boolean exitFlag = false; //�޴��� ���������� ���� flag����
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("�������α׷�. �޴��� ��ȣ �Է����ּ��� \n�޴�) 1. �Է� 2.��� 3.����");
			
			try {
			if( inputMenu.equals("1") || inputMenu.equals("2") || inputMenu.equals("3") ) {//�Է� �޴� ��
				
				if(inputMenu.equals("1")) {//�������Է�
					inputData();
				}//end if
				if(inputMenu.equals("2")) {//���������
					printData();
				}//end if
				if(inputMenu.equals("3")) {//����
					exitFlag = closeApp();
				}//end if
			}else {
				JOptionPane.showInputDialog(null, "�޴��� 1,2,3�� �ϳ��� �Է����ּ���");
			}//end else
			}catch(NullPointerException npe) {//�Է¸޴�Dialog���� x�� �����ų� cancel button�� ������ ��
				exitFlag =	closeApp();
			}//end catch
			
		}while( !exitFlag );
		
	}//menu
	
	/**
	 * �̸��� ���̸� CSV (comma separated value) �����͸� �Է¹޾� 
	 */
	public void inputData() {
		String csvData = JOptionPane.showInputDialog("�������Է� \n �Է� ��) �̸�, ����");
	
		try {
		String[] tempData = csvData.split(","); //�ƹ��͵� �Է����� ������ NullPointerException �߻�
		if( tempData.length == 2 ) {//�Է°��� ���� üũ, ���� ���� �ʰ� "OK"�� ������ ""�� �Է�
			
			String name = tempData[0];
			int age = Integer.parseInt(tempData[1]); //NumberFormatException
			
			//�Էµ����͸� VO �� �ְ�, VO�� List�� �߰�
			dataList.add(new DataVO(name,age));
			
		}else {
			JOptionPane.showMessageDialog(null, "�Է������� �̸�, ���� �����̾�� �մϴ�");
		}//end else
		}catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "�Է��� ���� �߰����ּ���");
		}catch(NumberFormatException nfe) {
		JOptionPane.showMessageDialog(null, "���̴� ���� �����̾�� �մϴ�");
	}//end catch
		
	}//inputData
	
	/**
	 * �Էµ� �̸��� ���̸� List���� �޾ƿͼ� JTextArea�� ���
	 * ��ȣ( for �ε��� ), �̸�(VO), ����(VO), �¾ ��(��¥��ü�� ���̸� ����)
	 */
	public void printData() {
		
		StringBuilder sbOutputData = new StringBuilder(); //��µ����͸� ������ ����
		sbOutputData.append("��ȣ\t�̸�\t����\t�¾��\n");
		sbOutputData.append("----------------------------------------------------\n");
		if( dataList.isEmpty() ) {//�����Ͱ� �������� �ʴ� ���
			sbOutputData.append("�Էµ� �����Ͱ� �������� �ʽ��ϴ�");
		}//end if
		
		DataVO dv = null;
		int nowYear = Calendar.getInstance().get(Calendar.YEAR);
		
		for( int idx = 0; idx < dataList.size() ; idx ++ ) {
			dv = dataList.get(idx); //����Ʈ �濡 ����ִ� VO�� �����ͼ� ����
			
			//method chain
			sbOutputData.append(idx+1).append("\t").append(dv.getName()).append("\t")
			.append(dv.getAge()).append("\t").append(nowYear - dv.getAge() + 1).append("\n");
		}//end for
		
		JTextArea jtaDataDisplay = new JTextArea(10, 60);
		jtaDataDisplay.setText(sbOutputData.toString());//������ ��� �����͸� J.T.A�� �߰�
		jtaDataDisplay.setEditable(false);//�����Ұ�
		
		JScrollPane jspDataDisplay = new JScrollPane(jtaDataDisplay);
		
		//MessageDialog�� ���
		JOptionPane.showMessageDialog(null, jspDataDisplay);
		
		
	}//printData
	
	/**
	 * ����ó��
	 */
	public boolean closeApp() {
		boolean flag = false;
		
		int selectExitBtn = JOptionPane.showConfirmDialog(null, "���� ���α׷� �����Ͻ�?");
		System.out.println(selectExitBtn);
		switch (selectExitBtn) {
		case JOptionPane.OK_OPTION: flag = true;
		}//end switch
		return flag;
	}//closeApp
	
}//class
