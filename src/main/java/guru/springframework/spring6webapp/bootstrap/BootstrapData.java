package guru.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastname("Evans");
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastname("Johnson");
        Publisher addison = new Publisher();
        addison.setPublisherName("Addison-Wesley Professional");
        Publisher wiley = new Publisher();
        addison.setPublisherName("Wiley Publishing");   

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("12345"); 
        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("545666");

        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);
        Book dddSaved = bookRepository.save(ddd);
        Book noEJBSaved = bookRepository.save(noEJB);
        Publisher addisonSaved = publisherRepository.save(addison);
        Publisher wileySaved = publisherRepository.save(wiley);

        // add relations and update 
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        addisonSaved.getBooks().add(dddSaved);
        wileySaved.getBooks().add(noEJBSaved);
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        publisherRepository.save(addisonSaved);
        publisherRepository.save(wileySaved);

        // report
        System.out.println("Bootstrap completed");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }

}
