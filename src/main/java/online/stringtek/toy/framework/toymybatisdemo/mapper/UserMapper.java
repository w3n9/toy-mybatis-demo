package online.stringtek.toy.framework.toymybatisdemo.mapper;

import online.stringtek.toy.framework.toymybatisdemo.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectList();
    User selectOne(User userParam);
}
