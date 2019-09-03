package BeiKeZhaoFang;

import java.util.Scanner;

public class Main2 {

 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  String str=sc.nextLine();
  int n=Integer.parseInt(str);
  String[] s=new String[n];
  for(int i=0;i<n;i++)
   s[i]=sc.nextLine();
  System.out.print(dowork(s,n));
 }

 private static int dowork(String[] s, int n) {
  String[] str1=new String[n];
  String[] str2=new String[n];
  int res=0;
  //str前面处理的oooo 紧跟着bc
  for(int i=0;i<n;i++) {
   str1[i]=s[i].split(" ")[0];
   str2[i]=s[i].split(" ")[1];
  }
  for(int i=0;i<n;i++) {
   String[] c=str1[i].split("");
   StringBuffer temp=new StringBuffer();
   if(c[0].equals("x"))
    temp.append("A");
   else temp.append("");
   
   if(c[1].equals("x"))
    temp.append("B");
   else temp.append("");
   
   if(c[2].equals("x"))
    temp.append("C");
   else temp.append("");
   
   if(c[3].equals("x"))
    temp.append("D");
   else temp.append("");
   String t=temp.toString();
   if(t.equals(str2[i]))
    res+=5;
   else if(str2[i].contains(t)&&(!t.equals(""))) {//String.contains(),返回布尔值，判断是否包含函数。
    res+=3;
   }else res+=0;
  }
  return res;
  
 }

}