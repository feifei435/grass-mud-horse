package jcj1988.factory;

import jcj1988.oprate.Operatable;

/**
 * ���������������࣬��ʹ�ù�������֮ǰ�����ȵ���init������
 * ���򽫻����,��ʼ������Ҫ�Ĳ���������һ���������󴫵�
 * @author jcj1988
 * */
public interface Factoryable{
	/**
	 * �����ַ���s�������������
	 * @param s Ҫ���ɵĲ�����������Ӧ���ַ���
	 * @return �����Ĳ������������
	 */
	public Operatable Factory(String s) ;
}
