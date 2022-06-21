import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ItemTest extends JFrame{
	ItemCollections ic;
	JTabbedPane pane;
	String strList []= {""};
	String sortList [] ={"제목","별점"}; 
	//리스트 생성
	JList<String> listTotal = new JList<String>(strList); 
	JList<String> listMovie = new JList<String>(strList); 
	JList<String> listBook = new JList<String>(strList); 
	JList<String> listSearch = new JList<String>(strList); 
	JButton append, revise, delete, search;
	JTextArea plotTA, reviewTA;
	JTextField searchTF ;
	JPanel write= new JPanel();
	JPanel detail = new JPanel();
	JPanel searchPanel = new JPanel();
	MyAppendDialog appendDialog;
	MyReviseDialog reviseDialog;
	//콤보박스 생성
	JComboBox <String> sort = new JComboBox <String> (sortList);
	String strMovie [] = {"제목","감독","배우","장르","등급","개봉년도","별점"};
	String strBook [] = {"제목","저자","출판사","출판년도","별점"};
	int index=-1;
	
	public ItemTest() {
		setTitle("JAVA 04 1916737 송민영");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우 닫으면 프로그램을 종료하도록 설정
		
		Container c =getContentPane();
		createMenu(); // 메뉴 생성, 프레임에 삽입
		 ic = new ItemCollections(); //ItemCollections에 대한 객체 생성
		//상단
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		top.add(new MyLabel(), BorderLayout.EAST); //MyLabel은 시간을 표시하는 라벨. 라벨을 우측 상단에 넣어줌 
		JLabel l = new JLabel("My Notes"); //"My Notes"라 써있는 라벨 생성. 
		l.setFont(new Font("TimesRoman",3,40));  //라벨 폰트
		l.setForeground(Color.blue); //라벨 색
		top.add(l, BorderLayout.CENTER);
		//좌측
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		JTabbedPane pane = createTabbedPane(); //탭팬 생성
		append = new JButton("추가");
		append.addActionListener(new MyButtonListener()); //버튼에 리스너 등록
		JPanel p = new JPanel();
		p.add(append);
		left.add(pane,BorderLayout.CENTER); left.add(p,BorderLayout.SOUTH);
		appendDialog = new MyAppendDialog(this,"입력"); //다이얼로그도 등록
		//우측
		JPanel right = new JPanel(); //여기에 라벨 하나 넣어야 되긴 할듯.
		right.setLayout(new BorderLayout());
		JPanel result = new JPanel();
		Border resultBorder = BorderFactory.createTitledBorder("상세보기"); //제목이 붙여진 경계 생성
		result.setBorder(resultBorder); //경계 등록
		result.setLayout(new BorderLayout());
		//세부사항
		detail.setLayout(new GridLayout(1,0));
		ImagePanel img= new ImagePanel(); //이미지 패널 생성
		detail.add(img);detail.add(write); 
		JPanel text = new JPanel();
		text.setLayout(new GridLayout(0,1));
		//줄거리
		JPanel plot = new JPanel();
		Border plotBorder = BorderFactory.createTitledBorder("줄거리"); //제목이 붙여진 경계 생성
		plot.setBorder(plotBorder); //경계 등록
		plotTA= new JTextArea(6,65); //크기 조절
		plot.add(new JScrollPane(plotTA)); //스크롤팬 등록
		plotTA.setLineWrap(true); //자동 줄바꿈
		//감상평
		JPanel review = new JPanel();
		Border reviewBorder = BorderFactory.createTitledBorder("감상평"); //제목이 붙여진 경계 생성
		review.setBorder(reviewBorder); //경계 등록
		reviewTA= new JTextArea(6,65); //크기 조절
		review.add(new JScrollPane(reviewTA)); //스크롤팬 등록
		reviewTA.setLineWrap(true); //자동 줄바꿈
		
		text.add(plot); text.add(review);		
		result.add(detail,BorderLayout.CENTER); result.add(text, BorderLayout.SOUTH);
		
		revise = new JButton("수정");
		delete = new JButton("삭제");
		//버튼에 리스너 등록
		revise.addActionListener(new MyButtonListener());
		delete.addActionListener(new MyButtonListener());
		
		JPanel btn = new JPanel();
		btn.add(revise); btn.add(delete); //		
		right.add(result, BorderLayout.CENTER);right.add(btn, BorderLayout.SOUTH);
		
		c.add(top, BorderLayout.NORTH);	c.add(left, BorderLayout.WEST);c.add(right, BorderLayout.CENTER);
		
		setSize(1000,800); //프레임 크기 1000x800
		setVisible(true);
	}
	
	//메뉴를 만들어 프레임에 삽입한다
	private void createMenu() {
		MyMenuListener mml = new MyMenuListener(); //리스너 객체 생성
		JMenuBar mb = new JMenuBar(); //메뉴바 생성
			
		JMenu fileMenu = new JMenu("파일"); //파일 메뉴 생성
		JMenuItem fileItem [] = new JMenuItem[3]; 
		String fileStr [] = {"불러오기","저장하기","종료"};
		//3개의 메뉴아이템을 파일 메뉴에 삽입
		for(int i=0;i<2;i++) { //2개의 메뉴 아이템을 파일 메뉴에 삽입
			fileItem[i] = new JMenuItem(fileStr[i]); //메뉴 아이템 생성
			fileItem[i].addActionListener(mml); //메뉴 아이템에 리스너 등록
			fileMenu.add(fileItem[i]); //메뉴아이템을 파일 메뉴에 삽입
		}
		fileMenu.addSeparator(); //분리선 삽입
		fileItem[2] = new JMenuItem(fileStr[2]); //메뉴 아이템 생성
		fileItem[2].addActionListener(mml); //메뉴아이템에 리스너 등록
		fileMenu.add(fileItem[2]); //메뉴 아이템을 파일 메뉴에 삽입
			
		JMenu helpMenu = new JMenu("도움말"); //도움말 메뉴 생성
		//1개의 메뉴 아이템을 도움말 메뉴에 삽입
		JMenuItem helpItem = new JMenuItem("시스템 정보"); //메뉴 아이템 생성
		helpItem.addActionListener(mml); //메뉴 아이템에 리스너 등록
		helpMenu.add(helpItem); //메뉴 아이템을 도움말 메뉴에 삽입
			
		mb.add(fileMenu);mb.add(helpMenu); //메뉴바에 파일, 도움말 메뉴 삽입
			
		setJMenuBar(mb); //메뉴바를 프레임에 부착
    }
	
	private JTabbedPane createTabbedPane() {
		pane = new JTabbedPane();
		searchPanel.setLayout(new BorderLayout());
		JPanel up = new JPanel(); 
		searchTF = new JTextField(15); //검색하는 textfield
		search = new JButton("검색");//검색 버튼 만들기
		search.addActionListener(new MySearchListener()); //버튼에 리스너 등록
		up.add(sort,BorderLayout.WEST); //제목, 별점으로 구성된 콤보박스 등록
		up.add(searchTF,BorderLayout.CENTER);
		up.add(search,BorderLayout.EAST);
		searchPanel.add(up,BorderLayout.NORTH);
		searchPanel.add(listSearch,BorderLayout.CENTER);
		
		 //리스트에 리스너 등록
		listTotal.addListSelectionListener(new ListListener());
		listMovie.addListSelectionListener(new ListListener()); 
		listBook.addListSelectionListener(new ListListener()); 
		listSearch.addListSelectionListener(new ListListener());
		pane.addTab("전체", listTotal);
		pane.addTab("영화", listMovie);
		pane.addTab("도서", listBook);
		pane.addTab("검색", searchPanel);
		
		return pane;
	}
	class ListListener implements ListSelectionListener{ //리스트에 대한 이벤트 처리
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(pane.getSelectedIndex()==1) { //영화인경우
				String listname = listMovie.getSelectedValue(); //select한 값을 받아옴 
				index = ic.getIndex(listname); //그 값의 인덱스를 받아옴
				//영화 탭을 제외한 탭에 대해서 selection을 clear시킴
				listTotal.clearSelection();
				listBook.clearSelection();
				listSearch.clearSelection();
			}
			else if(pane.getSelectedIndex()==2) { //책인 경우
				String listname = listBook.getSelectedValue();  //select한 값을 받아옴
				index = ic.getIndex(listname);  //그 값의 인덱스를 받아옴
				//도서 탭을 제외한 탭에 대해서 selection을 clear시킴
				listTotal.clearSelection();
				listMovie.clearSelection();
				listSearch.clearSelection();
			}
			else if(pane.getSelectedIndex()==3) { //검색인 경우
				String listname = listSearch.getSelectedValue();  //select한 값을 받아옴
				index = ic.getIndex(listname); //그 값의 인덱스를 받아옴
				//검색 탭을 제외한 탭에 대해서 selection을 clear시킴
				listTotal.clearSelection();
				listMovie.clearSelection();
				listBook.clearSelection();
			}
			else {
				index=listTotal.getSelectedIndex(); //목록에서 선택된 index를 받아와서 index에 저장
				//전체 탭을 제외한 탭에 대해서 selection을 clear 
				listMovie.clearSelection();
				listBook.clearSelection();
				listSearch.clearSelection();
			}

			if(index!=-1&&ic.getType(index)!=null) {
				write.removeAll();
				write.repaint();
				JPanel detailleft= new JPanel();
				detailleft.setLayout(new GridLayout(0,1,0,30));
				JPanel detailright = new JPanel();
				detailright.setLayout(new GridLayout(0,1,0,30));
				if(ic.getType(index).equals("Movie")) { //선택한 것이 movie일 경우
					for(int i=0;i<strMovie.length;i++) {
						detailleft.add(new JLabel(strMovie[i]));
					}
				Movie mov = (Movie)ic.getItem(index);
				detailright.add(new JLabel(mov.getTitle()));
				detailright.add(new JLabel(mov.getWriter()));
				detailright.add(new JLabel(mov.getActor()));
				detailright.add(new JLabel(mov.getGenre()));				
				detailright.add(new JLabel(mov.getGrade()));
				detailright.add(new JLabel(mov.getYear()));
				detailright.add(new JLabel(mov.getStar()));
				plotTA.setText(mov.getPlot());
				reviewTA.setText(mov.getReview());
				}
				else if(ic.getType(index).equals("Book")&&ic.getType(index)!=null){ //선택한 것이 도서일 경우
					for(int i=0;i<strBook.length;i++) {
						detailleft.add(new JLabel(strBook[i]));
					}
					Book book = (Book)ic.getItem(index);
					detailright.add(new JLabel(book.getTitle()));
					detailright.add(new JLabel(book.getWriter()));
					detailright.add(new JLabel(book.getPublisher()));
					detailright.add(new JLabel(book.getYear()));
					detailright.add(new JLabel(book.getStar()));
					plotTA.setText(book.getPlot());
					reviewTA.setText(book.getReview());
			}

			write.add(detailleft, BorderLayout.WEST);
			write.add(detailright,BorderLayout.CENTER);
			write.revalidate();
			}
			if(ic.getType(index)==null) { //빈 곳을 선택했을 경우
				write.removeAll();
				write.repaint();
				plotTA.setText("");
				reviewTA.setText("");
			}
			repaint();
			
		}
	}
	class MySearchListener implements ActionListener{ //검색 버튼에 대한 리스너

		@Override
		public void actionPerformed(ActionEvent e) {
			if(searchTF.getText().length()==0) { //검색 문자열이 없을 경우
				JOptionPane.showMessageDialog(null, "입력되지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
				return;	
			}
			if(sort.getSelectedIndex()==0) { //콤보박스가 제목
				if(ic.getStrTitle(searchTF.getText())==null) {
					JOptionPane.showMessageDialog(null, "찾는 내용이 없습니다","경고",JOptionPane.WARNING_MESSAGE);
					return;	
				}
				else {
					listSearch.setListData(ic.getStrTitle(searchTF.getText()));
				}
				
			}
			else { //콤보박스가 별점
				if(ic.getStrStar(searchTF.getText())==null) {
					JOptionPane.showMessageDialog(null, "찾는 내용이 없습니다","경고",JOptionPane.WARNING_MESSAGE);
					return;	
				}
				else {
					listSearch.setListData(ic.getStrStar(searchTF.getText()));
				}
			}
			
		}
		
	}
	class MyButtonListener implements ActionListener{ //나머지 버튼에 대한 리스너
	
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == append) { //추가 버튼
				appendDialog.setVisible(true);
				appendDialog.setInitialize();
				listTotal.clearSelection();
				listMovie.clearSelection();
				listBook.clearSelection();
			}
			else if(obj==revise) { //수정 버튼
				reviseDialog = new MyReviseDialog(null,"수정",index);
				if(index==-1||index>=ic.getVSize()) {
					JOptionPane.showMessageDialog(null, "선택하지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
					return;
				}
				else {
					reviseDialog.setVisible(true);
				}
			}
			else if(obj==delete) { //삭제 버튼
				int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					if(index==-1||index>=ic.getVSize()) {
						JOptionPane.showMessageDialog(null, "선택하지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
						return;
					}
					ic.delete(index);//삭제하기
				}
			}	
			if(ic.getVSize()!=0) { //벡터에 들어있는게 없을 경우
				listTotal.setListData(ic.getTotal()); 
				listMovie.setListData(ic.getStrMovie());// 리스트 새로 만들기
				listBook.setListData(ic.getStrBook());
			}
			else {
				listTotal.setListData(strList); 
				listMovie.setListData(strList);// 리스트 새로 만들기
				listBook.setListData(strList);
			}
			searchTF.setText("");
			listSearch.setListData(strList);
		
		}
	}
	
	class MyMenuListener implements ActionListener{
		private JFileChooser chooser  = new JFileChooser(".//"); //파일 다이얼로그 생성
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int ret;
			String filePath;
			
			String cmd= e.getActionCommand(); //사용자가 선택한 메뉴 아이템의 문자열 리턴
			switch (cmd) { //메뉴 아이템의 종류 구분
			case "불러오기": //열기를 눌렀을때 
				ret=chooser.showOpenDialog(null); //파일 다이얼로그 출력
				if(ret != JFileChooser.APPROVE_OPTION) { //사용자가 강제로 창을 닫았거나 취소 버튼을 누른 경우 경고창 뜨게함
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
					return; 
				}
				//파일 선택하고 열기 버튼 누른 경우
				filePath = chooser.getSelectedFile().getPath(); //파일 경로명 리턴
				try {
					ic.open(filePath);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e2.getMessage(), "경고", JOptionPane.WARNING_MESSAGE);
				}
				if(ic.getVSize()!=0) {
					listTotal.setListData(ic.getTotal()); 
					listMovie.setListData(ic.getStrMovie());// 리스트 새로 만들기
					listBook.setListData(ic.getStrBook());
				}
				else {
					listTotal.setListData(strList); 
					listMovie.setListData(strList);// 리스트 새로 만들기
					listBook.setListData(strList);
				}
				break;
			case "저장하기":
				ret=chooser.showSaveDialog(null); //파일 다이얼로그 출력
				if(ret != JFileChooser.APPROVE_OPTION) {//사용자가 강제로 창을 닫았거나 취소 버튼을 누른 경우 경고창 뜨게 함
					JOptionPane.showMessageDialog(null, "파일이 저장되지 않았습니다","경고",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//파일 선택하고 저장 버튼 누른 경우
				//파일 저장하기만 하면 끝남
				filePath = chooser.getSelectedFile().getPath(); //파일 경로명 리턴
				try {
					ic.store(filePath);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "경고", JOptionPane.WARNING_MESSAGE);
				} 
				
				break;
			case "종료": //종료 눌렀을때
				System.exit(0); //시스템 종료
				break;
			case "시스템 정보": //버전 정보 눌렀을때
				JOptionPane.showMessageDialog(null,"MyNotes 시스템 v 1.0입니다","Message",JOptionPane.INFORMATION_MESSAGE); //메시지 다이얼로그 생성
				break;
			}
		}
		
	}
	class ImagePanel extends JPanel{
		private ImageIcon icon;
		Image img;
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			if(index==-1) { 
				g.drawLine(20,20,250,300);
				g.drawLine(250,20,20,300);
				g.drawString("이미지 없음", 100, 170);
			}
			else {
				if(ic.getpath(index)!=null) { //이미지 경로명이 있을경우에만 이미지 그림
					icon = new ImageIcon(ic.getpath(index));
					img = icon.getImage();
					g.drawImage(img,20,20,230,280,this);
				}
				else {
					g.drawLine(20,20,250,300);
					g.drawLine(250,20,20,300);
					g.drawString("이미지 없음", 100, 170);
				}
			}
			
		}
	}

	public static void main(String[] args) throws Exception{
		new ItemTest();

	}

}
