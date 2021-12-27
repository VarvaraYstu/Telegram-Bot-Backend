package com.example.telegrambotbackend.telegrambot.data;

import com.example.telegrambotbackend.telegrambot.model.AddUserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "subscribers")
public class UserDataModel {
    @Id
    public long id;
    public String fName;
    public String lName;
    public int subscriptionType;
    public int price;

    public UserDataModel(String fName, String lName, int subscriptionType, Long chatId) {
        setPrice();
        this.fName = fName;
        this.lName = lName;
        this.subscriptionType = subscriptionType;
        id = chatId;

    }


    public void setPrice() {
        switch (subscriptionType){
            case 1: price = 2200;
                break;
            case 2: price = 2000;
                break;
            case 3: price = 4000;
                break;
        }
    }
}
