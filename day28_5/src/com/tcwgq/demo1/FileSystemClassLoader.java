package com.tcwgq.demo1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileSystemClassLoader extends ClassLoader {
	private String classpath;

	public FileSystemClassLoader() {
	}

	public FileSystemClassLoader(String classpath) {
		this.classpath = classpath;
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] datas = getClassData(name);
			if (datas == null) {
				throw new ClassNotFoundException("类没有找到：" + name);
			}
			return this.defineClass(name, datas, 0, datas.length);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ClassNotFoundException("类找不到：" + name);
		}
	}

	private byte[] getClassData(String name) throws IOException {
		name = name.replace(".", "\\") + ".class";
		File classFile = new File(classpath, name);
		return FileUtils.readFileToByteArray(classFile);
	}
}
