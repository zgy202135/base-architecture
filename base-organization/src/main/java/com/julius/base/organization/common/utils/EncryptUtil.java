package com.julius.base.organization.common.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;
import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.common.utils
 * @Author Julius Zhou
 * @Date 2020-12-27 23:23
 * @Description: 加密解密工具类
 */

@Slf4j
@Component
public class EncryptUtil{

    //密码编码器
    private static PasswordEncoder passwordEncoder;

    /**
     * 初始化操作
     */
    @PostConstruct
    public void init(){
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info(passwordEncoder.toString());
    }


    /**
     * MD5加密
     * @param key
     * @return
     */
    public static String encrypt(String key){
        Assert.notNull(key,"Key must not be null");
        String encryptKey = DigestUtils.md5DigestAsHex(key.getBytes(StandardCharsets.UTF_8));
        log.info("加密前：【{}】,加密后：【{}】",key,encryptKey);
        return encryptKey;
    }

    /**
     * BCrypt加密
     * @param key
     * @return
     */
    public static String bcrypt(String key){
        Assert.notNull(key,"Key must not be null");
        return passwordEncoder.encode(key);
    }

    /**
     * 密码校验
     * @param password
     * @param key
     * @return
     */
    public static Boolean verifyPassword(String password,String key){
        Assert.notNull(password,"password must not be null");
        Assert.notNull(key,"Key must not be null");
        return passwordEncoder.matches(key,password);
    }


}
