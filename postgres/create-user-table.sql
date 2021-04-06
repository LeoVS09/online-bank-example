Create table Bank_User (
  ID Bigint not null,
  Name Varchar(128) not null,
  Balance real not null,
  CONSTRAINT Bank_User_pk PRIMARY KEY (ID)
);

Insert into Bank_User(ID, Name, Balance) values (1, 'Tom', 1000);
Insert into Bank_User(ID, Name, Balance) values (2, 'Jerry', 2000);
Insert into Bank_User(ID, Name, Balance) values (3, 'Donald', 3000);