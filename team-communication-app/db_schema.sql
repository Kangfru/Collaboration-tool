CREATE TABLE members(
	id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(50) NOT NULL,
	nickName VARCHAR(50) NOT NULL,
	pw VARCHAR(50) NOT NULL
)

ALTER TABLE members ADD COLUMN photo VARCHAR(50) DEFAULT 'upload/images/default.jpg'

CREATE TABLE projects(
	id INT PRIMARY KEY AUTO_INCREMENT,
	projectName VARCHAR(50) NOT NULL,
	admin_id INT,
	FOREIGN KEY(admin_id) REFERENCES members(id)
)

CREATE TABLE project_member(
	member_id INT,
	project_id INT,
	PRIMARY KEY(member_id, project_id),
	FOREIGN KEY(member_id) REFERENCES members(id),
	FOREIGN KEY(project_id) REFERENCES projects(id)	
)

CREATE TABLE channels(
	id INT PRIMARY KEY AUTO_INCREMENT,
	channelName VARCHAR(50) NOT NULL,
	project_id INT NOT NULL,
	FOREIGN KEY(project_id) REFERENCES projects(id)
)

CREATE TABLE channelMessage(
	id INT PRIMARY KEY AUTO_INCREMENT,
	message VARCHAR(200) NOT NULL,
	sendDate DATETIME DEFAULT CURRENT_TIMESTAMP,
	member_id INT,
	channel_id INT,
	FOREIGN KEY(member_id) REFERENCES members(id),
	FOREIGN KEY(channel_id) REFERENCES channels(id)
	
)