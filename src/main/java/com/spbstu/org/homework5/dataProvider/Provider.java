package com.spbstu.org.homework5.dataProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.spbstu.org.homework5.dataProvider.DataSet;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


///home/e105-gamma/Рабочий стол/Автоматизированное тестирование/Автоматизированное тестирование готовые работы/testLab1/target/test-classes
public class Provider {
    @DataProvider(name = "provider")
    public static Object[] getData() throws IOException {
        FileReader dataFile =

                new FileReader("/home/e105-gamma/Рабочий стол/Автоматизированное тестирование/Автоматизированное тестирование готовые работы/testLab1/target/test-classes/metalsColorsDataSet.json");

        JsonReader jsonReader = new JsonReader(dataFile);

        Map<String, DataSet> testValues =
                new Gson().fromJson(jsonReader, new TypeToken<Map<String, DataSet>>() {
                }.getType());

        return testValues.values().toArray();
    }
}