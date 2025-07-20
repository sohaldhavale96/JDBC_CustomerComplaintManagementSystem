CREATE TABLE complaints(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	phone VARCHAR(20) UNIQUE,
	complaint VARCHAR(200) NOT NULL,
	status ENUM('solved','unsolved','in view') DEFAULT 'unsolved',
	gender ENUM('male','female') NOT NULL,
	date_of_raising_complaint DATETIME DEFAULT CURRENT_TIMESTAMP,
	date_of_solved_complaint DATETIME DEFAULT NULL
);