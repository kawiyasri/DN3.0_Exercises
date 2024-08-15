
DECLARE
    CURSOR cust_cursor IS
        SELECT c.CustomerID, l.LoanID, l.InterestRate, TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age
        FROM Customers c, Loans l
        WHERE c.CustomerID = l.CustomerID;
BEGIN
    FOR cust_rec IN cust_cursor LOOP
        IF cust_rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = cust_rec.LoanID;
            DBMS_OUTPUT.PUT_LINE('Updated LoanID: ' || cust_rec.LoanID || ', New Interest Rate: ' || (cust_rec.InterestRate - 1));
        END IF;
    END LOOP;
END;
/
