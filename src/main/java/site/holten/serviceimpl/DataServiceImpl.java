package site.holten.serviceimpl;

import site.holten.dao.data_air_temp;
import site.holten.dbhelper.DatabaseHelper;
import site.holten.service.DataService;

import java.util.List;

/**
 * Created by holten.gao on 2016/7/22.
 */
public class DataServiceImpl implements DataService {
    @Override
    public List<data_air_temp> queryAirTemp(long deviceid) {
        DatabaseHelper helper=new DatabaseHelper();
        String sql = "SELECT timestamp,value FROM data_air_temp WHERE deviceid="+deviceid;
        List<data_air_temp> airTempList=helper.queryEntityList(data_air_temp.class,sql);
        return airTempList;
    }
}
