package com.tcwgq.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Encoder;

/**
 * 文件下载并解决现实文件名乱码问题
 * 
 * @author lenovo
 * 
 */
public class DownloadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String fileName = "d:/稻香.mp3";
		String contentType = this.getServletContext().getMimeType(fileName);
		// URL编码，防止下载框中现实文件名乱码
		String encName = filenameEncoding("稻香.mp3", request);
		String contentDisposition = "attachment;filename=" + encName;
		InputStream is = new FileInputStream(fileName);
		response.setHeader("content-type", contentType);
		response.setHeader("content-disposition", contentDisposition);
		ServletOutputStream os = response.getOutputStream();
		IOUtils.copy(is, os);
		is.close();
	}

	private String filenameEncoding(String filename, HttpServletRequest request)
			throws IOException {
		String agent = request.getHeader("User-Agent"); // 获取浏览器
		if (agent.contains("Firefox")) {
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?"
					+ base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else if (agent.contains("MSIE")) {
			filename = URLEncoder.encode(filename, "utf-8");
		} else {
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}

}
