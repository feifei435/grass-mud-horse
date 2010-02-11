package jcj1988.analyze;

import java.io.FileNotFoundException;

import jcj1988.io.IOable;
import jcj1988.io.StdIO;
import jcj1988.io.ToFile;
import jcj1988.manage.Manager;
import jcj1988.vm.RunMode;

/**
 * �����в���������
 * 
 * @author jcj1988
 * 
 */
public class CmdAnalyze implements Analyzable {
	private String[] args = null;
	private String src = null;
	private String cfg = null;
	Manager manager = null;
	private RunMode mode = null;
	private IOable io = null;
	int i = 0;

	/**
	 * ���캯��
	 * 
	 * @param args
	 *            �����в���
	 */
	public CmdAnalyze(String[] args) {
		this.args = args;
	}

	@Override
	public void analyse() {
		for (i = 0; i < args.length; i++) {
			if (args[i].charAt(0) != '/')
				src = args[i];
			else
				switch (args[i].charAt(1)) {
				case 'r':
				case 'R':
					// manager=new RunMng();
					mode = RunMode.RUN;
					break;
				case 'c':
				case 'C':
					// manager=new CmpMng(io);
					mode = RunMode.CMP;
					break;
				case 'd':
				case 'D':
					// manager=new DebugMng(io);
					mode = RunMode.DBG;
					break;
				case 'o':
				case 'O':
					i++;
					try {
						io = new ToFile(args[i]);
					} catch (FileNotFoundException e) {
						// e.printStackTrace();
						io = new StdIO();
						io.error(e);
					}
					break;
				case 'p':
				case 'P':
					i++;
					cfg = args[i];
				}
		}
		if (mode == null)
			mode = RunMode.RUN;
		if (io == null)
			io = new StdIO();
		if (cfg == null)
			cfg = "config.xml";
	}

	/**
	 * ��������ļ���
	 * 
	 * @return �����ļ���
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * ������ö���
	 * 
	 * @return ���ö��������
	 */
	public String getCfg() {
		return cfg;
	}

	/**
	 * �������ģʽ
	 * 
	 * @return ����ģʽ������
	 */
	public RunMode getMode() {
		return mode;
	}

	/**
	 * ��������������
	 * 
	 * @return ����������������
	 */
	public IOable getIo() {
		return io;
	}
}
