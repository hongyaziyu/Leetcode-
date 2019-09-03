package BasicAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortAlgorithm {
	//���������㷨��ð������
	public int[] bubbleSort(int[] arr){
		int len=arr.length;
		for(int i=0;i<len-1;i++){
			for(int j=0;j<len-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	//ѡ������˼·��������δ����Ԫ�������ҳ���С��Ԫ��������ǰ�棬Ȼ����ʣ��δ�����������ҳ���С��Ԫ����������������ĩβ
	//���Դ����ơ�
	public int[] selectSort(int[] arr){
		int len=arr.length;
		int minIndex,temp;
		for(int i=0;i<len-1;i++){
			minIndex=i;
			for(int j=i+1;j<len;j++){
				if(arr[j]<arr[minIndex]){
					minIndex=j;
				}
			}
			temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
		return arr;
	}
	//�������򡣹���ԭ��ͨ�������������У���δ��������ݣ���������������дӺ���ǰɨ�貢���롣
	public int[] insertSort(int[] arr){
		int len=arr.length;
		int insertIndex;//Ҫ���������
		for(int i=1;i<len;i++){//������ڶ���Ԫ�ؿ�ʼѭ����������롣
			insertIndex=arr[i];//���������һ��ѭ��Ҫ�����Ԫ���������еڶ���Ԫ�ء�
			int j=i-1;
			while(j>=0&&insertIndex<arr[j]){
				arr[j+1]=arr[j];//���Ҫ�����Ԫ��С�ڵ�j��Ԫ������ƶ���
				j--;
			}
			arr[j+1]=insertIndex;//ֱ��Ҫ�����Ԫ�ز�С�ڵ�j��Ԫ�ؾͽ�insertIndex�������С�
		}
		return arr;
	}
	//ϣ�����򡣵�һ���㷨���Ӷ�ͻ��O(n^2)���㷨���Ǽ򵥲�������ĸĽ��档���ȱȽϾ���Զ��Ԫ�ء�ϣ�������ֽ���С��������
	public int[] shellSort(int[] arr){
		int temp;
		int len=arr.length;
		int gap=len;
		while(true){
			gap=gap/2;
			for(int i=0;i<gap;i++){
				for(int j=i+gap;j<len;j=j+gap){
					temp=arr[j];
					int k;
					for(k=j-gap;k>=0;k=k-gap){
						if(arr[k]>temp){
							arr[k+gap]=arr[k];
						}else{
							break;
						}
					}
					arr[k+gap]=temp;
				}
			}
			if(gap==1){
				break;
			}
		}
		return arr;
	}
	//�鲢���򡣷����㷨��Ӧ�ã���������������кϲ��õ���
	public int[] mergeSort(int[] a,int left,int right) {
		  if(left<right) {
		   int middle=(left+right)/2;
		   mergeSort(a,left,middle);
		   mergeSort(a,middle+1,right);
		   merge(a,left,middle,right);
		  }
		  return a;
		 }
	 private void merge(int[] a, int left, int middle, int right) {
		  int[] tempArray=new int[a.length];
		  int rightStart=middle+1;
		  int temp=left;
		  int third=left;
		  while(left<=middle&&rightStart<=right) {
			   if(a[left]<=a[rightStart])
			    tempArray[third++]=a[left++];
			   else tempArray[third++]=a[rightStart++];
		  }
		  //�����ʣ�µĿ���������
		  while(left<=middle) {
		   tempArray[third++]=a[left++];
		  }
		  //����ұ߻������ݣ��ұߵĿ���������
		  while(rightStart<=right){
		   tempArray[third++]=a[rightStart++];
		  }
		  //��Ҫ��һ���£�֮ǰ�Ƕ�temp���鸳ֵ������Ҫ��a��ֵ
		  //while(temp<=right) {
		  // a[temp]=tempArray[temp];
		  // temp++;
		  //}
		   //���ƻ�ԭ����,left�Ѿ����ı��ˣ�����temp=left(ԭʼ)
		for(int i = temp; i <=right; i++) {
		  a[i]=tempArray[i];
		}
	           
	  
	 }
	//�������򡣻���˼����ͨ��һ�����򽫴��������Ϊ���������Ĳ��֡�����һ���ֱȹؼ���С����һ���ֱȹؼ��ִ󡣷ֱ������
	//���ֽ��������Դﵽ��������
	public int[] quickSort(int[] arr){
		sort(arr,0,arr.length-1);
		return arr;
	}
	private void sort(int[] arr, int low, int high) {
		int i,j,index;
		if(low>high){
			return;
		}
		i=low;
		j=high;
		index=arr[i];
		while(i<j){
			while(i<j&&arr[j]>=index){
				j--;
			}
			if(i<j){
				arr[i++]=arr[j];
			}
			while(i<j&&arr[i]<index){
				i++;
			}
			if(i<j){
				arr[j--]=arr[i];
			}
		}
		arr[i]=index;
		sort(arr,low,i-1);
		sort(arr,i+1,high);
	}
	//������
	public int[] heapSort(int[] arr) { 
		// ������������й�����һ���󶥶�
		for (int i = arr.length / 2; i >= 0; i--){ 
			heapAdjust(arr, i, arr.length); 
		}
		
		// �𲽽�ÿ�����ֵ�ĸ��ڵ���ĩβԪ�ؽ����������ٵ�����������ʹ���Ϊ�󶥶�
		for (int i = arr.length - 1; i > 0; i--) { 
			swap(arr, 0, i); // ���Ѷ���¼�͵�ǰδ�����������е����һ����¼����
			heapAdjust(arr, 0, i); // ����֮����Ҫ���¼����Ƿ���ϴ󶥶ѣ���������Ҫ����
		}
		return arr;
	}
 
	/**
	 * �����ѵĹ���
	 * @param arr ��Ҫ���������
	 * @param i ��Ҫ�����ѵĸ��ڵ�����
	 * @param n ����ĳ���
	 */
	private static void heapAdjust(int[] arr, int i, int n) {
		int child;
		int father; 
		for (father = arr[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			
			// ���������С��������������Ҫ�Ƚ��������͸��ڵ�
			if (child != n - 1 && arr[child] < arr[child + 1]) {
				child++; // �����1��ָ��������
			}
			
			// ������ڵ�С�ں��ӽ�㣬����Ҫ����
			if (father < arr[child]) {
				arr[i] = arr[child];
			} else {
				break; // �󶥶ѽṹδ���ƻ�������Ҫ����
			}
		}
		arr[i] = father;
	}
 
	// ��ȡ�����ӽ��
	private static int leftChild(int i) {
		return 2 * i + 1;
	}
	
	// ����Ԫ��λ��
	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
	//��������
	public int[] countSort(int[] arr){
	    if (arr == null || arr.length == 0) {
	        return null;
	    }
	    
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    
	    //�ҳ������е������Сֵ
	    for(int i = 0; i < arr.length; i++){
	        max = Math.max(max, arr[i]);
	        min = Math.min(min, arr[i]);
	    }
	    
	    int help[] = new int[max];
	    
	    //�ҳ�ÿ�����ֳ��ֵĴ���
	    for(int i = 0; i < arr.length; i++){
	        int mapPos = arr[i] - min;
	        help[mapPos]++;
	    }
	    
	    int index = 0;
	    for(int i = 0; i < help.length; i++){
	        while(help[i]-- > 0){
	            arr[index++] = i+min;
	        }
	    }
	    
	    return arr;
	}
	//Ͱ����
	public  ArrayList<ArrayList<Integer>> bucketSort(int[] arr){
	    
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    for(int i = 0; i < arr.length; i++){
	        max = Math.max(max, arr[i]);
	        min = Math.min(min, arr[i]);
	    }
	    
	    //Ͱ��
	    int bucketNum = (max - min) / arr.length + 1;
	    ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
	    for(int i = 0; i < bucketNum; i++){
	        bucketArr.add(new ArrayList<Integer>());
	    }
	    
	    //��ÿ��Ԫ�ط���Ͱ
	    for(int i = 0; i < arr.length; i++){
	        int num = (arr[i] - min) / (arr.length);
	        bucketArr.get(num).add(arr[i]);
	    }
	    
	    //��ÿ��Ͱ��������
	    for(int i = 0; i < bucketArr.size(); i++){
	        Collections.sort(bucketArr.get(i));
	    }
	    
	    return bucketArr;
	    
	}
	//��������
	public int[] radixSort(int[] array,int d)//d����λ���������ֵ�λ����
	{
	    int n=1;//����λ����Ӧ������1,10,100...
	    int k=0;//����ÿһλ�����Ľ��������һλ����������
	    int length=array.length;
	    int[][] bucket=new int[10][length];//����Ͱ���ڱ���ÿ�������Ľ������һλ����������ͬ�����ַ���ͬһ��Ͱ��
	    int[] order=new int[length];//���ڱ���ÿ��Ͱ���ж��ٸ�����
	    while(n<d)
	    {
	        for(int num:array) //������array���ÿ�����ַ�����Ӧ��Ͱ��
	        {
	            int digit=(num/n)%10;
	            bucket[digit][order[digit]]=num;
	            order[digit]++;
	        }
	        for(int i=0;i<length;i++)//��ǰһ��ѭ�����ɵ�Ͱ������ݸ��ǵ�ԭ���������ڱ�����һλ��������
	        {
	            if(order[i]!=0)//���Ͱ�������ݣ����ϵ��±������Ͱ�������ݱ��浽ԭ������
	            {
	                for(int j=0;j<order[i];j++)
	                {
	                    array[k]=bucket[i][j];
	                    k++;
	                }
	            }
	            order[i]=0;//��Ͱ���������0��������һ��λ����
	        }
	        n*=10;
	        k=0;//��k��0��������һ�ֱ���λ������
	    }
	    return array;
	}
	//���Ժ���
	public static void main(String[] args) {
		int[] arr1={50,10,90,30,70,40,80,60,20};
		int[] arr2={50,10,90,30,70,40,80,60,20};
		int[] arr3={50,10,90,30,70,40,80,60,20};
		int[] arr4={50,10,90,30,70,40,80,60,20};
		int[] arr5={50,10,90,30,70,40,80,60,20};
		int[] arr6={50,10,90,30,70,40,80,60,20};
		int[] arr7={50,10,90,30,70,40,80,60,20};
		int[] arr8={50,10,90,30,70,40,80,60,20};
		int[] arr9={50,10,90,30,70,40,80,60,20};
		int[] arr10={50,10,90,30,70,40,80,60,20};
		SortAlgorithm sort=new SortAlgorithm();
		System.out.println(Arrays.toString(sort.bubbleSort(arr1)));
		System.out.println(Arrays.toString(sort.selectSort(arr2)));
		System.out.println(Arrays.toString(sort.insertSort(arr3)));
		System.out.println(Arrays.toString(sort.shellSort(arr4)));
		System.out.println(Arrays.toString(sort.mergeSort(arr5, 0, arr5.length-1)));
		System.out.println(Arrays.toString(sort.quickSort(arr6)));
		System.out.println(Arrays.toString(sort.heapSort(arr7)));
		System.out.println(Arrays.toString(sort.countSort(arr8)));
		System.out.println(sort.bucketSort(arr9).toString());
		System.out.println(Arrays.toString(sort.radixSort(arr10, 10)));
	}
}
