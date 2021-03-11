package TeamProject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class LoginEvt implements ActionListener{

	private Login li;
	
	public LoginEvt(Login li) {
		this.li = li;
		
		li.getJtfId().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				li.getJtfId().setText("");
			}
		});
		
		li.getJpfPw().addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent e){
		    	li.getJpfPw().setText("");   
		    }
		 });	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String id = li.getJtfId().getText();
		String pw ="";
		char[] pass = li.getJpfPw().getPassword();
		for(char p : pass) {
			pw += Character.toString(p);	
		}
		
		if(e.getSource() == li.getJbtnLogin()) {
			
			if((id.equals("admin"))&&(pw.equals("1234"))) {
				//Dialog 실행 
				System.out.println("로그인1");
			}else if((id.equals("root"))&&(pw.equals("1111"))) {
				//Dialog 실행
				System.out.println("로그인2");
			}else{
				JOptionPane.showMessageDialog(null,"아이디 혹은 비밀번호를 잘못 입력하셨습니다.","로그인실패",JOptionPane.ERROR_MESSAGE);		
			}
			
		}
		
	}

}
