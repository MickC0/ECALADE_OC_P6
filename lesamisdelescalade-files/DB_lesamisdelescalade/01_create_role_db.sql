-- Role: admin_lesamisdelescalade
-- DROP ROLE admin_lesamisdelescalade;

CREATE ROLE admin_lesamisdelescalade WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION;