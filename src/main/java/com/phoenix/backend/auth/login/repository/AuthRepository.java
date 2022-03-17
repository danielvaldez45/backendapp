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
    
    @Procedure("estadia_sp_get_auth_by_user")
    String sp_getAuthBUser(String auth);
    
    @Procedure("estadia_insert_user_v2")
    String sp_registerUser(String jsonUser);
    
    @Procedure("estadia_sp_insert_token_v2")
    String sp_persistenceTokenDB(String register_token);
}
