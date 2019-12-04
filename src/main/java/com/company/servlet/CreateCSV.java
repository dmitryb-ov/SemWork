//package com.company.servlet;
//
//import com.opencsv.CSVWriter;
//
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class CreateCSV {
//
//    public static void create(String email, String password, String gender, String country, String aboutYou, String confirmLicense) throws IOException {
//        CSVWriter writer = new CSVWriter(new FileWriter("./dataa.csv", true ));
//        writer.writeNext(new String[]{email, password, gender, country, aboutYou, confirmLicense});
//        writer.close();
//
//    }
//}
