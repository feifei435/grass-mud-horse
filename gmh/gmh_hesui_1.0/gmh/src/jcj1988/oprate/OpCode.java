package jcj1988.oprate;

import java.math.BigInteger;

/**
 * �����๤����Opraters�в�������ĸ���
 * @author jcj1988
 * **/
public class OpCode implements Operatable {
	private boolean needArg;
	private String name;

	/**
	 * �����๤����Opraters�в�������������Ĺ��캯��
	 * @param name ������
	 * @param needArg �����Ƿ���Ҫ����
	 */
	public OpCode(String name,boolean needArg) {
		this.needArg = needArg;
		this.name=name;
	}

	@Override
	public boolean isNeedArg() {
		return needArg;
	}

	@Override
	public boolean isMarkOpr() {
		return false;
	}

	@Override
	public void execute() {
	}

	@Override
	public void execute(BigInteger b) {
	}

	/**
	 * ��ò�����
	 */
	public String getName() {
		return name;
	}
}
