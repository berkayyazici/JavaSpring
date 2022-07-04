package com.Berkay.InterProbe.InterProbeBootcamp.Controller;

import com.Berkay.InterProbe.InterProbeBootcamp.Dao.UserDao;
import com.Berkay.InterProbe.InterProbeBootcamp.Entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserDao userDao;

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userDao.save(user));
    }

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userDao.findAll());
    }

}
