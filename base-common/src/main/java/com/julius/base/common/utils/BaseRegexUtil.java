package com.julius.base.common.utils;

import com.julius.base.common.constants.BaseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: base-architecture
 * @Package com.julius.base.common.utils
 * @Author Julius Zhou
 * @Date 2020-05-04 10:12
 * @Description: 基础校验工具类
 */
@Component
public abstract class BaseRegexUtil {


    private static final Logger log = LoggerFactory.getLogger(BaseRegexUtil.class);

    /**
     * 校验固定电话
     * @param telephone
     * @return
     */
    public Boolean regexTelephone(String telephone){
        Assert.notNull(telephone,"telephone must not be null");
        Pattern r = Pattern.compile(BaseConstant.RegexConstant.TELEPHONE_REGEX);
        Matcher m = r.matcher(telephone);
        return m.matches();
    }

    /**
     * 校验手机号码
     * @param mobile
     * @return
     */
    public Boolean regexMobile(String mobile){
        Assert.notNull(mobile,"mobile must not be null");
        Pattern pattern = Pattern.compile(BaseConstant.RegexConstant.MOBILE_REGEX);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    /**
     * 校验密码
     * @param password
     * @return
     */
    public Boolean regexPassword(String password){
        Assert.notNull(password,"password must not be null");
        Pattern pattern = Pattern.compile(BaseConstant.RegexConstant.PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * 校验邮箱
     * @param emial
     * @return
     */
    public Boolean regexEmail(String emial){
        Assert.notNull(emial,"password must not be null");
        Pattern pattern = Pattern.compile(BaseConstant.RegexConstant.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(emial);
        return matcher.matches();
    }
}
