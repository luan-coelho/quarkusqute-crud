package repository;

import jakarta.enterprise.context.ApplicationScoped;
import model.Person;

@ApplicationScoped
public class PersonRepository extends BaseRepository<Person, Long> {
}

