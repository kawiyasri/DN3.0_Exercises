--Assuming AuditLog Table
Create the AuditLog table if it does not already exist:
CREATE TABLE AuditLog (
    LogID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    ChangeDate DATE,
    Action VARCHAR2(50)
);
--Trigger LogTransaction
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (LogID, TransactionID, ChangeDate, Action)
    VALUES (AuditLog_seq.NEXTVAL, :NEW.TransactionID, SYSDATE, 'INSERT');
END LogTransaction;
/
--Create a sequence AuditLog_seq for the LogID:
CREATE SEQUENCE AuditLog_seq
START WITH 1
INCREMENT BY 1;
