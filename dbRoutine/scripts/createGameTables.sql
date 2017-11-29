create table Resource(
	resource_id serial primary  key,
	name varchar(120),
	type varchar(120),
	URL varchar(1200) not null
);

create table User(
	user_id     serial primary key,
	login       varchar(80) unique not null,
	auth_type   varchar(40)        not null,
	id_external varchar(120), --#for data created by external auth-providers
	password bytea not null,
	access_level integer default 0 not null
);

create table Character(
	character_id serial primary key,

	name  varchar(80) default '',
	class varchar(40) default 'plain',

	health  integer default 0 not null,
	roses   integer default 0 not null,
	d_roses integer default 0 not null,
	defence integer default 0 not null,
	attack  integer default 0 not null,
	rhythm  integer default 0 not null,
	experience integer default 0 not null,

	adventuring_since date,

	image_resource_id integer
	                references Resource(resource_id) 
	                default 0 --# 0 - изображение персонажа
					on update cascade
					on delete set default,
);

create table Item_Type(
	item_id serial primary key,
	parent_id integer references Item(item_id)
						on update cascade
						on delete set null,
	name varchar(80),
	image_resource_id references Resource(resource_id)
					   default 1 --# - предмет
					   on update cascade 
					   on delete set default,
);

create table Item(
	item_id serial primary key,
	type_id integer references Item_Type(item_id)
					on update cascade
					on delete set null, --# ??
	price integer default 0 not null,
	name varchar(80) default null,

);

create table Character_Item(
	item_id      integer references Item(item_id)
				on update cascade
				on delete cascade, -- ??
	character_id integer references Character(character_id)
				on update cascade
				on delete cascade,
	number integer default 1 not null,
	slot smallint default null,
	primary key(item_id, character_id)
);
create table Event(
	event_id serial primary key,
	name varchar(800),
	description varchar(8000) default '',
	reward_script_id references Script(script_id)
						on update cascade
						on delete set null,
); 

create table Script(
	script_id serial primary key,
	name varchar(120) unique,
	script text not null
);

create table Ability(
	ability_id serial primary key,
	name varchar(80),
	description text default null,

	ability_script_id integer references Script(script_id)
					default null
					on update cascade,
					on delete  set null,
	for_class varchar(80) default 'any',
	min_exp_to_use integer default 0 not null,
	cooldown integer default 0 not null,
	only_in_battle boolean default TRUE not null,
	passive 	   boolean default FALSE not null,

	image_resource_id references Resource(resource_id)
					   default 2 --# - навык
					   on update cascade 
					   on delete set default,
);

create table Character_Ability(
	ability_id integer references Ability(ability_id)
					on update cascade 
					on delete set null, -- ??
	character_id integer references Character(character_id)
					on update cascade
					on delete cascade,

	power_level integer default 0,
	last_useed  date default null,
	primary key(ability_id, character_id)
);
-- THEORY --
create table Question(
	question_id serial primary key,
	content text not null,
	answer text not null,
	wrong1 text,
	wrong2 text,
	wrong3 text
);

create table Test(
	test_id serial primary key,
	title varchar(200),
	description varchar(4000) default '',
	reward_script_id references Script(script_id)
						on update cascade
						on delete set null,
);


create table Course(
		course_id serial primary key,
		title varchar(1000),
		description varchar(4000) default ''
);

create table Article(
	article_id serial primary key,
	corse_id integer references Course(corse_id)
				on update cascade
				on delete set null,
	title varchar(80),
	subtitle varchar(80) default '',

	content text not null,

);

