select * from movie;

DELETE FROM movie  where movie_id  >=0;


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

select * from showing;
DELETE FROM showing  where showing_id  >=0;

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

DELETE FROM showing  where showing_id = 23;
DELETE FROM showing_seat where seat_id  >=0;

insert into showing_seat values (51, 'A1', 0, 7); --Name, status, showingId
insert into showing_seat values (52, 'A2', 0, 7);
insert into showing_seat values (53, 'A3', 0, 7);
insert into showing_seat values (54, 'A4', 0, 7);
insert into showing_seat values (55, 'A5', 0, 7);
insert into showing_seat values (56, 'A6', 0, 7);
insert into showing_seat values (57, 'A7', 0, 7);
insert into showing_seat values (58, 'A8', 0, 7);
insert into showing_seat values (59, 'A9', 0, 7);
insert into showing_seat values (60, 'A10', 0, 7);
insert into showing_seat values (61, 'B1', 0, 7);
insert into showing_seat values (62, 'B2', 0, 7);
insert into showing_seat values (63, 'B3', 0, 7);
insert into showing_seat values (64, 'B4', 0, 7);
insert into showing_seat values (65, 'B5', 0, 7);
insert into showing_seat values (66, 'B6', 0, 7);
insert into showing_seat values (67, 'B7', 0, 7);
insert into showing_seat values (68, 'B8', 0, 7);
insert into showing_seat values (69, 'B9', 0, 7);
insert into showing_seat values (70, 'B10', 0, 7);
insert into showing_seat values (71, 'C1', 0, 7);
insert into showing_seat values (72, 'C2', 0, 7);
insert into showing_seat values (73, 'C3', 0, 7);
insert into showing_seat values (74, 'C4', 0, 7);
insert into showing_seat values (75, 'C5', 0, 7);
insert into showing_seat values (76, 'C6', 0, 7);
insert into showing_seat values (77, 'C7', 0, 7);
insert into showing_seat values (78, 'C8', 0, 7);
insert into showing_seat values (79, 'C9', 0, 7);
insert into showing_seat values (80, 'C10', 0, 7);
insert into showing_seat values (81, 'D1', 0, 7);
insert into showing_seat values (82, 'D2', 0, 7);
insert into showing_seat values (83, 'D3', 0, 7);
insert into showing_seat values (84, 'D4', 0, 7);
insert into showing_seat values (85, 'D5', 0, 7);
insert into showing_seat values (86, 'D6', 0, 7);
insert into showing_seat values (87, 'D7', 0, 7);
insert into showing_seat values (88, 'D8', 0, 7);
insert into showing_seat values (89, 'D9', 0, 7);
insert into showing_seat values (90, 'D10', 0, 7);
insert into showing_seat values (91, 'E1', 0, 7);
insert into showing_seat values (92, 'E2', 0, 7);
insert into showing_seat values (93, 'E3', 0, 7);
insert into showing_seat values (94, 'E4', 0, 7);
insert into showing_seat values (95, 'E5', 0, 7);
insert into showing_seat values (96, 'E6', 0, 7);
insert into showing_seat values (97, 'E7', 0, 7);
insert into showing_seat values (98, 'E8', 0, 7);
insert into showing_seat values (99, 'E9', 0, 7);
insert into showing_seat values (100, 'E10', 0, 7);


