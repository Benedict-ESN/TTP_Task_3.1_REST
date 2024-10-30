package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.model.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<String, String> users = Map.of(
            "user1", "password1",
            "user2", "password2"
    );

    private final Map<String, List<Authorities>> authorities = Map.of(
            "user1", List.of(Authorities.READ, Authorities.WRITE),
            "user2", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).equals(password)) {
            return authorities.getOrDefault(user, Collections.emptyList());
        }
        return Collections.emptyList();
    }
}

