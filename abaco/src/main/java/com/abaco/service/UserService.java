package com.abaco.service;

import com.abaco.dto.UserDTO;

public interface UserService extends AbstractService<UserDTO> {
	Boolean login(final String email, final String password);
}
