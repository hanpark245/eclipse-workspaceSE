package bookcafe.table;

import java.io.Serializable;

public class Table implements Serializable {
	/*
	 * 1. ��� ����
	 */
	private int table_no;		//���̺��ȣ
	private String inTime;		//����ð�
	private String outTime;		//����ð�
	private int guest_no;		//�մ��ο���
	private String order_no;	//�ֹ���ȣ
	
	
	/*
	 * 2. ������ 3��
	 */
	public Table(){
		//Default constructor
	}
	
	public Table(int table_no, String inTime, int guest_no){	//table��ü ������(�մ�����) ���̺��ȣ,����ð�,�ο����� �Է�
		super();
		this.table_no = table_no;
		this.inTime = inTime;
		this.guest_no = guest_no;
		this.outTime = "";		//�̰ž����ָ� �����Ҷ� null�� ������
		this.order_no = "";
	}
	
	public Table(int table_no, String inTime, String outTime, int guest_no, String order_no) {	//�׳ɳ־�����
		super();
		this.table_no = table_no;
		this.inTime = inTime;
		this.outTime = outTime;
		this.guest_no = guest_no;
		this.order_no = order_no;
	}

	/*
	 * 3. getter/setter
	 */
	public int getTable_no() {
		return table_no;
	}

	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public int getGuest_no() {
		return guest_no;
	}

	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	
	@Override
	public String toString() {
		return table_no + "\t" + inTime + "\t" + outTime + "\t" + guest_no + "\t" + order_no;
	}
}
