package jcj1988.factory;

import java.math.BigInteger;

import jcj1988.io.IOable;
import jcj1988.oprate.Arith;
import jcj1988.oprate.Flow;
import jcj1988.oprate.Heap;
import jcj1988.oprate.IO;
import jcj1988.oprate.Operatable;
import jcj1988.oprate.Stack;
import jcj1988.vm.CodeSection;

/**
 * ����������๤������һ��ʵ�ַ�ʽ����ͨ���̳��˲����ӿڵ�ö������ʵ�ֵ�
 * 
 * @author jcj1988
 * */
public class OpEnum implements Factoryable {
	/**
	 * ���������������
	 */
	public static IOable std = null;
	/**
	 * ջ����
	 */
	public static Stack s = null;
	/**
	 * �Ѷ���
	 */
	public static Heap h = null;
	/**
	 * �����ƶ���
	 */
	public static Flow f = null;
	/**
	 * �������
	 */
	public static Arith a = null;
	/**
	 * ���������������
	 */
	public static IO io = null;

	/**
	 * ���캯��
	 * 
	 * @param cs
	 *            �������������
	 */
	public OpEnum(CodeSection cs) {
		std = cs.getIo();
		s = new Stack(std);
		a = new Arith(s);
		h = new Heap(cs.getVmarg().getHeapMax(), s);
		io = new IO(std, s, h);
		f = new Flow(cs.getMng(), s);
	}

	@Override
	public Operatable Factory(String s) {
		OpCode r = null;
		try {
			r = (OpCode) OpCode.class.getDeclaredField(s).get(this);
		} catch (Exception e) {
			e.printStackTrace();
			// std.error(e);
		}
		// ���ȵķ���
		// OpCode[] oc = OpCode.values();
		// for (int i = 0; i < oc.length; i++) {
		// if (oc[i].name().equals(s)) {
		// r = oc[i];
		// break;
		// }
		// }
		return r;
	}

	/**
	 * ���ջ����
	 * 
	 * @return ջ���������
	 */
	public Stack getStack() {
		return s;
	}

	/**
	 * ��öѶ���
	 * 
	 * @return �Ѷ��������
	 */
	public Heap getHeap() {
		return h;
	}

	/**
	 * ���������
	 * 
	 * @return �����������
	 */
	public Flow getFlow() {
		return f;
	}

	/**
	 * ����������
	 * 
	 * @return ������������
	 */
	public Arith getArith() {
		return a;
	}

	/**
	 * ��������������
	 * 
	 * @return ����������������
	 */
	public IO getIo() {
		return io;
	}

	/**
	 * ����ö���ࣨ�ڲ��ࣩ
	 * 
	 * @author jcj1988
	 */
	public enum OpCode implements Operatable {
		// Stack Manipulation
		/**
		 * ����ջ��Ԫ��
		 */
		S_POP(false) {
			@Override
			public void execute() {
				s.pop();
			}
		},
		/**
		 * ѹջ
		 */
		S_PUSH(true) {
			@Override
			public void execute(BigInteger b) {
				s.push(b);
			}
		},
		/**
		 * ����ջ��Ԫ��ѹջ
		 */
		S_DUP(false) {
			@Override
			public void execute() {
				s.dup();
			}
		},
		/**
		 * ���Ƶ�n��Ԫ�ص�ջ��
		 */
		S_COPY(true) {
			@Override
			public void execute(BigInteger b) {
				s.copy(b.intValue());
			}
		},
		/**
		 * ����ջ������Ԫ��
		 */
		S_SWAP(false) {
			@Override
			public void execute() {
				s.swap();
			}
		},
		/**
		 * ����ջ����n��Ԫ�أ�������ջ��Ԫ��
		 */
		S_SLIDE(true) {
			@Override
			public void execute(BigInteger b) {
				s.slid(b.intValue());
			}
		},
		// Arithmetic
		/**
		 * �״γ�ջΪ��ֵ,�ٴγ�ջΪ��ֵ,ִ�мӲ��������ѹջ
		 */
		A_ADD(false) {
			@Override
			public void execute() {
				a.add();
			}
		},
		/**
		 * �״γ�ջΪ��ֵ,�ٴγ�ջΪ��ֵ,ִ�м����������ѹջ
		 */
		A_SUB(false) {
			@Override
			public void execute() {
				a.sub();
			}
		},
		/**
		 * �״γ�ջΪ��ֵ,�ٴγ�ջΪ��ֵ,ִ�г˲��������ѹջ
		 */
		A_MUL(false) {
			@Override
			public void execute() {
				a.mul();
			}
		},
		/**
		 * �״γ�ջΪ��ֵ,�ٴγ�ջΪ��ֵ,ִ���������������ѹջ
		 */
		A_DIV(false) {
			@Override
			public void execute() {
				a.div();
			}
		},
		/**
		 * �״γ�ջΪ��ֵ,�ٴγ�ջΪ��ֵ,ִ��ȡģ���������ѹջ
		 */
		A_MOD(false) {
			@Override
			public void execute() {
				a.mod();
			}
		},
		// Heap Access
		/**
		 * ���״γ�ջԪ�ش洢���ٴγ�ջԪ����ָ���Ķѵ�ַ��
		 */
		H_PUT(false) {
			@Override
			public void execute() {
				h.put();
			}
		},
		/**
		 * ����ջԪ����ָ���Ķ�λ�ô�Ԫ��ѹջ
		 */
		H_GET(false) {
			@Override
			public void execute() {
				h.get();
			}
		},
		// Flow Control
		/**
		 * ����һ�����
		 */
		F_MARK(true) {
			@Override
			public void execute(BigInteger b) {
				f.mark(b);
			}

			@Override
			public boolean isMarkOpr() {
				return true;
			}
		},
		/**
		 *���ú���
		 */
		F_CALL(true) {
			@Override
			public void execute(BigInteger b) {
				f.call(b);
			}
		},
		/**
		 * ��������ת
		 */
		F_JMP(true) {
			@Override
			public void execute(BigInteger b) {
				f.jmp(b);
			}
		},
		/**
		 * ջ��Ԫ��Ϊ0ʱ��ת
		 */
		F_JZ(true) {
			@Override
			public void execute(BigInteger b) {
				f.jz(b);
			}
		},
		/**
		 * ջ��Ԫ��Ϊ��ʱ��ת
		 */
		F_JNEG(true) {
			@Override
			public void execute(BigInteger b) {
				f.jneg(b);
			}
		},
		/**
		 * �����������ص��ô�
		 */
		F_RET(false) {
			@Override
			public void execute() {
				f.ret();
			}
		},
		/**
		 * ������������������
		 */
		F_END(false) {
			@Override
			public void execute() {
				f.end();
			}
		},
		// I/O
		/**
		 * ��������ѹջ
		 */
		I_INT(false) {
			@Override
			public void execute() {
				io.getInt();
			}
		},
		/**
		 * �����ַ�ѹջ
		 */
		I_CHR(false) {
			@Override
			public void execute() {
				io.getChar();
			}
		},
		/**
		 * ���ջ������
		 */
		O_INT(false) {
			@Override
			public void execute() {
				io.putInt();
			}
		},
		/**
		 * ���ջ���ַ�
		 */
		O_CHR(false) {
			@Override
			public void execute() {
				io.putChar();
			}
		},
		// EOF
		/**
		 * �ļ�����
		 */
		X_EOF(false) {
			@Override
			public void execute() {
				// do nothing
				// System.out.println("OK!");//������
			}
		};
		/**
		 * �Ƿ���Ҫ����
		 */
		public boolean needArg;

		// public String name;

		@Override
		public boolean isNeedArg() {
			return needArg;
		}

		/**
		 * ���캯��
		 * 
		 * @param needArg
		 *            �Ƿ���Ҫ����
		 */
		private OpCode(boolean needArg) {
			this.needArg = needArg;
		}

		@Override
		public boolean isMarkOpr() {
			return false;
		}

		@Override
		public String getName() {
			return name();
		}

		@Override
		public void execute() {
			// do nothing
		}

		@Override
		public void execute(BigInteger b) {
			// do nothing
		}

	}
}
