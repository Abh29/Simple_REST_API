drop table if exists STREAMS;

CREATE TABLE `STREAMS` (
                           id varchar(255) not null primary key ,
                           title varchar(255),
                           description varchar(255),
                           url varchar(255),
                           start_date datetime,
                           end_date datetime
);
