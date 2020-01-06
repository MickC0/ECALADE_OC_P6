--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

-- Started on 2020-01-06 21:27:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 33526)
-- Name: climbingarea; Type: TABLE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE TABLE public.climbingarea (
    id integer NOT NULL,
    member_id integer NOT NULL,
    name character varying NOT NULL,
    region character varying NOT NULL,
    description character varying NOT NULL,
    profil character varying NOT NULL,
    rock_type character varying NOT NULL,
    maximum_height real NOT NULL,
    is_approuved boolean DEFAULT false NOT NULL
);


ALTER TABLE public.climbingarea OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 206 (class 1259 OID 41249)
-- Name: climbingarea_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE SEQUENCE public.climbingarea_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.climbingarea_id_seq OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 206
-- Name: climbingarea_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER SEQUENCE public.climbingarea_id_seq OWNED BY public.climbingarea.id;


--
-- TOC entry 201 (class 1259 OID 33575)
-- Name: comment; Type: TABLE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE TABLE public.comment (
    id integer NOT NULL,
    member_id integer NOT NULL,
    climbingarea_id integer NOT NULL,
    description character varying(5000) NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    update_date timestamp without time zone
);


ALTER TABLE public.comment OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 211 (class 1259 OID 41264)
-- Name: comment_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE SEQUENCE public.comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_id_seq OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 211
-- Name: comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER SEQUENCE public.comment_id_seq OWNED BY public.comment.id;


--
-- TOC entry 202 (class 1259 OID 33583)
-- Name: guidebook; Type: TABLE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE TABLE public.guidebook (
    id integer NOT NULL,
    member_id integer NOT NULL,
    name character varying NOT NULL,
    description character varying NOT NULL,
    added_date date NOT NULL,
    is_loaned boolean NOT NULL,
    region character varying
);


ALTER TABLE public.guidebook OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 210 (class 1259 OID 41261)
-- Name: guidebook_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE SEQUENCE public.guidebook_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.guidebook_id_seq OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 2897 (class 0 OID 0)
-- Dependencies: 210
-- Name: guidebook_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER SEQUENCE public.guidebook_id_seq OWNED BY public.guidebook.id;


--
-- TOC entry 196 (class 1259 OID 33518)
-- Name: member; Type: TABLE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE TABLE public.member (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    pseudo character varying(50) NOT NULL,
    gender character varying(10) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying NOT NULL,
    role character varying(50) NOT NULL,
    enabled boolean NOT NULL
);


ALTER TABLE public.member OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 205 (class 1259 OID 33657)
-- Name: member_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE SEQUENCE public.member_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.member_id_seq OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 2898 (class 0 OID 0)
-- Dependencies: 205
-- Name: member_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER SEQUENCE public.member_id_seq OWNED BY public.member.id;


--
-- TOC entry 200 (class 1259 OID 33567)
-- Name: photo; Type: TABLE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE TABLE public.photo (
    id integer NOT NULL,
    climbingarea_id integer NOT NULL,
    name character varying NOT NULL,
    url character varying NOT NULL
);


ALTER TABLE public.photo OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 209 (class 1259 OID 41258)
-- Name: photo_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE SEQUENCE public.photo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.photo_id_seq OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 2899 (class 0 OID 0)
-- Dependencies: 209
-- Name: photo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER SEQUENCE public.photo_id_seq OWNED BY public.photo.id;


--
-- TOC entry 204 (class 1259 OID 33593)
-- Name: reservation_request; Type: TABLE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE TABLE public.reservation_request (
    id integer NOT NULL,
    member_id integer NOT NULL,
    guidebook_id integer NOT NULL,
    status character varying NOT NULL
);


ALTER TABLE public.reservation_request OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 203 (class 1259 OID 33591)
-- Name: reservation_request_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE SEQUENCE public.reservation_request_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_request_id_seq OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 2900 (class 0 OID 0)
-- Dependencies: 203
-- Name: reservation_request_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER SEQUENCE public.reservation_request_id_seq OWNED BY public.reservation_request.id;


--
-- TOC entry 199 (class 1259 OID 33543)
-- Name: route; Type: TABLE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE TABLE public.route (
    id integer NOT NULL,
    sector_id integer NOT NULL,
    name character varying NOT NULL,
    description character varying NOT NULL,
    cotation character varying NOT NULL,
    height real NOT NULL
);


ALTER TABLE public.route OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 208 (class 1259 OID 41255)
-- Name: route_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE SEQUENCE public.route_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.route_id_seq OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 2901 (class 0 OID 0)
-- Dependencies: 208
-- Name: route_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER SEQUENCE public.route_id_seq OWNED BY public.route.id;


--
-- TOC entry 198 (class 1259 OID 33535)
-- Name: sector; Type: TABLE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE TABLE public.sector (
    id integer NOT NULL,
    climbingarea_id integer NOT NULL,
    name character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.sector OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 207 (class 1259 OID 41252)
-- Name: sector_id_seq; Type: SEQUENCE; Schema: public; Owner: admin_lesamisdelescalade
--

CREATE SEQUENCE public.sector_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sector_id_seq OWNER TO admin_lesamisdelescalade;

--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 207
-- Name: sector_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER SEQUENCE public.sector_id_seq OWNED BY public.sector.id;


--
-- TOC entry 2737 (class 2604 OID 41251)
-- Name: climbingarea id; Type: DEFAULT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.climbingarea ALTER COLUMN id SET DEFAULT nextval('public.climbingarea_id_seq'::regclass);


--
-- TOC entry 2741 (class 2604 OID 41266)
-- Name: comment id; Type: DEFAULT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.comment ALTER COLUMN id SET DEFAULT nextval('public.comment_id_seq'::regclass);


--
-- TOC entry 2742 (class 2604 OID 41263)
-- Name: guidebook id; Type: DEFAULT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.guidebook ALTER COLUMN id SET DEFAULT nextval('public.guidebook_id_seq'::regclass);


--
-- TOC entry 2735 (class 2604 OID 33659)
-- Name: member id; Type: DEFAULT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.member ALTER COLUMN id SET DEFAULT nextval('public.member_id_seq'::regclass);


--
-- TOC entry 2740 (class 2604 OID 41260)
-- Name: photo id; Type: DEFAULT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.photo ALTER COLUMN id SET DEFAULT nextval('public.photo_id_seq'::regclass);


--
-- TOC entry 2743 (class 2604 OID 33596)
-- Name: reservation_request id; Type: DEFAULT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.reservation_request ALTER COLUMN id SET DEFAULT nextval('public.reservation_request_id_seq'::regclass);


--
-- TOC entry 2739 (class 2604 OID 41257)
-- Name: route id; Type: DEFAULT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.route ALTER COLUMN id SET DEFAULT nextval('public.route_id_seq'::regclass);


--
-- TOC entry 2738 (class 2604 OID 41254)
-- Name: sector id; Type: DEFAULT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.sector ALTER COLUMN id SET DEFAULT nextval('public.sector_id_seq'::regclass);


--
-- TOC entry 2747 (class 2606 OID 33534)
-- Name: climbingarea climbingarea_pk; Type: CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.climbingarea
    ADD CONSTRAINT climbingarea_pk PRIMARY KEY (id);


--
-- TOC entry 2755 (class 2606 OID 33582)
-- Name: comment comment_pk; Type: CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pk PRIMARY KEY (id);


--
-- TOC entry 2757 (class 2606 OID 33590)
-- Name: guidebook guidebook_pk; Type: CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.guidebook
    ADD CONSTRAINT guidebook_pk PRIMARY KEY (id);


--
-- TOC entry 2745 (class 2606 OID 33525)
-- Name: member member_pk; Type: CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.member
    ADD CONSTRAINT member_pk PRIMARY KEY (id);


--
-- TOC entry 2753 (class 2606 OID 33574)
-- Name: photo photo_pk; Type: CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_pk PRIMARY KEY (id);


--
-- TOC entry 2759 (class 2606 OID 33601)
-- Name: reservation_request reservation_request_pk; Type: CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.reservation_request
    ADD CONSTRAINT reservation_request_pk PRIMARY KEY (id);


--
-- TOC entry 2751 (class 2606 OID 33550)
-- Name: route route_pk; Type: CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.route
    ADD CONSTRAINT route_pk PRIMARY KEY (id);


--
-- TOC entry 2749 (class 2606 OID 33542)
-- Name: sector sector_pk; Type: CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.sector
    ADD CONSTRAINT sector_pk PRIMARY KEY (id);


--
-- TOC entry 2765 (class 2606 OID 33622)
-- Name: comment climbingarea_comment_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT climbingarea_comment_fk FOREIGN KEY (climbingarea_id) REFERENCES public.climbingarea(id);


--
-- TOC entry 2763 (class 2606 OID 33627)
-- Name: photo climbingarea_photo_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT climbingarea_photo_fk FOREIGN KEY (climbingarea_id) REFERENCES public.climbingarea(id);


--
-- TOC entry 2761 (class 2606 OID 33642)
-- Name: sector climbingarea_sector_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.sector
    ADD CONSTRAINT climbingarea_sector_fk FOREIGN KEY (climbingarea_id) REFERENCES public.climbingarea(id);


--
-- TOC entry 2768 (class 2606 OID 33652)
-- Name: reservation_request guidebook_reservation_request_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.reservation_request
    ADD CONSTRAINT guidebook_reservation_request_fk FOREIGN KEY (guidebook_id) REFERENCES public.guidebook(id);


--
-- TOC entry 2760 (class 2606 OID 33612)
-- Name: climbingarea member_climbingarea_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.climbingarea
    ADD CONSTRAINT member_climbingarea_fk FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- TOC entry 2764 (class 2606 OID 33617)
-- Name: comment member_comment_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT member_comment_fk FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- TOC entry 2766 (class 2606 OID 33607)
-- Name: guidebook member_guidebook_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.guidebook
    ADD CONSTRAINT member_guidebook_fk FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- TOC entry 2767 (class 2606 OID 33602)
-- Name: reservation_request member_reservation_request_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.reservation_request
    ADD CONSTRAINT member_reservation_request_fk FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- TOC entry 2762 (class 2606 OID 33647)
-- Name: route sector_route_fk; Type: FK CONSTRAINT; Schema: public; Owner: admin_lesamisdelescalade
--

ALTER TABLE ONLY public.route
    ADD CONSTRAINT sector_route_fk FOREIGN KEY (sector_id) REFERENCES public.sector(id);


-- Completed on 2020-01-06 21:27:56

--
-- PostgreSQL database dump complete
--

