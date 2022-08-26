CREATE TABLE logs (
	log_id SERIAL PRIMARY KEY,
	message VARCHAR(240),
	"content" VARCHAR(10000),
	"level" VARCHAR(20),
	"timestamp" VARCHAR(100)
);
