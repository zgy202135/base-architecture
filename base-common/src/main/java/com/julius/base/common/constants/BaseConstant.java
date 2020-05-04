package com.julius.base.common.constants;

/**
 * @Title: base-architecture
 * @Package com.julius.base.common.BaseConstant
 * @Author Julius Zhou
 * @Date 2020-05-03 21:34
 * @Description: 基础常量池
 */
public class BaseConstant {


    //男性
    public static final int MALE = 0;

    //女性
    public static final int FEMALE = 1;

    //未删除
    public static final int DELETE_NO = 0;

    //已删除
    public static final int DELETE_YES = 1;


    //未知异常
    public static final String UNKNOWN_EXCEPTION = "未知异常";

    /**
     * 校验常量池
     */
    public class RegexConstant{
        //固定电话校验
        public static final String TELEPHONE_REGEX = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";
        //手机号码校验
        public static final String MOBILE_REGEX = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        //密码校验（以字母开头，长度在6~18之间，只能包含字母、数字和下划线）
        public static final String PASSWORD_REGEX = "^[a-zA-Z]\\w{5,17}$";
        //邮箱校验
        public static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    }

}
