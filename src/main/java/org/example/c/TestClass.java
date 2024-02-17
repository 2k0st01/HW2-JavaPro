package org.example.c;

import java.io.Serializable;

public class TestClass implements Serializable {
    @Save
    private String field1 = "filed1";

    private String field2 = "filed2";
    @Save
    private String field3 = "filed3";

    private String field4 = "filed4";
    @Save
    private String field5 = "filed5";

    @Override
    public String toString() {
        return "TestClass{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}
