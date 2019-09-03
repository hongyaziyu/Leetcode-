package BasicAlgorithm;

import java.util.Arrays;

/**
 * @author ������ ������
 *             0
 *           /   \
 *          1     3
 *        /  \  /  \
 *       2   4 6    7
 *      / \
 *     5   8
 *  �����е�������0 1 3 2 4 6 7 5 8
 */
public class HeapSort {
	
	public static void main(String[] args) {
		int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
		System.out.println("����֮ǰ��");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
 
		// ������
		heapSort(arr);
 
		System.out.println();
		System.out.println("����֮��");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
 
	/**
	 * ������
	 */
	private static void heapSort(int[] arr) { 
		// ������������й�����һ���󶥶�
		for (int i = arr.length / 2; i >= 0; i--){ 
			heapAdjust(arr, i, arr.length); 
		}
		
		// �𲽽�ÿ�����ֵ�ĸ��ڵ���ĩβԪ�ؽ����������ٵ�����������ʹ���Ϊ�󶥶�
		for (int i = arr.length - 1; i > 0; i--) { 
			swap(arr, 0, i); // ���Ѷ���¼�͵�ǰδ�����������е����һ����¼����
			heapAdjust(arr, 0, i); // ����֮����Ҫ���¼����Ƿ���ϴ󶥶ѣ���������Ҫ����
		}
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
}
