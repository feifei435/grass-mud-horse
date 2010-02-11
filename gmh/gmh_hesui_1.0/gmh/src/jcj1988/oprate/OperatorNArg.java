package jcj1988.oprate;

/**
 * �޲��������ࣨoperator which Need Not Argument��
 * @author jcj1988
 * */
public class OperatorNArg implements Callable {
	Operatable op = null;
	String name=null;
	/**
	 * �޲���������Ĺ��캯��
	 * @param op �������������
	 */
	public OperatorNArg(Operatable op) {
		this.op = op;
		this.name=op.getName();
	}

	@Override
	public void call() {
		op.execute();
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isMark() {
		return false;
	}
}
