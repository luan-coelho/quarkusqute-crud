package resource;

import dto.CreatePersonDTO;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Person;
import service.PersonService;

import java.util.List;

@Blocking
@Produces(MediaType.TEXT_HTML)
@Path("/")
public class PersonResource {

    @CheckedTemplate(requireTypeSafeExpressions = false)
    public static class Templates {
        public static native TemplateInstance index();

        public static native TemplateInstance create();
    }

    @Inject
    PersonService service;

    @GET
    public TemplateInstance get() {
        List<Person> personList = service.findAll();
        return Templates.index().data("persons", personList);
    }

    @GET
    @Path("/create")
    public TemplateInstance create() {
        return Templates.create();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public TemplateInstance save(CreatePersonDTO personDTO) {
        Person person = CreatePersonDTO.dataTransferObjectToEntity(personDTO);
        service.create(person);
        return Templates.index();
    }
}
