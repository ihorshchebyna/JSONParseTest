import enums.Build;
import enums.Environment;
import environments.DataBaseProperties;
import environments.TestEnvironment;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class FileParser {

    public TestEnvironment fileParser(String pathToFile, Environment environment, Build build) throws Exception {
        return parseEnvProps(pathToFile, environment, build);
    }

    private DataBaseProperties parseDBProps(JSONArray jsonArray, Build build) throws Exception {
        DataBaseProperties dbProps = new DataBaseProperties();

        for (int i = 0; i <= jsonArray.size(); i++) {
            if (jsonArray.get(i).toString().contains(build.toString())) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                JSONArray jsonArray1 = (JSONArray) jsonObject.get(build.toString());
                JSONObject db = (JSONObject) jsonArray1.get(0);
                dbProps.setDriver(db.get("driver").toString());
                dbProps.setHostname(db.get("hostName").toString());
                dbProps.setPassword(db.get("password").toString());
                dbProps.setPort(db.get("port").toString());
                dbProps.setServiceName(db.get("serviceName").toString());
                dbProps.setUser(db.get("user").toString());
                return dbProps;
            }
        }
        return dbProps;
    }

    private TestEnvironment parseEnvProps(String pathToFile, Environment environmentType, Build build) throws Exception {
        TestEnvironment testEnvironment = new TestEnvironment();

        JSONObject environment = getEnvironmentFromJSON(environmentType, pathToFile);
        JSONArray dbProps1 = (JSONArray) environment.get("databaseProperties");

        testEnvironment.setBaseUrlWebSite(environment.get("baseUrlWebSite").toString());
        testEnvironment.setDatabaseProperties(parseDBProps(dbProps1, build));
        testEnvironment.setNameOfEnvironment(environment.get("nameOfEnvironment").toString());
        testEnvironment.setRemoteWebDriverUrl(environment.get("remoteWebDriverUrl").toString());
        testEnvironment.setPassword(environment.get("webSiteUsername").toString());
        testEnvironment.setUsername(environment.get("webSiteUsername").toString());

        return testEnvironment;
    }

    private JSONObject getEnvironmentFromJSON(Environment environmentType, String pathToFile) throws IOException, ParseException {
        FileReader reader = new FileReader(pathToFile);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonArray = (JSONObject) jsonParser.parse(reader);
        return (JSONObject) jsonArray.get(environmentType.toString());
    }
}
