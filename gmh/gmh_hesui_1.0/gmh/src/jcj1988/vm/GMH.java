package jcj1988.vm;

import java.io.Reader;

import jcj1988.analyze.Analyzable;
import jcj1988.analyze.VmAnalyzeImpl;
import jcj1988.analyze.CmdAnalyze;
import jcj1988.cfg.Config;
import jcj1988.cfg.VMarg;
import jcj1988.factory.Factoryable;
import jcj1988.factory.OpEnum;
import jcj1988.io.IOable;
import jcj1988.manage.CmpMng;
import jcj1988.manage.DebugMng;
import jcj1988.manage.Manager;
import jcj1988.manage.RunMng;
import jcj1988.oprate.Executable;
//import jcj1988.analyze.OpAnalyzeImpl;
//import java.util.Hashtable;
/**
 * gmh����������࣬���������������������û���ָ���Ĳ���
 * @author jcj1988
 *
 */
public class GMH implements Executable {
	/**
	 * ���������������ӿ�
	 */
	public IOable io = null;
	/**
	 * ������Ŀ��ƶ���
	 */
	public Config cfg = null;
	/**
	 * �����ļ�����������
	 */
	Reader reader = null;
	/**
	 * �������������
	 */
	public VMarg vmarg = null;
	/**
	 * �����������������
	 */
	CodeSection cs = null;
	/**
	 * �������󹤳�
	 */
	public Factoryable fct = null;
	// public TriNode<Operatable> tree = null;
	/**
	 * ��������
	 */
	Analyzable alz = null;
	/**
	 * ���ȹ������
	 */
	Manager mng = null;
	/**
	 * ���캯����ͨ����������������������г�ʼ��
	 * @param caz ����������������
	 */
	public GMH(CmdAnalyze caz) {
		io = caz.getIo();
		RunMode mode=caz.getMode();
		switch (mode) {
		case RUN:
			mng = new RunMng();
			break;
		case CMP:
			mng = new CmpMng(io);
			break;
		case DBG:
			mng = new DebugMng(io);
			break;
		}
		cfg = new Config(caz.getCfg());
		vmarg = cfg.getVMarg();
		cs = new CodeSection(caz.getSrc(), io, vmarg, mng);
		fct = new OpEnum(cs);// OpEnum(cs);Operators(cs);
		alz = new VmAnalyzeImpl(cs, cfg.buildCmdTree(fct), mng);
		//alz=new OpAnalyzeImpl(cs,cfg.getHashtable());
	}

	@Override
	public void execute() {
		alz.analyse();
		mng.execute();
		io.close();
	}
	
	/**
	 * gmh�������������
	 * @param args �����в���
	 */
	public static void main(String[] args) {
		CmdAnalyze caz=new CmdAnalyze(args);
		caz.analyse();	
		IOable io = caz.getIo();
		if(caz.getSrc()==null){
			io.print("û�б�ѡ����'sourceFile',ʹ�÷��� GMH sourceFile [{/r|/c|/d}] [/o outputFile] [/p configFile]���磺\nGMH hworld.gmh /r /o out.txt\n");
		}else
			new GMH(caz).execute();
	}
}
