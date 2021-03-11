package project;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ViewReport extends JDialog{
	
	
	private JButton jbtnView;
	private JButton jbtnReport;
	private JTextArea jtalog;
	
	
	public ViewReport(Login li) {
		super(li,"Log Information system",true);
		
		jbtnView = new JButton("View");
		jbtnReport = new JButton("Report");
		jtalog = new JTextArea(50,50);
		
		
	}
	
	
	
	
	public JButton getJbtnView() {
		return jbtnView;
	}

	public JButton getJbtnReport() {
		return jbtnReport;
	}

	public JTextArea getJtalog() {
		return jtalog;
	}

	public static void main(String[] args) {
		
	}

}
