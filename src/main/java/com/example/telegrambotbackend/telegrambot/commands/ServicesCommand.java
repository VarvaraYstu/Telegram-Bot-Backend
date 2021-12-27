package com.example.telegrambotbackend.telegrambot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ServicesCommand implements BotCommand{
    @Override
    public String getCommandName() {
        return "/services";
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Наш фитнес центр предоставляет следующие услуги:\n" +
                "▫️групповое занятие йогой\uD83E\uDDD8\u200D♀️\n" +
                "▫️индивидуальные тренировки с тренером \uD83C\uDFCB️\n" +
                "▫️посещение спа \uD83E\uDDD6\u200D♀️ \n" +
                "▫️сеансы массажа\uD83D\uDC86\u200D♀️\n" +
                "▫️посещение бассейна \uD83C\uDFCA\u200D♂️\n" +
                "▫️групповое занятие по плаванию\uD83C\uDFCA\u200D♀️");
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
