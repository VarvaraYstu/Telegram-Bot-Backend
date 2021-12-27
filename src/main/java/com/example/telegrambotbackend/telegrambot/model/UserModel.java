package com.example.telegrambotbackend.telegrambot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONPropertyName;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "subscribers_")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "f_name")
    private String fName;
    @Column(name = "l_name")
    private String lName;
    @Column(name = "subscription_type")
    private int subscriptionType;
    @Column(name = "price")
    private int price;

    public UserModel(String fName, String lName, int subscriptionType, int price) {
        this.fName = fName;
        this.lName = lName;
        this.subscriptionType = subscriptionType;
        this.price = price;
    }

}
