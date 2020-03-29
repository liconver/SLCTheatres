insert into tickettype values(1,'Adult',12.99);
insert into tickettype values(2,'Senior',8.99);
insert into tickettype values(3,'Child',6.99);

DELETE FROM users  where user_id  >=0;

select * from users;
insert into users values(1, 'batman', 'password', 'bat', 'man', 'bat@mail.com');
insert into users values(2, 'cjf', '7777', 'Christian', 'Falzone', 'c@gmail');
insert into users values(3, 'serg', 'berg', 'Sergio', 'Gamboa', 's@yahoo.com');
insert into users values(4, 'liam', 'taken', 'Liam', 'Converse', 'l@revature.com');

CREATE TRIGGER add_showing_seats
AFTER INSERT ON showing
    FOR EACH ROW EXECUTE PROCEDURE insert_showing_seats_when_showing_is_inserted();
   
CREATE SEQUENCE mysequence
INCREMENT 1
START 1;

drop sequence mysequence;



create or replace function insert_showing_seats_when_showing_is_inserted()
returns trigger as $$
begin 
	insert into showing_seat values(nextval('mysequence'), 'A1',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'A2',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'A3',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'A4',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'A5',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'A6',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'A7',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'A8',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'A9',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'A10',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B1',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B2',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B3',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B4',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B5',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B6',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B7',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B8',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B9',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'B10',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C1',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C2',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C3',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C4',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C5',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C6',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C7',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C8',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C9',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'C10',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D1',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D2',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D3',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D4',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D5',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D6',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D7',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D8',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D9',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'D10',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E1',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E2',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E3',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E4',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E5',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E6',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E7',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E8',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E9',0,new.movie_id_fk);
	insert into showing_seat values(nextval('mysequence'), 'E10',0,new.movie_id_fk);
	return null;
end
$$ language 'plpgsql';


