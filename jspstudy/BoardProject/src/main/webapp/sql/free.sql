DROP TABLE FREE;
CREATE TABLE FREE
(
    FREENO NUMBER NOT NULL,
    WRITER VARCHAR2(100 BYTE),
    TITLE VARCHAR2(1000 BYTE) NOT NULL,
    CONTENT VARCHAR2(4000 BYTE),
    IP VARCHAR2(20 BYTE),
    HIT NUMBER
);

ALTER TABLE FREE
    ADD CONSTRAINT FREE_PK PRIMARY KEY(FREENO);

DROP SEQUENCE FREE_SEQ;
CREATE SEQUENCE FREE_SEQ NOCACHE;

INSERT INTO FREE(FREENO, WRITER, TITLE, CONTENT, IP, HIT) VALUES(FREE_SEQ.NEXTVAL, '이영식', '워크샵공지', '첨부파일을 확인해주세요.', '127.0.0.1', 5);
INSERT INTO FREE(FREENO, WRITER, TITLE, CONTENT, IP, HIT) VALUES(FREE_SEQ.NEXTVAL, '김철수', '사용안내', '다음 달부터 사용 가능합니다.', '127.127.127.0', 10);
