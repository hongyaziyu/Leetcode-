package LinkedListImplement;

public class MyLinkedListTest {
	private static String x;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyLinkedList<String> list=new MyLinkedList();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		for(int i=0;i<list.size();i++){
			System.out.println("�����"+i+":"+list.GetE(i));
		
		}
		System.out.println();
		System.out.println("����ɾ��");
		x=list.Delete(0);
			System.out.println("ɾ����"+x);
			for(int i=0;i<=list.size();i++){
				System.out.println("�����"+i+":"+list.GetE(i));
			
			}
			System.out.println("�����޸�");
			list.Renew("Yimi", 2);
			for(int i=1;i<=list.size();i++){
				System.out.println("�����"+i+":"+list.GetE(i));
			
			}
			System.out.println();
			System.out.println("���Բ���");
			x=list.GetE(3);
			System.out.println("x="+x);
			
	}
}
