create database jukebox;
use jukebox;
create table songs(songId int primary key auto_increment, trackName varchar(100) not null,
trackPath varchar(100) not null, duration double not null,
rating int not null ,artist varchar(50) not null,genre varchar(20) not null);
insert into songs(trackName,trackPath, duration,rating,artist,genre) values ('Tere Naam',
'src/main/resources/Tere Naam - Tere Naam 128 Kbps.wav',4.05,4,'Udit','Sad');
create table playlist(playlistid int not null,songId  int not null );
insert into playlist (playlistid,songId) values(1,1);
create table playlistdetails(playlistid int primary key,playlistname varchar(200) not null);
insert into playlistdetails (playlistid,playlistname) values(1,'Abc');
select * from songs where genre like 'pop';
select trackPath from songs where songId = 1;
SELECT * FROM jukebox.songs;
SELECT * FROM jukebox.playlist;
SELECT * FROM jukebox.playlistdetails;