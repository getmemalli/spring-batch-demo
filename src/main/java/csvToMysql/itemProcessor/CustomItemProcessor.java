package csvToMysql.itemProcessor;

import csvToMysql.Person;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
        System.out.println("Processing..." + person);
        return person;
    }
}
