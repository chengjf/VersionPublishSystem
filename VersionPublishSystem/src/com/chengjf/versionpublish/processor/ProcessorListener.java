/*    
 * Copyright 2010 digital china financial software Inc.
 * All rights reserved.
 * project name: VersionPublishSystem
 * version:  VersionPublishSystemV1.0          
 *---------------------------------------------------
 * @FileName: ProcessorListener.java  
 * @Package:com.chengjf.processor  
 * @Description: TODO 
 * @author: chengjf  
 * @date:2014-8-3 下午12:31:06  
 * @version V1.0    
 */
package com.chengjf.versionpublish.processor;

/** 
 * @ClassName: ProcessorListener  
 * @Description: 处理过程监听器 
 * @author: CJF 
 * @date:2014-8-3 下午12:31:06   
 */
public interface ProcessorListener {

	/**  
	 * @Title: processStart  
	 * @Description: 处理过程开始 
	 * @param  
	 * @return void 
	 * @throws  
	 */
	public void processStart();
	
	/**  
	 * @Title: processEnd  
	 * @Description: 处理过程结束
	 * @param  
	 * @return void 
	 * @throws  
	 */
	public void processEnd();
	
}
