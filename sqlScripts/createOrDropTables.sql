select * from users;
select * from purchase;
select * from ticket;
select * from tickettype;
select * from showing_seat;
select * from showing;
select * from movie;

drop table ticket;
drop table tickettype;
drop table purchase;
drop table users;
drop table showing_seat;
drop table showing; 
drop table movie;

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
create table ticket(
	ticket_id numeric primary key not null,
	seat_id_FK numeric references showing_seat(seat_id),
	ticket_type_id_FK numeric references tickettype(ticket_type_id),
	purchase_id_FK numeric references purchase(purchase_id)
);
create table tickettype(
	ticket_type_id numeric primary key not null,
	tickettype text not null,
	price numeric 
);
create table showing_seat(
	seat_id numeric primary key not null,
	seat_name text not null,
	status numeric,
	showing_id_fk numeric references showing(showing_id)
);
create table showing(
	showing_id numeric primary key not null,
	showtime text not null,
	movie_id_FK numeric references movie(movie_id) 
);
create table movie(
	movie_id numeric primary key not null,
	description text unique not null,
	duration numeric not null,
	poster text,
	title text not null
);

commit;