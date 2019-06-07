
CREATE TABLE appuser(
 user_id  BIGINT NOT NULL,
 username VARCHAR(20) NOT NULL,
 created_by VARCHAR(20) NOT NULL,
 email VARCHAR(20) NOT NULL,
 passwd_hash VARCHAR(64) NOT NULL,
 last_login DATE,
 PRIMARY KEY (user_id)
);

CREATE TABLE userdetails(
 user_id  BIGINT NOT NULL,
 address VARCHAR(200),
 phone VARCHAR(20),
 first_name VARCHAR(20),
 last_name VARCHAR(20),
 sex VARCHAR(20),
 mobile VARCHAR(20),
 notes VARCHAR(200),
 PRIMARY KEY (user_id),
 CONSTRAINT FK_user_details FOREIGN KEY  (user_id) REFERENCES appuser(user_id)
);

CREATE TABLE ugroup(
 group_id  BIGINT NOT NULL,
 group_name VARCHAR(20) NOT NULL,
 description VARCHAR(200),
 PRIMARY KEY (group_id)
);

CREATE TABLE user_group(
 group_id  BIGINT NOT NULL,
 user_id  BIGINT NOT NULL,
 PRIMARY KEY (group_id,user_id),
 CONSTRAINT FK_user_group_to_user FOREIGN KEY (user_id) REFERENCES appuser(user_id),
 CONSTRAINT FK_user_group_to_group FOREIGN KEY  (group_id) REFERENCES ugroup(group_id)
);

CREATE TABLE book(
 book_id  BIGINT NOT NULL,
 title VARCHAR(200) NOT NULL,
 info VARCHAR(200),
 description VARCHAR(200),
 PRIMARY KEY (book_id)
);


CREATE TABLE author(
 author_id  BIGINT NOT NULL,
 name VARCHAR(200) NOT NULL,
 info VARCHAR(200),
 PRIMARY KEY (author_id)
);

CREATE TABLE book_author(
 author_id  BIGINT NOT NULL,
 book_id  BIGINT NOT NULL,
 PRIMARY KEY (book_id,author_id),
 CONSTRAINT FK_book_author_to_autor FOREIGN KEY (author_id) REFERENCES author(author_id),
 CONSTRAINT FK_book_author_to_book FOREIGN KEY  (book_id) REFERENCES book(book_id)
);

CREATE TABLE loan(
 loan_id  BIGINT NOT NULL,
 user_id  BIGINT NOT NULL,
 be_id  BIGINT NOT NULL,
 aqired   DATE,
 returned DATE,
 PRIMARY KEY (loan_id)
);

CREATE TABLE book_examplar (
 be_id  BIGINT NOT NULL,
 book_id  BIGINT NOT NULL,
 loan_id BIGINT,
 publishing DATE,
 publisher  VARCHAR(200),
 description VARCHAR(200),
 PRIMARY KEY (be_id),
 CONSTRAINT FK_book_examplar_to_book FOREIGN KEY  (book_id) REFERENCES book(book_id)
);





