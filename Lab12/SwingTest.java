import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ModalDialog extends JDialog{
	String [] font = {"굴림","돋움","궁서","맑은 고딕"};
	JComboBox <String> strCombo;
	JTextField tfsize;
	JCheckBox ckbold, ckitalic;
	int style; //글씨 스타일을 저장할 변수
	public ModalDialog(JFrame frame, String title) {
		super(frame, title, true); //true는 모달 타입을 만들도록 지시
		setLayout(new BorderLayout()); //BorderLayout으로 지정
		JPanel left = new JPanel(); //패널 생성
		left.setLayout(new GridLayout(0,1)); //패널을 GridLayout으로 지정
		//패널에 삽입
		left.add(new JLabel("폰트 종류")); 
		left.add(new JLabel("폰트 스타일"));
		left.add(new JLabel("폰트 크기"));
		
		JPanel right = new JPanel(); //패널 생성
		right.setLayout(new GridLayout(0,1)); //패널 GridLayout으로 지정
		strCombo = new JComboBox<String>(font); //문자열 콤보박스
		right.add(strCombo); //패널에 콤보박스 삽입
		JPanel panelStyle = new JPanel(); //패널 생성(스타일)
		MyCheckListener mcl = new MyCheckListener(); //체크박스에 대한 리스너 객체 생성
		ckbold = new JCheckBox("BOLD"); //체크박스 생성
		ckbold.addItemListener(mcl); //체크박스에 리스너 등록
		ckitalic = new JCheckBox("ITALIC"); //체크박스 생성
		ckitalic.addItemListener(mcl); //체크박스에 리스너 등록
		panelStyle.add(ckbold);	panelStyle.add(ckitalic); //패널에 부착
		right.add(panelStyle); //패널에 스타일 패널 삽입
		tfsize = new JTextField(); //text field 생성
		right.add(tfsize); //text field 패널에 삽입
		
		JPanel down = new JPanel();//패널 생성
		JButton ok = new JButton("설정"); //버튼 생성
		ok.addActionListener(new ActionListener() { //익명 클래스
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //다이얼로그 닫음
			
			}
		});
		down.add(ok);//패널에 버튼 부착
		add(left,BorderLayout.WEST);add(right,BorderLayout.CENTER);	add(down, BorderLayout.SOUTH); //패널에 삽입
		setSize(230,180); //크기 250x150
	}
	class MyCheckListener implements ItemListener{ //체크박스에 대한 리스너
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(ckbold.isSelected() &&ckitalic.isSelected()) { //BOLD와 ITALIC이 체크되어있으면
				style=3; 
			}
			else if(ckbold.isSelected()) { //BOLD가 체크되어있으면
				style=1;
			}
			else if(ckitalic.isSelected()){ //ITALIC이 체크되어있으면
				style=2;
			}
			else { //체크가 없으면
				style=0;
			}
		}	
	}
	public String getFontName() {
		int index =strCombo.getSelectedIndex(); //콤보박스에서 선택한 인덱스 받아오기
		return font[index]; //font[index]리턴
	}

	public String getFontSize() {
		if(tfsize.getText().length()==0) return null; //텍스트 필드에 입력된 것이 없으면 null 리턴
		else return tfsize.getText(); //아니면 텍스트필드에서 값을 받아와서 리턴
	}

	public int getStyle() {
		return style; //스타일 리턴
	}
	/*public int getFlag() {
		return flag; //"설정"버튼이 눌렸는지 리턴
	}*/
}
public class SwingTest extends JFrame{
	JLabel lb = new JLabel("Text"); //라벨 생성
	ModalDialog dialog;
	public SwingTest() {
		setTitle("Menu 만들기 예제"); //프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		Container c =getContentPane();
		createMenu(); // 메뉴 생성, 프레임에 삽입
		c.setLayout(new FlowLayout()); //컨탠트팬을 FlowLayout으로 설정
		c.add(lb); //라벨을 컨텐트팬에 부착
		
		dialog = new ModalDialog(this, " "); //모달 다이얼로그 생성
		lb.setToolTipText("편집에 따라 변경될 영역입니다."); //라벨에 툴팁 달기
		ToolTipManager m = ToolTipManager.sharedInstance(); //ToolTipManager 객체를 얻기
		m.setInitialDelay(0); //초기 툴팁 출력 지연 시간을 0초로 설정
			
		setSize(300,200); //프레임 크기 300x200
		setVisible(true);
	}
	//메뉴를 만들어 프레임에 삽입한다
	private void createMenu() {
		MyListener ml = new MyListener(); //리스너 객체 생성
		JMenuBar mb = new JMenuBar(); //메뉴바 생성
		
		JMenu fileMenu = new JMenu("파일"); //파일 메뉴 생성
		JMenuItem fileItem [] = new JMenuItem[3]; 
		String fileStr [] = {"열기","저장","종료"};
		//3개의 메뉴아이템을 파일 메뉴에 삽입
		for(int i=0;i<2;i++) { //2개의 메뉴 아이템을 파일 메뉴에 삽입
			fileItem[i] = new JMenuItem(fileStr[i]); //메뉴 아이템 생성
			fileItem[i].addActionListener(ml); //메뉴 아이템에 리스너 등록
			fileMenu.add(fileItem[i]); //메뉴아이템을 파일 메뉴에 삽입
		}
		fileMenu.addSeparator(); //분리선 삽입
		fileItem[2] = new JMenuItem(fileStr[2]); //메뉴 아이템 생성
		fileItem[2].addActionListener(ml); //메뉴아이템에 리스너 등록
		fileMenu.add(fileItem[2]); //메뉴 아이템을 파일 메뉴에 삽입
		

		JMenu editMenu = new JMenu("편집"); //편집 메뉴 생성
		JMenuItem editItem [] = new JMenuItem[3]; 
		String editStr [] = {"색 선택","폰트","텍스트 변경"};
		//3개의 메뉴아이템을 편집 메뉴에 삽입
		for(int i=0;i<editItem.length;i++) {
			editItem[i] = new JMenuItem(editStr[i]); //메뉴 아이템 생성
			editItem[i].addActionListener(ml); //메뉴 아이템에 리스너 등록
			editMenu.add(editItem[i]); //메뉴 아이템을 편집 메뉴에 삽입
		}
		
		JMenu helpMenu = new JMenu("도움말"); //도움말 메뉴 생성
		//1개의 메뉴 아이템을 도움말 메뉴에 삽입
		JMenuItem helpItem = new JMenuItem("버전 정보"); //메뉴 아이템 생성
		helpItem.addActionListener(ml); //메뉴 아이템에 리스너 등록
		helpMenu.add(helpItem); //메뉴 아이템을 도움말 메뉴에 삽입
		
		mb.add(fileMenu);mb.add(editMenu);mb.add(helpMenu); //메뉴바에 파일, 편집, 도움말 메뉴 삽입
		
		setJMenuBar(mb); //메뉴바를 프레임에 부착
	}
	
	class MyListener implements ActionListener{
		private JFileChooser chooser  = new JFileChooser(); //파일 다이얼로그 생성
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int ret;
			String filePath;
			String cmd= e.getActionCommand(); //사용자가 선택한 메뉴 아이템의 문자열 리턴
			switch (cmd) { //메뉴 아이템의 종류 구분
			case "열기": //열기를 눌렀을때 
				ret=chooser.showOpenDialog(null); //파일 다이얼로그 출력
				if(ret != JFileChooser.APPROVE_OPTION) { //사용자가 강제로 창을 닫았거나 취소 버튼을 누른 경우 경고창 뜨게함
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
					return; 
				}
				//파일 선택하고 열기 버튼 누른 경우
				filePath = chooser.getSelectedFile().getPath(); //파일 경로명 리턴
				lb.setText(filePath+"파일이 선택되었습니다."); //라벨의 text 바뀜
				break;
			case "저장":
				ret=chooser.showSaveDialog(null); //파일 다이얼로그 출력
				if(ret != JFileChooser.APPROVE_OPTION) {//사용자가 강제로 창을 닫았거나 취소 버튼을 누른 경우 경고창 뜨게 함
					JOptionPane.showMessageDialog(null, "파일이 저장되지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//파일 선택하고 저장 버튼 누른 경우
				filePath = chooser.getSelectedFile().getPath(); //파일 경로명 리턴
				lb.setText(filePath+"파일에 저장되었습니다."); //라벨의 text 바뀜
				break;
			case "종료": //종료 눌렀을때
				int result = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?","종료 확인",JOptionPane.YES_NO_OPTION); //확인 다이얼로그 생성
				if(result==JOptionPane.YES_OPTION) //확인 버튼을 누르면
					System.exit(0); //시스템 종료
				break;
			case "색 선택": //색 선택 눌렀을때 
				Color selectedColor = JColorChooser.showDialog(null, "색상 선택", Color.YELLOW); //컬러 다이얼로그를 출력하고 사용자가 선택한 색을 알아온다 
				if(selectedColor !=null) //사용자가 색을 선택하고 "확인"버튼을 누른경우
					lb.setForeground(selectedColor); //사용자가 선태한 색으로 문자열 색 변경
				break;
			case "폰트": //폰트를 누르면
				dialog.setVisible(true); //모달 다이얼로그 작동 시작
				String fontName = dialog.getFontName(); //다이얼로그로 부터 글씨체 받아오기
				int fontStyle  = dialog.getStyle(); //다이얼로그로부터 폰트 스타일 받아오기
				String fontSize= dialog.getFontSize(); //다이얼로그로부터 폰트 크기 받아오기
				lb.setFont(new Font(fontName,fontStyle,fontSize==null?lb.getFont().getSize():Integer.parseInt(fontSize))); //받아온 폰트 글씨체, 스타일, 크기로 라벨의 폰트 변경
				break;
			case "텍스트 변경": //텍스트 변경 눌렀을때
				String text = JOptionPane.showInputDialog("변경할 텍스트를 입력하세요"); //입력 다이얼로그 생성
				if(text!=null)  //입력한게 있으면
					lb.setText(text); //사용자가 입력한 문자열로 라벨의 text를 바꿔줌
				break;
			case "버전 정보": //버전 정보 눌렀을때
				JOptionPane.showMessageDialog(null,"테스트 v1.0","버전 정보",JOptionPane.INFORMATION_MESSAGE); //메시지 다이얼로그 생성
				break;
			}
			
		}
		
	}
	public static void main(String[] args) {
		new SwingTest();
	}

}

