package com.example.messageservice.Repo;

import com.example.messageservice.Domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsgRepo extends MongoRepository<Message, String> {
    List<Message> id(String id);
}
