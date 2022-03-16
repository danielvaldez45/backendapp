package com.phoenix.backend.auth.login.repository;


import com.phoenix.backend.auth.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;


public interface AuthRepository extends JpaRepository<User, Long> {
    
    /*@Procedure
    String  sp_print_hello_world_estadiadvt(String message);
    
    @Procedure("sp_get_select_user_estadiadvt")
    String getAuthsVerifyUser(String auth);
    */
    
    @Procedure("estadia_insert_user_v2")
    boolean sp_registerUser(String jsonUser);
    
}
