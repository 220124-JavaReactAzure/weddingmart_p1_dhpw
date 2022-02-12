-- DROP SCHEMA dbo;

CREATE SCHEMA dbo;
-- weddingmart.dbo.app_users definition

-- Drop table

-- DROP TABLE weddingmart.dbo.app_users;

CREATE TABLE weddingmart.dbo.app_users (
	email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	username varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	password varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	phone varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__app_user__AB6E6165FA7D652F PRIMARY KEY (email)
);


-- weddingmart.dbo.asset_type definition

-- Drop table

-- DROP TABLE weddingmart.dbo.asset_type;

CREATE TABLE weddingmart.dbo.asset_type (
	id int IDENTITY(1,1) NOT NULL,
	description varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__asset_ty__3213E83FD92AC23B PRIMARY KEY (id)
);


-- weddingmart.dbo.meal_choice definition

-- Drop table

-- DROP TABLE weddingmart.dbo.meal_choice;

CREATE TABLE weddingmart.dbo.meal_choice (
	id int NOT NULL,
	description varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__meal_cho__3213E83FF71BCAC4 PRIMARY KEY (id)
);


-- weddingmart.dbo.wedding definition

-- Drop table

-- DROP TABLE weddingmart.dbo.wedding;

CREATE TABLE weddingmart.dbo.wedding (
	id int IDENTITY(1,1) NOT NULL,
	budget float NULL,
	wedding_date date NULL,
	rsvp_by_date date NULL,
	CONSTRAINT PK__wedding__3213E83F0923193D PRIMARY KEY (id)
);


-- weddingmart.dbo.asset definition

-- Drop table

-- DROP TABLE weddingmart.dbo.asset;

CREATE TABLE weddingmart.dbo.asset (
	id int IDENTITY(1,1) NOT NULL,
	email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	name varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	phone varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	price float NULL,
	address varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	type_id int NULL,
	CONSTRAINT PK__asset__3213E83F2784FDE7 PRIMARY KEY (id),
	CONSTRAINT asset_FK FOREIGN KEY (type_id) REFERENCES weddingmart.dbo.asset_type(id)
);


-- weddingmart.dbo.asset_booking definition

-- Drop table

-- DROP TABLE weddingmart.dbo.asset_booking;

CREATE TABLE weddingmart.dbo.asset_booking (
	asset_id int NOT NULL,
	wedding_id int NOT NULL,
	booking_date date NULL,
	CONSTRAINT PK__asset_bo__1C062A0675A956B0 PRIMARY KEY (asset_id,wedding_id),
	CONSTRAINT asset_booking_FK_asset FOREIGN KEY (asset_id) REFERENCES weddingmart.dbo.asset(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT asset_booking_FK_wedding FOREIGN KEY (wedding_id) REFERENCES weddingmart.dbo.wedding(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- weddingmart.dbo.attendee definition

-- Drop table

-- DROP TABLE weddingmart.dbo.attendee;

CREATE TABLE weddingmart.dbo.attendee (
	user_email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	wedding_id int NOT NULL,
	rsvp_answer bit NULL,
	plus_one_rsvp bit NULL,
	CONSTRAINT PK__attendee__7E76DE08E8925FDF PRIMARY KEY (user_email,wedding_id),
	CONSTRAINT attendee_FK_user_email FOREIGN KEY (user_email) REFERENCES weddingmart.dbo.app_users(email) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT attendee_FK_wedding_id FOREIGN KEY (wedding_id) REFERENCES weddingmart.dbo.wedding(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- weddingmart.dbo.betrothed definition

-- Drop table

-- DROP TABLE weddingmart.dbo.betrothed;

CREATE TABLE weddingmart.dbo.betrothed (
	user_email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	wedding_id int NULL,
	CONSTRAINT PK__betrothe__B0FBA21343C43A2E PRIMARY KEY (user_email),
	CONSTRAINT betrothed_FK_user_email FOREIGN KEY (user_email) REFERENCES weddingmart.dbo.app_users(email) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT betrothed_FK_wedding_id FOREIGN KEY (wedding_id) REFERENCES weddingmart.dbo.wedding(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- weddingmart.dbo.employee definition

-- Drop table

-- DROP TABLE weddingmart.dbo.employee;

CREATE TABLE weddingmart.dbo.employee (
	user_email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT PK__employee__B0FBA213D56BC784 PRIMARY KEY (user_email),
	CONSTRAINT employee_FK FOREIGN KEY (user_email) REFERENCES weddingmart.dbo.app_users(email) ON DELETE CASCADE ON UPDATE CASCADE
);


-- weddingmart.dbo.meal_order definition

-- Drop table

-- DROP TABLE weddingmart.dbo.meal_order;

CREATE TABLE weddingmart.dbo.meal_order (
	user_email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	wedding_id int NOT NULL,
	lunch_choice int NULL,
	dinner_choice int NULL,
	CONSTRAINT PK__meal_ord__7E76DE0819DE2766 PRIMARY KEY (user_email,wedding_id),
	CONSTRAINT meal_order_FK FOREIGN KEY (user_email,wedding_id) REFERENCES weddingmart.dbo.attendee(user_email,wedding_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT meal_order_FK_dinner FOREIGN KEY (dinner_choice) REFERENCES weddingmart.dbo.meal_choice(id),
	CONSTRAINT meal_order_FK_lunch FOREIGN KEY (lunch_choice) REFERENCES weddingmart.dbo.meal_choice(id)
);


-- weddingmart.dbo.meal_order_plus_one definition

-- Drop table

-- DROP TABLE weddingmart.dbo.meal_order_plus_one;

CREATE TABLE weddingmart.dbo.meal_order_plus_one (
	user_email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	wedding_id int NOT NULL,
	lunch_choice int NULL,
	dinner_choice int NULL,
	CONSTRAINT PK__meal_ord__7E76DE089EC6D185 PRIMARY KEY (user_email,wedding_id),
	CONSTRAINT meal_order_plus_one_FK FOREIGN KEY (user_email,wedding_id) REFERENCES weddingmart.dbo.attendee(user_email,wedding_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT meal_order_plus_one_FK_dinner FOREIGN KEY (dinner_choice) REFERENCES weddingmart.dbo.meal_choice(id),
	CONSTRAINT meal_order_plus_one_FK_lunch FOREIGN KEY (lunch_choice) REFERENCES weddingmart.dbo.meal_choice(id)
);
