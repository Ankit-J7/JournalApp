package com.project.journalApp.service;

import com.project.journalApp.entity.JournalEntity;
import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user)
    {
        userRepository.save(user);
    }
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public User findbyId(ObjectId id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deletebyId(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName)
    {
        return userRepository.findByUserName(userName);

    }

}
