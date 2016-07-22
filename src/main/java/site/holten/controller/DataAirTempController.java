package site.holten.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.holten.dao.data_air_temp;
import site.holten.service.CommonService;
import site.holten.service.DataService;
import site.holten.serviceimpl.CommonServiceImpl;
import site.holten.serviceimpl.DataServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by holten.gao on 2016/7/22.
 */
@Controller
public class DataAirTempController {
	CommonService commonService = new CommonServiceImpl();
	DataService dataService = new DataServiceImpl();

	@RequestMapping("/airTemp")
	public void queryAirTemp(HttpServletRequest request, HttpServletResponse response) {
		//long deviceid=Long.parseLong(request.getParameter("deviceid"));
		long deviceid=10500001;
		List<data_air_temp> airTempList=dataService.queryAirTemp(deviceid);
		commonService.writerToJson(airTempList, response);
	}
}
