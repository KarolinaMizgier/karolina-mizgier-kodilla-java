INSERT INTO USERS VALUES (6,'Anna','Nowak');

UPDATE POSTS
SET BODY='To delete'
WHERE ID=2;

DELETE FROM POSTS
WHERE ID=2;
COMMIT;