DECLARE
    CURSOR transactions_cursor IS
        SELECT c.CustomerID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY c.CustomerID, t.TransactionDate;

    v_customer_id Customers.CustomerID%TYPE;
    v_customer_name Customers.Name%TYPE;
BEGIN
    FOR t_rec IN transactions_cursor LOOP
        IF t_rec.CustomerID != v_customer_id THEN
            IF v_customer_id IS NOT NULL THEN
                DBMS_OUTPUT.PUT_LINE('End of statement for CustomerID ' || v_customer_id);
            END IF;
            v_customer_id := t_rec.CustomerID;
            v_customer_name := t_rec.Name;
            DBMS_OUTPUT.PUT_LINE('Statement for CustomerID ' || v_customer_id || ': ' || v_customer_name);
        END IF;
        DBMS_OUTPUT.PUT_LINE('TransactionID: ' || t_rec.TransactionID ||
                             ', Date: ' || TO_CHAR(t_rec.TransactionDate, 'YYYY-MM-DD') ||
                             ', Amount: ' || t_rec.Amount ||
                             ', Type: ' || t_rec.TransactionType);
    END LOOP;
    IF v_customer_id IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('End of statement for CustomerID ' || v_customer_id);
    END IF;
END;
/
