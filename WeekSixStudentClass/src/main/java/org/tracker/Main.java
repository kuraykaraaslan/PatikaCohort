package org.tracker;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static HashMap<String, Boolean> studentList = new HashMap<String, Boolean>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (new File("session.txt").exists())
        {
            readFromSession();
        } else {
            studentList = readFromTxt("ogrencilistesi.txt");
        }

        System.out.println("Ögrenci Listesi Yüklendi");

        while (true)
        {
            System.out.println("Bir öğrenci seçmek için Enter'a Basınız");
            scanner.nextLine();

            String studentName = getStudentRandom();

            System.out.println("Seçilen Öğrenci: " +studentName);

            setStudentTrue(studentName);

            writeToSession();

            if (isEveryoneTrue())
            {
                System.out.println("######################################");
                System.out.println("Herkes söz aldı. Sıradaki tur başlıyor");
                setAllStudentsFalse();
            }
        }

    }

    public static String getStudentRandom() {
        Random rand = new Random();
        String[] hasMapKeys = studentList.keySet().toArray(new String[0]);
        while (true) {
            int num = rand.nextInt(hasMapKeys.length);
            String randomStudent = hasMapKeys[num];
            Boolean value = studentList.get(randomStudent);
            if (value == false) {
                return randomStudent;
            }
        }
    }

    public static HashMap<String, Boolean> readFromTxt(String fileName) {

        File fileIn1 = new File(fileName);

        HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();

        try (BufferedReader bf = new BufferedReader(new FileReader(fileIn1))) {//SURROUND WITH try with resources FOR THE EXCEPTIONS

            String readLine;
            int line = 0;

            while ((readLine = bf.readLine()) != null) {
                if (line % 2 != 0) {//CHECKING WHETHER THE ROW IS ODD

                    hashMap.put(readLine, false);
                }
                line++;
            }

            return hashMap;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeToSession()
    {
        try {
            File currentFile = new File("session.txt");
            if (currentFile.exists()) {
                currentFile.delete();
            }
        }
        catch (Exception e)
        {
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("session.txt", true))){
            for(Map.Entry<String, Boolean> entry : studentList.entrySet()) {
                String key = entry.getKey();
                Boolean value = entry.getValue();
                writer.write(key + ":" + value);
                writer.newLine();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }

    public static void readFromSession()
    {

        File fileIn1 = new File("session.txt");

        try (BufferedReader bf = new BufferedReader(new FileReader(fileIn1))) {

            String readLine;

            while ((readLine = bf.readLine()) != null) {

                String[] exploded = readLine.split(":");

                String key = exploded[0];
                Boolean value;

                if(exploded[1] == "true")
                {
                    value = true;
                } else {
                    value = false;
                }

                studentList.put(key,value);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void setStudentTrue(String studentName) {
        studentList.put(studentName, true);
        return;
    }

    public static void setAllStudentsFalse()
    {
        for(Map.Entry<String, Boolean> entry : studentList.entrySet()) {
            String key = entry.getKey();
            studentList.put(key, false);
        }
        return;
    }

    public static boolean isEveryoneTrue()
    {
        for(Map.Entry<String, Boolean> entry : studentList.entrySet()) {
            Boolean value = entry.getValue();

            if (value == false)
            {
                return false;
            }

        }

        return true;
    }


}



