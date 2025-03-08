package Splitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private double totalLend;
    private double totalBorrow;
    Map<UUID, Balance> balances;

    private User(){
        this.id = UUID.randomUUID();
        balances = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UUID getId() {
        return id;
    }

    public double getTotalBorrow() {
        return totalBorrow;
    }

    public double getTotalLend() {
        return totalLend;
    }

    public Map<UUID, Balance> getBalances() {
        return balances;
    }

    public void setTotalBorrow(double totalBorrow) {
        this.totalBorrow = totalBorrow;
    }

    public void setTotalLend(double totalLend) {
        this.totalLend = totalLend;
    }

    public void notifications(double amount){
        if(amount < 0){
            System.out.println("user has borrowed: " + amount);
        } else {
            System.out.println("user has lent: " + amount);
        }
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private String phone;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            User user = new User();
            user.name = this.name;
            user.email = this.email;
            user.phone = this.phone;
            return user;
        }
    }
}
