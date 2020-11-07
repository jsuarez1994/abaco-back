package com.abaco.service;

import com.abaco.dto.UserDTO;

public interface UserService {

	UserDTO save(UserDTO dto);

	Boolean login(final String email, final String password);
}
