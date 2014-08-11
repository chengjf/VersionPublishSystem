/*    
 * Copyright 2010 digital china financial software Inc.
 * All rights reserved.
 * project name: VersionPublishSystem
 * version:  VersionPublishSystemV1.0          
 *---------------------------------------------------
 * @FileName: Processor.java  
 * @Package:com.chengjf.processor  
 * @Description: TODO 
 * @author: chengjf  
 * @date:2014-8-3 下午12:29:59  
 * @version V1.0    
 */
package com.chengjf.versionpublish.processor;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: Processor  
 * @Description: TODO 
 * @author: CJF 
 * @date:2014-8-3 下午12:29:59   
 */
public abstract class Processor {

	// 监听器列表
	private List<ProcessorListener> processorListeners;
	
	public Processor() {
		this.processorListeners = new ArrayList<ProcessorListener>();
	}
	
	/**  
	 * @Title: process  
	 * @Description: 处理
	 * @param  
	 * @return void 
	 * @throws  
	 */
	protected abstract void process();
	
	/**  
	 * @Title: addProcessorListener  
	 * @Description: 添加监听 
	 * @param @param processorListener 
	 * @return void 
	 * @throws  
	 */
	public void addProcessorListener(ProcessorListener processorListener) {
		this.processorListeners.add(processorListener);
	}
	
	/**  
	 * @Title: execute  
	 * @Description: 供调用 
	 * @param  
	 * @return void 
	 * @throws  
	 */
	public void execute() {
		for(ProcessorListener listener : this.processorListeners) {
			listener.processStart();
		}
		this.process();
		for(ProcessorListener listener : this.processorListeners) {
			listener.processEnd();
		}
	}
}
