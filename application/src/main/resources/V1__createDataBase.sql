CREATE TABLE organizations
(
    name VARCHAR NOT NULL,
    CONSTRAINT organizations_pk PRIMARY KEY (name)
);
CREATE TABLE products
(
    id           SERIAL,
    name         VARCHAR        NOT NULL,
    organization VARCHAR NOT NULL REFERENCES organizations (name) ON UPDATE CASCADE ON DELETE CASCADE,
    amount       INTEGER        NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (id)
);



