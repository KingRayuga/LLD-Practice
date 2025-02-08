package Builder;

public class UserProfile {
    private String name;
    private String number;
    private String email;
    private Integer age;
    private String address;

    private UserProfile(){

    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder{
        private String name;
        private String number;
        private String email;
        private Integer age;
        private String address;

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public UserProfile build(){
            UserProfile userProfile = new UserProfile();
            userProfile.name = this.name;
            userProfile.address = this.address;
            userProfile.age = this.age;
            userProfile.number = this.number;
            userProfile.email = this.email;
            return userProfile;
        }
    }
}