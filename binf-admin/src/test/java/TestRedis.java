import me.binf.cache.CacheService;
import me.binf.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * Created by wangbin on 14-10-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:/conf/spring-cache.xml"})
public class TestRedis {

     @Autowired
     private CacheService cacheService;


    @Test
    public void test1(){

        File file = new File("D:/test.txt");

        System.out.println(file.exists());

        cacheService.put("test1",file);

        File obj = (File)cacheService.get("test1");

        //obj.toURI().

        try {
            byte[] bytes = new byte[1];

            InputStream inputStream = new FileInputStream(obj);

            while (true){
              int red =   inputStream.read(bytes,0,bytes.length);
                System.out.println("red:"+red);
                System.out.println("b:"+new String(bytes));
                if(red<0){
                    break;
                }

            }






            inputStream.close();
        }catch (Exception e){

        }




    }



}
