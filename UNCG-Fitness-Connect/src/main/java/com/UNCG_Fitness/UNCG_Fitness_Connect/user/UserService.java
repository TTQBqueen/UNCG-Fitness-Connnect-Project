package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

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
        //return userRepository.getReferenceById(id);
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Add a new User to the database.
     *
     * @param user the new User to add
     */
    public void addNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    /**
     * Update an existing User.
     *
     * @param user the User details.
     */
    public void updateUser(int userId, User user) {
        User existing = getUserById(userId);
        existing.setUserName(user.getUserName());
        existing.setEmail(user.getEmail());
        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setRole(user.getRole());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(existing);

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

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(()
                -> new UsernameNotFoundException(userName + "not found"));
    }

    public User getUser(int id) {
        return userRepository.getReferenceById(id);
    }
}
