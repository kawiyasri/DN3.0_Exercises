CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    FOR emp_rec IN (SELECT EmployeeID, Salary FROM Employees WHERE Department = p_department FOR UPDATE) LOOP
        UPDATE Employees
        SET Salary = Salary * (1 + p_bonus_percentage / 100),
            LastModified = SYSDATE
        WHERE EmployeeID = emp_rec.EmployeeID;
        DBMS_OUTPUT.PUT_LINE('Updated EmployeeID: ' || emp_rec.EmployeeID || ', New Salary: ' || emp_rec.Salary * (1 + p_bonus_percentage / 100));
    END LOOP;
    COMMIT;
END UpdateEmployeeBonus;
/
