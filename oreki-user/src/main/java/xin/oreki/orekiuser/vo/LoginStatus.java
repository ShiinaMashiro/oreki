package xin.oreki.orekiuser.vo;

import lombok.*;

/**
 * @author oreki
 */
@AllArgsConstructor
public enum LoginStatus {
    // 登录成功
    LOGIN_SUCCESS(0, "登录成功"),
    //用户不存在
    USER_NOT_EXIST(1, "用户不存在"),
    // 密码错误
    PASSWORD_ERROR(2, "密码错误"),
    // 其他错误
    OTHER_ERROR(3, "登录失败");

    @Getter
    @Setter
    private int code;
    @Getter
    @Setter
    private String msg;

}
