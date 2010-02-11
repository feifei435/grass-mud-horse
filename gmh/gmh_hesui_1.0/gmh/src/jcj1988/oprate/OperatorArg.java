package jcj1988.oprate;

import java.math.BigInteger;

/**
 * ���β����ࣨOperator which have Argument��
 * @author jcj1988
 * */
public class OperatorArg implements Callable{
	Operatable op = null;
	BigInteger arg = null;
	String name=null;

	/**
	 * ���β�����Ĺ��캯��
	 * @param op �������������
	 * @param arg ����ʱ����Ĳ���
	 */
	public OperatorArg(Operatable op, BigInteger arg) {
		this.op = op;
		this.arg = arg;
		this.name=op.getName()+" "+arg;
	}

	@Override
	public void call() {
		op.execute(arg);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isMark() {
		return op.isMarkOpr();
	}
}