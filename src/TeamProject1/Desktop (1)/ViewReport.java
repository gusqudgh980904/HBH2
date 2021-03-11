package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class ViewReport extends JDialog{
	
	private JButton jbtnView;
	private JButton jbtnReport;
	private JTextArea jtaLog;
	
	public void addDialog() {
		jbtnView = new JButton("view");
		jbtnReport = new JButton("report");
		jtaLog = new JTextArea();
		//JLabel jlIfm = new JLabel("Ver1.0 Log Information system");
		
		JScrollPane jspLog = new JScrollPane(jtaLog);
		TitledBorder tbLog = new TitledBorder("Log Information");
		
		setTitle("Log Information system");
		setLayout(null);
		setBounds(getX()+300,getY()+120, 550, 550);
		
		Font jbtnfont = new Font("¸¼Àº °íµñ",Font.BOLD, 22);
		jbtnView.setFont(jbtnfont);
		jbtnReport.setFont(jbtnfont);
		tbLog.setTitleFont(jbtnfont);
		
		jbtnView.setForeground(Color.white);
		jbtnView.setBackground(Color.pink);
		jbtnReport.setForeground(Color.white);
		jbtnReport.setBackground(Color.pink);
		getContentPane().setBackground(Color.white);
		
		add(jbtnView);
		add(jbtnReport);
		add(jspLog);
		add(jspLog);
		//add(jlIfm);
		
		jspLog.setBorder(tbLog);
		
		jspLog.setBounds(20,100,493,380);
		jbtnView.setBounds(303,63,100,40);
		jbtnReport.setBounds(411,63,100,40);
		//jlIfm.setBounds(337,480,200,30);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
	
	public JButton getJbtnView() {
		return jbtnView;
	}

	public JButton getJbtnReport() {
		return jbtnReport;
	}

	public JTextArea getJtaLog() {
		return jtaLog;
	}

}
