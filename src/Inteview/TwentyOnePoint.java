package Inteview;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TwentyOnePoint {
	private int[] pai=new int[52];
	private String[] huase={"��","��","÷","��"};
	private String[] paiM={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private ArrayList<Integer> al=new ArrayList<Integer>();
	private int currentPoint;
	private int computerPoint = 0;
	private int currentPage=0;


	public TwentyOnePoint() {
	super();
	xipai();// ϴ��
	fapai();//����
	needPai();//�Ƿ�Ҫ��
	computerPai();//���Է���
	result(); //������
	}
	private void xipai() { 
	for(int i = 0; i < 52 ;i++ ){
	pai[i]=i; //52���Ƹ�ֵ
	}
	for(int j = 0;j<26;j++){ //����26��
	Random r = new Random();
	int i1 = Math.abs(r.nextInt()%52); //��52���������ҵ���һ��
	int i2 =Math.abs(r.nextInt()%52);//��52���������ҵ��ڶ���

	int temp = pai[i2];
	pai[i2] = pai[i1];
	pai[i1] = temp;
	}
	}




	private void fapai() {
	/* for(int i = 0;i<52;i++){
	System.out.print(pai[i]+"\t");
	}*/

	//�ȷ����Ÿ����
	al.add(pai[0]);
	al.add(pai[1]);
	currentPoint += calPoint(pai[0]);
	currentPoint+= calPoint(pai[1]); 
	currentPage= 2;
	}
	private int calPoint(int i) {//�����Ƶĵ���
	int temp = 0;
	if(i%13+1>10){ //JQK����10
	temp = 10;
	}
	else{
	temp = (i+1)%13;
	}
	return temp;
	}




	private void needPai() {

	while(true){
	xianshi(); //��ʾ����

	if(currentPoint>=21){ //��ҵ�������21������Ҫ��
	break;
	}
	System.out.println("�Ƿ�Ҫ��,����N��Ҫ��");
	Scanner sc = new Scanner(System.in);
	if(sc.next().equalsIgnoreCase("N")){
	break; //����N�����
	}else {
	al.add(pai[currentPage]); //���������
	currentPoint+=calPoint(pai[currentPage]); //�Ƶ���+
	currentPage++;
	}

	}

	}
	private void xianshi() {
	for(Integer in:al){ //��ʾ������е���
	System.out.print(huase[in/13]+" "+paiM[in%13]+"\t"); //��ʾ��ɫ ������
	}
	System.out.println("��ǰ�ܷ֣�"+currentPoint);

	}
	private void computerPai() {
	Random r = new Random();
	computerPoint = Math.abs(r.nextInt())%10+16; //���Եĵ�����16�㵽26��
	System.out.println("\n���� ������:"+computerPoint);
	}

	private void result() {
	if(currentPoint>21){ //��ҵ�������21������Ҫ��
	System.out.println("you lost��");
	}else if(currentPoint==computerPoint){
	System.out.println("you lost��");
	}else if(computerPoint>21){
	System.out.println("you Win��");

	}else if(currentPoint>computerPoint){
	System.out.println("you Win��");
	}else{
	System.out.println("you Lost��");
	}

	}
	public static void main(String[] args){
	new TwentyOnePoint();
	}
}
