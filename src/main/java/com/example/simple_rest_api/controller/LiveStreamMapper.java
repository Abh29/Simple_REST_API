package com.example.simple_rest_api.controller;

import com.example.simple_rest_api.model.LiveStream;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class LiveStreamMapper implements RowMapper<LiveStream> {

    @Override
    public LiveStream mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LiveStream(
                rs.getObject("id", UUID.class),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("url"),
                rs.getTimestamp("start_date"),
                rs.getTimestamp("end_date")
        );
    }
}
