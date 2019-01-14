package com.sunym.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunym.map.mapper.RouteMapper;
import com.sunym.map.model.RouteModel;
import com.sunym.map.model.StationModel;
import com.sunym.map.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteMapper routeMapper;

	@Override
	public List<RouteModel> getRoutes(String route_code) {
		return routeMapper.getRoute(route_code);
	}

	@Override
	public RouteModel getSingleRoute(String route_code) {
		List<RouteModel> list = routeMapper.getRoute(route_code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<StationModel> getRouteStations(String route_code) {
		return routeMapper.getRouteStations(route_code);
	}

	@Override
	public List<StationModel> getDriveStations(String route_code, String drv_date, String drv_time) {
		return routeMapper.getDriveStations(route_code, drv_date, drv_time);
	}
}
