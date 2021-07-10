package day3.spring.mapper;


import day3.spring.domain.User;

public interface UserMapper {

    public User selectStudent(String id);
    public User selectTeacher(String id);
    public User selectAdmin(String id);
}
