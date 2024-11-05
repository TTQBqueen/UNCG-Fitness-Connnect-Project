package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    /**
     * Fetch all Users.
     *
     * @return the list of all Users.
     */
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    /**
     * Fetch a unique User.
     *
     * @param userId the unique User Id.
     * @return a unique Student object.
     *
     */
    public User getUserById(long userId) {
        return repo.findById(userId).orElse(null);
    }

    /**
     * Add a new User to the database.
     *
     * @param user the new User to add
     */
    public void addNewUser(User user) {
        repo.save(user);
    }

    /**
     * Update an existing User.
     *
     * @param userId the unique User Id.
     * @param user   the new User details.
     */
    public void updateUser(long userId, User user) {
        repo.save(user);
    }

    /**
     * Delete a unique User.
     *
     * @param userId the unique User Id.
     */
    public void deleteUserById(long userId) {
        repo.deleteById(userId);
    }

}
