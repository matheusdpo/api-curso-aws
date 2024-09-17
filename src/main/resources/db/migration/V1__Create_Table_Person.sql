CREATE TABLE person (
                        id bigint NOT NULL AUTO_INCREMENT,
                        first_name varchar(128),
                        last_name varchar(128),
                        gender varchar(8),
                        address varchar(255),
                        PRIMARY KEY (id)
);
