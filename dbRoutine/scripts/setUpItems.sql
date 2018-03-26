insert into resource(name, type, url)
values ('Медиатор', 'img', '/img/items/mediator.png');

-- Item prototypes ~ types
insert into item_type(name, image_resource_id)
values ('Медиатор', 
	(select resource_id from resource 
		where name = 'Медиатор'));
 
