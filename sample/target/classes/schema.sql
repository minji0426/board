/**
  데이터 베이스 생성 스크립트 입력
 */
create table board (
	id int identity primary key NOT NULL,
	title varchar(100) NOT NULL,
	content nvarchar(max),
	writer varchar(20) NOT NULL,
	inst_date datetime NOT NULL,
	views int DEFAULT 0 NOT NULL,
	ip varchar(15),
	pw varchar(100),
	del_yn char(1) DEFAULT 'N' NOT NULL
);

create table reply (
	reply_id int identity primary key NOT NULL,
	parent_reply_id int,
	id int,
	r_writer varchar(20) NOT NULL,
	r_content varchar(100) NOT NULL,
	inst_date datetime NOT NULL,
	del_yn char(1) DEFAULT 'N' NOT NULL,
	
	CONSTRAINT fk_board FOREIGN KEY (id) 
	REFERENCES board(id) ON DELETE CASCADE
);

create table file (
	file_no int identity primary key NOT NULL,
	board_id int NOT NULL,
--	file_name varchar(300) NOT NULL
	org_file_name varchar(300) NOT NULL,
--	stored_file_name varchar(50) NOT NULL,
--	file_size int(11),
	reg_date datetime NOT NULL,
	del_yn char(1) DEFAULT 'N' NOT NULL
);


INSERT INTO board (
	title, content, writer, inst_date,
)values(
	'title', 'content', 'writer', getdate()
);

INSERT INTO board (
	title, content, writer, inst_date,
)values(
	'title', 'content', 'writer', getdate()
);
INSERT INTO board (
	title, content, writer, inst_date,
)values(
	'title', 'content', 'writer', getdate()
);
INSERT INTO board (
	title, content, writer, inst_date,
)values(
	'title', 'content', 'writer', getdate()
);
INSERT INTO board (
	title, content, writer, inst_date,
)values(
	'title', 'content', 'writer', getdate()
);
INSERT INTO board (
	title, content, writer, inst_date,
)values(
	'title', 'content', 'writer', getdate()
);
INSERT INTO board (
	title, content, writer, inst_date,
)values(
	'title', 'content', 'writer', getdate()
);


