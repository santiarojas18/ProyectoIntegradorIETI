package com.example.demo.service.user;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.user.User;
import com.example.demo.repository.user.UserDto;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesMongo implements UsersService{
    private final UserRepository userRepository;
    public UserServicesMongo( @Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDto userDto) {
        User createdUser = userRepository.save(new User(userDto));
        return createdUser;
    }

    @Override
    public User findById(String id) {
        Optional<User> optionalUser = userRepository.findById( id );
        if ( optionalUser.isPresent() )
        {
            return optionalUser.get();
        }
        else
        {
            return  null;

        }
    }

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        if ( userRepository.existsById( id ) )
        {
            userRepository.deleteById( id );
            return true;
        }
        return false;
    }

    @Override
    public User update(UserDto userDto, String userId) {
        if ( userRepository.findById(userId).isPresent() )
        {
            User user = userRepository.findById(userId).get();
            user.update(userDto);
            userRepository.save( user );
            return user;
        }
        return null;
    }
}
