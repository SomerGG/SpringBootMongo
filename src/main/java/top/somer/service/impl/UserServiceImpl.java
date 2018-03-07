package top.somer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.somer.dao.IUserDao;
import top.somer.model.User;
import top.somer.service.IUserService;

import java.util.List;
import java.util.Map;

/**
 * @author Somer
 * @date 2018-03-04 20:33
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void remove(String id) {
        userDao.remove(id);
    }

    @Override
    public void insertAll(List<User> userList) {
        userDao.insertAll(userList);
    }

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findByPager(Map<String, String> params, Pageable pageable) {
        return userDao.findByPager(params, pageable);
    }
}
