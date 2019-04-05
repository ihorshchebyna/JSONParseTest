package environments;

public class TestEnvironment {
    private String nameOfEnvironment;
    private String remoteWebDriverUrl;
    private String baseUrlWebSite;
    private String username;
    private String password;
    private DataBaseProperties databaseProperties;


    public String getNameOfEnvironment() {
        return nameOfEnvironment;
    }

    public void setNameOfEnvironment(String nameOfEnvironment) {
        this.nameOfEnvironment = nameOfEnvironment;
    }

    public String getRemoteWebDriverUrl() {
        return remoteWebDriverUrl;
    }

    public void setRemoteWebDriverUrl(String remoteWebDriverUrl) {
        this.remoteWebDriverUrl = remoteWebDriverUrl;
    }

    public String getBaseUrlWebSite() {
        return baseUrlWebSite;
    }

    public void setBaseUrlWebSite(String baseUrlWebSite) {
        this.baseUrlWebSite = baseUrlWebSite;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataBaseProperties getDatabaseProperties() {
        return databaseProperties;
    }

    public void setDatabaseProperties(DataBaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }
}
