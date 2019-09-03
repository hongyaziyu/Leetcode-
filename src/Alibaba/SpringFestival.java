package Alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class SpringFestival {
		 
	    public static void main(String[] args){
	        Scanner sc=new Scanner(System.in);
	        String[] str=sc.nextLine().split(",");
	        double target=sc.nextDouble();
	        double[] nums=new double[str.length];
	       /* for(int i=0;i<str.length;i++){
	            nums[i]=Double.parseDouble(str[i]);
	        }*/
	        nums= Arrays.stream(str).mapToDouble(Double::parseDouble).toArray();
	        System.out.print(getRecord2(false,false,nums,0,1,0,target));

	    }


	    public static Boolean getRecord2(Boolean flag,Boolean flag2,double[] nums,int i,int j,double all,double target){
	        if(j>nums.length){
	           return false;
	        }
	        if(j<nums.length&&nums[i]>10&&nums[j]>10){
	            flag=true;
	        }
	        all=all+nums[i];

	        if(all>=target){
	            flag2=true;
	        }

	        if(flag2&&flag){
	           return true;
	        }
	        return getRecord2(flag,flag2,nums,++i,++j,all,target);

	    }

}
