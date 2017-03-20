package com.mxz.mq.redis;

import com.zp.index.IndexWriter;
import com.zp.search.IndexSearch;
import redis.clients.jedis.Jedis;

/**
 * redis 排序测试
 * Created by MABIAO on 2017/3/20 0020.
 */
public class RedisSearch {


    public void test(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        IndexWriter iw=new IndexWriter(jedis);
        //addIdAndIndexItem(id,"切分后的字符串，中间以“|”分隔");
        iw.addIdAndIndexItem("1","Ruby|on|Rails|为什么|什么|如此|高效");
        iw.addNeedSortItem("price","23.9");//需要排序的item
        iw.addNeedSortItem("date","2012");
        iw.addNeedSortItem("author","Klein");
        iw.writer();

        iw=new IndexWriter(jedis);
        iw.addIdAndIndexItem("2","Ruby|么");
        iw.addNeedSortItem("price","12.9");
        iw.addNeedSortItem("date","2011");
        iw.addNeedSortItem("author","Kevin");
        iw.writer();

        IndexSearch is=new IndexSearch(jedis);
        System.out.println(is.search("Ruby"));
        System.out.println(is.search("price", IndexSearch.ASC, "Ruby"));
        jedis.disconnect();

        }

    public static void main(String args[]){
        new RedisSearch().test();
    }
}
