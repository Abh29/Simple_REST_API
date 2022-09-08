package com.example.simple_rest_api.controller;

import com.example.simple_rest_api.model.LiveStream;
import com.example.simple_rest_api.repository.LiveStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    //localhost:8080/streams
    @GetMapping
    public List<LiveStream> findAll() {
        return  repository.findAll();
    }

    //localhost:8080/streams/{id}
    @GetMapping("/{ID}")
    public Optional<LiveStream> findById(@PathVariable UUID ID) {
        return repository.findById(ID);
    }

    //localhost:8080/streams
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody LiveStream liveStream) {
        repository.save(liveStream);
    }

    //localhost:8080/streams/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{ID}")
    public void update(@RequestBody LiveStream liveStream, @PathVariable UUID ID) {
        LiveStream stream = new LiveStream(
                ID,
                liveStream.title(),
                liveStream.description(),
                liveStream.url(),
                liveStream.startDate(),
                liveStream.endDate()
        );

        repository.update(stream);
    }

    //localhost:8080/streams/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{ID}")
    public void delete(@PathVariable UUID ID) {
        repository.delete(ID);
    }

}
