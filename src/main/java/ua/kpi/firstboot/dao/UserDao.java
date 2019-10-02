package ua.kpi.firstboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.kpi.firstboot.domain.User;

@Repository
public class UserDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<User> findAll() {
    return this.jdbcTemplate.query(
        "select id,  name from users" ,
        UserDao::mapRow);
  }

  private static User mapRow(ResultSet resultSet, int i) throws SQLException {
    return User.builder()
        .id(resultSet.getInt("id"))
        .name(resultSet.getString("name"))
        .build();
  }

  public User findUserById(int id) {
    return this.jdbcTemplate.queryForObject(
        "select id, name from users where id = ?",
        new Object[]{id},
        UserDao::mapRow);
  }

}
