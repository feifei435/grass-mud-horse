package jcj1988.oprate;
/**
 * ���ò�����ӿڣ��Բ������ٴη�װ�Ľ��
 * @author jcj1988
 *
 */
public interface Callable{
	/**
	 * ���ò���
	 */
	public void call();
	/**
	 * ��ò�������
	 * @return ����������
	 */
	public String getName();
	/**
	 * �����Ƿ�ΪMark����
	 * @return �ж��Ƿ�ΪMark�����Ľ��
	 */
	public boolean isMark();
}
