package com.mighty.springbootexercise.services;

import com.mighty.springbootexercise.enums.ResultEnum;
import com.mighty.springbootexercise.exceptions.UserException;
import com.mighty.springbootexercise.entity.User;
import com.mighty.springbootexercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void getAge(Integer id) throws Exception{

        User user = userRepository.findById(id).get();
        Integer age = user.getAge();
        if (age < 10) {
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age >= 10 && age < 16) {
            throw new UserException(ResultEnum.MIDDLE_SCHOOL);
        }

    }

}
