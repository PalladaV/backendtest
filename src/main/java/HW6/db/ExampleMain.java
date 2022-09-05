package HW6.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class ExampleMain {

    public static void main( String[] args ) throws IOException {
        SqlSession session = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new
                    SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            HW6.db.dao.CategoriesMapper categoriesMapper = session.getMapper(HW6.db.dao.CategoriesMapper.class);
            HW6.db.model.CategoriesExample example = new HW6.db.model.CategoriesExample();

            example.createCriteria().andIdEqualTo(1);
            List<HW6.db.model.Categories> list = categoriesMapper.selectByExample(example);
            System.out.println(categoriesMapper.countByExample(example));

            HW6.db.model.Categories categories = new HW6.db.model.Categories();
            categories.setTitle("test");
            categoriesMapper.insert(categories);
            session.commit();

            HW6.db.model.CategoriesExample example2 = new HW6.db.model.CategoriesExample();
            example2.createCriteria().andTitleLike("%test%");
            List<HW6.db.model.Categories> list2 = categoriesMapper.selectByExample(example2);
            HW6.db.model.Categories categories2 = list2.get(0);
            categories2.setTitle("test100");
            categoriesMapper.updateByPrimaryKey(categories2);
            session.commit();

            categoriesMapper.deleteByPrimaryKey(categories2.getId());
            session.commit();

        } finally {
            session.close();
        }


    }
}
