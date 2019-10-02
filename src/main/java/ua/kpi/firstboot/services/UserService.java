package ua.kpi.firstboot.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.firstboot.dao.UserDao;
import ua.kpi.firstboot.domain.User;

@Service
public class UserService {

  @Autowired
  UserDao userDao;


  public List<User> findAll() {
    return userDao.findAll();
  }

  public Optional<User> findById(int id){
    try{
      return Optional.of(userDao.findUserById(id));
    }catch (Exception ex){
      return Optional.empty();
    }

  }

}
