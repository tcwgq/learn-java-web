package com.tcwgq.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tcwgq.utils.CommonUtils;

public class UploadServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 指定缓存大小与临时目录
		File temp = new File("d:/temp");
		if (!temp.exists())
			temp.mkdirs();
		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 20, temp);
		ServletFileUpload sf = new ServletFileUpload(factory);
		// 限制单个文件大小为100KB
		// sf.setFileSizeMax(1024 * 100);
		// 限制总大小为200KB
		// sf.setSizeMax(1024 * 100 * 2);
		try {
			List<FileItem> list = sf.parseRequest(request);
			FileItem fi = list.get(0);
			String fileName = fi.getName();
			int index = fileName.lastIndexOf("\\");
			if (index != -1) {
				fileName = fileName.substring(index + 1);
			}
			int result = fileName.hashCode();
			String hex = Integer.toHexString(result);
			String root = this.getServletContext()
					.getRealPath("/WEB-INF/files");
			String rootPath = root + "/" + hex.charAt(0) + "/" + hex.charAt(1);
			File rootFile = new File(rootPath);
			if (!rootFile.exists()) {
				rootFile.mkdirs();
			}
			String destFileName = rootPath + "/" + CommonUtils.uuid() + "_"
					+ fileName;
			fi.write(new File(destFileName));
			request.setAttribute("msg", "文件上传成功！");
			request.getRequestDispatcher("/success.jsp").forward(request,
					response);
		} catch (Exception e) {
			if (e instanceof FileUploadBase.FileSizeLimitExceededException) {
				request.setAttribute("msg", "上传的单个文件大小超过100KB");
				request.getRequestDispatcher("/form3.jsp").forward(request,
						response);
			} else {
				request.setAttribute("msg", "上传的总文件大小超过200KB");
				request.getRequestDispatcher("/form3.jsp").forward(request,
						response);
			}
		}
	}
}
