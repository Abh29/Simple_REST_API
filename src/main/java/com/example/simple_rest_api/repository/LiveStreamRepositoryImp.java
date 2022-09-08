package com.example.simple_rest_api.repository;

import com.example.simple_rest_api.model.LiveStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LiveStreamRepositoryImp implements LiveStreamRepository{

    private final DataSource DATASOURCE;
    private final RowMapper<LiveStream> MAPPER;
    private final JdbcTemplate template;


    @Autowired
    public LiveStreamRepositoryImp(
            @Qualifier("hikariDataSource")
            DataSource DATASOURCE,
            @Qualifier("liveStreamMapper")
            RowMapper<LiveStream> MAPPER,
            JdbcTemplate template) {
        this.DATASOURCE = DATASOURCE;
        this.MAPPER = MAPPER;
        this.template = template;
    }

    @Override
    public Optional<LiveStream> findById(UUID id) {
        return template.query("SELECT * FROM STREAMS WHERE id=?", MAPPER, id)
                .stream().findAny();
    }

    @Override
    public List<LiveStream> findAll() {
        return template.query("SELECT * FROM STREAMS", MAPPER).stream().toList();
    }

    @Override
    public void save(LiveStream entity) {
        template.update("INSERT INTO STREAMS(id, title, description, url, start_date, end_date) values(?, ?, ?, ?, ?, ?)",
               entity.ID(), entity.title(), entity.description(), entity.url(), entity.startDate(), entity.endDate());
    }

    @Override
    public void update(LiveStream entity) {
        template.update("UPDATE STREAMS SET title=?, description=?, url=?, start_date=?, end_date=? WHERE id=?",
                entity.ID(), entity.title(), entity.description(), entity.url(), entity.startDate(), entity.endDate());
    }

    @Override
    public void delete(UUID id) {
        template.update("DELETE FROM STREAMS WHERE id=?", id);
    }
}
