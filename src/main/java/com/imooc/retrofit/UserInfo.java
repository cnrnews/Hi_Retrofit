package com.imooc.retrofit;

import java.io.Serializable;
import java.util.List;

/**
 * @Author lihl
 * @Date 2022/1/7 10:52
 * @Email 1601796593@qq.com
 */
public class UserInfo implements Serializable {
    private boolean admin;
    private int coinCount;
    private String email;
    private String icon;
    private int id;
    private String nickname;
    private String password;
    private String publicName;
    private String token;
    private int type;
    private String username;
    private List<?> chapterTops;
    private List<?> collectIds;
}
