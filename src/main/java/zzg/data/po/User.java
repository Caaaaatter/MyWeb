package zzg.data.po;

import lombok.Data;

/**
 * Created by zhangzhenguo
 * on 2018/6/22
 * info:用戶信息
 */
@Data
public class User {
    private String id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;


}
