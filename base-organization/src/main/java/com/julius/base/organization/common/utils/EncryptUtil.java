package com.julius.base.organization.common.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.common.utils
 * @Author Julius Zhou
 * @Date 2020-12-27 23:23
 * @Description: 加密解密工具类
 */

@Slf4j
public class EncryptUtil {

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



}
