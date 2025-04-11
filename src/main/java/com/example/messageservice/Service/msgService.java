package com.example.messageservice.Service;

import com.example.messageservice.Domain.Message;
import com.example.messageservice.Repo.MsgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class msgService {
    private MsgRepo msgRepo;

    @Autowired
    public msgService(MsgRepo msgRepo) {
        this.msgRepo = msgRepo;
    }

    public Optional<List<Message>> getMessages() {
        List<Message> msgList = msgRepo.findAll();
        return Optional.of(msgList);
    }

    public Optional<Message> addMessage(Message msg) {
        Message newMsg = msgRepo.save(msg);
        return Optional.of(newMsg);
    }

    public Optional<Message> updateMessage(Message msg) {
        Optional<Message> optional = msgRepo.findById(msg.getId());
        if (optional.isPresent()) {
            return Optional.of(msgRepo.save(msg)); // Save the updated message
        }
        return Optional.empty();
    }

    public Optional<Message> deleteMessage(String id) {
        Optional<Message> optional = msgRepo.findById(id);
        optional.ifPresent(msgRepo::delete);
        return optional;
    }
//    public Optional<Message> updateMessage(Message msg) {
//        msgRepo.u
//    }
}
