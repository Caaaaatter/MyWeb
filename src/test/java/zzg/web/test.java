package zzg.web;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;

/**
 * Created by zhangzhenguo
 * on 2018/6/28
 * info:
 */
public class test {


    public static void main(String[] args) {
        DataSource dataSource = dataSource();

    }
    public static DataSource dataSource() {

        Environment environment = new Environment() {
            @Override
            public boolean containsProperty(String s) {
                return false;
            }

            @Nullable
            @Override
            public String getProperty(String s) {
                return null;
            }

            @Override
            public String getProperty(String s, String s1) {
                return null;
            }

            @Nullable
            @Override
            public <T> T getProperty(String s, Class<T> aClass) {
                return null;
            }

            @Override
            public <T> T getProperty(String s, Class<T> aClass, T t) {
                return null;
            }

            @Override
            public String getRequiredProperty(String s) throws IllegalStateException {
                return null;
            }

            @Override
            public <T> T getRequiredProperty(String s, Class<T> aClass) throws IllegalStateException {
                return null;
            }

            @Override
            public String resolvePlaceholders(String s) {
                return null;
            }

            @Override
            public String resolveRequiredPlaceholders(String s) throws IllegalArgumentException {
                return null;
            }

            @Override
            public String[] getActiveProfiles() {
                return new String[0];
            }

            @Override
            public String[] getDefaultProfiles() {
                return new String[0];
            }

            @Override
            public boolean acceptsProfiles(String... strings) {
                return false;
            }
        };
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

}


