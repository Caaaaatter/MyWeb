package zzg.data.mybatis;

import org.springframework.stereotype.Repository;
import zzg.data.po.User;

/**
 * Created by zhangzhenguo
 * on 2018/6/22
 * info:用户操作
 */
@Repository
public interface UserDao {
    /**
     * 根据用户查找用户
     * @param userName  用户名
     * @return 用户信息
     */
    User findUserByUserName(String userName);


}
