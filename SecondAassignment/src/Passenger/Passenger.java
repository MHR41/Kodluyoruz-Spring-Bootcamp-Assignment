package Passenger;

public class Passenger {
    private String name;
    private String lastName;
    private PassengerEducationalStatus educationalStatus;
    private PassengerAgeCategory ageCategory;

    public Passenger(String name, String lastName, PassengerEducationalStatus educationStatus, PassengerAgeCategory ageCategory) {
        this.name = name;
        this.lastName = lastName;
        this.educationalStatus = educationStatus;
        this.ageCategory = ageCategory;
    }

    //getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public PassengerEducationalStatus getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(PassengerEducationalStatus educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    public PassengerAgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(PassengerAgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationalStatus=" + educationalStatus +
                ", ageCategory=" + ageCategory +
                '}';
    }
}