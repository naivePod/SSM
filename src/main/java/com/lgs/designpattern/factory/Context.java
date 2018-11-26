package com.lgs.designpattern.factory;

import com.lgs.designpattern.encrypt.EncryptService;
import com.lgs.designpattern.utils.PropertyUtil;

/**
 * @Auther: lgs
 * @Date: 2018-11-16 11:33
 * @Description:
 */
public class Context {
    public EncryptService create() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(PropertyUtil.getValue("encry", "com.lgs.designpattern.encrypt.MD5Encrypt"));
        return (EncryptService)clazz.newInstance();
    }

}
