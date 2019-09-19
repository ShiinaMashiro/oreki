package xin.oreki.orekiuser.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.oreki.orekiuser.domain.User;

/**
 * @author oreki
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 按照用户名查询用户信息
     * @param username 用户名
     * @return 用户
     */
    User findByUsername(String username);
}
