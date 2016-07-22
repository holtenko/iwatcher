package site.holten.service;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by holten.gao on 2016/7/22.
 */
public interface CommonService {
    void writerToJson(Object resp, HttpServletResponse response);
}
