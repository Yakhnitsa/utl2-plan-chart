create table chart_entity_table (
  id bigint not null,
  confirmed integer not null,
  date datetime,
  declared integer not null,
  shipped integer not null,
  primary key (id))
  engine=MyISAM;

create table hibernate_sequence (next_val bigint)
  engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table order_table (
  id bigint not null,
  closed date,
  created date,
  note varchar(255),
  receive_station_code integer,
  send_station_code integer,
  primary key (id)) engine=MyISAM;


create table order_table_chart_elements (
  order_id bigint not null,
  chart_elements_id bigint not null,
  primary key (order_id,
               chart_elements_id)) engine=MyISAM;

create table partners_data (
  id bigint not null,
  code integer,
  descriptions varchar(1024),
   email_address varchar(255),
   full_company_name varchar(50),
   post_address varchar(255),
   short_company_name varchar(10),
   type varchar(255),
   primary key (id)) engine=MyISAM;

create table railroad_stations (
  code integer not null,
  administration varchar(255),
  location_x double precision not null,
  location_y double precision not null,
  node integer not null,
  rail_department varchar(255),
  rus_name varchar(255),
  ukr_name varchar(255),
  primary key (code)) engine=MyISAM;

create table user_role (
  user_id bigint not null,


  roles varchar(255)) engine=MyISAM;

create table system_user (
  id bigint not null,
  active bit not null,
  email varchar(255),
  password varchar(255),
  username varchar(255),
  primary key (id)) engine=MyISAM;

alter table order_table_chart_elements add constraint UK_hjra53qffypw76e2wd33x8a7q unique (chart_elements_id);

alter table order_table add constraint order_receive_station_fk foreign key (receive_station_code) references railroad_stations (code);

alter table order_table add constraint order_sent_station_fk foreign key (send_station_code) references railroad_stations (code);

alter table order_table_chart_elements add constraint table_elements_chart_entity_fk foreign key (chart_elements_id) references chart_entity_table (id);

alter table order_table_chart_elements add constraint elements_table_fk foreign key (order_id) references order_table (id);

alter table user_role add constraint user_role_system_user_fk foreign key (user_id) references system_user (id);
