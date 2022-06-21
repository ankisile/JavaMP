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
	static Vector <Item> v = new Vector <Item>(); //���� ��ü ���� 
	int index;
	
	public void create(Item i) { //���Ϳ� ���
		v.add(i);
	}
		
	public void revise(int i, Item it) { //����
		v.set(i, it);
	}
	public void delete(int i) { //����
		v.remove(i);
	}
	public String [] getStrTitle(String str) { //������ ���(���� �˻��Ҷ�)
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
	public String [] getStrStar(String str) { //������ ���(���� �˻��Ҷ�)
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
	
	public Item getItem(int i) { //���Ϳ� ����ִ� ��ü ����
		return v.get(i);
	}
	
	public String getpath(int i) { //�̹��� ��� ����
		if(i>=v.size())
			return null;
		return v.get(i).getImg();
	}
	
	public int getIndex(String str) { //���ͳ������� �ε��� ����
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
	
	public String getType(int i) { //��ȭ���� �������� ����
		if(i>=v.size()||i==-1)
			return null;
		if(v.get(i) instanceof Movie) {
			return "Movie";
		}
		else {
			return "Book";
		}
	}
	
	public void store(String str) throws FileNotFoundException, IOException { //���� ����
		File f = new File(str);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(v); //��ü ����
		oos.close();
	}
	
	public void open(String str) throws Exception { //���� ����
		File f = new File(str);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		v = (Vector<Item>)ois.readObject(); 
		ois.close();
	}
	
	
	public String [] getTotal() { //��ü �� ����Ʈ
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
	
	public String [] getStrMovie() { //��ȭ �� ����Ʈ
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
	
	public String [] getStrBook() { //å �� ����Ʈ
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

	public int getVSize() { //���� ������
		return v.size();
	}

}
