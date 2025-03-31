INSERT  INTO cinema ( name, location) VALUES 
( 'PVR Cinemas', 'New York'), 
( 'AGS Cinemas', 'Los Angeles');

INSERT INTO movies ( title, genre, duration, rating,cinema_id) 
VALUES 
( 'Inception', 'Sci-Fi', '148', 'good',1),
( 'The Dark Knight', 'Action', '152', 'best',2);


INSERT INTO users (id, name, email) 
VALUES (1, 'User1', 'user1@example.com'), 
(2, 'User2', 'user2@example.com');


insert into bookings (cinema_id,movie_id,user_id,showtime,seats) values 
(1,1,1,'10 AM',10),
(2,2,2,'2 PM',15);

insert into movies_showtimes(movies_id,showtimes) values (1,'10 AM'),
(1,'12 PM'),(2,'2 PM'),(2,'9 PM');








