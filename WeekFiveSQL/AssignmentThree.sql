SELECT * FROM country WHERE country LIKE 'A%a';
SELECT * FROM country WHERE LENGTH(country) >= 6 AND RIGHT(country, 1) = 'n';
SELECT * FROM film WHERE LOWER(title) LIKE '%t%' OR UPPER(title) LIKE '%T%';
SELECT * FROM film WHERE title LIKE 'C%' AND LENGTH(title) > 90 AND rental_rate = 2.99;
