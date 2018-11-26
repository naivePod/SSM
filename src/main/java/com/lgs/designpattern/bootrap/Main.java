package com.lgs.designpattern.bootrap;

import com.lgs.designpattern.factory.Context;

import javax.servlet.FilterChain;

/**
 * @Auther: lgs
 * @Date: 2018-11-16 10:53
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        new Context().create().encryptStr("abc");

    }
}
