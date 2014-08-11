/*    
 * Copyright 2010 digital china financial software Inc.
 * All rights reserved.
 * project name: VersionPublishSystem
 * version:  VersionPublishSystemV1.0          
 *---------------------------------------------------
 * @FileName: ConfigurationFactory.java  
 * @Package:com.chengjf.versionpublish.factory  
 * @Description: TODO 
 * @author: chengjf  
 * @date:2014-8-3 下午12:50:06  
 * @version V1.0    
 */
package com.chengjf.versionpublish.factory;

import java.util.Properties;

/** 
 * @ClassName: ConfigurationFactory  
 * @Description: TODO 
 * @author: CJF 
 * @date:2014-8-3 下午12:50:06   
 */
public class ConfigurationFactory {

	private static volatile ConfigurationFactory instance;
	private Properties properties;
	
	public static String DEV_INSTRUCTION_URL = "DEV_INSTRUCTION_URL"; 
	public static String DEV_INSTRUCTION_FILE_PATH = "DEV_INSTRUCTION_FILE_PATH";
	public static String JAVADOC_URL = "JAVADOC_URL";
	public static String JAVADOC_FILE_PATH = "JAVADOC_FILE_PATH";
	public static String OLD_SOURCE_CODE_URL = "OLD_SOURCE_CODE_URL";
	public static String OLD_SOURCE_CODE_FILE_PATH = "OLD_SOURCE_CODE_FILE_PATH";
	public static String NEW_SOURCE_CODE_URL = "NEW_SOURCE_CODE_URL";
	public static String NEW_SOURCE_CODE_FILE_PATH = "NEW_SOURCE_CODE_FILE_PATH"; 
	public static String OLD_DB_SOURCE_CODE_FILE_PATH = "OLD_DB_SOURCE_CODE_FILE_PATH"; 
	public static String NEW_DB_SOURCE_CODE_FILE_PATH = "NEW_DB_SOURCE_CODE_FILE_PATH"; 
	public static String UPDATE_RECORD_FILE_PATH = "UPDATE_RECORD_FILE_PATH";
	public static String VERSIONPUBLISH_RESULT_FILE_PATH = "VERSIONPUBLISH_RESULT_FILE_PATH";

	public static String OLD_VERSION = "OLD_VERSION";
	public static String OLD_VERSION_BASE_NUMBER = "OLD_VERSION_BASE_NUMBER";
	public static String NEW_VERSION = "NEW_VERSION";
	public static String NEW_VERSION_BASE_NUMBER = "NEW_VERSION_BASE_NUMBER";

	public static String DEV_INSTRUCTION_FILE_NAME = "DEV_INSTRUCTION_FILE_NAME";
	public static String JAVADOC_FILE_NAME = "JAVADOC_FILE_NAME";
	public static String DB_FULL_FILE_NAME = "DB_FULL_FILE_NAME"; 
	public static String DB_INCREMENT_FILE_NAME = "DB_INCREMENT_FILE_NAME";
	public static String NORMAL_FULL_FILE_NAME = "NORMAL_FULL_FILE_NAME";
	public static String NORMAL_INCREMENT_FILE_NAME = "NORMAL_INCREMENT_FILE_NAME";
	public static String SSO_FULL_FILE_NAME = "SSO_FULL_FILE_NAME";
	public static String SSO_INCREMENT_FILE_NAME = "SSO_INCREMENT_FILE_NAME";
	
	private ConfigurationFactory() {
		this.properties = new Properties();
	}
	
	public static ConfigurationFactory getInstance() {
		if(instance == null) {
			synchronized (ConfigurationFactory.class) {
				if(instance == null) {
					instance = new ConfigurationFactory();
				}
			}
		}
		return instance;
	}
	
	public void setField(String key, String value) {
		this.properties.setProperty(key, value);
	}
	
	public String getField(String key) {
		return this.properties.getProperty(key);
	}
}
