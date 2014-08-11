/*    
 * Copyright 2010 digital china financial software Inc.
 * All rights reserved.
 * project name: VersionPublishSystem
 * version:  VersionPublishSystemV1.0          
 *---------------------------------------------------
 * @FileName: TestComporessToZip.java  
 * @Package:com.chengjf.versionpublish.test  
 * @Description: TODO 
 * @author: chengjf  
 * @date:2014-8-3 下午6:52:52  
 * @version V1.0    
 */
package com.chengjf.versionpublish.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import com.chengjf.versionpublish.util.VersionPublishUtil;

/**
 * @ClassName: TestComporessToZip
 * @Description: TODO
 * @author: CJF
 * @date:2014-8-3 下午6:52:52
 */
public class TestComporessToZip {

	public static void main(String[] args) {
		File file = new File("V");
		try {
			if (!file.exists()) {
				file.mkdir();
				File aText = new File("./V/a.txt");
				aText.createNewFile();
				FileOutputStream outputStream = new FileOutputStream(aText);
				String a = "测试\n我是大英雄\nβγαεaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
				byte[] b = a.getBytes(Charset.forName("UTF-8"));
				for (int i = 0; i < 100; i++) {
					outputStream.write(b);
				}
				outputStream.flush();
				outputStream.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.err.println(System.currentTimeMillis());
			VersionPublishUtil.compressToZip(file, "V.zip");
			System.err.println(System.currentTimeMillis());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
