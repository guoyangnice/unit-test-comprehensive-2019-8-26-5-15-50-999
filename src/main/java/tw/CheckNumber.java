package tw;

/**
 * �������ÿ�������ǲ�����ȷ��
 * @author yangjie
 *
 */
public class CheckNumber {
	public static boolean isValid(int[] array) {
		if(array.length == 4) {
			for(int i = 0; i < array.length;i++) {
				if(array[i] < 10 && array[i] >= 0) {
					return true;
				}else {
					return false;
				}
			}
		}else {
			return false;
		}
		
		return false;
	}
}
