package site.holten.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.holten.controller.vo.CommonListReq;
import site.holten.dao.*;
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
public class DataController {
    CommonService commonService = new CommonServiceImpl();
    DataService dataService = new DataServiceImpl();

    @RequestMapping("/airTemp")
    public void queryAirTemp(HttpServletRequest request, HttpServletResponse response) {
        CommonListReq commonListReq=commonService.genCommonListReq(request);
        List<data_air_temp> list = dataService.queryAirTempList(commonListReq);
        commonService.writerToJson(request, list, response);
    }

    @RequestMapping("/airHumidity")
    public void queryAirHumidity(HttpServletRequest request, HttpServletResponse response) {
        CommonListReq commonListReq=commonService.genCommonListReq(request);
        List<data_air_humidity> list = dataService.queryAirHumidityList(commonListReq);
        commonService.writerToJson(request, list, response);
    }

    @RequestMapping("/atmosphere")
    public void queryAtmosphere(HttpServletRequest request, HttpServletResponse response) {
        CommonListReq commonListReq=commonService.genCommonListReq(request);
        List<data_atmosphere> list = dataService.queryAtmosphereList(commonListReq);
        commonService.writerToJson(request, list, response);
    }

    @RequestMapping("/rainfall")
    public void queryRainfall(HttpServletRequest request, HttpServletResponse response) {
        CommonListReq commonListReq=commonService.genCommonListReq(request);
        List<data_rainfall> list = dataService.queryRainfallList(commonListReq);
        commonService.writerToJson(request, list, response);
    }

    @RequestMapping("/windDirect")
    public void queryWindDirect(HttpServletRequest request, HttpServletResponse response) {
        CommonListReq commonListReq=commonService.genCommonListReq(request);
        List<data_wind_direct> list = dataService.queryWindDirectList(commonListReq);
        commonService.writerToJson(request, list, response);
    }

    @RequestMapping("/windSpeed")
    public void queryWindSpeed(HttpServletRequest request, HttpServletResponse response) {
        CommonListReq commonListReq=commonService.genCommonListReq(request);
        List<data_wind_speed> list = dataService.queryWindSpeedList(commonListReq);
        commonService.writerToJson(request, list, response);
    }
    @RequestMapping("/solarRadiation")
    public void querySolarRadiation(HttpServletRequest request, HttpServletResponse response) {
        CommonListReq commonListReq=commonService.genCommonListReq(request);
        List<data_solar_radiation> list = dataService.querySolarRadiationList(commonListReq);
        commonService.writerToJson(request, list, response);
    }
}
