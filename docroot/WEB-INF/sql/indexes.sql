create index IX_D0695FF5 on sbamdc_CardBox (name[$COLUMN_LENGTH:75$], userId);
create index IX_FDC72C36 on sbamdc_CardBox (userId);

create index IX_E574F5A3 on sbamdc_Flashcard (cardBoxId_fk);
create index IX_6642C99B on sbamdc_Flashcard (userId);