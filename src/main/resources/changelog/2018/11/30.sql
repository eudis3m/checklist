--liquibase formatted sql

--changeset versao:9

ALTER FUNCTION db_projetos_ib.dias_restantes(date) OWNER TO postgres;

ALTER FUNCTION db_projetos_ib.remove_acento(text) OWNER TO postgres;
  
ALTER FUNCTION db_projetos_ib.remove_chars_especiais(text) OWNER TO postgres;
  
ALTER FUNCTION db_projetos_ib.remove_espacos(text, text) OWNER TO postgres;
  
ALTER FUNCTION db_projetos_ib.simplifica_str(text) OWNER TO postgres;