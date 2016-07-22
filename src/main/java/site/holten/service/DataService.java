package site.holten.service;

import site.holten.dao.data_air_temp;

import java.util.List;

/**
 * Created by holten.gao on 2016/7/22.
 */
public interface DataService {
    public List<data_air_temp> queryAirTemp(long deviceid);
}
