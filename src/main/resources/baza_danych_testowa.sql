--
-- PostgreSQL database dump
--

-- SET client_encoding = 'UTF8';
-- SET check_function_bodies = false;
-- SET client_min_messages = warning;
-- SET search_path = public, pg_catalog;
-- SET default_tablespace = '';
-- SET default_with_oids = false;

--
-- TOC entry 2083 (class 1259 OID 392707)
-- Dependencies: 5
-- Name: tabela_testowa; Type: TABLE; Schema: public; Owner: postgres; Tablespace:
--

CREATE TABLE tabela_testowa (
    id bigint AUTO_INCREMENT,
    kolumna1 varchar(255),
    kolumna2 varchar(255),
    kolumna3 varchar(255),
    kolumna4 bigint,
    PRIMARY KEY(id)
);


-- ALTER TABLE public.tabela_testowa OWNER TO postgres;

--
-- TOC entry 2407 (class 0 OID 392707)
-- Dependencies: 2083
-- Data for Name: tabela_testowa; Type: TABLE DATA; Schema: public; Owner: postgres
--

insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość1','wartość2','wartość3',1);
insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość21','wartość22','wartość23',5);
insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość31','wartość22','wartość32',6);
insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość54','wartość43','wartość45',4);
insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość43','wartość23','wartość34',4);
insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość43','wartość54','wartość43',2);
insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość54','wartość52','wartość53',8);
insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość21','wartość2211','wartość43',4);
insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość43','wartość33','wartość45',9);
insert into tabela_testowa (kolumna1, kolumna2, kolumna3, kolumna4) VALUES ('wartość87','wartość62','wartość11',3);



--
-- TOC entry 2406 (class 2606 OID 392713)
-- Dependencies: 2083 2083
-- Name: i1_constr; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace:
--

-- ALTER TABLE ONLY tabela_testowa
--     ADD CONSTRAINT i1_constr PRIMARY KEY (id);


