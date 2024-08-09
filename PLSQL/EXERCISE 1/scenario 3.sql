DECLARE
BEGIN
    FOR loan_rec IN (SELECT l.LoanID, c.Name, l.EndDate
                     FROM Loans l, Customers c
                     WHERE l.CustomerID = c.CustomerID
                     AND l.EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: LoanID ' || loan_rec.LoanID || ' for customer ' || loan_rec.Name || ' is due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
