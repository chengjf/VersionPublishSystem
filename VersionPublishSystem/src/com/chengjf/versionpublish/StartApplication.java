/*    
 * Copyright 2010 digital china financial software Inc.
 * All rights reserved.
 * project name: VersionPublishSystem
 * version:  VersionPublishSystemV1.0          
 *---------------------------------------------------
 * @FileName: StartApplication.java  
 * @Package:com.chengjf.versionpublish  
 * @Description: TODO 
 * @author: chengjf  
 * @date:2014-8-3 下午1:10:49  
 * @version V1.0    
 */
package com.chengjf.versionpublish;

import com.chengjf.versionpublish.monitor.VersionPublishMonitor;
import com.chengjf.versionpublish.processor.impl.AfterProcessor;
import com.chengjf.versionpublish.processor.impl.AntProcessor;
import com.chengjf.versionpublish.processor.impl.BeforeProcessor;
import com.chengjf.versionpublish.processor.impl.CompareProcessor;
import com.chengjf.versionpublish.processor.impl.DownloadProcessor;

/**
 * @ClassName: StartApplication
 * @Description: TODO
 * @author: CJF
 * @date:2014-8-3 下午1:10:49
 */
public class StartApplication {

	public static void main(String[] args) {
		
		VersionPublishMonitor monitor = new VersionPublishMonitor();
		
		DownloadProcessor downloadProcessor = new DownloadProcessor();
		monitor.registerProcessorListener(downloadProcessor);
		
		BeforeProcessor beforeProcessor = new BeforeProcessor();
		monitor.registerProcessorListener(beforeProcessor);
		
		AntProcessor antProcessor = new AntProcessor();
		monitor.registerProcessorListener(antProcessor);
		
		CompareProcessor compareProcessor = new CompareProcessor();
		monitor.registerProcessorListener(compareProcessor);
		
		AfterProcessor afterProcessor = new AfterProcessor();
		monitor.registerProcessorListener(afterProcessor);
		
		downloadProcessor.execute();
		beforeProcessor.execute();
		antProcessor.execute();
		compareProcessor.execute();
		afterProcessor.execute();
	}
}
