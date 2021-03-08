package day0223;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ��� ���� ��� ������Ʈ ũ�Ⱑ ���� �����Ǵ� ���̾ƿ� �Ŵ���
 * @author user
 */
@SuppressWarnings("serial")
//1. ������ ������Ʈ ���
public class UseGridLayout extends JFrame {
	//2. ������Ʈ ����
	public UseGridLayout() {
		super("GridLayout ����");
		String[] btnTitle = "1,2,3,4,5,6,7,8,9,#,0,*".split(",");
		
		JButton[] jbtn = new JButton[btnTitle.length]; //��ư �迭 ���� ( ���� ���� null �ʱ�ȭ�� ����)
		
		//�۲� ����
		Font font = new Font("Serif",Font.BOLD, 20 );
		
		for( int i =0; i < jbtn.length ; i ++) {
			jbtn[i] = new JButton( btnTitle[i] ); // �� ���� ��ư ��ü�� ��ư Ÿ��Ʋ�� �ο��Ͽ� ����
			jbtn[i].setFont(font);//������ �۲��� ����
		}//end for
		
		//3. ��ġ������ ���� BorderLayout => GridLayout
		setLayout(new GridLayout(4,3));

		
		//4. ������Ʈ ��ġ ( add(������Ʈ��) )
		for( int i = 0 ; i < jbtn.length ; i ++) {
			add( jbtn[i] ); // ������ ��ư ��ü�� ��ġ
		}//end for
		
		//5. ������ ũ�� ����
		setSize(300, 450);
		
		//6.����ڿ� �����ֱ�
		setVisible(true);
		
		//7. ������ �����̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseGridLayout

	public static void main(String[] args) {
		UseGridLayout ugl = new UseGridLayout();
		

	}//main

}//class
