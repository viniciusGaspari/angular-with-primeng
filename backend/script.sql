CREATE TABLE companies (
    company_id INTEGER GENERATED ALWAYS AS IDENTITY,
	company_cnpj integer,
    company_email VARCHAR(255) NOT NULL,
    company_name VARCHAR(255) NOT NULL,
    company_password VARCHAR(255) NOT NULL,
    role_id integer,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP WITH TIME ZONE,

    CONSTRAINT companies_role_id_fkey FOREIGN KEY (role_id) REFERENCES roles(role_id),
	CONSTRAINT companies_pkey PRIMARY KEY (company_id),
    CONSTRAINT companies_email_unique UNIQUE (company_email),
	constraint companies_cnpj_unique UNIQUE (company_cnpj)
);

CREATE TABLE permissions (
    permissions_id INTEGER GENERATED ALWAYS AS IDENTITY,
    can_delete BOOLEAN DEFAULT FALSE,
    can_create BOOLEAN DEFAULT FALSE,
    can_read BOOLEAN DEFAULT TRUE,
    can_update BOOLEAN DEFAULT FALSE,
    CONSTRAINT permissions_pkey PRIMARY KEY (permissions_id)
);

CREATE TABLE roles (
    role_id INTEGER GENERATED ALWAYS AS IDENTITY,
    role_name VARCHAR(50) NOT NULL,
    permissions_id INTEGER,
    CONSTRAINT roles_pkey PRIMARY KEY (role_id),
    CONSTRAINT roles_permissions_id_fkey FOREIGN KEY (permissions_id) REFERENCES permissions(permissions_id)
);

CREATE TABLE employees (
    employee_id INTEGER GENERATED ALWAYS AS IDENTITY,
    employee_name VARCHAR(100) NOT NULL,
    role_id INTEGER,
    company_id INTEGER,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP WITH TIME ZONE,
    CONSTRAINT employee_pkey PRIMARY KEY (employee_id),
    CONSTRAINT employee_role_id_fkey FOREIGN KEY (role_id) REFERENCES roles(role_id)
);