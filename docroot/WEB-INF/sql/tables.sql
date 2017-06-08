create table sbamdc_CardBox (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	author VARCHAR(75) null,
	shared BOOLEAN
);

create table sbamdc_Flashcard (
	id_ LONG not null primary key,
	frontSide STRING null,
	backSide STRING null,
	cardBoxId_fk LONG,
	title VARCHAR(75) null
);