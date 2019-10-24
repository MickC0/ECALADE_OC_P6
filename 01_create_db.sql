
CREATE SEQUENCE public.member_id_seq;

CREATE TABLE public.member (
                id INTEGER NOT NULL DEFAULT nextval('public.member_id_seq'),
                first_name VARCHAR(50) NOT NULL,
                last_name VARCHAR(50) NOT NULL,
                pseudo VARCHAR(50) NOT NULL,
                birthdate DATE NOT NULL,
                gender VARCHAR(10) NOT NULL,
                email VARCHAR(50) NOT NULL,
                password VARCHAR NOT NULL,
                is_member BOOLEAN NOT NULL,
                is_admin BOOLEAN NOT NULL,
                CONSTRAINT member_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.member_id_seq OWNED BY public.member.id;

CREATE TABLE public.climbingarea (
                id INTEGER NOT NULL,
                member_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                region VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                profil VARCHAR NOT NULL,
                rock_type VARCHAR NOT NULL,
                hold_type VARCHAR NOT NULL,
                maximum_height REAL NOT NULL,
                is_approuved BOOLEAN DEFAULT false NOT NULL,
                CONSTRAINT climbingarea_pk PRIMARY KEY (id)
);


CREATE TABLE public.sector (
                id INTEGER NOT NULL,
                climbingarea_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                CONSTRAINT sector_pk PRIMARY KEY (id)
);


CREATE TABLE public.route (
                id INTEGER NOT NULL,
                sector_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                cotation VARCHAR NOT NULL,
                height REAL NOT NULL,
                pitch_number INTEGER NOT NULL,
                CONSTRAINT route_pk PRIMARY KEY (id)
);


CREATE TABLE public.startingpoint (
                id INTEGER NOT NULL,
                climbingarea_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                latitude VARCHAR NOT NULL,
                longitude VARCHAR NOT NULL,
                CONSTRAINT startingpoint_pk PRIMARY KEY (id)
);


CREATE TABLE public.parking (
                id INTEGER NOT NULL,
                climbingarea_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                latitude VARCHAR NOT NULL,
                longitude VARCHAR NOT NULL,
                CONSTRAINT parking_pk PRIMARY KEY (id)
);


CREATE TABLE public.photo (
                id INTEGER NOT NULL,
                climbingarea_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                url VARCHAR NOT NULL,
                CONSTRAINT photo_pk PRIMARY KEY (id)
);


CREATE TABLE public.comment (
                id INTEGER NOT NULL,
                member_id INTEGER NOT NULL,
                climbingarea_id INTEGER NOT NULL,
                description VARCHAR(5000) NOT NULL,
                creation_date TIMESTAMP NOT NULL,
                update_date TIMESTAMP NOT NULL,
                CONSTRAINT comment_pk PRIMARY KEY (id)
);


CREATE TABLE public.guidebook (
                id INTEGER NOT NULL,
                member_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                added_date TIMESTAMP NOT NULL,
                is_loaned BOOLEAN NOT NULL,
                CONSTRAINT guidebook_pk PRIMARY KEY (id)
);


CREATE SEQUENCE public.reservation_request_id_seq;

CREATE TABLE public.reservation_request (
                id INTEGER NOT NULL DEFAULT nextval('public.reservation_request_id_seq'),
                member_id INTEGER NOT NULL,
                guidebook_id INTEGER NOT NULL,
                reservation_state VARCHAR NOT NULL,
                CONSTRAINT reservation_request_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.reservation_request_id_seq OWNED BY public.reservation_request.id;

ALTER TABLE public.reservation_request ADD CONSTRAINT member_reservation_request_fk
FOREIGN KEY (member_id)
REFERENCES public.member (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.guidebook ADD CONSTRAINT member_guidebook_fk
FOREIGN KEY (member_id)
REFERENCES public.member (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.climbingarea ADD CONSTRAINT member_climbingarea_fk
FOREIGN KEY (member_id)
REFERENCES public.member (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comment ADD CONSTRAINT member_comment_fk
FOREIGN KEY (member_id)
REFERENCES public.member (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comment ADD CONSTRAINT climbingarea_comment_fk
FOREIGN KEY (climbingarea_id)
REFERENCES public.climbingarea (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.photo ADD CONSTRAINT climbingarea_photo_fk
FOREIGN KEY (climbingarea_id)
REFERENCES public.climbingarea (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.parking ADD CONSTRAINT climbingarea_parking_fk
FOREIGN KEY (climbingarea_id)
REFERENCES public.climbingarea (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.startingpoint ADD CONSTRAINT climbingarea_startingpoint_fk
FOREIGN KEY (climbingarea_id)
REFERENCES public.climbingarea (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.sector ADD CONSTRAINT climbingarea_sector_fk
FOREIGN KEY (climbingarea_id)
REFERENCES public.climbingarea (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.route ADD CONSTRAINT sector_route_fk
FOREIGN KEY (sector_id)
REFERENCES public.sector (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation_request ADD CONSTRAINT guidebook_reservation_request_fk
FOREIGN KEY (guidebook_id)
REFERENCES public.guidebook (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
