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