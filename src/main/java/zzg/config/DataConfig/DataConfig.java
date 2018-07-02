package zzg.config.DataConfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySource("classpath:/datasource.properties")
public class DataConfig implements EnvironmentAware {


    Environment environment;

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = "dataSource",destroyMethod = "close")
     public DataSource dataSource() {
        // BasicDataSource dataSource = new BasicDataSource();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl( environment.getProperty( "data_source_url" ) );
        dataSource.setUsername( environment.getProperty( "data_source_username" ) );
        dataSource.setPassword( environment.getProperty( "data_source_password" ) );
        // dataSource.setDbType( "mysql" );
        dataSource.setDriverClassName( environment.getProperty( "data_source_dirverclass" ) );
        dataSource.setMaxActive( Integer.parseInt( environment.getProperty( "data_source_maxActive" ) ) );
        dataSource.setMinIdle( Integer.parseInt( environment.getProperty( "data_source_minIdle" ) ) );
        dataSource.setMaxActive( Integer.parseInt( environment.getProperty( "data_source_maxWait" ) ) );
        dataSource.setTimeBetweenEvictionRunsMillis( Long.parseLong( environment.getProperty( "data_source_timeBetweenEvictionRunsMillis" ) ) );
        dataSource.setMinEvictableIdleTimeMillis( Long.parseLong( environment.getProperty( "data_source_minEvictableIdleTimeMillis" ) ) );
        dataSource.setPoolPreparedStatements( Boolean.parseBoolean( environment.getProperty( "data_source_poolPreparedStatements" ) ) );
        dataSource.setMaxPoolPreparedStatementPerConnectionSize( Integer.parseInt( environment.getProperty( "data_source_maxPoolPreparedStatementPerConnectionSize" ) ) );
        dataSource.setTestWhileIdle( Boolean.parseBoolean( environment.getProperty( "data_source_testWhileIdle" ) ) );
        dataSource.setTestOnBorrow( Boolean.parseBoolean( environment.getProperty( "data_source_testOnBorrow" ) ) );
        dataSource.setTestOnReturn( Boolean.parseBoolean( environment.getProperty( "data_source_testOnReturn" ) ) );
        return dataSource;

   /* return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("schema.sql")
            .build();*/
    }




    @Bean
    @DependsOn("dataSource")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, ApplicationContext applicationContext) throws IOException {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource( dataSource );
        sessionFactory.setTypeAliasesPackage( "zzg.data.po" );
        Resource[] mapperLocations = applicationContext.getResources( "classpath:mapper/*.xml" );
        sessionFactory.setMapperLocations( mapperLocations );
        return sessionFactory;
    }

    @Bean
    @DependsOn("sqlSessionFactoryBean")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage( "zzg.data.mybatis" );
        configurer.setSqlSessionFactoryBeanName( "sqlSessionFactoryBean" );
        return configurer;
    }


    @Bean
    @DependsOn("dataSource")
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate( dataSource );
    }
}
