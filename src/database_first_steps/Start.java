package database_first_steps;

public class Start {

}
//shell> mysql -h host -u user -p 
// for logging on different than running on current device server. 

//shell> mysql -u user -p
//for logging on server running on the same computer.

//issue queries - wydawaæ zapytania.

//QUIT or \q to exit mysql mode. 

// \c - If you decide you do not want to execute a query that you are in the process of entering, 
//cancel it by typing \c . 

/* PROMPT AND ITS MEANINGS 
 * 
 * mysql>	Ready for new query
	->	    Waiting for next line of multiple-line query
	'>		Waiting for next line, waiting for completion of a string that began with a single quote (“'”)
	">		Waiting for next line, waiting for completion of a string that began with a double quote (“"”)
	`>		Waiting for next line, waiting for completion of an identifier that began with a backtick (“`”)
	/*>		Waiting for next line, waiting for completion of a comment that began with /*

*/

//ERROR : mysql> SELECT * FROM my_table WHERE name = 'Smith AND age < 30;
//'>
//	FIRST WE HAVE TO ADD '	AND AFTER THAT WE CAN TYPE \c to delete the query.

//SHOW DATABASES; - shows databases to which user has access.

//USE db_name - to enter a db . Doesn't require semicolon ! Like quit! (But still we can use it.)
//It must be given on a single line!

//CREATE DATABASE menagerie; - obvious.

//shell> mysql -h host -u user -p menagerie - logging in with selecting db at once. 

//SELECT DATABASE() - You can see at any time which database is currently selected.

//SHOW TABLES; - obvious.

//DESCRIBE table_name; - shows table. 

//CREATE TABLE event (name VARCHAR(20), date DATE,
//-> type VARCHAR(15), remark VARCHAR(255));

//LOAD DATA LOCAL INFILE '/path/pet.txt' INTO TABLE pet
//-> LINES TERMINATED BY '\r\n';	(second line for windows) // loading data from file. 
//Remember about administrator rights location of the file and /  --- forward slashes. 

//INSERT INTO pet
//-> VALUES ('Puffball','Diane','hamster','f','1999-03-30',NULL);	- example of adding data to database.

//SELECT : 
//SELECT what_to_select  //indicates what you want to see: a list of columns, or * to indicate “all columns.”
//FROM which_table
//WHERE conditions_to_satisfy;

//e.g. SELECT * FROM pet;

//DELETE FROM pet;	 deletes the content of the table .

//UPDATE table SET birth = '1989-08-31' WHERE name = 'Bowser';	// updates.

//SELECT * FROM pet WHERE name = 'Bowser'; // selecting only one row.

//SELECT * FROM pet WHERE birth >= '1998-1-1';

//SELECT * FROM pet WHERE species = 'snake' OR species = 'bird';

//SELECT * FROM pet WHERE (species = 'cat' AND sex = 'm')
//-> OR (species = 'dog' AND sex = 'f');		parentheses are good option in this situation.
//AND has a higher precedence than OR.

//SELECT DISTINCT owner FROM pet;	// returns different values from selected column.

//Use a WHERE clause to combine row selection with column selection. For example, 
//to get birth dates for dogs and cats only.

//SELECT name, species, birth FROM pet;
//-> WHERE species = 'dog' OR species = 'cat';

//ORDER BY COL_NAME DESC;  - sort descendingly. Default is ascending. 

//SELECT name, species, birth FROM pet
//-> ORDER BY species, birth DESC;	// sorting by species, when species are the same sort by birth.

//SELECT name, birth, death,
//-> TIMESTAMPDIFF(YEAR,birth,death) AS age
//-> FROM pet WHERE death IS NOT NULL ORDER BY age;	// returns ages of pets when they died 
//as another column which is the output of the function and sorts it. 

//AS - allows us to give new column a name and put outcomes of the function in a new column. 

//MONTH(BIRTH) - returns month value from a column with dates named BIRTH.

//SELECT name, birth FROM pet WHERE MONTH(birth) = 5;	- If you want to know which animal has birthday 
//on may.

//SELECT name, birth FROM pet
//-> WHERE MONTH(birth) = MONTH(DATE_ADD(CURDATE(),INTERVAL 1 MONTH));	- universal function.

//MOD(MONTH(CURDATE()), 12);	modulo function.

//SELECT * FROM pet WHERE name LIKE 'b%'; // returns only names starting with "b" . Case sensitive!
// _ - means : just one ( but any) character.
// % - means : any number of characters.( also zero) 
// LIKE / NOT LIKE - do not use = or <> when you use SQL patterns, use only those operators.

//SELECT * FROM pet WHERE name LIKE '_____'; any word with 5 characters .

//SELECT * FROM pet WHERE name REGEXP BINARY '^b';	
//comparison to be case sensitive

/*
 ^ - starts with.		'^b'
 $ - ends with . 		'fy$'
 . -  matches any single character.
 [...] - matches any character within the brackets,for example, “[abc]” matches “a”, “b”, or “c”. 
 [a-z] - a range of characters.
 [0-9] - any digit.
 {n} - repeat n times preceding value.
 * - matches zero or more instances of the thing preceding it. 'x*' - any number of x's.
 
 */

//SELECT COUNT(*) FROM pet; counts all of the rows which equals all of the pets.

//SELECT owner, COUNT(*) FROM pet GROUP BY owner;

//SET sql_mode = 'ONLY_FULL_GROUP_BY';	
//SELECT owner, COUNT(*) FROM pet; - then this returns an error, not a false result.

/*	SELECT pet.name,
    -> (YEAR(date)-YEAR(birth)) - (RIGHT(date,5)<RIGHT(birth,5)) AS age,
    -> remark
    -> FROM pet INNER JOIN event
    ->   ON pet.name = event.name		//ON these conditions.
    -> WHERE event.type = 'litter';

    The FROM clause joins two tables because the query needs to pull information from both of them.
    ON is all about joining two tables when both satisfy the same condition.
 	
 * */

//DESC  is short for DESCRIBE . e.g. DESC pet;










////////////////////// TIPS AND ADVICES 
/*
SQL keywords are not case-sensitive! 

Under Windows, restriction of the same letters does not apply, although
you must refer to databases and tables using the same lettercase throughout a given query

MySQL expects dates in 'YYYY-MM-DD'.

When implementing a table by data from a file , remember that single tab is sufficient for 
distinguishing values referred to different columns and when you actually don't have a value - use \N. 

You can sort on multiple columns, and you can sort different columns in different directions.

The result of any arithmetic comparison with NULL is also NULL

When doing an ORDER BY, NULL values are presented first if you do ORDER BY ... ASC.s

A REGEXP pattern match succeeds if the pattern matches anywhere in the value being tested.
// (This differs from a LIKE pattern match, which succeeds only if the pattern matches the entire value.)

The use of COUNT() in conjunction with GROUP BY is useful for characterizing your data under various groupings.

In :  DESCRIBE table_name , 	NULL indicates whether the column can contain NULL values and 
Key indicates whether the column is indexed . Extra displays special information about columns.

If you have indexes on a table, SHOW INDEX FROM tbl_name produces information about them.


*/











