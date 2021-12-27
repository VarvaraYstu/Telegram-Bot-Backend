package com.example.telegrambotbackend.telegrambot.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartCommand implements BotCommand {
    @Override
    public String getCommandName() {
        return "/start";
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("✨Привет, " + message.getFrom().getFirstName() + ", ✨\n" +
                "\uD83D\uDE03Хочешь узнать поподробнее о нашем фитнес центре? /information \n" +
                "\uD83E\uDD14А может ты хочешь увидеть список услуг, предоставляемых нашим фитнес центром? /services \n" +
                "\uD83E\uDD73Настроен решительно менять свою жизнь или просто хочешь отлично провести время? /subscription ");
        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
