DROP TABLE IF EXISTS student;

CREATE TABLE student (
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(2) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加日期',
	PRIMARY KEY (id)
);


DELETE FROM student;

INSERT INTO student (id, `name`, age, email, create_time, is_delete) VALUES
(1, '白驹', 26, 'baiju@hlj.com', '2020-1-29 17:46:19', 0),
(2, '江河', 20, 'jianghe@hlj.com', '2020-1-29 17:46:19', 0),
(3, '明镜', 28, 'mingjing@hlj.com', '2020-1-29 17:46:19', 0),
(4, '淡然', 21, 'danran@hlj.com', '2020-1-29 17:46:19', 0),
(5, '听风', 25, 'tingfeng@hlj.com', '2020-1-29 17:46:19', 0),
(6, 'Alice', 22, 'alice@qq.com', '2020-1-29 17:46:19', 0),
(7, 'Anni', 22, 'alice@qq.com', '2020-1-29 17:46:19', 1),
(8, 'Tom', 22, 'alice@qq.com', '2020-1-29 17:46:19', 1);