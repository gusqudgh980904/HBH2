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
				//Dialog ���� 
				System.out.println("�α���1");
			}else if((id.equals("root"))&&(pw.equals("1111"))) {
				//Dialog ����
				System.out.println("�α���2");
			}else{
				JOptionPane.showMessageDialog(null,"���̵� Ȥ�� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.","�α��ν���",JOptionPane.ERROR_MESSAGE);		
			}
			
		}
		
	}

}
