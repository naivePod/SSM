package com.lgs.utils;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Auther: lgs
 * @Date: 2018-11-14 11:40
 * @Description:将
 */
public class StringUtil {
    public static void main(String[] args) {
        StringUtil stringUtil = new StringUtil();
        Scanner in = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        Set<String> targetSet = new HashSet<>();
        List<String> notInSet = new ArrayList<>();

        List<String> list = new LinkedList<>();
        while (in.hasNext()) {
            String s = in.next();
            if(s.equals("end")) break;
            stringBuilder.append(s.toLowerCase());
            list.add(s.toLowerCase().trim());
        }
        System.out.println("第一次输入结束");
        while(in.hasNextLine()) {
            String s = in.nextLine();
            if(s.equals("end")) break;
            if(StringUtils.isEmpty(s)) continue;
            s = s.trim();
            String[] strs = s.split(" ");

            String newStr = "";
            if(strs.length>2) {
                System.out.println(s);
            }
            if(strs.length == 1) {
                newStr = strs[0].substring(strs[0].lastIndexOf(".")+1);
            } else {
                newStr = strs[strs.length-1];
            }

            newStr = newStr.replace(',', ' ').trim();
            targetSet.add(newStr.toLowerCase());
        }
        System.out.println("第二次输入结束");
        for(String str : list) {
            if(!targetSet.contains(str)) {
                notInSet.add(str);
            } else {
                targetSet.remove(str);
            }
        }
        for(String str : notInSet) {
            System.out.print("null " + str.toUpperCase()+",\n");
        }
        System.out.println("==========原视图不存在的字段==========");
        for(String str : targetSet) {
            System.out.println(str);
        }
    }
    public String transferToSql(String string) {
        StringBuilder sb = new StringBuilder();

        sb.append("li.LI_GOODS ");
        sb.append(string);
        sb.append(",");
        sb.append("\n");

        return sb.toString();

    }

}
