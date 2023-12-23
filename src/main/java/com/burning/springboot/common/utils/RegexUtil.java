package com.burning.springboot.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 还没有看
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 15:42
 */
public class RegexUtil {

    //测试地址
    // https://www.liaoxuefeng.com/wiki/1016959663602400/1017639890281664
    // https://www.cnblogs.com/ggjucheng/p/3423731.html


    public static void main(String[] args) {
        //如果直接给出字符，就是精确匹配。用\d可以匹配一个数字，\w可以匹配一个字母或数字
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile = Pattern.compile("00\\d");
        System.out.println(compile.pattern());
        Matcher matcher = compile.matcher("001");
        System.out.println(matcher.matches());


        // 用.可以匹配任意字符
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile1 = Pattern.compile("py.");

        // 用*表示任意个字符（包括0个）
        // 用+表示至少一个字符
        // 用?表示0个或1个字符
        // 用{n}表示n个字符
        // 用{n,m}表示n-m个字符
        // \d{3}表示匹配3个数字
        // \s可以匹配一个空格（也包括Tab等空白符），所以\s+表示至少有一个空格，例如匹配' '，'  '等；
        // \d{3,8}表示3-8个数字，例如'1234567'
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile2 = Pattern.compile("\\d{3}\\s+\\d{3,8}");
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile3 = Pattern.compile("\\d{3}\\-\\d{3,8}");
        Matcher matcher1 = compile2.matcher("010  12345");
        Matcher matcher3 = compile3.matcher("010-12345");
        System.out.println(matcher1.matches());
        System.out.println(matcher3.matches());

        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern compile4 = Pattern.compile("\\d{3}\\s+\\-\\s+\\d{3,8}");
        Matcher matcher4 = compile4.matcher("010 - 12345");
        System.out.println(matcher4.matches());

        System.out.println("======");
        Pattern compile5 = Pattern.compile("\\d+\\s");
        Matcher matcher5 = compile5.matcher("0101010101 ");
        System.out.println(matcher5.matches());

        String  str = "abc d";
        String substring = str.substring(0, str.indexOf(" "));
        System.out.println(substring.length());



        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        //简单工厂方法创建一个正则表达式,
        Pattern pattern = Pattern.compile("\\d+");

        //返回正则表达式的字符串形式
        System.out.println(pattern.pattern());

        //用于分隔字符串
        String[] str1 = pattern.split("我QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        for (String s : str1) {
            System.out.println(s);
        }

        // 适合用于只匹配一次,且匹配全部字符串
        Pattern.matches("\\d+", "2223");
        Pattern.matches("\\d+", "2223aa");
        Pattern.matches("\\d+", "22bb23");


        //想得到更强更便捷的正则匹配操作,那就需要将Pattern与Matcher一起合作,Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持.
        Matcher matcher11 = pattern.matcher("2234");
        Matcher matcher2 = pattern.matcher("2234aa");


        //对整个字符串进行匹配,只有整个字符串都匹配了才返回true
        System.out.println(matcher11.matches());
        System.out.println(matcher2.matches());

        Matcher matcher33 = pattern.matcher("aa2234");

        // 对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
        System.out.println(matcher2.lookingAt());
        System.out.println(matcher33.lookingAt());

        // 对字符串进行匹配,匹配到的字符串可以在任何位置.
        System.out.println(matcher11.find());
        System.out.println(matcher2.find());
        System.out.println(matcher33.find());

        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("aaa2223bb");
        m.find();
        //返回匹配到的子字符串在字符串中的索引位置.
        System.out.println(m.start());
        // 返回匹配到的子字符串的最后一个字符在字符串中的索引位置.(有歧义)
        System.out.println(m.end());
        // group()返回匹配到的子字符串
        System.out.println(m.group());

        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern p1 = Pattern.compile("\\d+\\w+");
        Matcher m1 = p1.matcher("2223bb");
        System.out.println(m1.matches());
        System.out.println(m1.start());
        System.out.println(m1.end());
        System.out.println(m1.group());

        //start(int i),end(int i),group(int i)专用于分组操作,Mathcer类还有一个groupCount()用于返回有多少组.
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        Pattern p2 = Pattern.compile("([a-z]+)(\\d+)");
        Matcher m2 = p2.matcher("aaa2223bb");
        System.out.println(m2.find());
        System.out.println(m2.groupCount());
        System.out.println(m2.group());
        //返回aaa,返回第一组匹配到的子字符串
        System.out.println(m2.group(1));
        System.out.println(m2.group(2));

    }
}
