package com.julius.base.study.test.bat.mock.service.impl;

import com.julius.base.study.test.bat.mock.service.OtherService;
import org.springframework.stereotype.Service;

/**
 * @Package: com.julius.base.study.test.bat.mock.service.impl
 * @ClassName: OtherServiceImpl
 * @Author: Julius
 * @Description: 第三方接口实现
 * @Date: 2020/4/8 15:02
 * @Version: 1.0
 */
@Service
public class OtherServiceImpl implements OtherService {
    @Override
    public String getOtherString() {
        return "other";
    }
}
