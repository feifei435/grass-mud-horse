package jcj1988.oprate;

import java.math.BigInteger;
/**
 * ���в�����Ľӿڣ�ͳһ�������壬�Է��㽨��������ͳһ��ʽ����
 * @author jcj1988
 * */
public interface Operatable extends Executable{
	/**
	 * ��Ҫ����������
	 * @param b ����
	 */
	public void execute(BigInteger b);

	/**
	 * ���ز����Ƿ���Ҫ����
	 * @return �жϽ��
	 */
	public boolean isNeedArg();
	
	/**
	 * �����Ƿ���Mark����
	 * @return �жϽṹ
	 */
	public boolean isMarkOpr();
	
	/**
	 * ��ò�������
	 * @return ��������
	 */
	public String getName();
}