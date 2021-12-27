package com.example.telegrambotbackend.telegrambot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SubscriptionCommand implements BotCommand{
//    public boolean check = false;
//    public boolean getCheck(){
//        return check;
//    }
    @Override
    public String getCommandName() {
        return "/subscription";
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("""
                Наш фитнес-центр предлагает несколько вариантов абонемента (абонемент действителен 1 месяц со срока оплаты):\n
                1. Тренажерный зал + бассейн -2200р\n
                2. Спа - 2000р \n
                3. Комбо (тренажерный зал, спа, бассейн) - 4000р\n
                Чтобы оформить абонемент напишите: ОФОРМИТЬ АБОНЕМЕНТ""");
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
