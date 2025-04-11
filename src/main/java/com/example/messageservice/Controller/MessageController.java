package com.example.messageservice.Controller;

import com.example.messageservice.Domain.Message;
import com.example.messageservice.Service.msgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/index")
public class MessageController {

    private msgService service;

    @Autowired
    public MessageController(msgService service) {
        this.service = service;
    }

    @GetMapping("msg")
    public List<Message> getAllMsgs() {
        Optional<List<Message>> msgList = service.getMessages();
        if (msgList.isPresent()) {
            return msgList.get();
        }
        return null;
    }

    @PostMapping("msg")
    public Message addMsg(@RequestBody Message msg) {
        Optional<Message> newMsg = service.addMessage(msg);
        if (newMsg.isPresent()) {
             return newMsg.get();
        }
        return null;
    }

    @PutMapping("msg")
    public Message updateMsg(@RequestBody Message msg) {
        Optional<Message> newMsg = service.updateMessage(msg);
        if (newMsg.isPresent()) {
            return newMsg.get();
        }
        return null;
    }

    @DeleteMapping("msg")
    public Message deleteMsg(@RequestBody Map<String, String> body) {
        String id = body.get("id");
        Optional<Message> msg = service.deleteMessage(id);
        return msg.orElse(null);
    }
}
