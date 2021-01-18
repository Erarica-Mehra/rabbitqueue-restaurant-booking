create table bookings(
   id INT NOT NULL AUTO_INCREMENT,
   username varchar(100) NOT NULL,
   restaurant VARCHAR(100) NOT NULL,
   special_request VARCHAR(500),
   reply_to VARCHAR(100) NOT NULL,
   request_from VARCHAR(100) NOT NULL,
   subject VARCHAR(500) NOT NULL,
   slot VARCHAR(100) NOT NULL,
   date_request Date NOT NULL,
   status boolean NOT NULL,
   PRIMARY KEY (id)
);