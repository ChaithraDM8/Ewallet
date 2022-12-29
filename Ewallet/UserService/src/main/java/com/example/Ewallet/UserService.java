package com.example.Ewallet;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserEntryDto userEntryDto) throws UserAlreadyExistsException {
        User user = User.builder()
                .userName(userEntryDto.getUserName())
                .name(userEntryDto.getName())
                .phoneNum(userEntryDto.getPhoneNum())
                .email(userEntryDto.getEmail())
                .password(userEntryDto.getPassword())
                .build();
        User userExisting = userRepository.findByUserName(user.getUserName());
        if (userExisting != null) {
            throw new UserAlreadyExistsException("Username already exists...!!");
        }
        userRepository.save(user);
    }


    public User findByUserNameAndPassword(String userName, String password) throws UserNotFoundException {
        User userExists = userRepository.findByUserName(userName);
        if (userExists == null)
            throw new UserNotFoundException("User Not Found..!!");
        String pass = password;
        if (!password.equals(userExists.getPassword())) {
            throw new UserNotFoundException("Invalid password...!");
        }
        return userExists;
    }
}

