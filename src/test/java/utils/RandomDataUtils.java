package utils;

import com.github.javafaker.Faker;

public class RandomDataUtils {
    Faker faker = new Faker();

    public String setFirstName(){
        return faker.name().firstName();
    }
    public String setLastName(){
        return faker.name().lastName();
    }
    public String setEmail(){
        return faker.internet().emailAddress();
    }
    public String setGender(){
        return faker.options().option("Male", "Female","Other");
    }
    public String setPhoneNum(){
        return faker.phoneNumber().subscriberNumber(10);
    }
    public String setIncorrectPhoneNum(){
        return faker.phoneNumber().subscriberNumber(4);
    }
    public String setDayOfBirth(){
        return String.valueOf(faker.number().numberBetween(10, 20));
    }
    public String setMonthOfBirth(){
        return String.valueOf(faker.number().numberBetween(0, 11));
    }
    public String getNameOfMonth(){
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }
    public String setYearOfBirth(){
        return String.valueOf(faker.number().numberBetween(1990, 2010));
    }
    public String setSubject(){
        return faker.options().option("Math","Arts");
    }
    public String setHobby(){
        return faker.options().option("Sport","Music","Reading");
    }
    public String setAddress(){
        return faker.address().fullAddress();
    }
    public String setPermanentAddress(){
        return faker.address().fullAddress();
    }
    public String setState(){
        return faker.options().option("NCR", "Haryana", "Uttar Pradesh");
    }
    public String setCity(String state){
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Lucknow", "Mathura", "Varanasi");
            case "Haryana" -> faker.options().option("Chandigarh", "Gurgaon", "Karnal");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaisalmer");
            default -> state;
        };
    }

}
