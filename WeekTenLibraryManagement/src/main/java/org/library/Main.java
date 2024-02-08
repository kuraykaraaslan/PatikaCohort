package org.library;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import org.library.entities.Author;
import org.library.entities.Book;
import org.library.entities.Category;
import org.library.entities.Publisher;
import org.library.entities.BookBorrowing; 


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Author julesVerne = new Author("Jules Verne", 1828, "France");
        Author markTwain = new Author("Mark Twain", 1835, "United States");
        Author jkRowling = new Author("J.K. Rowling", 1965, "United Kingdom");
        Author agathaChristie = new Author("Agatha Christie", 1890, "United Kingdom");

        Publisher hetzel = new Publisher("Hetzel", 1837, "France");
        Publisher harperCollins = new Publisher("HarperCollins", 1989, "United States");
        Publisher bloomsbury = new Publisher("Bloomsbury Publishing", 1986, "United Kingdom");
        Publisher doddMead = new Publisher("Dodd, Mead and Company", 1839, "United States");

        Category scienceFiction = new Category("Science Fiction", "A genre of speculative fiction that typically deals with imaginative and futuristic concepts such as advanced science and technology, space exploration, time travel, parallel universes, and extraterrestrial life.");
        Category adventure = new Category("Adventure", "An exciting or very unusual experience.");
        Category fantasy = new Category("Fantasy", "A genre of speculative fiction set in a fictional universe, often inspired by real world myth and folklore.");
        Category mystery = new Category("Mystery", "A genre of fiction that usually involves a mysterious death or a crime to be solved.");

        Book twentyThousandLeaguesUnderTheSea = new Book();
        twentyThousandLeaguesUnderTheSea.setName("Twenty Thousand Leagues Under the Sea");
        twentyThousandLeaguesUnderTheSea.setPublicationYear(1870);
        twentyThousandLeaguesUnderTheSea.setAuthor(julesVerne);
        twentyThousandLeaguesUnderTheSea.setPublisher(hetzel);

        Book theAdventuresOfTomSawyer = new Book();
        theAdventuresOfTomSawyer.setName("The Adventures of Tom Sawyer");
        theAdventuresOfTomSawyer.setPublicationYear(1876);
        theAdventuresOfTomSawyer.setAuthor(markTwain);
        theAdventuresOfTomSawyer.setPublisher(doddMead);

        Book harryPotterAndThePhilosophersStone = new Book();
        harryPotterAndThePhilosophersStone.setName("Harry Potter and the Philosopher's Stone");
        harryPotterAndThePhilosophersStone.setPublicationYear(1997);
        harryPotterAndThePhilosophersStone.setAuthor(jkRowling);
        harryPotterAndThePhilosophersStone.setPublisher(bloomsbury);

        Book murderOnTheOrientExpress = new Book();
        murderOnTheOrientExpress.setName("Murdur on the Orient Express");
        murderOnTheOrientExpress.setPublicationYear(1934);
        murderOnTheOrientExpress.setAuthor(agathaChristie);
        murderOnTheOrientExpress.setPublisher(doddMead);

        entityManager.persist(julesVerne);
        entityManager.persist(markTwain);
        entityManager.persist(jkRowling);
        entityManager.persist(agathaChristie);
        entityManager.persist(hetzel);
        entityManager.persist(harperCollins);
        entityManager.persist(bloomsbury);
        entityManager.persist(doddMead);
        entityManager.persist(scienceFiction);
        entityManager.persist(adventure);
        entityManager.persist(fantasy);
        entityManager.persist(mystery);
        entityManager.persist(twentyThousandLeaguesUnderTheSea);
        entityManager.persist(theAdventuresOfTomSawyer);
        entityManager.persist(harryPotterAndThePhilosophersStone);
        entityManager.persist(murderOnTheOrientExpress);

        BookBorrowing borrowing = new BookBorrowing();
        borrowing.setName("John Doe");
        borrowing.setBook(twentyThousandLeaguesUnderTheSea);
        entityManager.persist(borrowing);
        
        transaction.commit();
        entityManager.close();

        entityManagerFactory.close();
    }
}

        



