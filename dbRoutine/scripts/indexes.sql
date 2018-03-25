create index index_person_name on person (name);
create index index_band_name_trgm on band using gin (name gin_trgm_ops); 
