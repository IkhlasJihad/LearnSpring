-- Database: library

-- DROP DATABASE library;

CREATE DATABASE library
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-----------------------

-- SCHEMA: simple-lib

-- DROP SCHEMA "simple-lib" ;

CREATE SCHEMA "simple-lib"
    AUTHORIZATION postgres;

-- DROP TABLE "simple-lib".book;

CREATE TABLE "simple-lib".book
(
    id integer NOT NULL,
    name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    author_name character varying(20) COLLATE pg_catalog."default",
    isbn character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT book_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;