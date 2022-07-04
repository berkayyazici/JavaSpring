package com.Berkay.InterProbe.InterProbeBootcamp.Dao;

import com.Berkay.InterProbe.InterProbeBootcamp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
