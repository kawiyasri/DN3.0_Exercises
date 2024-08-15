CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc_rec IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings' FOR UPDATE) LOOP
        UPDATE Accounts
        SET Balance = Balance * 1.01,
            LastModified = SYSDATE
        WHERE AccountID = acc_rec.AccountID;
        DBMS_OUTPUT.PUT_LINE('Updated AccountID: ' || acc_rec.AccountID || ', New Balance: ' || acc_rec.Balance * 1.01);
    END LOOP;
    COMMIT;
END ProcessMonthlyInterest;
/
