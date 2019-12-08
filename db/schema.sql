cd C:\Bitnami\wampstack-7.1.28-0\mysql\bin

USE jspdb;

DROP TABLE `user`;
DROP TABLE `board`;

CREATE TABLE `user`(
	seq BIGINT(10) NOT NULL AUTO_INCREMENT,
	id VARCHAR(20) NOT NULL UNIQUE COMMENT '회원',
	password VARCHAR(255) NOT NULL COMMENT '비밀번호',
	name VARCHAR(10) COMMENT '이름',
	gender INT(1) DEFAULT 2 COMMENT '성별',
	salt VARCHAR(20) COMMENT 'SHA-256 Salt',
	PRIMARY KEY (`seq`),
	UNIQUE KEY uniq_key(`id`)
);

CREATE TABLE `board`(
	seq BIGINT(10) NOT NULL AUTO_INCREMENT,
	user_seq BIGINT(10) NOT NULL COMMENT '글쓴이',
	title VARCHAR(30) NOT NULL COMMENT '제목',
	content TEXT NOT NULL COMMENT '내용',
	registered_at datetime NOT NULL COMMENT '등록일자',
	hit INT(10) NOT NULL DEFAULT 0 COMMENT '조회수',
	PRIMARY KEY (`seq`),
	FOREIGN KEY (`user_seq`) REFERENCES `user`(`seq`) ON DELETE CASCADE
);

