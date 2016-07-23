package site.holten.serviceimpl;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.holten.controller.vo.CommonListReq;
import site.holten.service.CommonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * Created by holten.gao on 2016/7/22.
 */
public class CommonServiceImpl implements CommonService {
    private final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Override
    public void writerToJson(HttpServletRequest request,Object resp, HttpServletResponse response) {
        Gson gson=new Gson();
        String callback = request.getParameter("callback");
        responseString( callback+"("+gson.toJson(resp)+ ")", response);
    }

    @Override
    public CommonListReq genCommonListReq(HttpServletRequest request) {
        long deviceid = Long.parseLong(request.getParameter("deviceid"));
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        if(startTime==null||"".equals(startTime)) startTime="2015-01-01 00:00:00";
        if(endTime==null||"".equals(endTime)) endTime= new Timestamp(System.currentTimeMillis()).toString();
        return new CommonListReq(deviceid,startTime,endTime);
    }

    private void responseString(String data, HttpServletResponse response) {
        response.setContentType("text/plain; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(data);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }
}
