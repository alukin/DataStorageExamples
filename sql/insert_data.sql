
INSERT INTO appuser(user_id, username, created_by, email, passwd_hash) 
            VALUES (1, 'librarian1','system','lib1@test.com','d8578edf8458ce06fbc5bb76a58c5ca4');
INSERT INTO appuser(user_id, username, created_by, email, passwd_hash) 
            VALUES (2, 'librarian2','system','lib2@test.com','d8578edf8458ce06fbc5bb76a58c5ca4');
INSERT INTO appuser(user_id, username, created_by, email, passwd_hash) 
            VALUES (1001, 'user1','librarian1','user1@test.com','d8578edf8458ce06fbc5bb76a58c5ca4');
INSERT INTO appuser(user_id, username, created_by, email, passwd_hash)
            VALUES (1002, 'user2','librarian2','user2@test.com','d8578edf8458ce06fbc5bb76a58c5ca4');
INSERT INTO appuser(user_id, username, created_by, email, passwd_hash) 
            VALUES (1003, 'user3','librarian1','user3@test.com','d8578edf8458ce06fbc5bb76a58c5ca4');
INSERT INTO appuser(user_id, username, created_by, email, passwd_hash)
            VALUES (1004, 'user4','librarian2','user4@test.com','d8578edf8458ce06fbc5bb76a58c5ca4');

INSERT INTO userdetails(user_id, first_name,last_name) VALUES(1,"Ivan","Ivanow");
INSERT INTO userdetails(user_id, first_name,last_name) VALUES(2,"Petro","Petrov");
INSERT INTO userdetails(user_id, first_name,last_name) VALUES(1001,"Ivan","Netudyhata");
INSERT INTO userdetails(user_id, first_name,last_name) VALUES(1002,"Petro","Vbyigloba");

INSERT INTO ugroup(group_id, group_name,description)
            VALUES(1,'Librarians','Librarians, can give books, etc');
INSERT INTO ugroup(group_id, group_name,description)
            VALUES(1000,'Library Users','Library users, can take and return, etc');
            
INSERT INTO user_group(group_id,user_id)
             VALUES(1,1); 
INSERT INTO user_group(group_id,user_id)
             VALUES(1,2); 
INSERT INTO user_group(group_id,user_id)
             VALUES(1000,1001); 
INSERT INTO user_group(group_id,user_id)
             VALUES(1000,1002); 
INSERT INTO user_group(group_id,user_id)
             VALUES(1000,1003); 
INSERT INTO user_group(group_id,user_id)
             VALUES(1000,1004); 
INSERT INTO user_group(group_id,user_id)
             VALUES(1000,1); 
INSERT INTO user_group(group_id,user_id)
             VALUES(1000,2); 




INSERT INTO author(author_id,name)
            VALUES(1,'Stephen King');
INSERT INTO author(author_id,name)
            VALUES(2,'Arthur Moesly');

INSERT INTO book(book_id,title)
          VALUES(1,'It');
INSERT INTO book(book_id,title)
          VALUES(2,'Needfull things');
INSERT INTO book(book_id,title)
          VALUES(3,'Black Tower');
INSERT INTO book(book_id,title)
          VALUES(4,'Shining');

INSERT INTO book_author(author_id,book_id)
            VALUES(1,1);
INSERT INTO book_author(author_id,book_id)
            VALUES(1,2);
INSERT INTO book_author(author_id,book_id)
            VALUES(1,3);
INSERT INTO book_author(author_id,book_id)
            VALUES(1,4);
INSERT INTO book_author(author_id,book_id)
            VALUES(2,2);

INSERT INTO book_examplar(be_id,book_id)
            VALUES(1,1);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(2,1);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(3,1);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(4,2);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(5,2);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(6,2);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(7,2);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(8,3);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(9,3);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(10,3);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(11,3);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(12,3);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(13,4);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(14,4);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(15,4);
INSERT INTO book_examplar(be_id,book_id)
            VALUES(16,4);
