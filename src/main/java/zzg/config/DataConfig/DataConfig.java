package zzg.config.DataConfig;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DataConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();


        //DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl( "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8" );
        dataSource.setUsername( "root" );
        dataSource.setPassword( "newstart2017" );
       // dataSource.setDbType( "mysql" );
        dataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
        return dataSource;
   /* return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("schema.sql")
            .build();*/
    }


    @Bean
    @DependsOn("dataSource")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, ApplicationContext applicationContext) throws IOException{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("zzg.data.po");
        Resource[] mapperLocations = applicationContext.getResources("classpath:mapper/*.xml");
        sessionFactory.setMapperLocations(mapperLocations);
        return sessionFactory;
    }

    @Bean
    @DependsOn("sqlSessionFactoryBean")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("zzg.data.mybatis");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        return configurer;
    }



    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate( dataSource );
    }

}
