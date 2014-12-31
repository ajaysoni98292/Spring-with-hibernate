package com.spring.example.utils;

import com.spring.example.enums.Roles;
import com.spring.example.persistence.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author ajay
 */
public class ActiveUserUtil {

    private static final Logger logger = LoggerFactory.getLogger(ActiveUserUtil.class);

    /* The following method is used whenever you want to update or you want to do on active user
     * Call this method from anywhere using the class and get the information of the active user.
     */
    public static User getUser() {
        User user = null;
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = (User) authentication.getPrincipal();
        } catch (Exception e) {
            logger.error("Problem while getting user obj {} {} ", e, e.getStackTrace());
        }
        return user;
    }

    /* The following method is used whenever you want to identify the active user is admin or not. */

    public static boolean isUserAdmin(){
        if(getUser().getRole().getRole().equalsIgnoreCase(Roles.ROLE_ADMIN.name())){
            return true;
        }
        return false;
    }

    /* The following method is used whenever you want to identify the active user is agent or not */

    public static boolean isUserAgent(){
        if(getUser().getRole().getRole().equalsIgnoreCase(Roles.ROLE_AGENT.name())){
            return true;
        }
        return false;
    }


    public static long getUserId(){
        return getUser().getId();
    }
}
