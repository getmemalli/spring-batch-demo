package csvToMysql.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class PersonFieldSetMapper implements FieldSetMapper<Person> {

    @Override
    public Person mapFieldSet(FieldSet fs) {

        if(fs == null){
            return null;
        }

        Person person = new Person();
        person.setRowNumber(fs.readString("rowNumber"));
        person.setLastName(fs.readString("lastName"));
        person.setFirstName(fs.readString("firstName"));

        return person;
    }


}
