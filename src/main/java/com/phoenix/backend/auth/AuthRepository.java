package com.phoenix.backend.auth;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface AuthRepository extends JpaRepository<UserAuth, Long> {
    
    @Procedure
    String  sp_print_hello_world_estadiadvt(String message);
    
    @Procedure
    boolean sp_get_auths_verify_user_estadiadvt(String username, String password);
}
