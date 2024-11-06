package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    /**
     * Get all Users.
     *
     * @return the list of all Users.
     */
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    /**
     * Find one user by ID.
     *
     * @param id the unique User Id.
     * @return a unique Student object.
     *
     */
    public User getUserById(long id) {
        return repo.getReferenceById(id);
    }

    /**
     * Find one user by ID.
     *
     * @param id the unique User Id.
     * @return a unique Student object.
     *
     */
    public User getUser(long id) {
        return repo.getReferenceById(id);
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
     * @param user the User details.
     */
    public void updateUser(User user) {
        repo.save(user);
    }

    /**
     * Save user entry.
     *
     * @param user the User details.
     */
    public void saveUser(User user) {
        repo.save(user);
    }

    /**
     * Delete a unique User by Id.
     *
     * @param userId the unique User Id.
     */
    public void deleteUser(long userId) {
        repo.deleteById(userId);
    }

    /**
     * Get a User by username
     *
     * @param userName the unique User username
     */
    public User getUserByUserName(String userName) {
        return repo.findByUserName(userName).orElseThrow();
    }

}
