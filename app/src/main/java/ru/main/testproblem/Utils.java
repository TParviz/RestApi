package ru.main.testproblem;

import ru.main.testproblem.api.TestApi;
import ru.main.testproblem.api.TestClient;

public class Utils {
    public static TestApi getApi() {
        return TestClient.getTestClient().create(TestApi.class);
    }
}
