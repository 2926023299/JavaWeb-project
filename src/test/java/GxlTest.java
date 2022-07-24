
import com.gxl.dao.CartDao;
import com.gxl.dao.ProductDao;
import com.gxl.dao.TypeDao;
import com.gxl.model.Cart;
import com.gxl.model.PageBean;
import com.gxl.model.Product;
import com.gxl.model.Type;
import com.gxl.service.ProductService;
import com.gxl.service.impl.ProductServiceImpl;
import com.gxl.utils.MybatisTool;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class GxlTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        CartDao mapper = sqlSession.getMapper(CartDao.class);

        Cart cart = mapper.hasCart(7, 14);
        System.out.println(cart);
    }

    @Test
    public void testCartGetAll() {
        SqlSession sqlSession = MybatisTool.getSqlSession();

        CartDao mapper = sqlSession.getMapper(CartDao.class);

        List<Cart> all = mapper.findAll(7);

        for (Cart cart : all) {
            System.out.println(cart);
        }
    }
}
