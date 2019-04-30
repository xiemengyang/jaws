package com.jaws.test.webcrawler;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.jaws.test.webcrawler
 * @ClassName: Main
 * @Description: 作用描述
 * @Author: jaws
 * @CreateDate: 2018/12/17 19:53
 * @Version: 1.0
 */

public class Main {

    public static void main(String[] args) {
        String url = "https://coding.imooc.com/?sort=2&page=";
        //List<Imooc> imoocs = new ArrayList<Imooc>();
        Map<Integer, String> map = new HashMap<>(16);
        int count = 6;

        //限定爬取数量
        for (int page = 1; page <= count; page++) {
            String pageUrl = url + page;
            System.out.println("爬取页面：" + pageUrl);
            int index = map.size()>0?map.size()+1:1;
            map.putAll(Imooc.getNameListByIndex(index, pageUrl));
        }
        String str = null;
        System.out.println(map.size());
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer indexInt = entry.getKey();
            boolean flag1 = indexInt <= 9;
            boolean flag2 = indexInt > 9 && indexInt < 100;
            str = flag1?"00"+indexInt:(flag2?"0"+indexInt:String.valueOf(entry.getKey()));
            System.out.println(str + "：" + entry.getValue());
        }

    }
}
