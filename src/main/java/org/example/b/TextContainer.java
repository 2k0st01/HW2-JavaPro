package org.example.b;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaveTo(path = "/Users/staskosto/Documents/Java-Modul#3/AAAA.txt")
public class TextContainer {
    String s = "Hello Java World!!!";

    @Sever
    public void save(String file){
        try(PrintWriter pw = new PrintWriter(file)){
            pw.println(s);
            System.out.println("Finish");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
