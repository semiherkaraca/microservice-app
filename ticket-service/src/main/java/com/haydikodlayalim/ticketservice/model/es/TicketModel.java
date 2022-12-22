package com.haydikodlayalim.ticketservice.model.es;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "ticket")
public class TicketModel {

    @Id
    private String id;
    private String description;
    private String notes;
    private String assignee;
    private Date ticketDate;
    private String priorityType;
    private String ticketStatus;
}
