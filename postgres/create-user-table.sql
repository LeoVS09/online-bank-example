create table Bank_Account (
  ID      Bigint primary key,
  Balance real   not null
);

insert into Bank_Account(ID, Balance) values (1, 1000);
insert into Bank_Account(ID, Balance) values (2, 2000);
insert into Bank_Account(ID, Balance) values (3, 3000);

create table Bank_User (
   ID Bigint primary key,
   Name Varchar(128) not null,
   Account_id Bigint not null references Bank_Account
);

insert into Bank_User(ID, Name, Account_id) values (1, 'Tom', 1);
insert into Bank_User(ID, Name, Account_id) values (2, 'Jerry', 2);
insert into Bank_User(ID, Name, Account_id) values (3, 'Donald', 3);