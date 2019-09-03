package BasicAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortAlgorithm {
	//最经典的排序算法：冒泡排序
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
	//选择排序。思路：首先在未排序元素里面找出最小的元素排在最前面，然后在剩余未排序数组中找出最小的元素排在已排序数组末尾
	//。以此类推。
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
	//插入排序。工作原理：通过构建有序数列，对未排序的数据，在已排序的数列中从后向前扫描并插入。
	public int[] insertSort(int[] arr){
		int len=arr.length;
		int insertIndex;//要插入的数据
		for(int i=1;i<len;i++){//从数组第二个元素开始循环将数组插入。
			insertIndex=arr[i];//设置数组第一次循环要插入的元素是数组中第二个元素。
			int j=i-1;
			while(j>=0&&insertIndex<arr[j]){
				arr[j+1]=arr[j];//如果要插入的元素小于第j个元素向后移动。
				j--;
			}
			arr[j+1]=insertIndex;//直到要插入的元素不小于第j个元素就将insertIndex插入其中。
		}
		return arr;
	}
	//希尔排序。第一个算法复杂度突破O(n^2)的算法。是简单插入排序的改进版。优先比较距离远的元素。希尔排序又叫缩小增量排序。
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
	//归并排序。分治算法的应用，将已有序的子序列合并得到。
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
		  //把左边剩下的拷贝到数组
		  while(left<=middle) {
		   tempArray[third++]=a[left++];
		  }
		  //如果右边还有数据，右边的拷贝到数组
		  while(rightStart<=right){
		   tempArray[third++]=a[rightStart++];
		  }
		  //还要干一件事，之前是对temp数组赋值，我们要对a赋值
		  //while(temp<=right) {
		  // a[temp]=tempArray[temp];
		  // temp++;
		  //}
		   //复制回原素组,left已经被改变了，这里temp=left(原始)
		for(int i = temp; i <=right; i++) {
		  a[i]=tempArray[i];
		}
	           
	  
	 }
	//快速排序。基本思想是通过一趟排序将待排数组分为两个独立的部分。其中一部分比关键字小，另一部分比关键字大。分别对两个
	//部分进行排序以达到整体有序。
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
	//堆排序
	public int[] heapSort(int[] arr) { 
		// 将待排序的序列构建成一个大顶堆
		for (int i = arr.length / 2; i >= 0; i--){ 
			heapAdjust(arr, i, arr.length); 
		}
		
		// 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
		for (int i = arr.length - 1; i > 0; i--) { 
			swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
			heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
		}
		return arr;
	}
 
	/**
	 * 构建堆的过程
	 * @param arr 需要排序的数组
	 * @param i 需要构建堆的根节点的序号
	 * @param n 数组的长度
	 */
	private static void heapAdjust(int[] arr, int i, int n) {
		int child;
		int father; 
		for (father = arr[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			
			// 如果左子树小于右子树，则需要比较右子树和父节点
			if (child != n - 1 && arr[child] < arr[child + 1]) {
				child++; // 序号增1，指向右子树
			}
			
			// 如果父节点小于孩子结点，则需要交换
			if (father < arr[child]) {
				arr[i] = arr[child];
			} else {
				break; // 大顶堆结构未被破坏，不需要调整
			}
		}
		arr[i] = father;
	}
 
	// 获取到左孩子结点
	private static int leftChild(int i) {
		return 2 * i + 1;
	}
	
	// 交换元素位置
	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
	//计数排序
	public int[] countSort(int[] arr){
	    if (arr == null || arr.length == 0) {
	        return null;
	    }
	    
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    
	    //找出数组中的最大最小值
	    for(int i = 0; i < arr.length; i++){
	        max = Math.max(max, arr[i]);
	        min = Math.min(min, arr[i]);
	    }
	    
	    int help[] = new int[max];
	    
	    //找出每个数字出现的次数
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
	//桶排序
	public  ArrayList<ArrayList<Integer>> bucketSort(int[] arr){
	    
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    for(int i = 0; i < arr.length; i++){
	        max = Math.max(max, arr[i]);
	        min = Math.min(min, arr[i]);
	    }
	    
	    //桶数
	    int bucketNum = (max - min) / arr.length + 1;
	    ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
	    for(int i = 0; i < bucketNum; i++){
	        bucketArr.add(new ArrayList<Integer>());
	    }
	    
	    //将每个元素放入桶
	    for(int i = 0; i < arr.length; i++){
	        int num = (arr[i] - min) / (arr.length);
	        bucketArr.get(num).add(arr[i]);
	    }
	    
	    //对每个桶进行排序
	    for(int i = 0; i < bucketArr.size(); i++){
	        Collections.sort(bucketArr.get(i));
	    }
	    
	    return bucketArr;
	    
	}
	//基数排序
	public int[] radixSort(int[] array,int d)//d代表位数，即数字的位数。
	{
	    int n=1;//代表位数对应的数：1,10,100...
	    int k=0;//保存每一位排序后的结果用于下一位的排序输入
	    int length=array.length;
	    int[][] bucket=new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
	    int[] order=new int[length];//用于保存每个桶里有多少个数字
	    while(n<d)
	    {
	        for(int num:array) //将数组array里的每个数字放在相应的桶里
	        {
	            int digit=(num/n)%10;
	            bucket[digit][order[digit]]=num;
	            order[digit]++;
	        }
	        for(int i=0;i<length;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
	        {
	            if(order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
	            {
	                for(int j=0;j<order[i];j++)
	                {
	                    array[k]=bucket[i][j];
	                    k++;
	                }
	            }
	            order[i]=0;//将桶里计数器置0，用于下一次位排序
	        }
	        n*=10;
	        k=0;//将k置0，用于下一轮保存位排序结果
	    }
	    return array;
	}
	//测试函数
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
