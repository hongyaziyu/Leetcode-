package JD;
import java.util.*;
import java.util.Map.Entry;
/**
 * @author 黄子玉 考场安排
 * 题目描述：考场有n组男女，有m组男女有关系。将考场移除最少的人使得考场上的人相互之间没有关系。且移出的人字典序最小。
 * 输入：第一行两个数n和m。其中1到n为男生，n+1到2n为女生。
 * 其余m行为关系，左边数为男生编号，右边数为女生编号。
 * 输出：最小移出的人数，和移出的顺序，这个顺序的字典序最小。
 * 举例：
 * 2 2
 * 1 3
 * 1 4
 * 输出：
 * 1 1
 * 解题思路：优先踢出人缘好的，人缘数一样优先踢出男生。
 */
public class ArrangementOfExamnation {
	public static class MyMap{
		//用红黑树图来实现图。红黑树是有序的，按照key来排序。
		public TreeMap<Integer,HashSet<Integer>> map;
		public MyMap(){
			this.map=new TreeMap<>();
		}
		//定义put操作。如果没有maleNum则创建一个maleNum再创建一个HashSet存femaleNum，有的话直接在Set中加入femaleNum
		void put(int maleNum,int femaleNum){
			if(map.containsKey(maleNum)){
				map.get(maleNum).add(femaleNum);
			}else{
				HashSet<Integer> temp=new HashSet<>();
				temp.add(femaleNum);
				map.put(maleNum, temp);
			}
		}
		//获得最大连接数，也就是人缘最好的人，将map存入entries再遍历entries获得set集合最大的也就是跟female关系最多的male。
		int getMaxLinkCount(){
			int maxSize=0;
			Set<Entry<Integer, HashSet<Integer>>> entries=map.entrySet();//Map是java中的接口，Map.Entry是
			//Map的一个内部接口。Map提供了常用的方法keySet()和entrySet()等方法。
			//keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry
			for(Entry<Integer, HashSet<Integer>> iter:entries){
				maxSize=Math.max(iter.getValue().size(), maxSize);
			}
			return maxSize;
		}
		//根据最好人缘的人员数找到拥有最好人缘的那个maleNum
		int getMaxLinkKey(int maxSize){
			Set<Entry<Integer, HashSet<Integer>>> entries=map.entrySet();
			for(Entry<Integer, HashSet<Integer>> iter:entries){
				if(iter.getValue().size()==maxSize){
					return iter.getKey();
				}
			}
			return -1;
		}
		//定义方法，根据key值移除整个元素，并返回value的Set集合。
		Set<Integer> removeKey(int key){
			Set<Integer> res=null;
			if(map.containsKey(key)){
				res=map.remove(key);
			}
			return res;
		}
		//根据key和value删除value
		void removeValue(int key,int value){
			map.get(key).remove(value);
			if(map.get(key).size()==0){
				map.remove(key);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		MyMap maleMap=new MyMap();//建造maleMap，key放maleNum，value放与maleNum有关的所有femaleNum集合。
		MyMap femaleMap=new MyMap();//建造femaleMap，key放femaleNum，value放与femaleNum有关的所有maleNum集合。
		for(int i=0;i<m;i++){
			int temp1=sc.nextInt();
			int temp2=sc.nextInt();
			maleMap.put(temp1, temp2);
			femaleMap.put(temp2, temp1);
		}
		int count=0;//最少需要移出的人数。开始设为0.
		ArrayList<Integer> res=new ArrayList<>();//接收移除key的value集合。根据这个集合删除另外一个Map的key值。
		while(maleMap.map.size()>0){
			count++;
			int max1=maleMap.getMaxLinkCount();
			int max2=femaleMap.getMaxLinkCount();
			int max=Math.max(max1, max2);
			MyMap toRemove=max1<max2?femaleMap:maleMap;//male和female里面哪个人缘最好先删除哪一个。
			int key=toRemove.getMaxLinkKey(max);//获得人缘最好的那个人的编号。
			Set<Integer> set=toRemove.removeKey(key);//删除人缘最好的那个人，然后返回集合。
			MyMap another=max1<max2?maleMap:femaleMap;
			for(int iter:set){//删除另外集合中的关系。
				another.removeValue(iter, key);
			}
			res.add(key);//存储删除的人。
		}
		System.out.println(count);
		Collections.sort(res);//对res排序使得字典序最小。
		for(int iter:res){
			System.out.println(iter);
		}
	}
}
