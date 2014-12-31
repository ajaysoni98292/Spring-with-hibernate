package com.spring.example.model;

import com.spring.example.form.validator.SizeConstraint;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ajay
 */

public class ChangePassword {

    @NotEmpty
    private String oldPassword;

    @NotEmpty
    @SizeConstraint(min=6, max=20)
    private String newPassword;

    @NotEmpty
    @SizeConstraint(min=6, max=20)
    private String confirmPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
