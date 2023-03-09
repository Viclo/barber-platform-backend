CREATE TABLE IF NOT EXISTS customers (
  id_customer uuid primary key,
  name varchar(128) not null,
  nit bigint not null,
  gender varchar(32) 
);

CREATE TABLE IF NOT EXISTS employees (
  id_employee uuid primary key,
  firstName varchar(64) not null,
  lastName varchar(64) not null,
  ci bigint not null,
  birthdate date not null,
  salary decimal not null
);

CREATE TABLE IF NOT EXISTS services (
  id_service uuid primary key,
  name varchar(64) not null,
  description varchar(256),
  price decimal not null,
  estimateTime time
);

CREATE TABLE IF NOT EXISTS tickets (
  id_ticket uuid primary key,
  id_customer uuid not null,
  id_employee uuid not null,
  id_service uuid not null,
  numero int not null,
  foreign key (id_customer) references customers(id_customer) on delete cascade,
  foreign key (id_employee) references employees(id_employee) on delete cascade,
  foreign key (id_service) references services(id_service) on delete cascade
);

CREATE TABLE IF NOT EXISTS invoices (
  id_invoice uuid primary key,
  id_customer uuid not null,
  total decimal not null,
  foreign key (id_customer) references customers(id_customer) on delete cascade
);

CREATE TABLE IF NOT EXISTS invoices_services (
  id_invoice uuid not null,
  id_customer uuid not null,
  primary key (id_invoice, id_customer),
  foreign key (id_invoice) references invoices(id_invoice) on delete cascade,
  foreign key (id_customer) references customers(id_customer) on delete cascade
);