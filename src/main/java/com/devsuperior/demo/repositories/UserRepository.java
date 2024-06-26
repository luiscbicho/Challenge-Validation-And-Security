package com.devsuperior.demo.repositories;

import com.devsuperior.demo.entities.User;
import com.devsuperior.demo.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select tb_user.email AS username, tb_user.password, tb_role.id AS roleId, tb_role.authority from tb_user inner join tb_user_role on tb_user.id=tb_user_role.user_id inner join tb_role on tb_role.id=tb_user_role.role_id where tb_user.email = :email")
    public List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

}
