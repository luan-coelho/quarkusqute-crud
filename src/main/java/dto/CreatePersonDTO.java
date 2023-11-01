package dto;

import jakarta.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Person;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonDTO {

    @FormParam("name")
    private String name;
    @FormParam("email")
    private String email;
    @FormParam("cpf")
    private String cpf;
    @FormParam("password")
    private String password;

    public static Person dataTransferObjectToEntity(CreatePersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setEmail(personDTO.getEmail());
        person.setCpf(personDTO.getCpf());
        person.setPassword(personDTO.getPassword());

        return person;
    }
}
