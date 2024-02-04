--CREATE TABLE IF NOT EXISTS tasklist(
--    id VARCHAR(8) PRIMARY KEY, task VARCHAR(256),
--    deadline VARCHAR(10),done BOOLEAN);

CREATE TABLE IF NOT EXISTS tasklista(
    id VARCHAR(8) PRIMARY KEY, task VARCHAR(256),
    deadline VARCHAR(10),timea VARCHAR(10), guests INT, seat VARCHAR(10), phone VARCHAR(20), done BOOLEAN);

--CREATE TABLE IF NOT EXISTS tasklistaa(
--    NO INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20), resdate VARCHAR(10),
--    restime VARCHAR(10), guests INT, seat VARCHAR(10),phone int(11),
--    text VARCHAR(256));

--CREATE TABLE IF NOT EXISTS tasklista (
--    id VARCHAR(8) PRIMARY KEY,
--    name VARCHAR(50) NOT NULL,
--    resdate VARCHAR(10),
--    restime VARCHAR(10),
--    guests VARCHAR(10),
--    seat VARCHAR(10),
--    phone VARCHAR(10),
--    specialRequest VARCHAR(100)
--);

--CREATE TABLE IF NOT EXISTS tasklista (
--    id VARCHAR(8) PRIMARY KEY,
--    name VARCHAR(50),
--    resdate DATE,
--    restime TIME,
--    guests INT,
--    seat BOOLEAN,
--    phone INT,
--    specialRequest VARCHAR(100)
--);