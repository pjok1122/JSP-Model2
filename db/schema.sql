cd C:\Bitnami\wampstack-7.1.28-0\mysql\bin

USE jspdb;

DROP TABLE `user`;
DROP TABLE `board`;

CREATE TABLE `user`(
	seq BIGINT(10) NOT NULL AUTO_INCREMENT,
	id VARCHAR(20) NOT NULL UNIQUE COMMENT 'ȸ��',
	password VARCHAR(255) NOT NULL COMMENT '��й�ȣ',
	name VARCHAR(10) COMMENT '�̸�',
	gender INT(1) DEFAULT 2 COMMENT '����',
	salt VARCHAR(20) COMMENT 'SHA-256 Salt',
	PRIMARY KEY (`seq`),
	UNIQUE KEY uniq_key(`id`)
);

CREATE TABLE `board`(
	seq BIGINT(10) NOT NULL AUTO_INCREMENT,
	user_seq BIGINT(10) NOT NULL COMMENT '�۾���',
	title VARCHAR(30) NOT NULL COMMENT '����',
	content TEXT NOT NULL COMMENT '����',
	registered_at datetime NOT NULL COMMENT '�������',
	hit INT(10) NOT NULL DEFAULT 0 COMMENT '��ȸ��',
	PRIMARY KEY (`seq`),
	FOREIGN KEY (`user_seq`) REFERENCES `user`(`seq`) ON DELETE CASCADE
);

