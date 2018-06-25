/*
package spittr.config;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.ArrayList;
import java.util.Collection;

@Configuration

public class DataConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl( "jdbc:mysql://localhost:3306/test" );
        dataSource.setUsername( "root" );
        dataSource.setPassword( "newstart2017" );
        dataSource.setDbType( "mysql" );
        dataSource.setDrverClassName( "com.mysql.jdbc.Driver" );


        return dataSource;
   */
/* return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("schema.sql")
            .build();*//*

    }


    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    }




    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate( dataSource );
    }

}
*/
