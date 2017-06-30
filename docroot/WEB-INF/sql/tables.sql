create table sbamdc_CardBox (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	shared BOOLEAN
);

create table sbamdc_Flashcard (
	id_ LONG not null primary key,
	userId LONG,
	frontSide STRING null,
	backSide STRING null,
	cardBoxId_fk LONG,
	title VARCHAR(75) null
);

create table sbamdc_LearnProgress (
	id_ LONG not null primary key,
	userId_fk LONG,
	cardBoxId_fk LONG,
	flashcardId_fk LONG,
	progress INTEGER
);

create table sbamdc_learnProgress (
	id_ LONG not null primary key,
	userId_fk LONG,
	flashCardId_fk LONG,
	slot INTEGER
);