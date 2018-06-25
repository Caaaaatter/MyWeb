package zzg.config.securityConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zzg.data.mybatis.UserDao;
import zzg.data.po.User;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhenguo
 * on 2018/6/22
 * info:用户登录校验
 */
@Service
public class UserLoginDetailService implements UserDetailsService{
    Logger logger = LoggerFactory.getLogger( UserLoginDetailService.class );

    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Autowired
    DataSource dataSource;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findUserByUserName( s );
        if(user != null ){
            logger.info( "查询到酒店配置信息："+user.getUserName() );
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add( new SimpleGrantedAuthority( "ROLE_ACCESS" ) );
            return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),grantedAuthorities);
        }
        throw new UsernameNotFoundException( "用户名不存在!" );



    }
}
