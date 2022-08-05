/* REGIONES */
INSERT INTO public.regiones ( nombre ) VALUES ( 'SUDAMERICA' );
INSERT INTO public.regiones ( nombre ) VALUES ( 'EUROPA' );
INSERT INTO public.regiones ( nombre ) VALUES ( 'ASIA' );
INSERT INTO public.regiones ( nombre ) VALUES ( 'AUSTRALIA' );


/* CLIENTES */

INSERT INTO public.clientes ( nombre, apellido, email, create_at, region_id ) VALUES ( 'Juan'   ,'Calle'    ,'juan@gmail.com'   ,'2008/12/31', 1 );
INSERT INTO public.clientes ( nombre, apellido, email, create_at, region_id ) VALUES ( 'Jose'   ,'Martinez' ,'jose@gmail.com'   ,'2008/12/31', 2 );
INSERT INTO public.clientes ( nombre, apellido, email, create_at, region_id ) VALUES ( 'Maria'  ,'Salgado'  ,'maria@gmail.com'  ,'2008/12/31', 1 );
INSERT INTO public.clientes ( nombre, apellido, email, create_at, region_id ) VALUES ( 'James'  ,'Calle'    ,'juan@gmail.com'   ,'2008/12/31', 3 );
INSERT INTO public.clientes ( nombre, apellido, email, create_at, region_id ) VALUES ( 'Rasmus' ,'Martinez' ,'jose@gmail.com'   ,'2008/12/31', 1 );
INSERT INTO public.clientes ( nombre, apellido, email, create_at, region_id ) VALUES ( 'Steven' ,'Salgado'  ,'maria@gmail.com'  ,'2008/12/31', 2 );

/* USUARIOS */

INSERT INTO public.usuarios ( username, password, enabled, nombre, apellido, email ) VALUES ( 'andres'  , '$2a$10$trDwOt5FAc2bSDxKxYHrSOeZCqpQvgm9Vegd.qBHGn3FmopoRVKhK', true, 'andres'    , 'guzman'  , 'andres.guzman@gmail.com' );
INSERT INTO public.usuarios ( username, password, enabled, nombre, apellido, email ) VALUES ( 'admin'   , '$2a$10$zIB.XWHdySJ7jbcmcO0vHOqFHTwW48Twpw7stGLD9kdj8i0xviTpq', true, 'juan'      , 'perez'   , 'juan.perez@gmail.com' );

/* ROLES */

INSERT INTO public.roles ( name_role, description ) VALUES ( 'ROLE_USER'    , 'Este rol pertenece al usuario comun' );
INSERT INTO public.roles ( name_role, description ) VALUES ( 'ROLE_ADMIN'   , 'Administrador con la mayoria de acciones permitidas' );

/* USUARIOS_ROLES */

INSERT INTO public.users_roles ( user_id, role_id ) VALUES ( 1, 1 );
INSERT INTO public.users_roles ( user_id, role_id ) VALUES ( 2, 2 );
INSERT INTO public.users_roles ( user_id, role_id ) VALUES ( 2, 1 );