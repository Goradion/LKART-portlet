create index IX_D0695FF5 on sbamdc_CardBox (name[$COLUMN_LENGTH:75$], userId);
create index IX_640EB765 on sbamdc_CardBox (name[$COLUMN_LENGTH:75$], userName[$COLUMN_LENGTH:75$]);
create index IX_FDC72C36 on sbamdc_CardBox (userId);

create index IX_E574F5A3 on sbamdc_Flashcard (cardBoxId_fk);