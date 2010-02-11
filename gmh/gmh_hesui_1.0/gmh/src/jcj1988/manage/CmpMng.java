package jcj1988.manage;

import java.math.BigInteger;

import jcj1988.io.IOable;
import jcj1988.oprate.Operatable;
/**
 * gmh����ģʽ�Ĺ�����
 * @author jcj1988
 *
 */
public class CmpMng extends Manager {
	private IOable io=null;

	/**
	 * ���캯��
	 * @param io ����������������
	 */
	public CmpMng(IOable io) {
		this.io=io;
	}

	@Override
	public void manage(Operatable elem) {
		//i++;
		//io.println(i+":"+elem.getName());
		io.println(elem.getName());
	}

	@Override
	public void manage(Operatable elem, BigInteger b) {
		//i++;
		//io.println(i+":"+elem.getName()+" "+b);
		io.println(elem.getName()+" "+b);
	}

	@Override
	public void execute() {
		// do nothing
	}

}
