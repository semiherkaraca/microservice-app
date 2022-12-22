package com.haydikodlayalim.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketNotification {

    private String tickerId;
    private String accountId;
    private String ticketDescription;
}
