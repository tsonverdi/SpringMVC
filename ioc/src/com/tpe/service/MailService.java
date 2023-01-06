package com.tpe.service;

import com.tpe.domain.Message;

public class MailService implements MessageService {

    public void sendMessage (Message message){

        System.out.println("I am the mail service, and sending message to you : " + message.getMessage());

    }
}
