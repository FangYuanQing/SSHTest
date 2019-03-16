package mapper;

import po.User;

public interface Usermapperport {
    public User findUserById(int id) throws Exception;
}
