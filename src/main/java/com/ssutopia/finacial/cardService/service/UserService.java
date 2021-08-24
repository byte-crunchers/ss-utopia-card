package com.ssutopia.finacial.cardService.service;

import com.ssutopia.finacial.cardService.entity.User;

public interface UserService {
    User findUserByUsername(String name);
}
