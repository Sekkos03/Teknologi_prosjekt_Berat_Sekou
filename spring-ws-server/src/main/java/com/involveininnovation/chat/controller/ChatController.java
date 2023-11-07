package com.involveininnovation.chat.controller;

import com.involveininnovation.chat.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private static KeyPair keyPair;

    static {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/private-message")
    public void recMessage(@Payload Message message) {
        try {
            PublicKey publicKey = keyPair.getPublic();
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedData = cipher.doFinal(message.getMessage().getBytes());
            System.out.println("Encrypted Data: " + new String(encryptedData));
            simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
            System.out.println(message.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

