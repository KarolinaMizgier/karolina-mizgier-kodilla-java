################################## STATS ################################

CREATE TABLE STATS (
                       STAT_ID INT(11) NOT NULL AUTO_INCREMENT,
                       STAT_DATE DATETIME NOT NULL,
                       STAT VARCHAR(20) NOT NULL,
                       VALUE INT(11) NOT NULL,
                       PRIMARY KEY (STAT_ID)
);

CREATE OR REPLACE VIEW BESTSELLERS_COUNT AS
SELECT count(*) AS COUNT
FROM BOOKS
WHERE BESTSELLER = 1;

DELIMITER $$
CREATE EVENT UPDATE_BESTSELLERS
    ON SCHEDULE EVERY 1 MINUTE
    DO
BEGIN
        DECLARE BEST_COUNT INT;
CALL UpdateBestsellers();
SELECT * FROM BESTSELLERS_COUNT INTO BEST_COUNT;
INSERT INTO STATS(STAT_DATE, STAT, VALUE) VALUES(CURTIME(), "BESTSELLERS", BEST_COUNT);
END $$
DELIMITER ;

SELECT * FROM STATS;
DROP EVENT UPDATE_BESTSELLERS;