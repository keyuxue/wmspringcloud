package com.kyx.repository;

import com.kyx.entity.User;

public interface UserRepository {
    public User login(String username, String passmord);
}
