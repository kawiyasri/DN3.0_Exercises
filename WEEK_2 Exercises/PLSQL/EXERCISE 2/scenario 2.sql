CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) IS
    employee_not_found EXCEPTION;
    v_salary NUMBER;
BEGIN
    -- Update salary and handle errors
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_employee_id FOR UPDATE;
    UPDATE Employees
    SET Salary = Salary * (1 + p_percentage / 100), LastModified = SYSDATE
    WHERE EmployeeID = p_employee_id;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for EmployeeID ' || p_employee_id);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: EmployeeID ' || p_employee_id || ' not found');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END UpdateSalary;
/
