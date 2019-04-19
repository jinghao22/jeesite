/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.message.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.message.entity.TextMessage;

/**
 * 文本信息DAO接口
 * @author jh
 * @version 2019-04-19
 */
@MyBatisDao
public interface TextMessageDao extends CrudDao<TextMessage> {
	
}