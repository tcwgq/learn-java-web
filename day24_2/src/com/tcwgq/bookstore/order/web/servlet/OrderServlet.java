package com.tcwgq.bookstore.order.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.itcast.utils.CommonUtils;

import com.tcwgq.bookstore.cart.domain.Cart;
import com.tcwgq.bookstore.cart.domain.CartItem;
import com.tcwgq.bookstore.order.domain.Order;
import com.tcwgq.bookstore.order.domain.OrderItem;
import com.tcwgq.bookstore.order.exception.OrderException;
import com.tcwgq.bookstore.order.service.OrderService;
import com.tcwgq.bookstore.user.domain.User;
import com.tcwgq.bookstore.util.PaymentUtil;

public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service = new OrderService();

	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 创建订单
		Order order = new Order();
		order.setOid(CommonUtils.uuid());
		order.setOrdertime(new Date());
		order.setState(1);
		User user = (User) request.getSession().getAttribute("user");
		order.setUser(user);
		order.setTotal(cart.getTotal());
		// 创建订单项
		List<OrderItem> items = new ArrayList<OrderItem>();
		for (CartItem item : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setIid(CommonUtils.uuid());
			orderItem.setCount(item.getCount());
			orderItem.setOrder(order);
			orderItem.setBook(item.getBook());
			orderItem.setSubtotal(item.getSubtotal());
			items.add(orderItem);
		}
		order.setOrderItems(items);
		// 清空购物车
		cart.clear();
		// 添加订单
		try {
			service.add(order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("order", order);
		return "f:/jsps/order/desc.jsp";
	}

	public String showOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		String uid = user.getUid();
		List<Order> orders = service.showOrders(uid);
		request.setAttribute("orders", orders);
		return "f:/jsps/order/list.jsp";
	}

	public String loadOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String oid = request.getParameter("oid");
		Order order = service.getOrder(oid);
		request.setAttribute("order", order);
		return "f:/jsps/order/desc.jsp";
	}

	public String confirm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String oid = request.getParameter("oid");
		try {
			service.comfirm(oid);
			request.setAttribute("msg", "订单确认成功！");
		} catch (OrderException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/jsps/msg.jsp";
	}

	public String pay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("merchantInfo.properties");
		Properties props = new Properties();
		props.load(is);
		String p0_Cmd = "Buy";
		String address = request.getParameter("address");
		String p1_MerId = props.getProperty("p1_MerId");
		String p2_Order = request.getParameter("oid");
		String p3_Amt = "0.01";
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		String p8_Url = props.getProperty("p8_Url");
		String p9_SAF = "0";
		String pa_MP = "";
		String pd_FrpId = request.getParameter("pd_FrpId");
		String pr_NeedResponse = "1";
		service.updateOrderAddress(p2_Order, address);
		String keyValue = props.getProperty("keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
		StringBuilder sb = new StringBuilder(props.getProperty("url"));
		sb.append("?p0_Cmd=").append(p0_Cmd).append("&p1_MerId=")
				.append(p1_MerId).append("&p2_Order=").append(p2_Order)
				.append("&p3_Amt=").append(p3_Amt).append("&p4_Cur=")
				.append(p4_Cur).append("&p5_Pid=").append(p5_Pid)
				.append("&p6_Pcat=").append(p6_Pcat).append("&p7_Pdesc=")
				.append(p7_Pdesc).append("&p8_Url=").append(p8_Url)
				.append("&p9_SAF=").append(p9_SAF).append("&pa_MP=")
				.append(pa_MP).append("&pd_FrpId=").append(pd_FrpId)
				.append("&pr_NeedResponse=").append(pr_NeedResponse)
				.append("&hmac=").append(hmac);
		String url = sb.toString();
		response.sendRedirect(url);
		return null;
	}

	public String back(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("merchantInfo.properties");
		Properties props = new Properties();
		props.load(is);
		String keyValue = props.getProperty("keyValue");
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		String hmac = request.getParameter("hmac");
		boolean flag = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
				r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
				r8_MP, r9_BType, keyValue);
		if (!flag) {
			request.setAttribute("msg", "校验失败！");
			return "f:/jsps/msg.jsp";
		}
		service.back(r6_Order);
		// 实际过程中，易宝支付提供了两种应答机制
		if (r9_BType.equals("1")) {
			request.setAttribute("msg", "支付成功！等待卖家发货！");
			return "f:/jsps/msg.jsp";
		} else {
			response.getWriter().print("success!");
			request.setAttribute("msg", "支付成功！等待卖家发货！");
			return "f:/jsps/msg.jsp";
		}
	}

}
