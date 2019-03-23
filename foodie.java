package 吃货联盟;

import java.util.Scanner;

public class foodie {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] names = new String[5];// 订餐人姓名
		String[] address = new String[5];// 订餐地址
		String[] menu = new String[5];// 订餐信息
		int[] time = new int[5];// 送餐时间
		double[] money = new double[5];// 总金额
		boolean[] state = new boolean[5];// true 代表已完成， false代表已预订

		String[] dishname = { "黄焖鸡", "鱼香肉丝", "宫保鸡丁" };// 菜品名
		double[] price = { 12, 14, 16 };// 单价
		int[] praise = new int[3];// 点赞
		int choice = 0;
		System.out.println("欢迎使用“吃货联盟点餐系统”");
		do {
			System.out.println("************************************************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("************************************************************");
			System.out.print("请选择：");
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
				if (choice < 0 || choice > 6) {
					System.out.println("请输入1-6的选项：");
					continue;
				}
			} else {
				System.out.println("请输入数字选项：");
				String x = sc.next();
				continue;
			}

			switch (choice) {
			case 1:// 一、我要订餐
				System.out.println("****************************欢迎订餐****************************");
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						System.out.print("请输入姓名：");// 订餐人姓名：要求用户输入
						names[i] = sc.next();
						System.out.println("序号\t菜名\t单价\t点赞");// 选择菜品及份数：显示三个菜单序号、名称、单价、点赞数，提示用户输入要选择的菜品序号及份数
						for (int j = 0; j < dishname.length; j++) {
							System.out.println((j + 1) + "\t" + dishname[j] + "\t" + price[j] + "\t" + praise[j]);
						}
						int food = 0;
						while (true) {
							System.out.print("请选择菜品：");
							if (sc.hasNextInt()) {
								food = sc.nextInt();
								if (food < 1 || food > 3) {
									System.out.println("请输入1-3的菜品：");
									continue;
								} else {
									break;
								}
							} else {
								System.out.println("请输入数字选项：");
								String x = sc.next();
								continue;
							}
						}

						int num;
						while (true) {
							System.out.print("请输入份数");
							if (sc.hasNextInt()) {
								num = sc.nextInt();
								break;
							} else {
								System.out.println("请输入正确份数（数字）：");
								String x = sc.next();
								continue;
							}
						}
						
						menu[i] = dishname[food - 1] + "\t" + num + "份";
						System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐）:");// 送餐时间：要求当天10到20点间整点送餐，要求用户输入10-20的整数，输入错误，重复输入
						do {
							if (sc.hasNextInt()) {
								time[i] = sc.nextInt();
								if (time[i] < 10 || time[i] > 20) {
									System.out.print("请在10-20点时间段内下单：");
								}
							} else {
								System.out.println("请输入正确时间：");
								String x = sc.next();// 清理非数字字符
							}
						} while (time[i] < 10 || time[i] > 20);
						System.out.print("请输入送餐地址：");// 送餐地址：要求用户输入
						address[i] = sc.next();
						money[i] = price[food - 1] * num;
						money[i] += money[i] >= 50 ? 0 : 6;// 总金额：总金额=菜品单价*份数+送餐费（送餐费：当单笔订单金额达到50元时，免送餐费，否则，需缴纳6元送餐费）
						state[i] = false;// 状态：两种状态：false：已预定（默认状态） true：已完成（订单已签收）
						System.out.println("订餐成功！" + menu[i]);// 订餐成功后，显示订单信息
						break;
					}
				}
				break;
			case 2:// 二、查看订单
				System.out.println("****************************查看订单****************************");
				System.out.println("订单餐号\t订餐人\t具体餐品信息\t送餐日期\t送餐地址\t总金额\t订单状态");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {// 遍历显示已有订单
						String stat = state[i] == true ? "已完成" : "已预定";// 内容包括：序号、订餐人姓名、订餐信息（菜品名和份数）、送餐时间、送餐地址、状态（已预定或已完成）、总金额
						System.out.println((i + 1) + "\t" + names[i] + "\t" + menu[i] + "\t" + time[i] + "\t"
								+ address[i] + "\t" + money[i] + "\t" + stat);
					}
				}
				break;
			case 3:// 三、签收订单
				System.out.println("****************************签收订单****************************");
				System.out.println("订单餐号\t订餐人\t具体餐品信息\t送餐日期\t送餐地址\t总金额\t订单状态");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {// 遍历显示已有订单
						String stat = state[i] == true ? "已完成" : "已预定";// 内容包括：序号、订餐人姓名、订餐信息（菜品名和份数）、送餐时间、送餐地址、状态（已预定或已完成）、总金额
						System.out.println((i + 1) + "\t" + names[i] + "\t" + menu[i] + "\t" + time[i] + "\t"
								+ address[i] + "\t" + money[i] + "\t" + stat);
					}
				}
				while (true) {
					int i;
					
					while (true) {
						System.out.println("请输入您要签收的订单(按0退出)：");
						if (sc.hasNextInt()) {
							i = sc.nextInt();
							break;
						} else {
							System.out.println("请输入订单（数字）：");
							String x = sc.next();
							continue;
						}
					}
					
					if (i>0&&names[i - 1] != null && !state[i - 1]) {
						state[i - 1] = true;// 将订单中状态改为已完成
						System.out.println("订单已签收成功！");
						break;
					} else if (i>0&&state[i - 1]) {
						System.out.println("此订单已完成！不能重复签收！！！");
						System.out.println("请重新输入（输入0退出）：");
					} else if(i==0){
						break;
					}else{
						System.out.println("无此订单！！！");
						System.out.println("请重新输入（输入0退出）：");
					}
				}
				break;
			case 4:// 四、删除订单
				System.out.println("****************************删除订单****************************");
				System.out.println("订单餐号\t订餐人\t具体餐品信息\t送餐日期\t送餐地址\t总金额\t订单状态");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {// 遍历显示已有订单
						String stat = state[i] == true ? "已完成" : "已预定";// 内容包括：序号、订餐人姓名、订餐信息（菜品名和份数）、送餐时间、送餐地址、状态（已预定或已完成）、总金额
						System.out.println((i + 1) + "\t" + names[i] + "\t" + menu[i] + "\t" + time[i] + "\t"
								+ address[i] + "\t" + money[i] + "\t" + stat);
					}
				}

				int i;
				while (true) {
					System.out.print("请输入要删除的订单：");
					if (sc.hasNextInt()) {
						i = sc.nextInt();
						if(i>0&&names[i-1]==null) {
							System.out.println("该订单不存在，请重新输入：");
						}else if(i>0&&i<=5&&names[i-1]!=null) {
							break;
						}else {
							System.out.println("输入错误，请输入已有的订单：");
						}
					} else {
						System.out.println("请输入订单（数字）：");
						String x = sc.next();
						continue;
					}
				}
				
				
				if (state[i - 1]) {// 用户输入订单序列号，如该序列号订单为已完成状态，可以删除，其他情况给出相应提示信息
					names[i - 1] = null;
					System.out.println("订单以删除");
				} else {
					System.out.println("订单未完成，不能删除！！！");
				}
				break;
			case 5:// 五、我要点赞
				System.out.println("****************************点赞菜品****************************");
				System.out.println("序号\t菜名\t单价\t点赞");// 选择菜品及份数：显示三个菜单序号、名称、单价、点赞数，提示用户输入要选择的菜品序号及份数
				for (int j = 0; j < dishname.length; j++) {
					System.out.println((j + 1) + "\t" + dishname[j] + "\t" + price[j] + "\t" + praise[j]);
				} // 显示菜品序号、菜品名、单价、点赞数，提示用户输入要点赞的菜品序号完成对菜品的点赞

				while (true) {
					System.out.print("请输入要点赞的餐品序号：");
					if (sc.hasNextInt()) {
						i = sc.nextInt();
						break;
					} else {
						System.out.println("请输入餐品序号（数字）：");
						String x = sc.next();
						continue;
					}
				}
				
				
				if (i > 0 && i <= 3) {
					praise[i - 1]++;
					System.out.println("点赞成功！");
				} else {
					System.out.println("请输入正确序号！！！");
				}
				break;
			}

		} while (choice != 6);// 六、退出系统// 退出整个系统，显示“谢谢使用，欢迎下次光临”。
		System.out.println("谢谢使用，欢迎下次光临");
		// 七、切换菜单
		// 用户可根据显示的主菜单，输入功能编号执行相应的功能，当输入1-5时，执行相应功能
	}

}
