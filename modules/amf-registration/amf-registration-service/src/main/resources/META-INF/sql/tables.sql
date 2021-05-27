create table REGIS_UserEntry (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	userEntryId LONG not null primary key,
	homePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	userId LONG
);