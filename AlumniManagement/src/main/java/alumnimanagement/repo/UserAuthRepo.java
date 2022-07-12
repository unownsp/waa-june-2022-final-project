package alumnimanagement.repo;

import alumnimanagement.entity.authUser.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {
    @Query("select  u from UserAuth u Where u.username =:username")
    UserAuth findByUsernameAndActive(@Param("username") String username);

    @Query("select u.Role from UserAuth u Where u.id =:id")
    String getRoleById(@Param("id") long id);

    @Query("SELECT F.department as departmentName,count(F.department) as count from UserAuth F group by F.department")
    List<Object[]> facultyByDepartment();

    @Query("SELECT A.state as title, count(S.id) as id FROM Address A JOIN  UserAuth S ON S.address.id = A.id group by A.state")
    List<Object[]> StudentByState();

    @Query("SELECT A.city as title, count(S.id) as id FROM Address A JOIN  UserAuth  S ON S.address.id = A.id WHERE A.state like %:state% group by A.city")
    List<Object[]> StudentByCity(@Param("state") String state);
}
