
public class twoDArray {

	public static void main(String[] args) {
		int arr[][] = new int[4][4]; //4*4 �迭 ����
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				arr[i][j]=0; // �迭�� ��� ���ҵ� 0���� �ʱ�ȭ
		}
		
		for(int i=0;i<10;) { //�ݺ��� ���鼭 10���� ������ ���� ����
			int n = (int)(Math.random()*10 + 1);
			int row = (int)(Math.random()*4); //�迭�� �� �ε��� �����ϰ� ����
			int col = (int)(Math.random()*4); //�迭�� �� �ε��� �����ϰ� ����
			
			if(arr[row][col]!=0) continue; //�迭 ���Ұ� 0�� �ƴϸ� �̹� ����� ���̹Ƿ� �ǳʶ�
			else arr[row][col]=n; //�׷��� �ʴٸ� ��������(1~10) ����
			i++;//������ ���� ���� ����
		}
		for(int i=0;i<4;i++){//2���� �迭 ���
			for(int j=0;j<4;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}

	}

}
