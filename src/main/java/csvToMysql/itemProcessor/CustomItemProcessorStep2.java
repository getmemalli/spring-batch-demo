package csvToMysql.itemProcessor;

import csvToMysql.domain.Constants;
import csvToMysql.domain.Person;
import org.springframework.batch.item.ItemProcessor;


public class CustomItemProcessorStep2 implements ItemProcessor<Person, Person> {


    public Person process(Person person) throws Exception {

        if(person.getRowNumber().equalsIgnoreCase( "4")){
            throw new Exception();
        }
        person.setStatus(Constants.PROCESSED);

        System.out.println("Processing...step 2" + person);
        return person;
    }
}
