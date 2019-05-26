package com.tcwgq.bookstore.book.admin.web.servlet;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.utils.CommonUtils;

import com.tcwgq.bookstore.book.domain.Book;
import com.tcwgq.bookstore.book.service.BookService;
import com.tcwgq.bookstore.category.domain.Category;
import com.tcwgq.bookstore.category.service.CategoryService;

public class AdminAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookService service = new BookService();
	CategoryService categoryService = new CategoryService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 缓存大小与临时目录
		DiskFileItemFactory factory = new DiskFileItemFactory(15 * 1024,
				new File("d:/temp"));
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 校验图片大小
		sfu.setFileSizeMax(15 * 1024);
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			Map<String, String> map = new HashMap<String, String>();
			for (FileItem item : fileItemList) {
				if (item.isFormField()) {
					String fieldName = item.getFieldName();
					String filedValue = item.getString("UTf-8");
					map.put(fieldName, filedValue);
				}
			}
			Book book = CommonUtils.toBean(map, Book.class);
			book.setBid(CommonUtils.uuid());
			Category category = CommonUtils.toBean(map, Category.class);
			book.setCategory(category);
			String realPath = this.getServletContext().getRealPath("/book_img");
			String fileName = fileItemList.get(1).getName();
			if (fileName.contains("\\")) {
				fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			}
			// 校验图片格式
			if (!(fileName.toLowerCase().endsWith("jpg")
					|| fileName.toLowerCase().endsWith("png") || fileName
					.toLowerCase().endsWith("gif"))) {
				request.setAttribute("msg", "图片格式不正确！");
				request.setAttribute("categories", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
						.forward(request, response);
				return;
			}
			fileName = CommonUtils.uuid() + "_" + fileName;
			book.setImage("book_img/" + fileName);
			File file = new File(realPath, fileName);
			fileItemList.get(1).write(file);
			Image image = new ImageIcon(file.getAbsolutePath()).getImage();
			if (image.getHeight(null) > 200 || image.getWidth(null) > 200) {
				request.setAttribute("msg", "图片尺寸超过200*200！");
				file.delete();
				request.setAttribute("categories", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
						.forward(request, response);
				return;
			}
			service.addBook(book);
		} catch (Exception e) {
			if (e instanceof FileUploadBase.FileSizeLimitExceededException) {
				request.setAttribute("msg", "您上传的图片大小超出了15KB！");
				request.setAttribute("categories", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
						.forward(request, response);
				return;
			}
		}
		request.getRequestDispatcher("/admin/AdminBookServlet?method=findAll")
				.forward(request, response);
	}
}
