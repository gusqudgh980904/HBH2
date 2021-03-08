package day0303;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//import org.graalvm.compiler.hotspot.stubs.NullPointerExceptionStub;

/**
 *	사용자에게 메뉴를 제공하고, 메뉴를 처리하는 코드 정의
 * @author user
 */
public class SelectMenu {

	private List<DataVO> dataList; //사용자가 입력한 데이터를 저장할 목적의 JCF.
	
	public SelectMenu() {
		// 사용자가 입력한 데이터를 저장할 목적의 List를 생성
		dataList = new ArrayList<DataVO>();
	}//SelectMenu
	/**
	 * 사용자가 그만 둘 때까지 제공할 메뉴
	 * 1. 데이터 입력, 2. 데이터 출력, 3. 종료
	 */
	public void menu() {

		boolean exitFlag = false; //메뉴를 빠져나가기 위한 flag변수
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("관리프로그램. 메뉴의 번호 입력해주세요 \n메뉴) 1. 입력 2.출력 3.종료");
			
			try {
			if( inputMenu.equals("1") || inputMenu.equals("2") || inputMenu.equals("3") ) {//입력 메뉴 비교
				
				if(inputMenu.equals("1")) {//데이터입력
					inputData();
				}//end if
				if(inputMenu.equals("2")) {//데이터출력
					printData();
				}//end if
				if(inputMenu.equals("3")) {//종료
					exitFlag = closeApp();
				}//end if
			}else {
				JOptionPane.showInputDialog(null, "메뉴는 1,2,3중 하나만 입력해주세요");
			}//end else
			}catch(NullPointerException npe) {//입력메뉴Dialog에서 x를 눌렀거나 cancel button을 눌렀을 때
				exitFlag =	closeApp();
			}//end catch
			
		}while( !exitFlag );
		
	}//menu
	
	/**
	 * 이름과 나이를 CSV (comma separated value) 데이터를 입력받아 
	 */
	public void inputData() {
		String csvData = JOptionPane.showInputDialog("데이터입력 \n 입력 예) 이름, 나이");
	
		try {
		String[] tempData = csvData.split(","); //아무것도 입력하지 않으면 NullPointerException 발생
		if( tempData.length == 2 ) {//입력값의 형식 체크, 값을 넣지 않고 "OK"를 누르면 ""가 입력
			
			String name = tempData[0];
			int age = Integer.parseInt(tempData[1]); //NumberFormatException
			
			//입력데이터를 VO 에 넣고, VO를 List에 추가
			dataList.add(new DataVO(name,age));
			
		}else {
			JOptionPane.showMessageDialog(null, "입력형식은 이름, 나이 형식이어야 합니다");
		}//end else
		}catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "입력할 값을 추가해주세요");
		}catch(NumberFormatException nfe) {
		JOptionPane.showMessageDialog(null, "나이는 숫자 형식이어야 합니다");
	}//end catch
		
	}//inputData
	
	/**
	 * 입력된 이름과 나이를 List에서 받아와서 JTextArea에 출력
	 * 번호( for 인덱스 ), 이름(VO), 나이(VO), 태어난 해(날짜객체와 나이를 연산)
	 */
	public void printData() {
		
		StringBuilder sbOutputData = new StringBuilder(); //출력데이터를 저장할 변수
		sbOutputData.append("번호\t이름\t나이\t태어난해\n");
		sbOutputData.append("----------------------------------------------------\n");
		if( dataList.isEmpty() ) {//데이터가 존재하지 않는 경우
			sbOutputData.append("입력된 데이터가 존재하지 않습니다");
		}//end if
		
		DataVO dv = null;
		int nowYear = Calendar.getInstance().get(Calendar.YEAR);
		
		for( int idx = 0; idx < dataList.size() ; idx ++ ) {
			dv = dataList.get(idx); //리스트 방에 들어있는 VO를 꺼내와서 저장
			
			//method chain
			sbOutputData.append(idx+1).append("\t").append(dv.getName()).append("\t")
			.append(dv.getAge()).append("\t").append(nowYear - dv.getAge() + 1).append("\n");
		}//end for
		
		JTextArea jtaDataDisplay = new JTextArea(10, 60);
		jtaDataDisplay.setText(sbOutputData.toString());//생성된 출력 데이터를 J.T.A에 추가
		jtaDataDisplay.setEditable(false);//편집불가
		
		JScrollPane jspDataDisplay = new JScrollPane(jtaDataDisplay);
		
		//MessageDialog에 출력
		JOptionPane.showMessageDialog(null, jspDataDisplay);
		
		
	}//printData
	
	/**
	 * 종료처리
	 */
	public boolean closeApp() {
		boolean flag = false;
		
		int selectExitBtn = JOptionPane.showConfirmDialog(null, "관리 프로그램 종료하실?");
		System.out.println(selectExitBtn);
		switch (selectExitBtn) {
		case JOptionPane.OK_OPTION: flag = true;
		}//end switch
		return flag;
	}//closeApp
	
}//class
