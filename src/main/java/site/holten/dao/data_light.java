package site.holten.dao;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by holten.gao on 2016/7/22.
 */
@Data
public class data_light {
	long deviceid;
	Timestamp timestamp;
	float value;
}
