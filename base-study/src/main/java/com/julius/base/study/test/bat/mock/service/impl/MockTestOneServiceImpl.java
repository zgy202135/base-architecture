package com.julius.base.study.test.bat.mock.service.impl;

import com.julius.base.study.test.bat.mock.service.MockTestOneService;
import com.julius.base.study.test.bat.mock.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: com.julius.base.study.test.bat.mock.service.impl
 * @ClassName: MockTestOneServiceImpl
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/4/7 13:52
 * @Version: 1.0
 */
@Service
public class MockTestOneServiceImpl implements MockTestOneService {

    @Autowired
    private OtherService otherService;

    /**
     * @param list
     * @return
     * @Description 拼接字符串
     */
    @Override
    public String getString(String list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(list);
        stringBuilder.append(otherService.getOtherString());
        return stringBuilder.toString();
    }
}
