package com.kyx.repository;

import com.kyx.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String passmord);
}
