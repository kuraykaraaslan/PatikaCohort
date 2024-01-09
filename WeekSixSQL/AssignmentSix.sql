SELECT AVG(rental_rate) AS average_rental_rate FROM film;
SELECT COUNT(*) FROM film WHERE title LIKE 'C%';
SELECT * FROM film WHERE rental_rate = 0.99 ORDER BY LENGTH(title) DESC LIMIT 1;
SELECT COUNT(DISTINCT replacement_cost) FROM film WHERE length > 150;

