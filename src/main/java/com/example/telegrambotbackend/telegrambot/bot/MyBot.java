package com.example.telegrambotbackend.telegrambot.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.example.telegrambotbackend.telegrambot.commands.*;
import com.example.telegrambotbackend.telegrambot.commands.subscriptionMode.Subscription;
import com.example.telegrambotbackend.telegrambot.data.UserDataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyBot extends TelegramLongPollingBot {
    BotCommand[] botCommands = new BotCommand[] {
            new HelloCommand(),
            new StartCommand(),
            new InformationCommand(),
            new ServicesCommand(),
            new SubscriptionCommand()
    };
    Subscription subscription = new Subscription();
    ArrayList<UserDataModel> users = new ArrayList<>();
    UserDataModel user;
    int index = 0;
    int subscriptionTypeInt = 0;
    String subscriptionType;
    Map<Long, Boolean> usersMode = new HashMap<>();
    @Override
    public String getBotUsername() {
        return "MagnoliaFitnessbot";
    }

    @Override
    public String getBotToken() {
        return "1980624736:AAHALBYT_mKLFuzWL9dDreOoJeolYVLFJqo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        boolean existenceCommand = false;
        if (!usersMode.containsKey(update.getMessage().getChatId())){
            usersMode.put(update.getMessage().getChatId(),false);
        }

        if (!usersMode.get(update.getMessage().getChatId())){
            for (int i = 0; i < botCommands.length; ++i){
                if (botCommands[i].getCommandName().equalsIgnoreCase(update.getMessage().getText())){
                    botCommands[i].executeCommand(update.getMessage().getChatId().toString(),update.getMessage() ,this);
                    existenceCommand = true;
                }
            }
            if (update.getMessage().getText().equalsIgnoreCase("оформить абонемент")) {
                subscription.fNameCommand(update.getMessage().getChatId().toString(),update.getMessage(), this);
                usersMode.put(update.getMessage().getChatId(),true);
                index = 0;
            }
            //если такой команды нет
            else if(!existenceCommand){
                BotCommand defaultCommand = new DefaultCommand();
                defaultCommand.executeCommand(update.getMessage().getChatId().toString(),update.getMessage() ,this);
            }
        }
        else {
            switch (index){
                case 0:
                    subscription.setId(update.getMessage().getChatId());
                    subscription.setfName(update.getMessage().getText());
                    subscription.lNameCommand(update.getMessage().getChatId().toString(),update.getMessage() ,this);
                    break;
                case 1:
                    subscription.setlName(update.getMessage().getText());
                    subscription.typeCommand(update.getMessage().getChatId().toString(),update.getMessage() ,this);
                    break;
                case 2:
                    subscriptionType = update.getMessage().getText();
                    try{
                        subscriptionTypeInt = Integer.parseInt(subscriptionType);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        subscription.correctType(update.getMessage().getChatId().toString(),update.getMessage() ,this);
                        --index;
                    }
                    if (subscriptionTypeInt < 1 || subscriptionTypeInt > 3){
                        subscription.correctType(update.getMessage().getChatId().toString(),update.getMessage() ,this);
                        --index;
                    }
                    else {
                        subscription.setSubscriptionType(subscriptionTypeInt);
                        subscription.correctData(update.getMessage().getChatId().toString(),update.getMessage() ,this);
                    }
                    break;
                case 3:
                    if (update.getMessage().getText().equalsIgnoreCase("да")){
                        user = new UserDataModel(subscription.fName, subscription.lName, subscription.subscriptionType, subscription.id);
                        users.add(user);
                        subscription.success(update.getMessage().getChatId().toString(),update.getMessage(), this);
                        usersMode.put(update.getMessage().getChatId(),false);
                    }
                    else if (update.getMessage().getText().equalsIgnoreCase("нет")){
                        index = -1;
                        subscription.fNameCommand(update.getMessage().getChatId().toString(),update.getMessage(), this);
                    }
                    else{
                        subscription.correctData(update.getMessage().getChatId().toString(),update.getMessage() ,this);
                        -- index;
                    }
                    break;
                default: break;
            }
            index ++;
        }
    }
}
