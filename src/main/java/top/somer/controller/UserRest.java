package top.somer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.somer.model.User;
import top.somer.service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Somer
 * @date 2018-03-04 20:35
 **/
@RestController
@RequestMapping("/api")
public class UserRest {

    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public String insert(User user) {
        userService.insert(user);
        return "insert success";
    }

    @PutMapping("/user")
    public String update(User user) {
        userService.update(user);
        return "update success";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/user")
    public String delete(String id) {
        userService.remove(id);
        return "delete success";
    }

    @GetMapping("/find/all")
    public List<User> findUser() {
        return userService.findAll();
    }

    @GetMapping("/find")
    public List<User> findUser(Integer pageNumber, Integer pageSize, String name) {
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        Map<String, String> params = new HashMap<>();
        if (!StringUtils.isEmpty(name)) {
            params.put("name", name);
        }
        return userService.findByPager(params, pageable);
    }
}
