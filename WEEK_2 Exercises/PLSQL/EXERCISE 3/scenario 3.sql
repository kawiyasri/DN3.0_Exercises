CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    insufficient_funds EXCEPTION;
    v_from_balance NUMBER;
BEGIN
    -- Check balance of the source account
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id FOR UPDATE;
    IF v_from_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    -- Perform the transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account_id;
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account_id;
    COMMIT;   
    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_amount || ' from AccountID ' || p_from_account_id || ' to AccountID ' || p_to_account_id);
EXCEPTION
    WHEN insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in AccountID ' || p_from_account_id);
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/

