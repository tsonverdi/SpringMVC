package com.tpe.main;

import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import com.tpe.service.WhatsappService;

public class MyApplication {

    public static void main(String[] args) {
//1. Asama**********************************
        Message message = new Message();
        message.setMessage("Siparisler verildi");

//        MessageService mailService = new MailService();
//        mailService.sendMessage(message);

//        SmsService smsService = new SmsService();
//        smsService.sendMessage(message);
//
//        WhatsappService whatsappService = new WhatsappService();
//        whatsappService.sendMessage(message);

        //2.Asama
        String serviceName = "mailService";
        MessageService service ;

        if(args.length>0) {
            serviceName = args[0];
        }

        if(serviceName.equalsIgnoreCase("whatsAppService")) {
            service = new WhatsappService();
        } else if (serviceName.equalsIgnoreCase("smsService")) {
            service=new SmsService();
        } else {
            service = new MailService();
        }
        service.sendMessage(message);
    }
}
