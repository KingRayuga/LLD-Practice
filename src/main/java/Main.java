import Builder.UserProfile;

public class Main {
    public static void main(String[] args){
        UserProfile userProfile = new UserProfile.Builder()
                .setName("John Doe")
                .setAge(30)
                .setEmail("john.doe@example.com")
                .setNumber("1234567890")
                .setAddress("123 Main St")
                .build();

        System.out.println("user is " + userProfile);
    }
}
