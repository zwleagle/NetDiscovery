package com.cv4j.netdiscovery.core.cookies;

import lombok.Getter;

import java.io.Serializable;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2018/2/1.
 */
@Getter
public class CookieGroup implements Serializable {

    private static final long serialVersionUID = -4641596355459197507L;

    private String domain;
    private List<HttpCookie> cookies;

    public CookieGroup(String domain) {
        this.domain = domain;
        this.cookies = new ArrayList<>();
    }

    public void putCookie(HttpCookie cookie) {
        this.getCookies().add(cookie);
    }

    public void putAllCookies(List<HttpCookie>  cookies) {
        this.getCookies().addAll(cookies);
    }

    public void removeCookie(HttpCookie cookie) {
        this.getCookies().remove(cookie);
    }

    /**
     * 将cookieGroup转换成String
     * @return
     */
    public String getCookieString() {

        StringBuilder buffer = new StringBuilder();

        cookies.forEach(cookie -> buffer.append(cookie.getName()).append("=").append(cookie.getValue()).append("; "));

        return buffer.length() > 2 ? buffer.substring(0, buffer.length() - 2) : buffer.toString();
    }

    @Override
    public String toString() {
        return "CookieGroup{" +
                "domain='" + domain + '\'' +
                ", cookies=" + cookies +
                '}';
    }
}
