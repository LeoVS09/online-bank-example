Create table Bank_User (
  ID Bigint primary key,
  Name Varchar(128) not null,
  Balance real not null
);

Insert into Bank_User(ID, Name, Balance) values (1, 'Tom', 1000);
Insert into Bank_User(ID, Name, Balance) values (2, 'Jerry', 2000);
Insert into Bank_User(ID, Name, Balance) values (3, 'Donald', 3000);

Create table Bank_Bill (
   ID Bigint primary key,
   Seller_id Bigint not null references Bank_User,
   Customer_id Bigint not null references Bank_User,
   Amount real not null
);

Insert into Bank_Bill(ID, Seller_id, Customer_id, Amount) values (1, 1, 2, 300);
Insert into Bank_Bill(ID, Seller_id, Customer_id, Amount) values (2, 2, 3, 400);
Insert into Bank_Bill(ID, Seller_id, Customer_id, Amount) values (3, 3, 1, 500);