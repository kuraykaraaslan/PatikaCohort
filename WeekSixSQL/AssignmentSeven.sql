SELECT rating, COUNT(*) FROM film GROUP BY rating;
SELECT replacement_cost, COUNT(*) as film_sayisi FROM film GROUP BY replacement_cost HAVING film_sayisi > 50;
SELECT store_id, COUNT(*) FROM customer GROUP BY store_id;
SELECT country_id, COUNT(*) as city_count FROM city GROUP BY country_id ORDER BY city_count DESC LIMIT 1;
