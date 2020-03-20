-- CREATE DATABASE teamcommunication;

-- SHOW DATABASES;

-- CREATE USER 'kangfru'@'localhost' IDENTIFIED BY '1234';

-- GRANT ALL PRIVILEGES ON teamcommunication.*TO 'kangfru'@'localhost';

-- FLUSH PRIVILEGES;

DROP TABLE members;
DROP TABLE projecets;
DROP TABLE project_member;
DROP TABLE channels;
DROP TABLE channelMessage;

CREATE TABLE members(
	id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(50) NOT NULL,
	nickName VARCHAR(50) NOT NULL,
	pw VARCHAR(50) NOT NULL
);

ALTER TABLE members ADD COLUMN photo VARCHAR(50) DEFAULT 'upload/images/default.jpg';

CREATE TABLE projects(
	id INT PRIMARY KEY AUTO_INCREMENT,
	projectName VARCHAR(50) NOT NULL,
	admin_id INT,
	FOREIGN KEY(admin_id) REFERENCES members(id)
);

CREATE TABLE project_member(
	member_id INT,
	project_id INT,
	PRIMARY KEY(member_id, project_id),
	FOREIGN KEY(member_id) REFERENCES members(id),
	FOREIGN KEY(project_id) REFERENCES projects(id)	
);
members
CREATE TABLE channels(
	id INT PRIMARY KEY AUTO_INCREMENT,
	channelName VARCHAR(50) NOT NULL,
	project_id INT NOT NULL,
	FOREIGN KEY(project_id) REFERENCES projects(id)
);

CREATE TABLE channelMessage(
	id INT PRIMARY KEY AUTO_INCREMENT,
	message VARCHAR(200) NOT NULL,
	sendDate DATETIME DEFAULT CURRENT_TIMESTAMP,
	member_id INT,
	channel_id INT,
	FOREIGN KEY(member_id) REFERENCES members(id),
	FOREIGN KEY(channel_id) REFERENCES channels(id)
	
);

INSERT INTO projects (projectName, admin_id)
VALUES ('Test Project 2', 1);

INSERT INTO project_member(project_id, member_id)
VALUES (2, 1);

UPDATE projects SET projectName = 'Test Project' WHERE id = 1;

SELECT id, projectName FROM projects;
SELECT p.id, p.projectName FROM members m, projects p, project_member pm WHERE 

SELECT pm.project_id FROM members m, project_member pm WHERE pm.member_id = m.id = 2;

SELECT p.id, p.projectName FROM projects p WHERE p.id = ANY(
	SELECT pm.project_id id FROM project_member pm WHERE pm.member_id = 2
);

SELECT p.id, p.projectname FROM projects p 
WHERE EXISTS
(
	SELECT project_id FROM project_member
   WHERE p.id = project_id AND member_id = 1
);

INSERT INTO project_member(project_id, member_id)
VALUES (1,2);