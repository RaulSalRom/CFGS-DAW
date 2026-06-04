START TRANSACTION;
UPDATE Accounts
SET balance = balance - 1000
WHERE accountNumber = '932656' ;


UPDATE Accounts
SET balance = balance + 1000
WHERE accountNumb = '933888';

COMMIT;

