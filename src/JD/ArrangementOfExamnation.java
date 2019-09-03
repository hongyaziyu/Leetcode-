package JD;
import java.util.*;
import java.util.Map.Entry;
/**
 * @author ������ ��������
 * ��Ŀ������������n����Ů����m����Ů�й�ϵ���������Ƴ����ٵ���ʹ�ÿ����ϵ����໥֮��û�й�ϵ�����Ƴ������ֵ�����С��
 * ���룺��һ��������n��m������1��nΪ������n+1��2nΪŮ����
 * ����m��Ϊ��ϵ�������Ϊ������ţ��ұ���ΪŮ����š�
 * �������С�Ƴ������������Ƴ���˳�����˳����ֵ�����С��
 * ������
 * 2 2
 * 1 3
 * 1 4
 * �����
 * 1 1
 * ����˼·�������߳���Ե�õģ���Ե��һ�������߳�������
 */
public class ArrangementOfExamnation {
	public static class MyMap{
		//�ú����ͼ��ʵ��ͼ�������������ģ�����key������
		public TreeMap<Integer,HashSet<Integer>> map;
		public MyMap(){
			this.map=new TreeMap<>();
		}
		//����put���������û��maleNum�򴴽�һ��maleNum�ٴ���һ��HashSet��femaleNum���еĻ�ֱ����Set�м���femaleNum
		void put(int maleNum,int femaleNum){
			if(map.containsKey(maleNum)){
				map.get(maleNum).add(femaleNum);
			}else{
				HashSet<Integer> temp=new HashSet<>();
				temp.add(femaleNum);
				map.put(maleNum, temp);
			}
		}
		//��������������Ҳ������Ե��õ��ˣ���map����entries�ٱ���entries���set��������Ҳ���Ǹ�female��ϵ����male��
		int getMaxLinkCount(){
			int maxSize=0;
			Set<Entry<Integer, HashSet<Integer>>> entries=map.entrySet();//Map��java�еĽӿڣ�Map.Entry��
			//Map��һ���ڲ��ӿڡ�Map�ṩ�˳��õķ���keySet()��entrySet()�ȷ�����
			//keySet()��������ֵ��Map��keyֵ�ļ��ϣ�entrySet()�ķ���ֵҲ�Ƿ���һ��Set���ϣ��˼��ϵ�����ΪMap.Entry
			for(Entry<Integer, HashSet<Integer>> iter:entries){
				maxSize=Math.max(iter.getValue().size(), maxSize);
			}
			return maxSize;
		}
		//���������Ե����Ա���ҵ�ӵ�������Ե���Ǹ�maleNum
		int getMaxLinkKey(int maxSize){
			Set<Entry<Integer, HashSet<Integer>>> entries=map.entrySet();
			for(Entry<Integer, HashSet<Integer>> iter:entries){
				if(iter.getValue().size()==maxSize){
					return iter.getKey();
				}
			}
			return -1;
		}
		//���巽��������keyֵ�Ƴ�����Ԫ�أ�������value��Set���ϡ�
		Set<Integer> removeKey(int key){
			Set<Integer> res=null;
			if(map.containsKey(key)){
				res=map.remove(key);
			}
			return res;
		}
		//����key��valueɾ��value
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
		MyMap maleMap=new MyMap();//����maleMap��key��maleNum��value����maleNum�йص�����femaleNum���ϡ�
		MyMap femaleMap=new MyMap();//����femaleMap��key��femaleNum��value����femaleNum�йص�����maleNum���ϡ�
		for(int i=0;i<m;i++){
			int temp1=sc.nextInt();
			int temp2=sc.nextInt();
			maleMap.put(temp1, temp2);
			femaleMap.put(temp2, temp1);
		}
		int count=0;//������Ҫ�Ƴ�����������ʼ��Ϊ0.
		ArrayList<Integer> res=new ArrayList<>();//�����Ƴ�key��value���ϡ������������ɾ������һ��Map��keyֵ��
		while(maleMap.map.size()>0){
			count++;
			int max1=maleMap.getMaxLinkCount();
			int max2=femaleMap.getMaxLinkCount();
			int max=Math.max(max1, max2);
			MyMap toRemove=max1<max2?femaleMap:maleMap;//male��female�����ĸ���Ե�����ɾ����һ����
			int key=toRemove.getMaxLinkKey(max);//�����Ե��õ��Ǹ��˵ı�š�
			Set<Integer> set=toRemove.removeKey(key);//ɾ����Ե��õ��Ǹ��ˣ�Ȼ�󷵻ؼ��ϡ�
			MyMap another=max1<max2?maleMap:femaleMap;
			for(int iter:set){//ɾ�����⼯���еĹ�ϵ��
				another.removeValue(iter, key);
			}
			res.add(key);//�洢ɾ�����ˡ�
		}
		System.out.println(count);
		Collections.sort(res);//��res����ʹ���ֵ�����С��
		for(int iter:res){
			System.out.println(iter);
		}
	}
}
