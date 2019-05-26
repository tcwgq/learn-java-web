package com.tcwgq.bookstore.order.junit.test;

import com.tcwgq.bookstore.util.PaymentUtil;

public class HmacTest {
	/**
	 * https://www.yeepay.com/app-merchant-proxy/node?
	 * p0_Cmd=Buy&p1_MerId=10001126856
	 * &p2_Order=111098BB1CBF4F23A9897FFFA526D32B&
	 * p3_Amt=0.01&p4_Cur=CNY&p5_Pid=&p6_Pcat=&p7_Pdesc=
	 * &p8_Url=http://localhost
	 * :8080/bookstore/OrderServlet?method=back&p9_SAF=0&
	 * pa_MP=&pd_FrpId=ABC-NET-B2C&pr_NeedResponse=1&hmac=35af1b3dd762d23c6918d1f29dea38ce
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String s = PaymentUtil.buildHmac("Buy", "10001126856",
				"111098BB1CBF4F23A9897FFFA526D32B", "0.01", "CNY", "", "", "",
				"http://localhost:8080/bookstore/OrderServlet?method=back",
				"0", "", "ABC-NET-B2C", "1",
				"69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");
		System.out.println(s);
	}
}
