create index IX_D0695FF5 on sbamdc_CardBox (name[$COLUMN_LENGTH:75$], userId);
create index IX_640EB765 on sbamdc_CardBox (name[$COLUMN_LENGTH:75$], userName[$COLUMN_LENGTH:75$]);
create index IX_FDC72C36 on sbamdc_CardBox (userId);

create index IX_EE7F8005 on sbamdc_Flashcard (cardBoxId_fk, title[$COLUMN_LENGTH:75$]);
create index IX_6642C99B on sbamdc_Flashcard (userId);

create index IX_C71F0BB4 on sbamdc_LearnProgress (cardBoxId_fk);
create index IX_749FA01E on sbamdc_LearnProgress (userId_fk, cardBoxId_fk);
create index IX_AC919299 on sbamdc_LearnProgress (userId_fk, flashcardId_fk);