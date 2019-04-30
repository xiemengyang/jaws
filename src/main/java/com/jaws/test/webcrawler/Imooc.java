package com.jaws.test.webcrawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Package: com.jaws.test.webcrawler
 * @ClassName: Imooc
 * @Description: 单个问题页面对象
 * @Author: jaws
 * @CreateDate: 2018/12/17 19:54
 * @Version: 1.0
 */
public class Imooc {

    public static String className;
    public static final String patternStr = "<p class=\"shizan-name\" title=\".+?>(.+?)</p>";

    public Imooc(String url) {
/*
        //正则表达式获取问题描述
        pattern = Pattern.compile("js-qa-wenda.+?rich-text\">(.+?)</div>");
        matcher = pattern.matcher(codeSource);
        if (matcher.find()) {
            quesDescription = matcher.group(1).replace("<p>", "").replace("</p>", "");
        }

        //正则表达式获取答案列表
        //获取回答者name
        pattern = Pattern.compile("detail-name.+?>(.+?)</a>.+?answer-content.+?>(.+?)</div>");
        matcher = pattern.matcher(codeSource);
        while (matcher.find()) {
            String answer = matcher.group(2).replace("<p>", "");
            answer = answer.replace("</p>", "");
            answer = answer.replace("<br />", "");
            answers.put(matcher.group(1), answer);
        }

        //正则表达式获取下一个url   爬取获取相关问题的url
        //获取回答者name
        pattern = Pattern.compile("class=\"relwenda\".+?href=\"(.+?)\".+?</a>");
        matcher = pattern.matcher(codeSource);
        while (matcher.find()) {
            nextUrl = "http://www.imooc.com" + matcher.group(1);
            //防止相关文题是本问题无线循环下去
            if (!nextUrl.equals(quesUrl)) {
                break;
            }
        }*/
    }

    public static Map<Integer, String> getNameListByIndex(int index, String url) {
        //获取单个问题页面源码
        String codeSource = Spider.getSource(url);
        //正则表达式获取question
        //<p class="shizan-name" title="
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(codeSource);
        Map<Integer, String> map = new HashMap<>(16);
        while (matcher.find()) {
            className = matcher.group(1);
            //System.out.println(index++ + "：" + question);
            map.put(index, className);
            index++;
        }

        return map;
    }

    /**
     * @return void
     * @method main
     * @description 测试方法
     * @date: 2018/12/17 19:57
     * @author: jaws
     * @param0 args
     */
    public static void main(String[] args) {
        String url = "https://coding.imooc.com/?sort=2&page=1";
        getNameListByIndex(1, url);
    }
}
