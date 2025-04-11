package com.example.messageservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Msg")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    private String id;
    private String content;
    private String senderName;
    private String receiveName;

    public String getSenderName() {
        return senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public String getReceiveName() {
        return receiveName;

    }
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
