package cn.lzy;

import cn.lzy.configbean.Person;
import cn.lzy.configbean.Student;
import cn.lzy.configbean.User;
import cn.lzy.customconfig.CustonProperties;
import cn.lzy.customconfig.MyProperties;
import cn.lzy.mybatis.Comment;
import cn.lzy.mybatis.CommentMapper;
import cn.lzy.mybatis.jp.Discuss;
import cn.lzy.mybatis.jp.DiscussRepository;
import cn.lzy.mybatis.redis.Address;
import cn.lzy.mybatis.redis.Family;
import cn.lzy.mybatis.redis.PersonRepository;
import cn.lzy.profielconfig.DBConnector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource("classpath:beans.xml")
public class Chapter01ApplicationTests {
//
    public
    @Autowired
    User user;
    @Autowired
    Person person;
    @Autowired
    Student student;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    DBConnector dbConnector;
    @Autowired
    CustonProperties custonProperties;
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private PersonRepository repository;
    @Autowired
    DiscussRepository discussRepository;
//    @Value("${student.id}")
//    int id;
//    @Value("${student.name}")
//    String name;
//    @Value("${student.age}")
//    int age;


    @Test
    public void iocTest() {
        System.out.println(applicationContext.containsBean("myService"));

    }


    @Test
    public void contextLoads() {
        /*Comment comment =commentMapper.findById(3);
        System.out.println("单元测试返回的Comment表的数据---"+comment);*/
      List<Discuss> list = discussRepository.findByAuthorNotNull();
        System.out.println(list);


        //插入数据
       /* Comment comment1 = new Comment();
         comment1.setContent("周玉婷");
         comment1.setAuthor("云计算二班");
         comment1.setaId(25);
         commentMapper.insertComment(comment1);*/

        //更行数据
        /* Comment comment2 = new Comment();
         comment2.setContent("很坏，非常简略");
         comment2.setId(4);
         commentMapper.updateComment(comment2);*/
//       System.out.println("单元测试返回的数据"+student);
//        System.out.println("单元测试返回的person数据"+person);
//        System.out.println("单元测试返回的user数据"+user);
        /*System.out.println(dbConnector.config());
       MyProperties myProperties=(MyProperties)applicationContext.getBean("MyProperties");
       if (myProperties != null){
           myProperties.getResult();
       }
//          System.out.println("id="+custonProperties.getS()+",name="+custonProperties.getW());
            System.out.println(custonProperties);*/



        }
@Test
    public  void  saveRedisPerson(){
    cn.lzy.mybatis.redis.Person personRedis = new cn.lzy.mybatis.redis.Person();
    personRedis.setFirstname("张");
    personRedis.setLastname("三");
    Address address = new Address();
    address.setCity("柳州");
    address.setCountry("中国");
    personRedis.setAddress(address);
    List<Family> list =new ArrayList<>();
    Family dad = new Family("父亲","刘");
    Family mom = new Family("母亲","王");
    list.add(dad);
    list.add(mom);
    personRedis.setFamilyList(list);
    cn.lzy.mybatis.redis.Person personResult = repository.save(personRedis);
    System.out.println(personResult);
    }

}


