package utils;

import com.github.javafaker.Faker;

public class RandomDataUtils {
    public String monthName = "";
    Faker faker = new Faker();

    public String setFirstName() {
        return faker.name().firstName();
    }

    public String setLastName() {
        return faker.name().lastName();
    }

    public String setEmail() {
        return faker.internet().emailAddress();
    }

    public String setGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String setPhoneNum() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String setIncorrectPhoneNum() {
        return faker.phoneNumber().subscriberNumber(4);
    }

    public String setDayOfBirth() {
        return String.valueOf(faker.number().numberBetween(10, 20));
    }

    public String setMonthOfBirth() {
        int monthNum = faker.number().numberBetween(0, 11);
        monthName = switch (monthNum) {
            case 0 -> "January";
            case 1 -> "February";
            case 2 -> "March";
            case 3 -> "April";
            case 4 -> "May";
            case 5 -> "June";
            case 6 -> "July";
            case 7 -> "August";
            case 8 -> "September";
            case 9 -> "October";
            case 10 -> "November";
            case 11 -> "December";
            default -> "Invalid month";
        };
        return String.valueOf(monthNum);
    }

    public String setYearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1990, 2010));
    }

    public String setSubject() {
        return faker.options().option("Maths", "Arts");
    }

    public String setHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getRandomFile() {
        return faker.options().option("pic.png", "pic2.png", "pic3.png");
    }

    public String setAddress() {
        return faker.address().fullAddress();
    }

    public String setState() {
        return faker.options().option("NCR", "Haryana", "Uttar Pradesh");
    }

    public String setCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Panipat", "Karnal");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaisalmer");
            default -> state;
        };
    }

}
