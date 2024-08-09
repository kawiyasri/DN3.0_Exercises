--Package Specification CustomerManagement
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE,
        p_balance IN NUMBER
    );
    PROCEDURE UpdateCustomer (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_balance IN NUMBER
    );  
    FUNCTION GetCustomerBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/
--Package Body CustomerManagement
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE,
        p_balance IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
    END AddCustomer;
    PROCEDURE UpdateCustomer (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_balance IN NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name, Balance = p_balance, LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;
        
        DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_name);
    END UpdateCustomer;
    FUNCTION GetCustomerBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customer_id;
        RETURN v_balance;
    END GetCustomerBalance;
END CustomerManagement;
/
