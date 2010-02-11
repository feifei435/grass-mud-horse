package jcj1988.cfg;

import java.util.Hashtable;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jcj1988.factory.Factoryable;
import jcj1988.oprate.Operatable;
import jcj1988.vm.TriNode;

/**
 * �����࣬��Ҫ�����xml�л�ȡ��������
 * 
 * @author Administrator
 * 
 */
public final class Config {
	DomParse dp = null;
	Document doc = null;
	NodeList root = null;
	TriNode<Operatable> tree = new TriNode<Operatable>(null);
	VMarg vmarg = null;
	Factoryable fct = null;
	Node cmd = null;
	int heapMax = 0;
	int s = 0;
	int t = 0;
	int l = 0;
	StringBuffer str = null;
	Hashtable<String, String> hashtable = new Hashtable<String, String>();

	/**
	 * ���캯��
	 * @param xmlName xml�ļ���
	 */
	public Config(String xmlName) {
		dp = new DomParse(xmlName);
		doc = dp.getDocument();
		root = dp.getBoot().item(0).getChildNodes();

		Node n = null;
		// NodeList nl = null;
		for (int i = 0; i < root.getLength(); i++) {
			n = root.item(i);
			if (n.getNodeName().equals("SOURSE")) {
				// TODO: �Ժ���˵
				n.getChildNodes();
			} else if (n.getNodeName().equals("VMARG")) {// ����xml������������
				setVMarg(n);
			} else if (n.getNodeName().equals("CMD"))
				cmd = n;// Ϊ����һ����������׼��
		}
	}

	/**
	 * ͨ��xml�������������
	 * @param n xml�е�����������ڵ�
	 */
	private void setVMarg(Node n) {
		try {
			heapMax = Integer.parseInt(n.getAttributes()
					.getNamedItem("HEAPMAX").getNodeValue());
		} catch (Exception e) {
			heapMax = 65536;
		}

		NodeList nl = n.getChildNodes();
		try {
			for (int j = 0; j < nl.getLength(); j++) {
				n = nl.item(j);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					if (n.getNodeName().equals("S")) {
						s = Integer.parseInt(n.getTextContent());
					} else if (n.getNodeName().equals("T")) {
						t = Integer.parseInt(n.getTextContent());
					} else if (n.getNodeName().equals("L")) {
						l = Integer.parseInt(n.getTextContent());
					}
				}
			}
		} catch (Exception e) {
			s = 33609;
			t = 27877;
			l = 39532;
		}

		vmarg = new VMarg(heapMax, s, t, l);

	}

	/**
	 * ͨ�������๤������һ��������
	 * @param f ��������������Ĳ����๤��
	 * @return �����õ�����������
	 */
	public TriNode<Operatable> buildCmdTree(Factoryable f) {
		this.fct = f;
		buildCmdTree(cmd, tree);
		return tree;
	}

	/**
	 * ͨ��xml�Ľڵ㴴��һ�������� 
	 * @param cmd ��ǰ�ĵ��ڵ�
	 * @param tr Ҫ��������ĸ��ڵ�
	 */
	private void buildCmdTree(Node cmd, TriNode<Operatable> tr) {
		Node n = null;
		NodeList nl = cmd.getChildNodes();
		boolean hasChild = false;// ��¼�Ƿ��к���
		for (int i = 0; i < nl.getLength(); i++) {
			n = nl.item(i);
			// System.out.println(n.getNodeName());
			TriNode<Operatable> tn = new TriNode<Operatable>(null);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				if (n.getNodeName().equals("S")) {
					tr.setLeft(tn);
					buildCmdTree(n, tn);
					hasChild = true;
				} else if (n.getNodeName().equals("T")) {
					tr.setMiddle(tn);
					buildCmdTree(n, tn);
					hasChild = true;
				} else if (n.getNodeName().equals("L")) {
					tr.setRight(tn);
					buildCmdTree(n, tn);
					hasChild = true;
				}
			}
		}
		if (!hasChild) {
			tr.setElem(fct.Factory(cmd.getTextContent()));
		}
	}

	/**
	 * ��ȡ������α���Ĺ�ϣ��ӳ��
	 * @return ��ϣ�����
	 */
	public Hashtable<String, String> getHashtable() {
		str = new StringBuffer();
		getHashtable(cmd);
		System.out.println(hashtable.get("S_DUP"));
		return hashtable;
	}

	/**
	 * ͨ��xml�Ľڵ㴴��һ��ӳ���,�˺����������⡭��������ȷ����xml�д�������� 
	 * @param cmd ��ǰ�ĵ��ڵ�
	 */
	private void getHashtable(Node cmd) {
		Node n = null;
		NodeList nl = cmd.getChildNodes();
		boolean hasChild = false;// ��¼�Ƿ��к���
		for (int i = 0; i < nl.getLength(); i++) {
			n = nl.item(i);
			// System.out.println(n.getNodeName());
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				if (n.getNodeName().equals("S")) {
					str.append((char) s);
					getHashtable(n);
					hasChild = true;
				} else if (n.getNodeName().equals("T")) {
					str.append((char) t);
					getHashtable(n);
					hasChild = true;
				} else if (n.getNodeName().equals("L")) {
					str.append((char) l);
					getHashtable(n);
					hasChild = true;
				}
			}
		}
		if (!hasChild) {
			// hashtable.put(fct.Factory(cmd.getTextContent()), str);
			hashtable.put(cmd.getTextContent(), str.toString());
			str = new StringBuffer();
		}

	}

	/**
	 * ����������������
	 * @return ������������������
	 */
	public VMarg getVMarg() {
		return vmarg;
	}
}
