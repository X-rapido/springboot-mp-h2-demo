DELETE FROM student;

INSERT INTO student (id, `name`, age, gender, email, create_time, version, is_delete) VALUES
(1, '白驹', 26, 0, 'baiju@hlj.com', '2020-1-29 17:46:19', 1, 0),
(2, '江河', 20, 0, 'jianghe@hlj.com', '2020-1-29 17:46:19', 1, 0),
(3, '明镜', 28, 0, 'mingjing@hlj.com', '2020-1-29 17:46:19', 1, 0),
(4, '淡然', 21, 0, 'danran@hlj.com', '2020-1-29 17:46:19', 1, 0),
(5, '听风', 25, 0, 'tingfeng@hlj.com', '2020-1-29 17:46:19', 1, 0),
(6, 'Alice', 22, 1, 'alice@qq.com', '2020-1-29 17:46:19', 1, 0),
(7, 'Anni', 22, 1, 'alice@qq.com', '2020-1-29 17:46:19', 1, 1),
(8, 'Tom', 22, 0, 'alice@qq.com', '2020-1-29 17:46:19', 1, 1);