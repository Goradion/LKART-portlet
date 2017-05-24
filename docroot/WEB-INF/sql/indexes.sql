create index IX_6319623B on sbamdc_CardBox (author[$COLUMN_LENGTH:75$]);
create index IX_67C0F2BB on sbamdc_CardBox (name[$COLUMN_LENGTH:75$]);

create index IX_E574F5A3 on sbamdc_Flashcard (cardBoxId_fk);