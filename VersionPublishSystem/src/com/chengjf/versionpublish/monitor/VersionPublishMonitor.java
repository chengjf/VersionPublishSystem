/*    
 * Copyright 2010 digital china financial software Inc.
 * All rights reserved.
 * project name: VersionPublishSystem
 * version:  VersionPublishSystemV1.0          
 *---------------------------------------------------
 * @FileName: VersionPublishMonitor.java  
 * @Package:com.chengjf.versionpublish.monitor  
 * @Description: TODO 
 * @author: chengjf  
 * @date:2014-8-3 下午1:12:18  
 * @version V1.0    
 */
package com.chengjf.versionpublish.monitor;

import com.chengjf.versionpublish.processor.Processor;
import com.chengjf.versionpublish.processor.ProcessorListener;

/**
 * @ClassName: VersionPublishMonitor
 * @Description: TODO
 * @author: CJF
 * @date:2014-8-3 下午1:12:18
 */
public class VersionPublishMonitor {

	// public void registerDownloadProcessorListener() {
	//
	// }
	//
	// public void registerBeforeProcessorListener() {
	//
	// }
	//
	// public void registerAntProcessorListener() {
	//
	// }
	//
	// public void registerCompareProcessorListener() {
	//
	// }
	//
	// public void registerAfterProcessorListener() {
	//
	// }

	// 计数
	private int total = 0;

	// 当前步骤
	private int current = 0;

	public void registerProcessorListener(Processor processor) {
		this.total++;
		final String className = processor.getClass().getName();

		processor.addProcessorListener(new ProcessorListener() {

			@Override
			public void processStart() {
				// TODO Auto-generated method stub
				System.out.println(className + " start at "
						+ System.currentTimeMillis());
			}

			@Override
			public void processEnd() {
				// TODO Auto-generated method stub
				System.out.println(className + " end at "
						+ System.currentTimeMillis());
				current++;
				System.err.println("当前已完成 " + current + "/" + total);
			}
		});
	}
	
}
