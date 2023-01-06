package com.tpe.service;

import com.tpe.domain.Message;

public class SmsService implements MessageService{

    public void sendMessage (Message message){

        System.out.println("I am the SMS service, and sending message to you : " + message.getMessage());

    }
}
