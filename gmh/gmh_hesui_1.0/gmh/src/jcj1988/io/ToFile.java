package jcj1988.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * ��������࣬������ض����ļ�
 * @author jcj1988
 *
 */
public class ToFile extends IO {
	/**
	 * ���캯��
	 * @param file ����ļ����ļ�������������ڣ����ļ��ᱻ�½�
	 * @throws FileNotFoundException ������ʽ���׳��쳣�����Ǵ�������ᷢ��
	 */
	public ToFile(String file) throws FileNotFoundException{
		super(new PrintStream(file));
	}
}
