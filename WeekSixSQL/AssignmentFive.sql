SELECT * FROM film WHERE title LIKE '%n' ORDER BY LENGTH(title) DESC LIMIT 5;
SELECT * FROM film WHERE title LIKE '%n' ORDER BY LENGTH(title), title LIMIT 5 OFFSET 5;
SELECT * FROM customer WHERE store_id = 1 ORDER BY last_name DESC LIMIT 4;
