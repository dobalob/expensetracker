USE expensetracker;

INSERT INTO tbl_expenses( expense, descriptor, amount)
    VALUES
        ( "monitor", "hp monitor", 70.00), 
        ( "smart watch", "apple watch 5", 500.00);

SELECT * FROM tbl_expenses;
-- DELETE FROM tbl_expenses 
--    WHERE 
--      id=3;
-- ALTER TABLE tbl_expenses AUTO_INCREMENT = 3; 