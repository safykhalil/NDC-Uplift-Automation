package utilities;// FakerSingleton.java
import com.github.javafaker.Faker;

import java.util.UUID;

public class FakerSingleton {
    private static FakerSingleton instance;
    private Faker faker;
    private String testData;
    private String AgencyName;

    private FakerSingleton() {
        faker = new Faker();
        testData = faker.name().firstName()+"_" + UUID.randomUUID().toString().substring(0, 6); // Example of generating a name
        AgencyName = faker.name().firstName()+"_" + UUID.randomUUID().toString().substring(0, 6); // Example of generating a name
    }

    public static FakerSingleton getInstance() {
        if (instance == null) {
            instance = new FakerSingleton();
        }
        return instance;
    }

    public String getTestData() {
        return testData;
    }
    public String getAgencyName() {
        return AgencyName;
    }

}


