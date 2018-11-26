package com.lgs.designpattern.utils;

import com.alibaba.druid.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lgs
 * @Date: 2018-11-16 08:45
 * @Description:
 */
public class PropertyUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static Map<String, String> map = new HashMap<>();

    static {
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/properties/config.ini");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            while(true) {
                String line = dataInputStream.readLine();
                if(StringUtils.isEmpty(line)) {
                    break;
                }
                String[] strs = line.split("=");
                map.put(strs[0].trim(), strs[1].trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("file not found ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getValue(String type, String defaultStr) {
        return map.get(type) == null? defaultStr : map.get(type);
    }
}
