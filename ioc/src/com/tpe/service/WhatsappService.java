package com.tpe.service;

import com.tpe.domain.Message;

public class WhatsappService implements MessageService{


    public void sendMessage (Message message){

        System.out.println("I am the Whatsapp service, and sending message to you : " + message.getMessage());

    }
}
