/*    
 * Copyright 2010 digital china financial software Inc.
 * All rights reserved.
 * project name: VersionPublishSystem
 * version:  VersionPublishSystemV1.0          
 *---------------------------------------------------
 * @FileName: ISourceCodeManager.java  
 * @Package:com.chengjf.versionpublish.manager  
 * @Description: TODO 
 * @author: chengjf  
 * @date:2014-8-3 下午1:06:56  
 * @version V1.0    
 */
package com.chengjf.versionpublish.manager;

/** 
 * @ClassName: ISourceCodeManager  
 * @Description: TODO 
 * @author: CJF 
 * @date:2014-8-3 下午1:06:56   
 */
public interface ISourceCodeManager {
	
	public boolean download(String url, String filePath);
}
