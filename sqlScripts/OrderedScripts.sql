select * from users;
select * from purchase;
select * from ticket;
select * from tickettype;
select * from showing_seat;
select * from showing;
select * from movie;

select * from showing_seat ss where status = 1;

--drop table ticket;
--drop table tickettype;
--drop table purchase;
--drop table users;
--drop table showing_seat;
--drop table showing; 
--drop table movie;
--drop sequence mysequence;

create table users(
    user_id numeric primary key not null,
    username text not null unique,
    password text not null,
    first_name text not null,
    last_name text not null,
    email text not null unique 
);
create table purchase(
    purchase_id numeric primary key not null,
    total_cost numeric not null,
    user_id_FK numeric references users(user_id)
);
create table tickettype(
    ticket_type_id numeric primary key not null,
    tickettype text not null,
    price numeric 
);
create table movie(
    movie_id numeric primary key not null,
    description text unique not null,
    duration numeric not null,
    poster text,
    title text not null
);
create table showing(
    showing_id numeric primary key not null,
    showtime text not null,
    movie_id_FK numeric references movie(movie_id) 
);
create table showing_seat(
    seat_id numeric primary key not null,
    seat_name text not null,
    status numeric,
    showing_id_fk numeric references showing(showing_id)
);
create table ticket(
    ticket_id numeric primary key not null,
    seat_id_FK numeric references showing_seat(seat_id),
    ticket_type_id_FK numeric references tickettype(ticket_type_id),
    purchase_id_FK numeric references purchase(purchase_id)
);
insert into tickettype values(1,'Adult',12.99);
insert into tickettype values(2,'Senior',8.99);
insert into tickettype values(3,'Child',6.99);
--DELETE FROM users  where user_id  >=0;
insert into users values(1, 'batman', 'password', 'bat', 'man', 'bat@mail.com');
insert into users values(2, 'cjf', '7777', 'Christian', 'Falzone', 'c@gmail');
insert into users values(3, 'serg', 'berg', 'Sergio', 'Gamboa', 's@yahoo.com');
insert into users values(4, 'liam', 'taken', 'Liam', 'Converse', 'l@revature.com');

   
CREATE SEQUENCE mysequence
INCREMENT 1
START 1;

--drop sequence mysequence;

create or replace function insert_showing_seats_when_showing_is_inserted()
returns trigger as $$
begin 
    insert into showing_seat values(nextval('mysequence'), 'A1',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'A2',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'A3',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'A4',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'A5',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'A6',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'A7',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'A8',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'A9',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'A10',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B1',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B2',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B3',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B4',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B5',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B6',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B7',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B8',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B9',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'B10',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C1',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C2',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C3',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C4',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C5',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C6',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C7',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C8',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C9',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'C10',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D1',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D2',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D3',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D4',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D5',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D6',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D7',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D8',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D9',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'D10',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E1',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E2',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E3',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E4',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E5',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E6',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E7',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E8',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E9',0,new.showing_id);
    insert into showing_seat values(nextval('mysequence'), 'E10',0,new.showing_id);
    return null;
end
$$ language 'plpgsql';

CREATE TRIGGER add_showing_seats
AFTER INSERT ON showing
    FOR EACH ROW EXECUTE PROCEDURE insert_showing_seats_when_showing_is_inserted();

--DELETE FROM movie  where movie_id  >=0;
insert into movie values(1, 'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins...', 181 , 'http://cdn.collider.com/wp-content/uploads/2019/03/avengers-endgame-poster-405x600.jpg', 'Avengers: Endgame');
insert into movie values(2, 'Twenty-seven years after their first encounter with the terrifying Pennywise, the Losers Club have grown up and..', 169 ,  'https://m.media-amazon.com/images/M/MV5BYTJlNjlkZTktNjEwOS00NzI5LTlkNDAtZmEwZDFmYmM2MjU2XkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 'It: Chapter Two');
insert into movie values(3, 'A familys serene beach vacation turns to chaos when their doppelgängers appear and begin to terrorize them.', 116 , 'https://m.media-amazon.com/images/M/MV5BZTliNWJhM2YtNDc1MC00YTk1LWE2MGYtZmE4M2Y5ODdlNzQzXkEyXkFqcGdeQXVyMzY0MTE3NzU@._V1_SY1000_CR0,0,631,1000_AL_.jpg', 'Us');
insert into movie values(4, 'Lawman Luke Hobbs (Dwayne "The Rock" Johnson) and outcast Deckard Shaw (Jason Statham) form an unlikely alliance when...', 137, 'https://m.media-amazon.com/images/M/MV5BOTIzYmUyMmEtMWQzNC00YzExLTk3MzYtZTUzYjMyMmRiYzIwXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_SY1000_CR0,0,685,1000_AL_.jpg', 'Fast & Furious Presents: Hobbs & Shaw');
insert into movie values(5, 'John Wick is on the run after killing a member of the international assassins guild, and with a $14 million price tag on his head,', 131 , 'https://m.media-amazon.com/images/M/MV5BMDg2YzI0ODctYjliMy00NTU0LTkxODYtYTNkNjQwMzVmOTcxXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_SY1000_CR0,0,648,1000_AL_.jpg', 'John Wick: Chapter 3 — Parabellum');
insert into movie values(6, 'When Hiccup discovers Toothless isnt the only Night Fury, he must seek "The Hidden World", a secret Dragon Utopia', 104, 'https://m.media-amazon.com/images/M/MV5BMjIwMDIwNjAyOF5BMl5BanBnXkFtZTgwNDE1MDc2NTM@._V1_SY1000_CR0,0,631,1000_AL_.jpg', 'How to Train Your Dragon: The Hidden World');
insert into movie values(7, 'Continuing the story of Max and his pet friends, following their secret lives after their owners...',86, 'https://m.media-amazon.com/images/M/MV5BMzdlMWQzZmItMDA5Ny00MGFjLTk0MDAtYjgzMmMyNTEwMzdhXkEyXkFqcGdeQXVyODQzNTE3ODc@._V1_SY1000_CR0,0,631,1000_AL_.jpg', 'The Secret Life of Pets 2');
insert into movie values(8, 'In a world where people collect Pokémon to do battle, a boy comes across an intelligent talking Pikachu...', 104, 'https://m.media-amazon.com/images/M/MV5BNDU4Mzc3NzE5NV5BMl5BanBnXkFtZTgwMzE1NzI1NzM@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 'Pokémon: Detective Pikachu');
insert into movie values(9, 'A faded television actor and his stunt double strive to achieve fame and success in the film industry...', 161, 'https://m.media-amazon.com/images/M/MV5BOTg4ZTNkZmUtMzNlZi00YmFjLTk1MmUtNWQwNTM0YjcyNTNkXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 'Once Upon a Time…in Hollywood');
insert into movie values(10, 'A newly fostered young boy in search of his mother instead finds unexpected super powers and...', 131, 'https://m.media-amazon.com/images/M/MV5BYTE0Yjc1NzUtMjFjMC00Y2I3LTg3NGYtNGRlMGJhYThjMTJmXkEyXkFqcGdeQXVyNTI4MzE4MDU@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 'Shazam!');
insert into movie values(11, 'Arthur Curry (Jason Momoa), the human-born heir to the underwater kingdom of Atlantis, goes...',143 , 'https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_SY1000_CR0,0,674,1000_AL_.jpg', 'Aquaman');
--DELETE FROM showing  where showing_id  >=0;
insert into showing  values(1, 'March 31, 4:00pm',1);
insert into showing values(2,'March 31 7:30pm',2 );
insert into showing values(3,'March 31 10:30pm', 3);
insert into showing values(4,'April 1 4:00pm',4  );
insert into showing values(5,'April 1 6:30pm',5 );
insert into showing values(6,'April 1 9:00pm',6 );
insert into showing values(7,'April 2 4:00pm',7);
insert into showing values(8,'April 2 6:00pm', 8);
insert into showing values(9,'April 2 8:00pm',9);
insert into showing values(10,'April 2 11:00pm', 10);
insert into showing values(11,'April 3 4:00pm', 11);
insert into showing  values(12, 'April 1, 10:00am',1);
insert into showing values(13,'April 1 12:30pm',2 );
insert into showing values(14,'April 1 2:00pm', 3);
insert into showing values(15,'April 2 10:00am',4  );
insert into showing values(16,'April 2 12:30pm',5 );
insert into showing values(17,'April 2 2:00pm',6 );
insert into showing values(18,'April 3 10:00am',7);
insert into showing values(19,'April 3 12:00pm', 8);
insert into showing values(20,'April 3 1:30pm',9);
insert into showing values(21,'April 3 8:00pm', 10);
insert into showing values(22,'April 4 4:00pm', 11);
insert into showing  values(23, 'April 4, 7:00pm',1);
--DELETE FROM showing  where showing_id = 23;
--DELETE FROM showing_seat where seat_id  >=0;