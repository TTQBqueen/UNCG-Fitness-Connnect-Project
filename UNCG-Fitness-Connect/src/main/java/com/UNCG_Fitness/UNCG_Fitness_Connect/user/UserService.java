package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Get all Users.
     *
     * @return the list of all Users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Find one user by ID.
     *
     * @param id the unique User Id.
     * @return a unique Student object.
     *
     */
    public User getUserById(int id) {
        return userRepository.getReferenceById(id);
    }

    /**
     * Add a new User to the database.
     *
     * @param user the new User to add
     */
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    /**
     * Update an existing User.
     *
     * @param user the User details.
     */
    public void updateUser(int userId, User user) {
        User existing = getUserById(userId);

        userRepository.save(user);
    }

    /**
     * Save user entry.
     *
     * @param user the User details.
     */
    public void saveUser(User user) {
        userRepository.save(user);
    }

    /**
     * Delete a unique User by Id.
     *
     * @param userId the unique User Id.
     */
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    /**
     * Get a User by username
     *
     * @param userName the unique User username
     */
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName).orElseThrow();
    }

}
