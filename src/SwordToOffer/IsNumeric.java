package SwordToOffer;

/**
 * @author ������ ��ʾ��ֵ���ַ���
 * ��Ŀ������
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ�����+100��,��5e2��,��-123��,��3.1416��͡�-1E-16�嶼��ʾ��ֵ�� 
 * ���ǡ�12e��,��1a3.14��,��1.2.3��,��+-5��͡�12e+4.3�嶼���ǡ�
 *����˼·������������־���ֱ��¼��+/-������e/E���͡�.���Ƿ���ֹ���
 *���ڡ�+/-���� �����������ǵ�һ�γ��ֵĻ�Ӧ�ó������ַ����ĵ�һ��λ�ã��������һ�γ����ڲ����ַ�����λ����������ǰ��Ҳ���ǡ�e/E�����ǾͲ����Ϲ�������ǵڶ��γ��֣���ô����Ӧ�ó����ڡ�e/E���ĺ��棬�����+/-����ǰ�治�ǡ�e/E������Ҳ�����Ϲ���
���ڡ�e/E���� ������ĺ��治���κ����֣��Ͳ����Ϲ���������ֶ����e/E��Ҳ�����Ϲ���
���ڡ�.���� ���ֶ����.���ǲ����Ϲ���ġ����С�e/E�����ַ������֡�.��Ҳ�ǲ����Ϲ���ġ�
ͬʱ��Ҫ��֤�����ַ���Ϊ 0-9 ֮������֡�
 */
public class IsNumeric {
	public boolean isNumeric(char[] str) {
        int len = str.length;
        boolean sign = false, decimal = false, hasE = false;
        for(int i = 0; i < len; i++){
            if(str[i] == '+' || str[i] == '-'){
                if(!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E')
                    return false;
                if(sign && str[i-1] != 'e' && str[i-1] != 'E')
                    return false;
                sign = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                if(i == len - 1)
                    return false;
                if(hasE)
                    return false;
                hasE = true;
            }else if(str[i] == '.'){
                if(hasE || decimal)
                    return false;
                decimal = true;
            }else if(str[i] < '0' || str[i] > '9')
                return false;
        }
        return true;
    }
}
