package zzg.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.FileCopyUtils;
import zzg.config.DataConfig.DataConfig;
import zzg.config.RootConfig;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhenguo
 * on 2018/6/22
 * info:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes ={DataConfig.class})
public class DataSourceTsst {
    @Resource
    private JdbcTemplate jdbcTemplate;
private Logger logger = LoggerFactory.getLogger(DataSourceTsst.class);
    @Test
    public void test(){
        Integer num = new Integer( "1" ) ;



        List<Map<String, Object>> maps = jdbcTemplate.queryForList( "SELECT * FROM USER" );


        System.out.println( maps );
        System.out.println( "-----------zhangzhenguo-----------值maps=" + maps+"," + "当前类=DataSourceTsst.test()" );

    }

    @Test
    public void test1(){

    }



}
