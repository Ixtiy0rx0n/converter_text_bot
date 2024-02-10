package org.example.controller;

import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

@Controller
public class GeneralController {
    private SendMessage sendMessage = new SendMessage();

    public SendMessage handle(String text) {
        String msg = "";
        if (text.equals("/start")) {
            msg = "Assalomu alaykum o'zingizga kerakli bo'limni tanlang";
            sendMessage.setText(msg);
            sendMessage.setParseMode("Markdown");
            sendMessage.disableWebPagePreview();
            KeyboardButton btnLotinKiril = new KeyboardButton();
            btnLotinKiril.setText("Lotin ⏩ Kiril");
            KeyboardButton btnKirilLotin = new KeyboardButton();
            btnKirilLotin.setText("Kiril ⏩ Lotin");
            KeyboardRow row = new KeyboardRow();
            row.add(btnLotinKiril);
            row.add(btnKirilLotin);
            ArrayList<KeyboardRow> rows = new ArrayList<>();
            rows.add(row);
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(rows);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setSelective(true);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
        } else if (text.equals("Lotin ⏩ Kiril")) {
            msg="Lotin tilida matn yuboring.";
            sendMessage.setText(msg);
            sendMessage.setParseMode("Markdown");
            sendMessage.disableWebPagePreview();
        } else if (text.equals("Kiril ⏩ Lotin")) {
            msg="Kiril tilida matn yuboring.";
//
            sendMessage.setText(msg);
            sendMessage.setParseMode("Markdown");
            sendMessage.disableWebPagePreview();
        }
        else if (text.equals("/help")) {
            msg = "help bo'limi";
            sendMessage.setText(msg);
            sendMessage.setParseMode("Markdown");
            sendMessage.disableWebPagePreview();
        } else {
            msg = "Mavjud emas";
            sendMessage.setText(msg);
            sendMessage.setParseMode("Markdown");
            sendMessage.disableWebPagePreview();
        }
        return sendMessage;
    }

}
