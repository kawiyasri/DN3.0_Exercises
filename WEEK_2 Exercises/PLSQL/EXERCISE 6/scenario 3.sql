DECLARE
    CURSOR loans_cursor IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;
    v_new_interest_rate NUMBER := 4; -- New interest rate policy
BEGIN
    FOR l_rec IN loans_cursor LOOP
        UPDATE Loans
        SET InterestRate = v_new_interest_rate,
            LastModified = SYSDATE
        WHERE LoanID = l_rec.LoanID;
        DBMS_OUTPUT.PUT_LINE('Updated LoanID: ' || l_rec.LoanID || ', New Interest Rate: ' || v_new_interest_rate);
    END LOOP;
    COMMIT;
END;
/
