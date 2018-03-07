package top.somer.dao;

import org.springframework.data.domain.Pageable;
import top.somer.model.User;

import java.util.List;
import java.util.Map;

/**
 * 用户基础操作接口
 *
 * @author Somer
 * @date 2018-03-04 18:22
 **/
public interface IUserDao {

    void insert(User user);

    void update(User user);

    void remove(String id);

    void insertAll(List<User> userList);

    User getUser(String id);

    List<User> findAll();

    List<User> findByPager(Map<String, String> params, Pageable pageable);
}
