package jcj1988.cfg;

/**
 * �����������
 * 
 * @author jcj1988
 * 
 */
public class VMarg {
	private int heapMax;
	private int S;
	private int T;
	private int L;

	/**
	 * ���캯��
	 * 
	 * @param h
	 *            �ѵ�������������ֵ��Ĭ��ֵ��Ϊ65536
	 * @param s
	 *            �����ַ�S��Unicode���루�統���ַ�Ϊ���ݡ��ǣ���ֵΪ33609��
	 * @param t
	 *            �����ַ�T��Unicode���루�統���ַ�Ϊ���࡯�ǣ���ֵΪ27877��
	 * @param l
	 *            �����ַ�L��Unicode���루�統���ַ�Ϊ�����ǣ���ֵΪ39532��
	 */
	public VMarg(int h, int s, int t, int l) {
		if (h > 0 && h < 65536)
			heapMax = h;
		else
			heapMax = 65536;
		S = s;
		T = t;
		L = l;
	}

/**
 * ��öѵ��������
 * @return �ѵ��������
 */
	public int getHeapMax() {
		return heapMax;
	}

	/**
	 * ��������ַ�S��Unicode���루�統���ַ�Ϊ���ݡ��ǣ���ֵΪ33609��
	 * @return �ַ�S��Unicode���루�統���ַ�Ϊ���ݡ��ǣ���ֵΪ33609��
	 */
	public int getS() {
		return S;
	}

	/**
	 * ��������ַ�T��Unicode���루�統���ַ�Ϊ���࡯�ǣ���ֵΪ27877��
	 * @return �ַ�T��Unicode���루�統���ַ�Ϊ���࡯�ǣ���ֵΪ27877��
	 */
	public int getT() {
		return T;
	}

	/**
	 * ��������ַ�L��Unicode���루�統���ַ�Ϊ�����ǣ���ֵΪ39532��
	 * @return �ַ�L��Unicode���루�統���ַ�Ϊ�����ǣ���ֵΪ39532��
	 */
	public int getL() {
		return L;
	}
}
