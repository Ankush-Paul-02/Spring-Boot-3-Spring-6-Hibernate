CREATE TABLE employee
(
    id         NUMBER,
    first_name VARCHAR2(45),
    last_name  VARCHAR2(45),
    email      VARCHAR2(45),
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE SEQUENCE employee_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TRIGGER employee_trigger
    BEFORE INSERT
    ON employee
    FOR EACH ROW
BEGIN
    SELECT employee_seq.NEXTVAL INTO :NEW.id FROM dual;
END;
/