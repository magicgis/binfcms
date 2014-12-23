import com.caucho.hessian.client.HessianProxyFactory;
import me.binf.api.PostServiceApi;

/**
 * Created by wangbin on 2014/12/23.
 */
public class HessionTest {

    public static void main(String[] args) {

        try {

            String url = "http://localhost:8080/admin/api/admin/postService";
            HessianProxyFactory factory = new HessianProxyFactory();
            factory.setOverloadEnabled(true);
            PostServiceApi basic = (PostServiceApi) factory.create(PostServiceApi.class, url);
            System.out.println(basic.hello());


        }catch (Exception e){

            e.printStackTrace();
        }



    }
}
