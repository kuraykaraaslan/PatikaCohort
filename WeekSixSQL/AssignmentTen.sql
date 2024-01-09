SELECT city.name, country.name FROM city LEFT JOIN country ON city.country_id = country.country_id;
SELECT payment.payment_id, customer.first_name, customer.last_name FROM payment RIGHT JOIN customer ON payment.customer_id = customer.customer_id;
SELECT rental.rental_id, customer.first_name, customer.last_name FROM rental FULL JOIN customer ON rental.customer_id = customer.customer_id;
