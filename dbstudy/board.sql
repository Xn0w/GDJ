DROP SEQUENCE BOARD_SEQ;
CREATE SEQUENCE BOARD_SEQ NOCACHE;

DROP TABLE BOARD;
CREATE TABLE BOARD (
    BOARD_NO NUMBER              NOT NULL,
    TITLE    VARCHAR2(1000 BYTE) NOT NULL,
    CONTENT  VARCHAR2(4000 BYTE),
    WRITER   VARCHAR2(100 BYTE)  NOT NULL,
    CREATE_DATE VARCHAR2(10 BYTE),
    MODIFY_DATE VARCHAR2(10 BYTE),
    CONSTRAINT PK_BOARD PRIMARY KEY(BOARD_NO)
);

INSERT INTO BOARD
VALUES(1, 'GDJ', '보충', '이원규', '11', '2');