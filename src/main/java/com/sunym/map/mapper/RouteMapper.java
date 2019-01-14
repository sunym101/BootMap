package com.sunym.map.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunym.map.model.RouteModel;
import com.sunym.map.model.StationModel;

/**
 * dao层接口
 * 
 * @author Sunyongmeng
 * @since 2019-01-03
 */
@Mapper
public interface RouteMapper {

	List<RouteModel> getRoute(@Param("route_code") String route_code);

	List<StationModel> getRouteStations(@Param("route_code") String route_code);

	List<StationModel> getDriveStations(@Param("route_code") String route_code, @Param("drv_date") String drv_date, @Param("drv_time") String drv_time);

}
