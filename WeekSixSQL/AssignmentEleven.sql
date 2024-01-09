SELECT actor.first_name AS actor_name, customer.first_name AS customer_name FROM actor FULL JOIN customer ON actor.first_name = customer.first_name;
SELECT actor.first_name AS actor_name, customer.first_name AS customer_name FROM actor INNER JOIN customer ON actor.first_name = customer.first_name;
SELECT actor.first_name AS actor_name, customer.first_name AS customer_name FROM actor LEFT JOIN customer ON actor.first_name = customer.first_name WHERE customer.first_name IS NULL;
SELECT actor.first_name AS actor_name, customer.first_name AS customer_name FROM customer LEFT JOIN actor ON customer.first_name = actor.first_name WHERE actor.first_name IS NULL;
