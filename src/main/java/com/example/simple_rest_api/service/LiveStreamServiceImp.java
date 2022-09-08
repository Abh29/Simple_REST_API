package com.example.simple_rest_api.service;

import com.example.simple_rest_api.model.LiveStream;
import com.example.simple_rest_api.repository.LiveStreamRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequestMapping("/test")
public class LiveStreamServiceImp implements LiveStreamService{

    private final LiveStreamRepository repository;

    public LiveStreamServiceImp(LiveStreamRepository repository) {
        this.repository = repository;
    }

    @PutMapping("/create")
    void creatLiveStream(){
        repository.save(new LiveStream(
                UUID.randomUUID(),
                "new Stream",
                """
                        JetBrains has winter and summer internships as well as flexible year-round part-time positions available for students.
                        """,
                "www.google.com",
                Timestamp.valueOf(LocalDateTime.now()),
                Timestamp.valueOf(LocalDateTime.now().plusHours(2L))
        ));
    }

}
