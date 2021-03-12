package TeamProject1;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewReportEvt extends AnalysisLog1 implements ActionListener{

	private ViewReport vr;
	private JTextArea jtaLog;
	
	private static int CLICK = 1;
	
	public ViewReportEvt(ViewReport vr) {
		this.vr = vr;
	}//ViewReportEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton jbtnView = vr.getJbtnView();
		JButton jbtnReport = vr.getJbtnReport();
		jtaLog = vr.getJtaLog();
		
		if(ae.getSource() == jbtnView) {
			CLICK = 0;
			try {
				jtaLog.setText("");
				getLogInfo();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		
		if(CLICK == 0) {
			if(ae.getSource() == jbtnReport) { 
				try {
					report();
				} catch (IOException e) {
					e.printStackTrace();
				
			}finally {
				JOptionPane.showMessageDialog(jbtnReport, "경로 : c:/dev/report\n파일이 생성되었습니다.");
			
			}//end if
		}
	}
}//actionPerformed

	public void getLogInfo() throws IOException {
		FileDialog fd = new FileDialog(vr,"LogFile Load", FileDialog.LOAD);
		fd.setVisible(true);

		String path = fd.getDirectory();
		String fileName = fd.getFile();
		File file = new File(path + fileName);
		
		StringBuilder sbLogData = new StringBuilder();


		fd.setTitle(path + fileName);

		if(file.exists() && file.getName().equals("sist_input_1.log")) {

			sbLogData.append(maxKey()).append("\n\n").append(GoValue()).append("\n")
			.append(DoneValue()).append("\n\n").append(MaxRequest()).append("\n\n")
			.append(ErrorValue()).append("\n\n").append(RangeMaxKey(1, 100));
		}//end if
		
		vr.getJtaLog().setText(String.valueOf(sbLogData));
		vr.getJtaLog().setEditable(false);
		
	}//getLogInfo1
	
	public void report() throws IOException{
		
		jtaLog = vr.getJtaLog();
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String b = sdf.format(System.currentTimeMillis());
		
		File dir = new File("c:/dev/report");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		
		File file = new File(dir.getAbsolutePath()+"/report_"+b+".dat");
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter( new FileWriter(file));
			bw.write(jtaLog.getText());
			bw.flush();
		}finally {
			if(bw != null) {bw.close();}
			}
	}//report
	
}//class


