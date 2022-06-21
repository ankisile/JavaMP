import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Vector;

public class ItemCollections {
	static Vector <Item> v = new Vector <Item>(); //백터 객체 생성 
	int index;
	
	public void create(Item i) { //벡터에 등록
		v.add(i);
	}
		
	public void revise(int i, Item it) { //수정
		v.set(i, it);
	}
	public void delete(int i) { //삭제
		v.remove(i);
	}
	public String [] getStrTitle(String str) { //제목을 출력(제목 검색할때)
		String arr [] = new String [v.size()];
		Iterator<Item> it =v.iterator();
		int i=0;
		Item item;
		while(it.hasNext()) {
			item = it.next();
			if(item.getTitle().contains(str)) {
				arr[i++]=item.getTitle();	
			}
		}
		if(arr.length==0||i==0) arr=null;
		return arr;
	}
	public String [] getStrStar(String str) { //별점을 출력(별점 검색할때)
		String arr [] = new String [v.size()];
		Iterator<Item> it =v.iterator();
		int i=0;
		Item item;
		while(it.hasNext()) {
			item = it.next();
			
			try {
			if(Integer.parseInt(item.getStar())>=Integer.parseInt(str)) {
				arr[i++]=item.getTitle();	
			}
			}
			catch(NumberFormatException e) {
				return null;
			}
		}
		if(arr.length==0||i==0) arr=null;
		return arr;
	}
	
	public Item getItem(int i) { //백터에 들어있는 객체 리턴
		return v.get(i);
	}
	
	public String getpath(int i) { //이미지 경로 리턴
		if(i>=v.size())
			return null;
		return v.get(i).getImg();
	}
	
	public int getIndex(String str) { //백터내에서의 인덱스 리턴
		int i=0;
		Iterator <Item> it =v.iterator();
		while(it.hasNext()) {
			Item n = it.next();	
			if(n.getTitle().equals(str)) 
				break;
			i++;
		}
		return i;
	}
	
	public String getType(int i) { //영화인지 도서인지 리턴
		if(i>=v.size()||i==-1)
			return null;
		if(v.get(i) instanceof Movie) {
			return "Movie";
		}
		else {
			return "Book";
		}
	}
	
	public void store(String str) throws FileNotFoundException, IOException { //파일 저장
		File f = new File(str);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(v); //객체 저장
		oos.close();
	}
	
	public void open(String str) throws Exception { //파일 열기
		File f = new File(str);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		v = (Vector<Item>)ois.readObject(); 
		ois.close();
	}
	
	
	public String [] getTotal() { //전체 탭 리스트
		String arr [] = new String [v.size()];
		Iterator <Item> it =v.iterator();
		int i=0;
		while(it.hasNext()) {
			Item n = it.next();
			arr[i++]=n.getTitle();			
		}
		if(arr.length==0) arr[0]=" ";
		return arr;
	}
	
	public String [] getStrMovie() { //영화 탭 리스트
		String arr [] = new String [v.size()];
		Iterator<Item> it =v.iterator();
		int i=0;
		while(it.hasNext()) {
			Item item = it.next();
			if(item instanceof Movie) {
			Movie n = (Movie)item;
			arr[i++]=n.getTitle();	
			}
		}
		if(arr.length==0) arr[0]=" ";
		return arr;
	}
	
	public String [] getStrBook() { //책 탭 리스트
		String arr [] = new String [v.size()];
		Iterator<Item> it =v.iterator();
		int i=0;
		while(it.hasNext()) {
			Item item = it.next();
			if(item instanceof Book) {
			Book n = (Book)item;
			arr[i++]=n.getTitle();	
			}
		}
		if(arr.length==0) arr[0]=" ";
		return arr;
	}

	public int getVSize() { //백터 사이즈
		return v.size();
	}

}
