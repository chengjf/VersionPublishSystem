/*    
 * Copyright 2010 digital china financial software Inc.
 * All rights reserved.
 * project name: VersionPublishSystem
 * version:  VersionPublishSystemV1.0          
 *---------------------------------------------------
 * @FileName: TestRenameFile.java  
 * @Package:com.chengjf.versionpublish.test  
 * @Description: TODO 
 * @author: chengjf  
 * @date:2014-8-3 下午1:44:56  
 * @version V1.0    
 */
package com.chengjf.versionpublish.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import com.chengjf.versionpublish.monitor.VersionPublishMonitor;
import com.chengjf.versionpublish.util.VersionPublishUtil;

/**
 * @ClassName: TestRenameFile
 * @Description: TODO
 * @author: CJF
 * @date:2014-8-3 下午1:44:56
 */
public class TestRenameFile {

	public static void main(String[] args) {
		File file = new File("a.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream outputStream = new FileOutputStream(file);
			String a = "测试\n我是大英雄\nβγαε";
			byte[] b = a.getBytes(Charset.forName("UTF-8"));
			outputStream.write(b);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(file.getAbsolutePath());
		File newFile = VersionPublishUtil.renameFile(file, "b.txt");
		System.err.println(newFile.getAbsolutePath());
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(newFile));
			String a = bufferedReader.readLine();
			while(a != null) {
				System.err.println(a);
				a = bufferedReader.readLine();
			}
			
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			file.delete();
			newFile.delete();
		}
	}
}
