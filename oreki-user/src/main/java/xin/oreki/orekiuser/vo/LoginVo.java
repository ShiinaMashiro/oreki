package xin.oreki.orekiuser.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xin.oreki.orekiuser.domain.User;

/**
 * @author oreki
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo {
    /** 登录是否成功 */
    private Boolean success;
    /**
     * 登录代码
     * 详情看LoginStatus.java
     * */
    private Integer code;
    private String message;
    private User user;

    public static LoginVo success(User user) {
        user.setPassword(null);
        return new LoginVo(true, LoginStatus.LOGIN_SUCCESS.getCode(), LoginStatus.LOGIN_SUCCESS.getMsg(), user);
    }

    public static LoginVo fail(LoginStatus status) {
        return new LoginVo(false, status.getCode(), status.getMsg(), null);
    }
}
