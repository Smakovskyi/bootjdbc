package ua.kpi.firstboot.conrtoller;


import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.firstboot.domain.User;
import ua.kpi.firstboot.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/")
  public List<User> getAllUsers(){

    return userService.findAll();
    //return Arrays.asList( User.builder().id(3).name("first").build());
  }

  @GetMapping("/{id}")
  public ResponseEntity getUserById(@PathVariable(name="id") int id){
    return userService.findById(id)
               .map( user -> ResponseEntity.ok( user) )
               .orElse( ResponseEntity.notFound().build() );

    //return ResponseEntity.ok(User.builder().id(2).name("first").build() );
  }

}
