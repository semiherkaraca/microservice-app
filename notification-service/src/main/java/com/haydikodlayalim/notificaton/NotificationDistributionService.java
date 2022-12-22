package com.haydikodlayalim.notificaton;

import com.haydikodlayalim.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationDistributionService {

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Notificaiton Alindi, Kullanicilara Gönderiliyor.");
        System.out.println("Notificaiton -> " + ticketNotification.toString());
    }
}
