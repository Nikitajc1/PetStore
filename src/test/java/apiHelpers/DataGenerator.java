package apiHelpers;

import java.util.random.RandomGenerator;

public class DataGenerator {
    private final String[] names = {
            "Cosmo",
            "Pluto",
            "Bob",
            "Colt"
    };

    private final String[] categories = {
            "longDog",
            "shyDog",
            "anotherDog",
            "shortDog"
    };

    private final String[] tags = {
            "defaultTag",
            "anotherTag",
            "thirdTag",
            "tagTag"
    };

    private final String[] statuses = {
            "available",
            "pending",
            "sold"
    };

    public String generateValidName() {
        return names[RandomGenerator.getDefault().nextInt(names.length)];
    }

    public String generateCategory() {
        return categories[RandomGenerator.getDefault().nextInt(categories.length)];
    }

    public String generateTag() {
        return tags[RandomGenerator.getDefault().nextInt(tags.length)];
    }

    public String generateStatus() {
        return statuses[RandomGenerator.getDefault().nextInt(statuses.length)];
    }

    public void main() {
        System.out.println(generateValidName());
    }
}
