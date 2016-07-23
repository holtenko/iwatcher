package site.holten.service;

import site.holten.controller.vo.CommonListReq;
import site.holten.dao.*;

import java.util.List;

/**
 * Created by holten.gao on 2016/7/22.
 */
public interface DataService {
    public List<data_air_temp> queryAirTempList(CommonListReq commonListReq);

    public List<data_air_humidity> queryAirHumidityList(CommonListReq commonListReq);

    public List<data_atmosphere> queryAtmosphereList(CommonListReq commonListReq);

    public List<data_rainfall> queryRainfallList(CommonListReq commonListReq);

    public List<data_wind_direct> queryWindDirectList(CommonListReq commonListReq);

    public List<data_wind_speed> queryWindSpeedList(CommonListReq commonListReq);

    public List<data_solar_radiation> querySolarRadiationList(CommonListReq commonListReq);
}
