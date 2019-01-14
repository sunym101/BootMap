package com.sunym.map.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunym.map.entity.ResultEntity;
import com.sunym.map.utils.DateUtil;

@Controller
public class WelcomeController {

	@RequestMapping("/welcomeapi")
	@ResponseBody
	public String welcomeapi() {
		String time = DateUtil.formatDateYMD3S(new Date());
		ResultEntity entity = new ResultEntity("0001", "Welcome to map application! Visit time = " + time);
		return entity.toJson();
	}

	@RequestMapping("/welcomepage")
	public String welcomepage(ModelMap map) {
		map.put("visittime", DateUtil.formatDateYMD3S(new Date()));
		// welcome.ftl 页面默认配置在 src/main/resources/templates下
		return "welcome";
	}
}
