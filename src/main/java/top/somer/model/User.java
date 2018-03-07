package top.somer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author Somer
 * @date 2018-03-04 18:18
 **/
@Document(collection = "user")
public class User implements Serializable {

    /**
     * 对应mongo的_id
     */
    @Id
    @Indexed
    @Field(value = "_id")
    private String id;
    @Field("name")
    private String name;
    @Field("age")
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "User [_id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
