package com.Alura.ForoHub.repository;

import com.Alura.ForoHub.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    //metodo para la autenticacion de UserDetailsService
    UserDetails findByUser(String username);

}
