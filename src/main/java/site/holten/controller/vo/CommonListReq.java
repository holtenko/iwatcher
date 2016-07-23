package site.holten.controller.vo;

import lombok.Data;

/**
 * Created by holten on 2016/7/23.
 */
@Data
public class CommonListReq {
    long deviceid;
    String startTime;
    String endTime;

    public CommonListReq(long deviceid, String startTime, String endTime) {
        this.deviceid = deviceid;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
