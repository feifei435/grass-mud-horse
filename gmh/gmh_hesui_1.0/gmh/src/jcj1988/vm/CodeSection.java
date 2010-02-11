package jcj1988.vm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import jcj1988.cfg.VMarg;
import jcj1988.io.IOable;
import jcj1988.manage.Manager;

/**
 * ������������������𱣴�����gmh�����Լ����й����е�һЩ������
 * �������ڲ������������࣬�����պ�Ķ��ϴ�ֻҪ��ѭ�ɸĲ���ɾ��ֻ��������ԭ����Ա�֤�Ķ������ٵ�ǣ��
 * @author jcj1988
 * */
public class CodeSection {
	private String filename;
	private BufferedReader reader;
	private VMarg vmarg;
	private IOable io;
	private Manager mng;

	// Integer[] lineNums;
	// Integer[] colNums;
	
	/**
	 * ���캯��
	 * @param file �����ļ���
	 * @param io ��׼��������ӿ�
	 * @param vmarg �����������������
	 * @param mng �����������
	 */
	public CodeSection(String file, IOable io, VMarg vmarg, Manager mng) {
		this.io = io;
		this.vmarg = vmarg;
		this.mng = mng;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			io.error(e);
		}
	}

	/**
	 * ��������ļ���gmhԴ���ļ�����
	 * @return �����ļ����ļ���
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * ����������������
	 * @return ������������������
	 */
	public VMarg getVmarg() {
		return vmarg;
	}

	/**
	 * ��������ļ�����������
	 * @return ���������������
	 */
	public BufferedReader getReader() {
		return reader;
	}

	/**
	 * ��ñ�׼���������������
	 * @return ��׼����������������
	 */
	public IOable getIo() {
		return io;
	}

	/**
	 * ��ȡ�����������
	 */
	public Manager getMng() {
		return mng;
	}
}
