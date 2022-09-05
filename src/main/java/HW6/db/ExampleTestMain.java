package HW6.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class ExampleTestMain {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        HW6.db.dao.CategoriesMapper categoriesMapper = sqlSession.getMapper(HW6.db.dao.CategoriesMapper.class);
        HW6.db.model.CategoriesExample categoriesExample = new HW6.db.model.CategoriesExample();

        categoriesExample.createCriteria().andIdEqualTo(1);

//        List<Categories> list = categoriesMapper.selectByExample(categoriesExample);
//        System.out.println(categoriesMapper.countByExample(categoriesExample));

        HW6.db.model.Categories selected = categoriesMapper.selectByPrimaryKey(2);
        System.out.println("ID: " + selected.getId() + "\ntitle: " + selected.getTitle());

        HW6.db.model.Categories categories = new HW6.db.model.Categories();
        //categories.setId(Long.valueOf(3));
        categories.setTitle("Test");
        categoriesMapper.insert(categories);
        sqlSession.commit();
    }

}
