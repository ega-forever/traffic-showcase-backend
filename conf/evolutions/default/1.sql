# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table BUS (
  ID                        bigint not null,
  FUEL_KIND_ID              bigint,
  NAME                      varchar(255),
  constraint pk_BUS primary key (ID))
;

create table Fuel (
  ID                        bigint not null,
  PRICE                     double,
  NAME                      varchar(255),
  constraint pk_Fuel primary key (ID))
;

create sequence BUS_seq;

create sequence Fuel_seq;

alter table BUS add constraint fk_BUS_fuel_1 foreign key (FUEL_KIND_ID) references Fuel (ID) on delete restrict on update restrict;
create index ix_BUS_fuel_1 on BUS (FUEL_KIND_ID);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists BUS;

drop table if exists Fuel;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists BUS_seq;

drop sequence if exists Fuel_seq;

