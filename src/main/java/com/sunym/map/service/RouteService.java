package com.sunym.map.service;

import java.util.List;

import com.sunym.map.model.RouteModel;
import com.sunym.map.model.StationModel;

public interface RouteService {
	public List<RouteModel> getRoutes(String route_code);
	
	public RouteModel getSingleRoute(String route_code);
	
	public List<StationModel> getRouteStations(String route_code);
	
	public List<StationModel> getDriveStations(String route_code, String drv_date, String drv_time);
}
