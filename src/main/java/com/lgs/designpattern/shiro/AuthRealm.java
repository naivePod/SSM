package com.lgs.designpattern.shiro;

/**
 * @Auther: lgs
 * @Date: 2018-11-16 14:26
 * @Description:
 */
public abstract class AuthRealm {
    private AuthRealm successor;

    public void setSuccessor(AuthRealm realm) {
        this.successor = realm;
    }

    public final boolean auth(AuthToken token) {
        if(token == null) return false;

        if(this.loginAuth(token)) {
            return true;
        }
        return successor!= null && successor.auth(token);
    }

    protected abstract boolean loginAuth(AuthToken token);

    protected abstract PermissionInfo doGetPermissionInfo(AuthToken token);
}
