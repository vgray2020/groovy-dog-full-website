package com.javaform11.javaform.service;

import com.javaform11.javaform.model.UsersModel;
import com.javaform11.javaform.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel registerUser(String login, String firstName, String lastName, String dogsName,
                                   String password, String email){
        if (login == null || password == null) {
            return null;
        } else {
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setFirstName(firstName);
            usersModel.setLastName(lastName);
            usersModel.setDogsName(dogsName);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return usersRepository.save(usersModel);
        }
    }
    public UsersModel authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }


}
