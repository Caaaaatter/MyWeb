package zzg.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
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

    @Test
    public void test(){

        List<Map<String, Object>> maps = jdbcTemplate.queryForList( "SELECT * FROM USER" );
        System.out.println( maps );
    }
}
