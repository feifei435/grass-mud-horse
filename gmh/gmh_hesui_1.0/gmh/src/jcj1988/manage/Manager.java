package jcj1988.manage;

import java.math.BigInteger;
import java.util.ArrayList;

import jcj1988.oprate.Callable;
import jcj1988.oprate.Executable;
import jcj1988.oprate.Operatable;

/**
 * ���п�����ĸ���
 * 
 * @author jcj1988
 * 
 */
public abstract class Manager implements Executable {
	/**
	 * �Ǻ��εĲ�������Ŀ��ƹ���
	 * 
	 * @param elem
	 *            �������������
	 */
	public abstract void manage(Operatable elem);

	/**
	 * ���εĲ�������Ŀ��ƹ���
	 * 
	 * @param elem
	 *            �������������
	 * @param b
	 *            ������������Ĳ���
	 */
	public abstract void manage(Operatable elem, BigInteger b);

	protected int i;

	@Override
	public void execute() {
		// do nothing
	}

	/**
	 * ���i��ֵ��iһ��Ϊ����λ��ָ�룩
	 * @return i��ֵ
	 */
	public int getI() {
		// do nothing
		return i;
	}

	/**
	 * ����i��ֵ��iһ��Ϊ����λ��ָ�룩
	 * @param i Ҫ���õ�ֵ
	 */
	public void setI(int i) {
		// do nothing
		this.i = i;
	}

	/**
	 * ��ò������������������ɵ����Ա�
	 * @return ��������������
	 */
	public ArrayList<Callable> getOpr() {
		// do nothing
		return null;
	}
}
