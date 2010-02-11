package jcj1988.manage;

import java.math.BigInteger;
import java.util.ArrayList;

import jcj1988.io.IOable;
import jcj1988.oprate.Operatable;
import jcj1988.oprate.Callable;
import jcj1988.oprate.OperatorArg;
import jcj1988.oprate.OperatorNArg;

/**
 * gmh����ģʽ�Ĺ�����
 * 
 * @author jcj1988
 * 
 */
public class DebugMng extends Manager {
	private IOable io = null;
	private ArrayList<Callable> opr = new ArrayList<Callable>();

	/**
	 * ���캯��
	 * 
	 * @param io
	 *            ����������������
	 */
	public DebugMng(IOable io) {
		this.io = io;
		io.println("����Ϊ���ع��̣�\n");
	}

	@Override
	public void manage(Operatable elem) {
		io.println(elem.getName());
		opr.add(new OperatorNArg(elem));
	}

	@Override
	public void manage(Operatable elem, BigInteger b) {
		io.println(elem.getName() + " " + b);
		if (elem.isMarkOpr()) {
			i = opr.size() - 1;
			elem.execute(b);
		}
		opr.add(new OperatorArg(elem, b));
	}

	@Override
	public void execute() {
		Callable o = null;
		io.println("\n\n����Ϊ���й��̣�\n");// (���س�����)
		for (i = 0; i < opr.size(); i++) {
			o = opr.get(i);
			io.print(i + ":" + o.getName() + " ");
			if (!o.isMark())
				o.call();
			io.println("");
		}
	}

	@Override
	public ArrayList<Callable> getOpr() {
		return opr;
	}
}
