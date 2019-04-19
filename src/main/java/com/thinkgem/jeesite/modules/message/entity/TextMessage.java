/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.message.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 文本信息Entity
 * @author jh
 * @version 2019-04-19
 */
public class TextMessage extends DataEntity<TextMessage> {
	
	private static final long serialVersionUID = 1L;
	private String filepath;		// 文件存放相对路径
	private String filetype;		// 文件类型:BJXX 表计信息文本
	private String filename;		// 文件名 表商系统通知收费系统传入
	private String extend;		// 预留
	
	public TextMessage() {
		super();
	}

	public TextMessage(String id){
		super(id);
	}

	@Length(min=0, max=32, message="文件存放相对路径长度必须介于 0 和 32 之间")
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	@Length(min=0, max=16, message="文件类型:BJXX 表计信息文本长度必须介于 0 和 16 之间")
	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	
	@Length(min=0, max=256, message="文件名 表商系统通知收费系统传入长度必须介于 0 和 256 之间")
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Length(min=0, max=256, message="预留长度必须介于 0 和 256 之间")
	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}
	
}