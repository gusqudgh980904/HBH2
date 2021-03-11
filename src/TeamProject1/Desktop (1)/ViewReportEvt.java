package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class ViewReportEvt implements ActionListener{

	private ViewReport vr;
	
	public ViewReportEvt(ViewReport vr) {
		this.vr = vr;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton jbtnView = vr.getJbtnView();
		JButton jbtnReport = vr.getJbtnReport();
		JTextArea jtaLog = vr.getJtaLog();
		
		if(ae.getSource() == jbtnView) {
			
		}
		
		if(ae.getSource() == jbtnReport) {
			
		}
	}
}
