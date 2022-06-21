import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame{
	JTextField tfInput, tfOutput;
	JButton btnRevise, btnDelete;
	Vector<String> v = new Vector<String>(); //벡터 생성
	JList<String> strList;
	int index; //목록에서 선택된 원소가 몇번째 원소인지 받아오는 변수
	
	public ListTest() {
		setTitle("리스트 테스트"); //프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane(); //컨텐트 팬을 알아낸다.
		c.setLayout(new BorderLayout()); //컨탠트팬에 BorderLayout 배치관리자 설정. 
		
		MyListener ml= new MyListener(); //리스너 객체 생성
		
		tfInput = new JTextField(); //text field 생성
		tfInput.addActionListener(ml); //text field에 리스너 등록
		
		strList = new JList<String>(v); //문자열 리스트 생성
		strList.addListSelectionListener(new ListListener()); //리스트에 리스너 등록
		
		JPanel down = new JPanel(); //패널 생성
		down.setLayout(new FlowLayout()); //패널에 FlowLayout 배치관리자 설정
		tfOutput= new JTextField(10); //열의 개수가 10칸인 textfield 생성

		btnRevise = new JButton("수정"); //버튼 생성
		btnRevise.addActionListener(ml); //버튼에 리스너 등록

		btnDelete = new JButton("삭제"); //버튼 생성
		btnDelete.addActionListener(ml);//버튼에 리스너 등록

		down.add(tfOutput);down.add(btnRevise);down.add(btnDelete);//패널에 부착
		
		c.add(tfInput, BorderLayout.NORTH);
		c.add(new JScrollPane(strList), BorderLayout.CENTER); //strList를 스크롤팬에 부착
		c.add(down, BorderLayout.SOUTH);
		//컨텐트 팬에 부착
		
		setSize(300,250); //프레임 크기 300x250
		setVisible(true); //프레임 화면 출력
	}
	class MyListener implements ActionListener{ //text field에 값을 입력하거나 버튼을 눌렀을때 발생하는 이벤트 구현

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource(); //이벤트 소스 컴포넌트의 레퍼런스를 리턴받아 받음
			if(obj==tfInput) { //래퍼런스가 tfInput이면(tfInput에 값을 입력)
				v.add(tfInput.getText()); //벡터에 tfInput으로 부터 값을 가져와서 저장
				tfInput.setText(""); //텍스트 필드에 입력된 내용지우기
			}
			if(obj==btnRevise) { //래퍼런스가 btnRevise면(수정 버튼 누름)
				v.set(index, tfOutput.getText()); //tfOutput으로 값을 받아와서 벡터에 index에 해당하는 곳의 값을 바꿔줌
				tfOutput.setText(""); //텍스트 필드에 입력된 내용지우기
			}
			if(obj==btnDelete) { //래퍼런스가 btnDelete면(삭제 버튼 누름)
				v.remove(index); //벡터에서 index가 해당하는 곳의 원소 삭제
				tfOutput.setText(""); //텍스트 필드에 입력된 내용지우기
			}
			strList.setListData(v); //벡터에 입력된 모든 이름으로 리스트 새로 만들기
		}
	}
	class ListListener implements ListSelectionListener{ 

		@Override
		public void valueChanged(ListSelectionEvent e) {
			String name = (String)strList.getSelectedValue(); //목록에서 선택된 값을 받아와서 name에 저장
			tfOutput.setText(name); //tfOutput의 텍스트 필드를 name으로 바꿔줌
			index=strList.getSelectedIndex(); //목록에서 선택된 index를 받아와서 index에 저장
		}
		
	}
	
	public static void main(String[] args) {
		new ListTest();
	}

}
