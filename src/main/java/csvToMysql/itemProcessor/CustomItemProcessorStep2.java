package csvToMysql.itemProcessor;

import csvToMysql.domain.Constants;
import csvToMysql.domain.Person;
import org.springframework.batch.item.ItemProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class CustomItemProcessorStep2 implements ItemProcessor<Person, Person> {


    public Person process(Person person) throws Exception {

        /*if(person.getRowNumber().equalsIgnoreCase( "2")){
            throw new Exception();
        }*/
        person.setStatus(Constants.PROCESSED);

        String responseData = this.getUrl();
        person.setData(responseData);

        System.out.println("Processing...step 2" + person);

        return person;
    }

    public String getUrl() {
        String responseString = "{}";
        try {

            URL url = new URL("https://beta-api.razorpay.in/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                responseString = output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return responseString;
    }
}
