package com.example.simple_rest_api.repository;

import com.example.simple_rest_api.model.LiveStream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LiveStreamRepository extends CrudRepository<LiveStream, UUID> {

}
