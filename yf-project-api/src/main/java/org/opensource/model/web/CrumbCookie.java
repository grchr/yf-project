package org.opensource.model.web;

public class CrumbCookie {
  private String crumb;
  private String cookie;

  public CrumbCookie(String crumb, String cookie) {
    this.crumb = crumb;
    this.cookie = cookie;
  }

  public String getCrumb() {
    return crumb;
  }

  public void setCrumb(String crumb) {
    this.crumb = crumb;
  }

  public String getCookie() {
    return cookie;
  }

  public void setCookie(String cookie) {
    this.cookie = cookie;
  }
}
