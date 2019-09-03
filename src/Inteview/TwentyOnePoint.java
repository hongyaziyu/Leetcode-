package Inteview;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TwentyOnePoint {
	private int[] pai=new int[52];
	private String[] huase={"黑","红","梅","方"};
	private String[] paiM={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private ArrayList<Integer> al=new ArrayList<Integer>();
	private int currentPoint;
	private int computerPoint = 0;
	private int currentPage=0;


	public TwentyOnePoint() {
	super();
	xipai();// 洗牌
	fapai();//发牌
	needPai();//是否要牌
	computerPai();//电脑发牌
	result(); //计算结果
	}
	private void xipai() { 
	for(int i = 0; i < 52 ;i++ ){
	pai[i]=i; //52张牌赋值
	}
	for(int j = 0;j<26;j++){ //打乱26次
	Random r = new Random();
	int i1 = Math.abs(r.nextInt()%52); //在52张中牌中找到第一张
	int i2 =Math.abs(r.nextInt()%52);//在52张中牌中找到第二张

	int temp = pai[i2];
	pai[i2] = pai[i1];
	pai[i1] = temp;
	}
	}




	private void fapai() {
	/* for(int i = 0;i<52;i++){
	System.out.print(pai[i]+"\t");
	}*/

	//先发两张给玩家
	al.add(pai[0]);
	al.add(pai[1]);
	currentPoint += calPoint(pai[0]);
	currentPoint+= calPoint(pai[1]); 
	currentPage= 2;
	}
	private int calPoint(int i) {//计算牌的点数
	int temp = 0;
	if(i%13+1>10){ //JQK都是10
	temp = 10;
	}
	else{
	temp = (i+1)%13;
	}
	return temp;
	}




	private void needPai() {

	while(true){
	xianshi(); //显示牌面

	if(currentPoint>=21){ //玩家点数大于21则不能再要牌
	break;
	}
	System.out.println("是否还要牌,输入N不要！");
	Scanner sc = new Scanner(System.in);
	if(sc.next().equalsIgnoreCase("N")){
	break; //输入N则结束
	}else {
	al.add(pai[currentPage]); //继续添加牌
	currentPoint+=calPoint(pai[currentPage]); //牌点数+
	currentPage++;
	}

	}

	}
	private void xianshi() {
	for(Integer in:al){ //显示玩家手中的牌
	System.out.print(huase[in/13]+" "+paiM[in%13]+"\t"); //显示花色 和牌面
	}
	System.out.println("当前总分："+currentPoint);

	}
	private void computerPai() {
	Random r = new Random();
	computerPoint = Math.abs(r.nextInt())%10+16; //电脑的点数在16点到26点
	System.out.println("\n电脑 的牌面:"+computerPoint);
	}

	private void result() {
	if(currentPoint>21){ //玩家点数大于21则不能再要牌
	System.out.println("you lost！");
	}else if(currentPoint==computerPoint){
	System.out.println("you lost！");
	}else if(computerPoint>21){
	System.out.println("you Win！");

	}else if(currentPoint>computerPoint){
	System.out.println("you Win！");
	}else{
	System.out.println("you Lost！");
	}

	}
	public static void main(String[] args){
	new TwentyOnePoint();
	}
}
