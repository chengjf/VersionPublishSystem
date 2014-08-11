/*    
 * Copyright 2010 digital china financial software Inc.
 * All rights reserved.
 * project name: VersionPublishSystem
 * version:  VersionPublishSystemV1.0          
 *---------------------------------------------------
 * @FileName: VersionPublishUtil.java  
 * @Package:com.chengjf.versionpublish.util  
 * @Description: TODO 
 * @author: chengjf  
 * @date:2014-8-3 下午12:43:18  
 * @version V1.0    
 */
package com.chengjf.versionpublish.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName: VersionPublishUtil
 * @Description: 工具类
 * @author: CJF
 * @date:2014-8-3 下午12:43:18
 */
public class VersionPublishUtil {

	/**
	 * @Title: renameFile
	 * @Description: 文件重命名
	 * @param @param file
	 * @param @param name
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static File renameFile(File file, String name) {
		String filePath = file.getAbsolutePath();
		String fileName = file.getName();
		String newFilePath = filePath.substring(0,
				filePath.length() - fileName.length())
				+ name;
		File newFile = new File(newFilePath);
		file.renameTo(newFile);
		return newFile;
	}

	/**
	 * @Title: compare
	 * @Description: 版本比较
	 * @param @param oldVersion
	 * @param @param newVersionn
	 * @param @param resultFilePath
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean compare(File oldVersion, File newVersionn,
			String resultFilePath) {
		// TODO
		return true;
	}

	/**
	 * @throws IOException
	 * @Title: compressToZip
	 * @Description: 压缩文件
	 * @param @param file
	 * @param @param zipName
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean compressToZip(File file, String zipName)
			throws IOException {
		ZipOutputStream zipOutputStream = null;
		try {
			File zipFile = new File(zipName);
			zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
			// 此处为了压缩文件的根目录即为源文件的根目录，而无需再有一层顶级目录
			if(file.isDirectory()) {
				for(File  f : file.listFiles()) {
					writeToZipFile(f, zipOutputStream, "");	
				}
			}else {
				writeToZipFile(file, zipOutputStream, "");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			zipOutputStream.flush();
			zipOutputStream.close();
		}

		return true;
	}

	/**
	 * @Title: executeCommand
	 * @Description: 执行命令行命令
	 * @param @param cmd
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String executeCommand(String cmd) {
		Process p;
		try {
			p = Runtime.getRuntime().exec(cmd);

			InputStream stdoutStream = new BufferedInputStream(
					p.getInputStream());
			StringBuffer buffer = new StringBuffer();
			for (;;) {
				int c = stdoutStream.read();
				if (c == -1) {
					break;
				}
				buffer.append((char) c);
			}
			String outputText = buffer.toString();
			stdoutStream.close();
			return outputText;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	private static void writeToZipFile(File file,
			ZipOutputStream zipOutputStream, String prefix) throws IOException {
		if (file.isDirectory()) {
			ZipEntry zipEntry = new ZipEntry(prefix + file.getName() + "/");
			zipOutputStream.putNextEntry(zipEntry);
			for (File f : file.listFiles()) {
				writeToZipFile(f, zipOutputStream, prefix + file.getName()
						+ "/");
			}
			zipOutputStream.closeEntry();
		} else {
			ZipEntry zipEntry = new ZipEntry(prefix + file.getName());
			zipOutputStream.putNextEntry(zipEntry);
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] b = new byte[256];
			while (fileInputStream.read(b) != -1) {
				zipOutputStream.write(b);
			}
			zipOutputStream.closeEntry();
		}
	}
}
