package day0226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener {

	public MainWindow() {
		super("���̾�α׿���");
		
		JButton jbtn = new JButton("���̾�α� ����");
		
		JPanel panel = new JPanel();
		panel.add(jbtn);
		
		jbtn.addActionListener(this);
		
		add("Center", panel);
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		//JDialog�� ��ӹ��� Ŭ������ ��üȭ
		new SubWindow(this);
		
	}//actionPerformed

	public static void main(String[] args) {
		new MainWindow();
	}//main

}//class
