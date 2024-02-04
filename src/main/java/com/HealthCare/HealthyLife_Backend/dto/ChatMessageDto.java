package com.HealthCare.HealthyLife_Backend.dto;

import com.HealthCare.HealthyLife_Backend.entity.Chatting;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter @Setter @Builder @AllArgsConstructor
public class ChatMessageDto {
    public enum MessageType {
        ENTER, TALK, CLOSE
    }
    private MessageType type;
    private String roomId;
    private Long sender;
    private String message;
    private LocalDateTime messageTime;
}