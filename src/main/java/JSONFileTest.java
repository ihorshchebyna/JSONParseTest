import environments.TestEnvironment;
import org.junit.Assert;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

import static enums.Build.DEVELOPMENT;
import static enums.Build.PRODUCTION;
import static enums.Environment.PLATFORM;
import static enums.Environment.WEBSITE;

public class JSONFileTest {
    private FileParser fileParser;
    private static final String filePath = "src/main/resources/properties.json";
    private TestEnvironment testEnvironment;

    @Test
    public void testNullValues() throws Exception {
        fileParser = new FileParser();
        testEnvironment = fileParser.fileParser(filePath, PLATFORM, PRODUCTION);
        Assert.assertNotNull("BaseURLWebsite is NULL", testEnvironment.getBaseUrlWebSite());
        Assert.assertNotNull("Environment Name is NULL", testEnvironment.getNameOfEnvironment());
        Assert.assertNotNull("RemoteWebDriver is NULL", testEnvironment.getRemoteWebDriverUrl());
        Assert.assertNotNull("Password is NULL", testEnvironment.getPassword());
        Assert.assertNotNull("Username is NULL", testEnvironment.getUsername());
        Assert.assertNotNull("DB Driver is NULL", testEnvironment.getDatabaseProperties().getDriver());
        Assert.assertNotNull("DB Host Name is NULL", testEnvironment.getDatabaseProperties().getHostname());
        Assert.assertNotNull("DB Password is NULL", testEnvironment.getDatabaseProperties().getPassword());
        Assert.assertNotNull("DB Port is NULL", testEnvironment.getDatabaseProperties().getPort());
        Assert.assertNotNull("DB Service Name is NULL", testEnvironment.getDatabaseProperties().getServiceName());
        Assert.assertNotNull("DB User is NULL", testEnvironment.getDatabaseProperties().getUser());
    }


    @Test(expected = SQLException.class)
    public void testCheckDBConnection() throws Exception {
        fileParser = new FileParser();
        testEnvironment = fileParser.fileParser(filePath, WEBSITE, DEVELOPMENT);
        String dbUrl = testEnvironment.getDatabaseProperties().getDriver()
                + ":"
                + testEnvironment.getDatabaseProperties().getHostname()
                + ":"
                + testEnvironment.getDatabaseProperties().getPort();
        String dbUser = testEnvironment.getDatabaseProperties().getUser();
        String dbPassword = testEnvironment.getDatabaseProperties().getPassword();
        DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}
