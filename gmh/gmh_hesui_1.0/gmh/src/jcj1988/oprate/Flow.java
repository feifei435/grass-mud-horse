package jcj1988.oprate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;

import jcj1988.manage.Manager;

/**
 * gmh�е������ƣ���gmh�еĲ���һ�£�����ϸ�ڲ鿴gmh˵���� 
 * @author jcj1988
 * */
public class Flow {
	Manager mng = null;
	private ArrayList<Callable> opr = null;
	java.util.Stack<Integer> callStack = new java.util.Stack<Integer>();
	Stack opStack = null;
	private Hashtable<BigInteger, Integer> labels = new Hashtable<BigInteger, Integer>();

	/**
	 * ���캯��������Flow����ĳ�ʼ��
	 * @param mng �����������
	 * @param s �������ջ����
	 */
	public Flow(Manager mng, Stack s) {
		this.mng = mng;
		this.opr=this.mng.getOpr();
		this.opStack=s;
	}

	/**
	 * ��ǲ���
	 * @param b ��ʶ��
	 */
	public void mark(BigInteger b) {
		labels.put(b, mng.getI());
	}

	/**
	 * ���ú�������
	 * @param b �����ô��ı�ʶ��
	 */
	public void call(BigInteger b) {
		callStack.push(mng.getI());
		mng.setI(labels.get(b));
	}

	/**
	 * ��������ת����ʶ����ִ��
	 * @param b ��ת����ʶ��
	 */
	public void jmp(BigInteger b) {
		mng.setI(labels.get(b));
	}

	/**
	 * ջ��Ԫ��Ϊ0ʱ��ת����ָʾ�ı�ʶ����
	 * @param b ��ָ���ı�ʶ��
	 */
	public void jz(BigInteger b) {
		if (opStack.pop().intValue() == 0) {
			mng.setI(labels.get(b));
		}
	}

	/**
	 * ջ��Ԫ��С��0ʱ��ת����ָʾ�ı�ʶ����
	 * @param b ��ָ���ı�ʶ��
	 */
	public void jneg(BigInteger b) {
		if (opStack.pop().signum() == -1) {
			mng.setI(labels.get(b));
		}
	}

	/**
	 * �����������ص��ô�
	 */
	public void ret() {
		mng.setI(callStack.pop());
	}

	/**
	 * ������������������
	 */
	public void end() {
		mng.setI(opr.size());
	}
}
