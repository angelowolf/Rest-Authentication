package model;

/**
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class Token {

    public String access_token;

    public Token() {
    }

    public Token(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

}
