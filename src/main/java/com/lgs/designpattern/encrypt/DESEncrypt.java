package com.lgs.designpattern.encrypt;

/**
 * @Auther: lgs
 * @Date: 2018-11-16 12:04
 * @Description:
 */
public class DESEncrypt implements EncryptService{
    @Override
    public void encryptStr(String string) {
        System.out.println(string + " DESEncrypt");
    }
}
