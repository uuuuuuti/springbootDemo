package ray.forms;

import javax.validation.constraints.NotNull;

/**
 * Created by zr on 2016/11/16.
 */
public class UserForm {
    @NotNull
    private String password;

    @NotNull
    private String newPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
