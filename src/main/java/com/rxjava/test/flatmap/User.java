package com.rxjava.test.flatmap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
public class User {

    private String id;
    private String name;
    private List<Address> addresses;

    public User() {
    }

    @Data
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Address {
        private String name;

        public Address() {
        }
    }




    public List<User> createUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(createUser(i));
        }
        return users;
    }


    public User createUser(int i) {
        return User.builder()
                .id("id_" + i)
                .name("name" + i)
                .addresses(new ArrayList<Address>() {{
                    add(Address.builder()
                            .name("addres_" + i)
                            .build());
                }})
                .build();

    }


}
