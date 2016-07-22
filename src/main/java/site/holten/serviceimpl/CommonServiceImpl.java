package site.holten.serviceimpl;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.holten.service.CommonService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by holten.gao on 2016/7/22.
 */
public class CommonServiceImpl implements CommonService {
    private final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Override
    public void writerToJson(Object resp, HttpServletResponse response) {
        Gson gson=new Gson();
        responseString(gson.toJson(resp), response);
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
