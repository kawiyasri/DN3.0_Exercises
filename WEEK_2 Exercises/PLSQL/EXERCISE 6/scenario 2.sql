DECLARE
    CURSOR accounts_cursor IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;
    v_fee NUMBER := 50; -- Annual maintenance fee
BEGIN
    FOR a_rec IN accounts_cursor LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee,
            LastModified = SYSDATE
        WHERE AccountID = a_rec.AccountID;
        DBMS_OUTPUT.PUT_LINE('Applied annual fee of ' || v_fee || ' to AccountID ' || a_rec.AccountID ||
                             ', New Balance: ' || (a_rec.Balance - v_fee));
    END LOOP;
    COMMIT;
END;
/
