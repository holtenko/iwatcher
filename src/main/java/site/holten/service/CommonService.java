package site.holten.service;

import site.holten.controller.vo.CommonListReq;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by holten.gao on 2016/7/22.
 */
public interface CommonService {
    void writerToJson(HttpServletRequest request,Object resp, HttpServletResponse response);
    CommonListReq genCommonListReq(HttpServletRequest request);
}
