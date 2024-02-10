package org.example.controller;

import org.example.dto.UserDTO;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
public class MyBot extends TelegramLongPollingBot {
    @Autowired
    private UserService userService;

    private final String username = "test_converter123_bot";
    private static final String token = "TOKEN";
    @Autowired
    private GeneralController generalController;

    public MyBot(TelegramBotsApi telegramBotsApi) throws TelegramApiException {
        super(token);
        telegramBotsApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update.hasMessage()) {
            Message message = update.getMessage();
            User user = message.getFrom();
            UserDTO dto = new UserDTO();


            if (message.hasText() && message.getText() != null ) {
//              sendMessage.setChatId(message.getChatId());
                dto.setName(user.getFirstName());
                dto.setLastName(user.getLastName());
                dto.setIsPremium(user.getIsPremium());
                dto.setUsername(user.getUserName());
                dto.setChatId(message.getChatId());
                dto.setPhone("999");
                if (userService.check(dto)) {
                    String text = message.getText();
                    sendMessage=generalController.handle(text);
                } else {
                    userService.save(dto);
                    System.out.println("New User: " + user.getFirstName() + " and chatId: " + message.getChatId());
                    String text = message.getText();
                    sendMessage=generalController.handle(text);
                }
            }

            try {
                sendMessage.setChatId(dto.getChatId());
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

}
