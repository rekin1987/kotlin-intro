public class GitUser {

    private String username;
    private String pass;
    private int colorMode;

    public GitUser() {
        this("default user", "default pass", 0);
    }

    public GitUser(String username) {
        this(username, "default pass", 0);
    }

    public GitUser(String username, String pass) {
        this(username, pass, 0);
    }

    public GitUser(String username, String pass, int colorMode) {
        this.username = username;
        this.pass = pass;
        this.colorMode = colorMode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getColorMode() {
        return colorMode;
    }

    public void setColorMode(int colorMode) {
        this.colorMode = colorMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GitUser gitUser = (GitUser) o;
        if (colorMode != gitUser.colorMode) {
            return false;
        }
        if (!username.equals(gitUser.username)) {
            return false;
        }
        return pass.equals(gitUser.pass);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + pass.hashCode();
        result = 31 * result + colorMode;
        return result;
    }

    @Override
    public String toString() {
        return "(" + this.getClass().getSimpleName() +
                " username = " + username +
                ", pass = " + pass +
                ", colorMode = " + colorMode
                + ")";
    }

    public GitUser copy() {
        return new GitUser(username, pass, colorMode);
    }

    public GitUser copy(String username) {
        return new GitUser(username, this.pass, this.colorMode);
    }

    public GitUser copy(String username, String pass) {
        return new GitUser(username, pass, this.colorMode);
    }

    public GitUser copy(String username, String pass, int colorMode) {
        return new GitUser(username, pass, colorMode);
    }

    public String component1() {
        return username;
    }

    public String component2() {
        return pass;
    }

    public int component3() {
        return colorMode;
    }

} // end of GitUser class