package com.lgs.designpattern.encrypt;

/**
 * @Auther: lgs
 * @Date: 2018-11-16 11:29
 * @Description:
 */
public class MD5Encrypt implements EncryptService {
    @Override
    public void encryptStr(String string) {
        System.out.println(string + " MD5");
    }
}
