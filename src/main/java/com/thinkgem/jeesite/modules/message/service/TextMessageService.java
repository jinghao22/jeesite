/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.message.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.message.entity.TextMessage;
import com.thinkgem.jeesite.modules.message.dao.TextMessageDao;

/**
 * 文本信息Service
 * @author jh
 * @version 2019-04-19
 */
@Service
@Transactional(readOnly = true)
public class TextMessageService extends CrudService<TextMessageDao, TextMessage> {

	public TextMessage get(String id) {
		return super.get(id);
	}
	
	public List<TextMessage> findList(TextMessage textMessage) {
		return super.findList(textMessage);
	}
	
	public Page<TextMessage> findPage(Page<TextMessage> page, TextMessage textMessage) {
		return super.findPage(page, textMessage);
	}
	
	@Transactional(readOnly = false)
	public void save(TextMessage textMessage) {
		super.save(textMessage);
	}
	
	@Transactional(readOnly = false)
	public void delete(TextMessage textMessage) {
		super.delete(textMessage);
	}
	
}