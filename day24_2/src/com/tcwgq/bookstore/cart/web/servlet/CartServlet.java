package com.tcwgq.bookstore.cart.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.tcwgq.bookstore.book.domain.Book;
import com.tcwgq.bookstore.book.service.BookService;
import com.tcwgq.bookstore.cart.domain.Cart;
import com.tcwgq.bookstore.cart.domain.CartItem;

/**
 * 只有用户登录后才有购物车，没登录的话，没有车 需要修改前面用户登录的方法，添加一辆购物车
 * 
 * @author lenovo
 * 
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		String bid = request.getParameter("bid");
		Book book = new BookService().findById(bid);
		int count = Integer.parseInt(request.getParameter("count"));
		CartItem item = new CartItem();
		item.setBook(book);
		item.setCount(count);
		cart.add(item);
		return "f:/jsps/cart/list.jsp";
	}

	public String remove(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		String bid = request.getParameter("bid");
		cart.remove(bid);
		return "f:/jsps/cart/list.jsp";
	}

	public String clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.clear();
		return "f:/jsps/cart/list.jsp";
	}

}
