DROP TABLE IF EXISTS request;
DROP TABLE IF EXISTS request_kind;

CREATE TABLE request_kind (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  code VARCHAR(100) NOT NULL,
  option_text VARCHAR(1000) NOT NULL
);

CREATE TABLE request (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  request_kind_id INT NOT NULL,
  policy_number VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  sur_name VARCHAR(250) NOT NULL,
  request_text VARCHAR(1000),
  foreign key (request_kind_id) references request_kind(id)
);

INSERT INTO request_kind (code, option_text) VALUES
  ('CNTR_ADJ', 'Contract Adjustment');
INSERT INTO request_kind (code, option_text) VALUES
  ('DMG_CASE', 'Damage Case');
INSERT INTO request_kind (code, option_text) VALUES
  ('COMPLAINT', 'Complaint');
