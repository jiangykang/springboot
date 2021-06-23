package cn.edu.hfut.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component //将此类交给spring容器管理
@ConfigurationProperties(prefix = "person")
public class PersonConfig {
    private String name;

    private int age;

    private String school;

    @Override
    public String toString() {
        return "PersonConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                '}';
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
