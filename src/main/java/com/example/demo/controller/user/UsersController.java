package com.example.demo.controller.user;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.user.User;
import com.example.demo.repository.user.UserDto;
import com.example.demo.service.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UsersController {
    private final UsersService userService;

    public UsersController(@Autowired UsersService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> all()
    {
        return ResponseEntity.ok(userService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id)
    {
        return ResponseEntity.ok(userService.findById(id));
    }


    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id)
    {
        return ResponseEntity.ok(userService.update(userDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete( @PathVariable String id)
    {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
