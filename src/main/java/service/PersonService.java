package service;

import jakarta.enterprise.context.ApplicationScoped;
import model.Person;
import repository.PersonRepository;

@ApplicationScoped
public class PersonService extends BaseService<Person, Long, PersonRepository> {
}
