package com.sunym.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunym.map.entity.ResultEntity;
import com.sunym.map.model.StationModel;
import com.sunym.map.service.RouteService;
import com.sunym.map.utils.StringUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MapController {

	@Autowired
	RouteService routeService;

	@RequestMapping("/routeStations")
	public String routeStations(ModelMap map, String routeCode) {
		log.debug("routeStations");
		ResultEntity entity = null;
		if (StringUtil.isEmpty(routeCode)) {
			entity = new ResultEntity("0002", "请求参数[routeCode]为空!");
		} else {
			List<StationModel> list = routeService.getRouteStations(routeCode);
			entity = new ResultEntity("0000", "OK");
			entity.setResult_info("stations", list);
		}
		return entity.toJson();
	}
}
