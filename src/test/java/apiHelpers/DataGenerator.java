package apiHelpers;

import java.util.random.RandomGenerator;

public class DataGenerator {
    private final String[] names = {
            "Cosmo",
            "Pluto",
            "Bob",
            "Colt",
            "Test",
            "Mini",
            "Boy",
            "Bigi"
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
            "tagTag",
            "testTag",
            "asd",
            "final",
            "continue"
    };

    private final String[] statuses = {
            "available",
            "pending",
            "sold"
    };

    private final int[] orderId = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    };

    private final String[] statusOfOrder = {
            "placed", "approved", "delivered"
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

    public int generateOrderId() {
        return orderId[RandomGenerator.getDefault().nextInt(orderId.length)];
    }

    public String generateOrderStatus() {
        return statusOfOrder[RandomGenerator.getDefault().nextInt(statusOfOrder.length)];
    }
}
