package �Ի�����;

import java.util.Scanner;

public class foodie {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] names = new String[5];// ����������
		String[] address = new String[5];// ���͵�ַ
		String[] menu = new String[5];// ������Ϣ
		int[] time = new int[5];// �Ͳ�ʱ��
		double[] money = new double[5];// �ܽ��
		boolean[] state = new boolean[5];// true ��������ɣ� false������Ԥ��

		String[] dishname = { "���˼�", "������˿", "��������" };// ��Ʒ��
		double[] price = { 12, 14, 16 };// ����
		int[] praise = new int[3];// ����
		int choice = 0;
		System.out.println("��ӭʹ�á��Ի����˵��ϵͳ��");
		do {
			System.out.println("************************************************************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("************************************************************");
			System.out.print("��ѡ��");
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
				if (choice < 0 || choice > 6) {
					System.out.println("������1-6��ѡ�");
					continue;
				}
			} else {
				System.out.println("����������ѡ�");
				String x = sc.next();
				continue;
			}

			switch (choice) {
			case 1:// һ����Ҫ����
				System.out.println("****************************��ӭ����****************************");
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						System.out.print("������������");// ������������Ҫ���û�����
						names[i] = sc.next();
						System.out.println("���\t����\t����\t����");// ѡ���Ʒ����������ʾ�����˵���š����ơ����ۡ�����������ʾ�û�����Ҫѡ��Ĳ�Ʒ��ż�����
						for (int j = 0; j < dishname.length; j++) {
							System.out.println((j + 1) + "\t" + dishname[j] + "\t" + price[j] + "\t" + praise[j]);
						}
						int food = 0;
						while (true) {
							System.out.print("��ѡ���Ʒ��");
							if (sc.hasNextInt()) {
								food = sc.nextInt();
								if (food < 1 || food > 3) {
									System.out.println("������1-3�Ĳ�Ʒ��");
									continue;
								} else {
									break;
								}
							} else {
								System.out.println("����������ѡ�");
								String x = sc.next();
								continue;
							}
						}

						int num;
						while (true) {
							System.out.print("���������");
							if (sc.hasNextInt()) {
								num = sc.nextInt();
								break;
							} else {
								System.out.println("��������ȷ���������֣���");
								String x = sc.next();
								continue;
							}
						}
						
						menu[i] = dishname[food - 1] + "\t" + num + "��";
						System.out.print("�������Ͳ�ʱ�䣨�Ͳ�ʱ����10����20��������Ͳͣ�:");// �Ͳ�ʱ�䣺Ҫ����10��20��������Ͳͣ�Ҫ���û�����10-20����������������ظ�����
						do {
							if (sc.hasNextInt()) {
								time[i] = sc.nextInt();
								if (time[i] < 10 || time[i] > 20) {
									System.out.print("����10-20��ʱ������µ���");
								}
							} else {
								System.out.println("��������ȷʱ�䣺");
								String x = sc.next();// ����������ַ�
							}
						} while (time[i] < 10 || time[i] > 20);
						System.out.print("�������Ͳ͵�ַ��");// �Ͳ͵�ַ��Ҫ���û�����
						address[i] = sc.next();
						money[i] = price[food - 1] * num;
						money[i] += money[i] >= 50 ? 0 : 6;// �ܽ��ܽ��=��Ʒ����*����+�Ͳͷѣ��Ͳͷѣ������ʶ������ﵽ50Ԫʱ�����Ͳͷѣ����������6Ԫ�Ͳͷѣ�
						state[i] = false;// ״̬������״̬��false����Ԥ����Ĭ��״̬�� true������ɣ�������ǩ�գ�
						System.out.println("���ͳɹ���" + menu[i]);// ���ͳɹ�����ʾ������Ϣ
						break;
					}
				}
				break;
			case 2:// �����鿴����
				System.out.println("****************************�鿴����****************************");
				System.out.println("�����ͺ�\t������\t�����Ʒ��Ϣ\t�Ͳ�����\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {// ������ʾ���ж���
						String stat = state[i] == true ? "�����" : "��Ԥ��";// ���ݰ�������š�������������������Ϣ����Ʒ���ͷ��������Ͳ�ʱ�䡢�Ͳ͵�ַ��״̬����Ԥ��������ɣ����ܽ��
						System.out.println((i + 1) + "\t" + names[i] + "\t" + menu[i] + "\t" + time[i] + "\t"
								+ address[i] + "\t" + money[i] + "\t" + stat);
					}
				}
				break;
			case 3:// ����ǩ�ն���
				System.out.println("****************************ǩ�ն���****************************");
				System.out.println("�����ͺ�\t������\t�����Ʒ��Ϣ\t�Ͳ�����\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {// ������ʾ���ж���
						String stat = state[i] == true ? "�����" : "��Ԥ��";// ���ݰ�������š�������������������Ϣ����Ʒ���ͷ��������Ͳ�ʱ�䡢�Ͳ͵�ַ��״̬����Ԥ��������ɣ����ܽ��
						System.out.println((i + 1) + "\t" + names[i] + "\t" + menu[i] + "\t" + time[i] + "\t"
								+ address[i] + "\t" + money[i] + "\t" + stat);
					}
				}
				while (true) {
					int i;
					
					while (true) {
						System.out.println("��������Ҫǩ�յĶ���(��0�˳�)��");
						if (sc.hasNextInt()) {
							i = sc.nextInt();
							break;
						} else {
							System.out.println("�����붩�������֣���");
							String x = sc.next();
							continue;
						}
					}
					
					if (i>0&&names[i - 1] != null && !state[i - 1]) {
						state[i - 1] = true;// ��������״̬��Ϊ�����
						System.out.println("������ǩ�ճɹ���");
						break;
					} else if (i>0&&state[i - 1]) {
						System.out.println("�˶�������ɣ������ظ�ǩ�գ�����");
						System.out.println("���������루����0�˳�����");
					} else if(i==0){
						break;
					}else{
						System.out.println("�޴˶���������");
						System.out.println("���������루����0�˳�����");
					}
				}
				break;
			case 4:// �ġ�ɾ������
				System.out.println("****************************ɾ������****************************");
				System.out.println("�����ͺ�\t������\t�����Ʒ��Ϣ\t�Ͳ�����\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {// ������ʾ���ж���
						String stat = state[i] == true ? "�����" : "��Ԥ��";// ���ݰ�������š�������������������Ϣ����Ʒ���ͷ��������Ͳ�ʱ�䡢�Ͳ͵�ַ��״̬����Ԥ��������ɣ����ܽ��
						System.out.println((i + 1) + "\t" + names[i] + "\t" + menu[i] + "\t" + time[i] + "\t"
								+ address[i] + "\t" + money[i] + "\t" + stat);
					}
				}

				int i;
				while (true) {
					System.out.print("������Ҫɾ���Ķ�����");
					if (sc.hasNextInt()) {
						i = sc.nextInt();
						if(i>0&&names[i-1]==null) {
							System.out.println("�ö��������ڣ����������룺");
						}else if(i>0&&i<=5&&names[i-1]!=null) {
							break;
						}else {
							System.out.println("����������������еĶ�����");
						}
					} else {
						System.out.println("�����붩�������֣���");
						String x = sc.next();
						continue;
					}
				}
				
				
				if (state[i - 1]) {// �û����붩�����кţ�������кŶ���Ϊ�����״̬������ɾ�����������������Ӧ��ʾ��Ϣ
					names[i - 1] = null;
					System.out.println("������ɾ��");
				} else {
					System.out.println("����δ��ɣ�����ɾ��������");
				}
				break;
			case 5:// �塢��Ҫ����
				System.out.println("****************************���޲�Ʒ****************************");
				System.out.println("���\t����\t����\t����");// ѡ���Ʒ����������ʾ�����˵���š����ơ����ۡ�����������ʾ�û�����Ҫѡ��Ĳ�Ʒ��ż�����
				for (int j = 0; j < dishname.length; j++) {
					System.out.println((j + 1) + "\t" + dishname[j] + "\t" + price[j] + "\t" + praise[j]);
				} // ��ʾ��Ʒ��š���Ʒ�������ۡ�����������ʾ�û�����Ҫ���޵Ĳ�Ʒ�����ɶԲ�Ʒ�ĵ���

				while (true) {
					System.out.print("������Ҫ���޵Ĳ�Ʒ��ţ�");
					if (sc.hasNextInt()) {
						i = sc.nextInt();
						break;
					} else {
						System.out.println("�������Ʒ��ţ����֣���");
						String x = sc.next();
						continue;
					}
				}
				
				
				if (i > 0 && i <= 3) {
					praise[i - 1]++;
					System.out.println("���޳ɹ���");
				} else {
					System.out.println("��������ȷ��ţ�����");
				}
				break;
			}

		} while (choice != 6);// �����˳�ϵͳ// �˳�����ϵͳ����ʾ��ллʹ�ã���ӭ�´ι��١���
		System.out.println("ллʹ�ã���ӭ�´ι���");
		// �ߡ��л��˵�
		// �û��ɸ�����ʾ�����˵������빦�ܱ��ִ����Ӧ�Ĺ��ܣ�������1-5ʱ��ִ����Ӧ����
	}

}
