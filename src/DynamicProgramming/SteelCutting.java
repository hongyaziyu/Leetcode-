package DynamicProgramming;


/**
 * @author ������
 * ʱ�䣺2019/07/05 12:00
 * �����и�����
 *���賤��Ϊi�ĸ����۸�Ϊp(i)����������Ϊn�ĸ����ͼ۸��p(i)������ѷָ��ʹ�û���r(n)���
 *������r(n)=max(p(n),r(1)+r(n-1),...,r(i)+r(n-i),...,r(n-1)+r(1))
 */
/**
 * @author ������
 *
 */
public class SteelCutting {
	//����1���õݹ鷨������⡣
	public static int cut(int n,int[] p){
		if(n==0){
			return 0;
		}
		int q=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			q=Math.max(q, p[i-1]+cut(n-i,p));
		}
		return q;
	}
	//����2������¼������¼ÿ���ӽ�������Ž�
	public static int cutMemo(int[] p){
		int[] r=new int[p.length+1];
		for(int i=0;i<=p.length;i++){
			r[i]=-1;
		}
		return cut(p,p.length,r);
	}
	//�����������ʱp[0]=1;p[1]=5,p[2]=8,p[3]=9.r[0]=-1,r[1]=-1,r[2]=-1,r[3]=-1,r[4]=-1��
	//����ʱp.length=4.r���鳤����5���±���0��4��
	//���r[4]��ֵ��
	//r[4]=max{r[3]+p[0],r[2]+p[1],r[1]+p[2],r[0]+p[3]}����Ҫ����r[3]��r[2]��r[1]��r[0]
	//r[3]=max{r[2]+p[0],r[1]+p[1],r[0]+p[2]}
	//r[2]=max{r[1]+p[0],r[0]+p[1]}
	//r[1]=max{r[0]+p[0]}
	//r[0]=0
	//�������ϵ������r[4]��q��Ȼ��q��Ϊ����ֵ��
	public static int cut(int[] p, int n, int[] r) {
		int q=-1;
        if(n==0)
            q=0;
        else {
            for(int i=1;i<=n;i++)
                q=Math.max(q, cut(p, n-i,r)+p[i-1]);
        }
        r[n]=q;

        return q;
	}
	//����3���Ե����϶�̬�滮��
	//������һ�������ķ������Է��ֿ����ȼ���r[0],r[1],r[2],r[3],r[4]��ֵ������������ȡʲôֵ��ȡʲôֵ��
	public static int buttom_up_cut(int[] p){
		int[] r=new int[p.length+1];
		r[0]=0;//���Բ�д��Ĭ��Ϊ0
		//���ѭ���ֱ����r[1],r[2],...
		for(int i=1;i<=p.length;i++){
			int q=-1;
			//�ڲ�ѭ���ֱ���r[1],r[2],...���Ž⡣
			for(int j=1;j<=i;j++){
				q=Math.max(q, p[j-1]+r[i-j]);
			}
			r[i]=q;
		}
		return r[p.length];
	}
	
	public static void main(String[] args) {
		int[] p={1,5,8,9};
		int n=2;
		System.out.println(SteelCutting.buttom_up_cut(p));
	}
}
