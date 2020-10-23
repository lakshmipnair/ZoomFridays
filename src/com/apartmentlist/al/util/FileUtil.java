package com.apartmentlist.al.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil
{
    private static final String RESOURCE_DIR = "src/resource/";

    public static List<String> readFileAsList(String fileName)
    {
        List<String> dataList = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(RESOURCE_DIR + fileName));

            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }

        return dataList;
    }

    public static void appendToFile(String data, String fileName) {
        FileWriter fr = null;
        BufferedWriter br = null;

        try {
            File file = new File(RESOURCE_DIR + fileName);
            fr = new FileWriter(file, true);
            br = new BufferedWriter(fr);
            br.write("\n" + data);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }

            if (fr != null)
            {
                try
                {
                    fr.close();
                }
                catch (IOException e)
                {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }
    }

    public static void overwriteFile(String data, String fileName) {
        FileWriter fr = null;
        BufferedWriter br = null;

        try {
            File file = new File(RESOURCE_DIR + fileName);
            fr = new FileWriter(file, false);
            br = new BufferedWriter(fr);
            br.write(data);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }

            if (fr != null)
            {
                try
                {
                    fr.close();
                }
                catch (IOException e)
                {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }
    }
}
