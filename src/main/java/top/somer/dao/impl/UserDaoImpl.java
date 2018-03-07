package top.somer.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import top.somer.dao.IUserDao;
import top.somer.model.User;

import java.util.List;
import java.util.Map;

/**
 * 用户基础操作实现
 *
 * @author Somer
 * @date 2018-03-04 18:25
 **/
@Service
public class UserDaoImpl implements IUserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入一个用户
     *
     * @param user
     */
    @Override
    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    /**
     * 根据id更新用户
     *
     * @param user
     */
    @Override
    public void update(User user) {
        Criteria criteria = Criteria.where("_id").is(user.getId());
        Query query = new Query(criteria);
        Update update = Update.update("name", user.getName()).set("age", user.getAge());
        mongoTemplate.updateMulti(query, update, User.class);
    }

    /**
     * 根据id删除一个用户
     *
     * @param id
     */
    @Override
    public void remove(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, User.class);
    }

    /**
     * 插入一个集合
     *
     * @param userList
     */
    @Override
    public void insertAll(List<User> userList) {
        mongoTemplate.insertAll(userList);
    }

    @Override
    public User getUser(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), User.class);
    }

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public List<User> findByPager(Map<String, String> params, Pageable pageable) {
        Query query = new Query();
        if (params.containsKey("name")) {
            query = new Query(Criteria.where("name").regex("^.*" + params.get("name") + ".*$"));
        }
        List<User> list = mongoTemplate.find(query.with(pageable), User.class);
        return list;
    }
}
