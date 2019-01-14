package com.sunym.map.controller.ftl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.sunym.map.entity.ResultEntity;
import com.sunym.map.model.RouteModel;
import com.sunym.map.model.StationModel;
import com.sunym.map.service.RouteService;
import com.sunym.map.utils.StringUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MapPageController {

	@Autowired
	RouteService routeService;

	@RequestMapping("/routeStationsPage")
	public String routeStationsPage(ModelMap map, String routeCode) {
		log.debug("routeStationsPage");
		ResultEntity entity = null;
		if (StringUtil.isEmpty(routeCode)) {
			entity = new ResultEntity("0002", "请求参数[routeCode]为空!");

			// 设置错误信息
			map.put("pageName", "routeStationsPage");
			map.put("errorMessage", entity.toJson());

			return "errorPage";// 跳转到ftl页面
		} else {
			RouteModel route = routeService.getSingleRoute(routeCode);
			if (route == null) {
				entity = new ResultEntity("0003", "数据不存在，routeCode = [" + routeCode + "]!");

				// 设置错误信息
				map.put("pageName", "routeStationsPage");
				map.put("errorMessage", entity.toJson());

				return "errorPage";// 跳转到ftl页面
			}

			List<StationModel> list = routeService.getRouteStations(routeCode);

			entity = new ResultEntity("0000", "OK");
			entity.setResult_info("stations", list);

			map.put("pageTitle", route.getRouteName());
			map.put("routeName", route.getRouteName());
			map.put("stationData", JSON.toJSONString(list));

			return "stationMap";// 跳转到ftl页面
		}
	}

	@RequestMapping("/driveStationsPage")
	public String driveStationsPage(ModelMap map, String routeCode, String driveDate, String driveShiftTime) {
		log.debug("driveStationsPage");
		ResultEntity entity = null;
		if (StringUtil.isEmpty(routeCode)) {
			entity = new ResultEntity("0002", "请求参数[routeCode]为空!");
			// 设置错误信息
			map.put("pageName", "routeStationsPage");
			map.put("errorMessage", entity.toJson());
			return "errorPage";// 跳转到ftl页面
		}

		if (StringUtil.isEmpty(driveDate)) {
			entity = new ResultEntity("0002", "请求参数[driveDate]为空!");
			// 设置错误信息
			map.put("pageName", "routeStationsPage");
			map.put("errorMessage", entity.toJson());
			return "errorPage";// 跳转到ftl页面
		}

		if (StringUtil.isEmpty(driveShiftTime)) {
			entity = new ResultEntity("0002", "请求参数[driveShiftTime]为空!");
			// 设置错误信息
			map.put("pageName", "routeStationsPage");
			map.put("errorMessage", entity.toJson());
			return "errorPage";// 跳转到ftl页面
		}

		RouteModel route = routeService.getSingleRoute(routeCode);
		if (route == null) {
			entity = new ResultEntity("0003", "数据不存在，routeCode = [" + routeCode + "]!");
			// 设置错误信息
			map.put("pageName", "routeStationsPage");
			map.put("errorMessage", entity.toJson());
			return "errorPage";// 跳转到ftl页面
		}

		// 获取站点数据
		List<StationModel> list = routeService.getDriveStations(routeCode, driveDate, driveShiftTime);
		if (list != null && list.size() > 0) {
			entity = new ResultEntity("0000", "OK");
			entity.setResult_info("stations", list);

			map.put("pageTitle", route.getRouteName());
			map.put("routeName", route.getRouteName());
			map.put("stationData", JSON.toJSONString(list));

			return "stationMap";// 跳转到ftl页面
		}

		entity = new ResultEntity("0003", "数据不存在，routeCode = [" + routeCode + "], driveDate=[" + driveDate + "], driveShiftTime=[" + driveShiftTime + "]!");
		// 设置错误信息
		map.put("pageName", "routeStationsPage");
		map.put("errorMessage", entity.toJson());
		return "errorPage";// 跳转到ftl页面
	}
}
