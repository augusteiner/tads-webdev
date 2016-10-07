
package tads.webdev.feign;

public class Contributor {

    private String login;
    private int contributions;

    public String getLogin() {

        return this.login;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public int getContributions() {

        return this.contributions;
    }

    public void setContributions(int contributions) {

        this.contributions = contributions;
    }

    @Override
    public String toString() {

        return String.format(
            "%s (%s)",

            this.getLogin(),
            this.getContributions());

    }

}
