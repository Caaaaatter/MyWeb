package zzg.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import zzg.config.servlet.druid.DruidStatView;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.WebServiceContext;

/**
 * Created by zhangzhenguo
 * on 2018/6/29
 * info:
 */

public class WebInitalizer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {


    }
}
