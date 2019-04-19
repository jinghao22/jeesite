/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.message.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.message.entity.TextMessage;
import com.thinkgem.jeesite.modules.message.service.TextMessageService;

import java.io.*;
import java.net.URLEncoder;

/**
 * 文本信息Controller
 * @author jh
 * @version 2019-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/message/textMessage")
public class TextMessageController extends BaseController {

	@Autowired
	private TextMessageService textMessageService;
	
	@ModelAttribute
	public TextMessage get(@RequestParam(required=false) String id) {
		TextMessage entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = textMessageService.get(id);
		}
		if (entity == null){
			entity = new TextMessage();
		}
		return entity;
	}
	
	@RequiresPermissions("message:textMessage:view")
	@RequestMapping(value = {"list", ""})
	public String list(TextMessage textMessage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TextMessage> page = textMessageService.findPage(new Page<TextMessage>(request, response), textMessage); 
		model.addAttribute("page", page);
		return "modules/message/textMessageList";
	}

	@RequiresPermissions("message:textMessage:view")
	@RequestMapping(value = "form")
	public String form(TextMessage textMessage, Model model) {
		model.addAttribute("textMessage", textMessage);
		return "modules/message/textMessageForm";
	}

	@RequiresPermissions("message:textMessage:edit")
	@RequestMapping(value = "save")
	public String save(TextMessage textMessage, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, textMessage)){
			return form(textMessage, model);
		}
		textMessageService.save(textMessage);
		addMessage(redirectAttributes, "保存文本信息记录成功");
		return "redirect:"+Global.getAdminPath()+"/message/textMessage/?repage";
	}
	
	@RequiresPermissions("message:textMessage:edit")
	@RequestMapping(value = "delete")
	public String delete(TextMessage textMessage, RedirectAttributes redirectAttributes) {
		textMessageService.delete(textMessage);
		addMessage(redirectAttributes, "删除文本信息记录成功");
		return "redirect:"+Global.getAdminPath()+"/message/textMessage/?repage";
	}

	//文件下载
	@RequiresPermissions("message:textMessage:edit")
	@RequestMapping(value = "download")
	public void download(HttpServletRequest request, HttpServletResponse response,TextMessage textMessage) throws IOException{

		//下载的文件路径
		//String path = textMessage.getFilepath();
		String path = "D:/file"+"/"+"a.txt";
		//获取输入流
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
		//转码，免得文件名中文乱码
		String filename =  URLEncoder.encode(textMessage.getFilename(),"UTF-8");
		//设置文件下载头
		response.addHeader("Content-Disposition", "attachment;filename=" + filename + ".txt");
		//设置文件ContentType类型，这样设置，会自动判断下载文件类型
		response.setContentType("multipart/form-data");
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		int len = 0;
		while((len = bis.read()) != -1){
			out.write(len);
			out.flush();
		}
		out.close();
	}

}