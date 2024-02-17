package org.example.b;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(value= RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String path();
}
