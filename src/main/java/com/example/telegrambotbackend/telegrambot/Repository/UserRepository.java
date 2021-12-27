package com.example.telegrambotbackend.telegrambot.Repository;

import com.example.telegrambotbackend.telegrambot.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    List<UserModel> findUserModelById(Long id);

}
