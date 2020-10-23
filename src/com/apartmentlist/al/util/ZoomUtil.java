package com.apartmentlist.al.util;

import java.util.List;
import java.util.Scanner;

import com.apartmentlist.al.service.ZoomService;

public class ZoomUtil
{
    private static String DATA_RECORD = "EmployeeData.txt";

    public static int readUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void displayChoice() {
        System.out.println("****************************************************");
        System.out.println("                Friday Zoom Meeting                      ");
        System.out.println("****************************************************");
        System.out.println("Choose any option from the list:");
        System.out.println("1. View all employees");
        System.out.println("2. Shuffle in groups");
        System.out.println("3. Add a new hire");
        System.out.println("4. Release an employee");
        System.out.println("5. Exit");
    }

    public static void executeUsersChoice(int choice)
    {
        switch (choice) {
            case 1:
                System.out.println("Listing all employees:");
                System.out.println(FileUtil.readFileAsList(DATA_RECORD));
                break;
            case 2:
                System.out.println("Shuffling into groups:");
                List<String> employees = FileUtil.readFileAsList(DATA_RECORD);
                System.out.println(ZoomService.getZoomGroups(employees));
                break;
            case 3:
                System.out.println("Enter name of the new employee:");
                String employeeName = getUserChoiceAsString();
                FileUtil.appendToFile(employeeName, DATA_RECORD);
                break;
            case 4:
                System.out.println("Enter name of the existing employee:");
                employeeName = getUserChoiceAsString();
                removeEmployee(employeeName);
                break;
            default:
                System.out.println("Sorry your choice was invalid. Please try again.");
                break;
        }
    }

    private static void removeEmployee(String employeeName) {
        List<String> employees = FileUtil.readFileAsList(DATA_RECORD);
        boolean isEmployeeRemoved = employees.remove(employeeName);
        if(!isEmployeeRemoved)
            System.out.println("Employee " + employeeName + " doesn't exist.");

        String updatedEmployeeRecord = String.join("\n", employees);
        FileUtil.overwriteFile(updatedEmployeeRecord, DATA_RECORD);
    }

    private static String getUserChoiceAsString()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
