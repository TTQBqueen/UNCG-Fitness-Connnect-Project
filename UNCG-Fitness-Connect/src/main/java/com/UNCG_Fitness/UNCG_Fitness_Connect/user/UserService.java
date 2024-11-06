package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    /**
     * Fetch all Users.
     *
     * @return the list of all Users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Fetch a unique user.
     *
     * @param userId the unique User id.
     * @return a unique User object.
     */
    public User getUserById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * Fetch all users whose major matches the search term.
     *
     * @param role the search key.
     * @return the list of matching Users.
     */
    public List<User> getUsersByRole(String role) {
        return userRepository.getUsersByRole(role);
    }


    /**
     * Fetch all users with a GPA above a threshold.
     *
     * @param userName the threshold
     * @return the list of matching Users
     */
    public List<User> getUsersByUserName(String userName) {
        return userRepository.getUsersByUserName(userName);
    }

    /**
     * Add a new User to the database.
     *
     * @param user the new User to add.
     */
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    /**
     * Update an existing User.
     *
     * @param userId the unique User Id.
     * @param user   the new User details.
     */
    public void updateUser(int userId, User user) {
        User existing = getUserById(userId);
        existing.setUserName(user.getUserName());
        existing.setEmail(user.getEmail());
        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setJoinDate(user.getJoinDate());
        existing.setRole(user.getRole());
        existing.setFlagged(user.getFlagged());

        userRepository.save(existing);
    }

    /**
     * Delete a unique User.
     *
     * @param userId the unique User Id.
     */
    public void deleteUserById(long userId) {
        userRepository.deleteById(userId);
    }


}
