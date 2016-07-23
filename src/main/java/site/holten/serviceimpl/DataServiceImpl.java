package site.holten.serviceimpl;

import site.holten.controller.vo.CommonListReq;
import site.holten.dao.*;
import site.holten.dbhelper.DatabaseHelper;
import site.holten.service.DataService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by holten.gao on 2016/7/22.
 */
public class DataServiceImpl implements DataService {
    DatabaseHelper helper = new DatabaseHelper();

    @Override
    public List<data_air_temp> queryAirTempList(CommonListReq commonListReq) {
        String sql;
        if (commonListReq.getDeviceid() == -1) {
            sql = "SELECT deviceid,timestamp,value FROM data_air_temp WHERE " +
                    "timestamp >'" + Timestamp.valueOf(commonListReq.getStartTime()) +
                    "' and timestamp <'" + Timestamp.valueOf(commonListReq.getEndTime()) + "'";
        } else {
            sql = "SELECT timestamp,value FROM data_air_temp " +
                    "WHERE deviceid=" + commonListReq.getDeviceid() +
                    " and timestamp >'" + Timestamp.valueOf(commonListReq.getStartTime()) +
                    "' and timestamp <'" + Timestamp.valueOf(commonListReq.getEndTime()) + "'";
        }
        return helper.queryEntityList(data_air_temp.class, sql);
    }

    @Override
    public List<data_air_humidity> queryAirHumidityList(CommonListReq commonListReq) {
        String sql;
        if (commonListReq.getDeviceid() == -1) {
            sql = "SELECT deviceid,timestamp,value FROM data_air_humidity WHERE "+
                    "timestamp >'" + Timestamp.valueOf(commonListReq.getStartTime()) +
                    "' and timestamp <'" + Timestamp.valueOf(commonListReq.getEndTime()) + "'";
        } else {
            sql = "SELECT timestamp,value FROM data_air_humidity " +
                    "WHERE deviceid=" + commonListReq.getDeviceid() +
                    " and timestamp >'" + Timestamp.valueOf(commonListReq.getStartTime()) +
                    "' and timestamp <'" + Timestamp.valueOf(commonListReq.getEndTime()) + "'";
        }
        return helper.queryEntityList(data_air_humidity.class, sql);
    }

    @Override
    public List<data_atmosphere> queryAtmosphereList(CommonListReq commonListReq) {
        String sql = "SELECT deviceid,timestamp,value FROM data_atmosphere WHERE "+
                "timestamp >'" + Timestamp.valueOf(commonListReq.getStartTime()) +
                "' and timestamp <'" + Timestamp.valueOf(commonListReq.getEndTime()) + "'";
        return helper.queryEntityList(data_atmosphere.class, sql);
    }

    @Override
    public List<data_rainfall> queryRainfallList(CommonListReq commonListReq) {
        String sql = "SELECT deviceid,timestamp,value FROM data_rainfall WHERE "+
                "timestamp >'" + Timestamp.valueOf(commonListReq.getStartTime()) +
                "' and timestamp <'" + Timestamp.valueOf(commonListReq.getEndTime()) + "'";
        return helper.queryEntityList(data_rainfall.class, sql);
    }

    @Override
    public List<data_wind_direct> queryWindDirectList(CommonListReq commonListReq) {
        String sql = "SELECT deviceid,timestamp,value FROM data_wind_direct WHERE "+
                "timestamp >'" + Timestamp.valueOf(commonListReq.getStartTime()) +
                "' and timestamp <'" + Timestamp.valueOf(commonListReq.getEndTime()) + "'";
        return helper.queryEntityList(data_wind_direct.class, sql);
    }

    @Override
    public List<data_wind_speed> queryWindSpeedList(CommonListReq commonListReq) {
        String sql = "SELECT deviceid,timestamp,value FROM data_wind_speed WHERE "+
                "timestamp >'" + Timestamp.valueOf(commonListReq.getStartTime()) +
                "' and timestamp <'" + Timestamp.valueOf(commonListReq.getEndTime()) + "'";
        return helper.queryEntityList(data_wind_speed.class, sql);
    }

    @Override
    public List<data_solar_radiation> querySolarRadiationList(CommonListReq commonListReq) {
        String sql = "SELECT deviceid,timestamp,value FROM data_solar_radiation WHERE "+
                "timestamp >'" + Timestamp.valueOf(commonListReq.getStartTime()) +
                "' and timestamp <'" + Timestamp.valueOf(commonListReq.getEndTime()) + "'";
        return helper.queryEntityList(data_solar_radiation.class, sql);
    }
}
