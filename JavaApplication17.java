/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication17;

import java.util.Scanner;

/**
 *
 * @author Fouad obaid
 */
public class JavaApplication17 {
    
/** @param args}**/

    public static void main(String[] args) {
         
          String[][] users=new String[10][5];

// نستخدم كلاس Scanner للتعامل مع الإدخال المدخل من المستخدم
  Scanner input = new Scanner(System.in);
  
  // نعرف اسم المستخدم وكلمة المرور الخاصة بالمسؤول
   String ADMIN_USERNAME = "admin";
   String ADMIN_PASSWORD = "123456";
  
  // نعرف الدور الخاص بالمسؤول والمستخدم
   int ADMIN_ROLE =1;
 int USER_ROLE = 2;

// نعرف متغير يحدد الدور الحالي للمستخدم (مسؤول أو مستخدم)
 int role;

// نعرف مصفوفة من كلاس المستخدم لتخزين المستخدمين
int User[] = new int[100];

// نعرف متغير يحدد عدد المستخدمين الموجودين في المصفوفة
int numUsers = 0;

    
        OUTER:
        while (true) {
            System.out.println("1. Login as admin");
            System.out.println("2. Login as user");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            // اذا اختار المستخدم الدخول كمسؤول
            switch (choice) {
                case 1 -> {
                    // نطلب من المستخدم ادخال اسم المستخدم وكلمة المرور
                    System.out.print("Enter username: ");
                    String username = input.next();
                    System.out.print("Enter password: ");
                    String password = input.next();
                    // اذا كان اسم المستخدم وكلمة المرور المدخلة صحيحة
                    // نعين الدور الخاص بالمستخدم كدور المسؤول
                    // ونعرض رسالة ترحيب للمسؤول
                    // وندخل في القائمة الخاصة بالمسؤول
                    if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                        role = ADMIN_ROLE;
                        System.out.println("Welcome admin!");
                        adminMenu(numUsers,users);
                    } else {
// اذا كان اسم المستخدم او كلمة المرور غير صحيحة
// نعرض رسالة خطأ
// ونعرض قائمة للمستخدم للاختيار ما بين محاولة الدخول مرة أخرى او الرجوع للقائمة الرئيسية
System.out.println("Incorrect username or password.");
System.out.println("1. Try again");
System.out.println("2. Go back to main menu");
System.out.print("Enter your choice: ");
choice = input.nextInt();
if (choice == 2) {
    continue;
}
                    }
          }
                case 2 -> {
                    // نعين الدور الخاص بالمستخدم كدور المستخدم
// ونعرضسالة ترحيب للمستخدم
// وندخل في القائمة الخاصة بالمستخدم
role = USER_ROLE;   System.out.println("Welcome user!");
userMenu(users);
          }
                case 3 -> {
                    break OUTER;
          }
                default -> {
          }
            }
        }
}

// نعرف الدالة التي تعرض القائمة الخاصة بالمسؤول
static void adminMenu(int numUsers, String[][] users) {
    Scanner input =new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println("1. Add users");
            System.out.println("2. View users");
            System.out.println("3. Search users");
            System.out.println("4. Edit user details");
            System.out.println("5. Delete users");
            System.out.println("6. Go back to main menu");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            // اذا اختار المستخدم إضافة مستخدمين
            switch (choice) {
                case 1 ->                     {
                        // نطلب من المستخدم ادخال المعلومات اللازمة للمستخدم
                        // ونقوم بإنشاء نسخة من كلاس المستخدم وإضافتها للمصفوفة
                        System.out.print("Enter account number: ");
                        int accountNumber = input.nextInt();
                        System.out.print("Enter username: ");
                        String username = input.next();
                        System.out.print("Enter id: ");
                        int id = input.nextInt();
                        System.out.print("Enter address: ");
                        String address = input.next();
                        System.out.print("Enter balance: ");
                        double balance = input.nextDouble();
                        int i=numUsers;
                        users[i][0] = Integer.toString(accountNumber);
                        users[i][1]=username;
                        users[i][2]=Integer.toString(id);
                        users[i][3]=address;
                        users[i][4]=Double.toString(balance);
                        System.out.println("User added successfully.");
                        numUsers ++;
                        
                        
                        
                    }
                case 2 -> {
                    // نعرض المستخدمين الموجودين في المصفوفة
                    // ونعر
// ونعرض رسالة لعدم وجود مستخدمين في المصفوفة في حال لم يكن هناك مستخدمين في المصفوفة
if (numUsers > 0) {
    String s="null";
    for (int i = 0; i <users.length ; i++) {
        for (int j = 0; j <users[i].length ; j++) {
           
             System.out.println(users[i][j]);
        
    }}
    System.out.println("Number of users: " + numUsers);
} else {
    System.out.println("No users found.");
}
            }
                case 3 ->                     {
                        // نطلب من المستخدم ادخال رقم الحساب البنكي الذي يريد البحث عنه
// ونبحث في المصفوفة ونعرض المستخدم الذي يطابق رقم الحساب البنكي المدخل
// ونعرض رسالة لعدم وجود المستخدم في المصفوفة في حال لم يتم العثور على المستخدم
                        System.out.print("Enter account number: ");
                        int accountNumber = input.nextInt();
                        boolean found = false;
                        for (int i = 0; i < numUsers; i++) {
                            int a=Integer.parseInt(users[i][0]);
                            if (a==accountNumber) {
                                for (int j = 0; j <users[i].length; j++) {
                                    System.out.println(users[i][j]);
                                }
                                found = true;
                                
                            }
                        }                       if (!found) {
                            System.out.println("User not found.");
                        }                                          }
                case 4 ->                     {
                        // نطلب من المستخدم ادخال رقم الحساب البنكي للمستخدم الذي يريد تعديل بياناته
// ونبحثفي المصفوفة ونعرض المستخدم الذي يطابق رقم الحساب البنكي المدخل
// ونطلب من المستخدم ادخال المعلومات التي يريد تعديلها
// ونقوم بتعديل المعلومات في كلاس المستخدم
// ونعرض رسالة لعدم وجود المستخدم في المصفوفة في حال لم يتم العثور على المستخدم
                        System.out.print("Enter account number: ");
                        int accountNumber = input.nextInt();
                        
                        boolean found = false;
                        for (int i = 0; i < users.length; i++) {
                            int a=Integer.parseInt(users[i][0]);
                            if (a==accountNumber) {
                                System.out.print("Enter username: ");
                                String username = input.next();
                                System.out.print("Enter id: ");
                                int id = input.nextInt();
                                System.out.print("Enter address: ");
                                String address = input.next();
                                System.out.print("Enter balance: ");
                                double balance = input.nextDouble();
                                users[i][1]=(username);
                                users[i][2]=Integer.toString(id);
                                users[i][3]=(address);
                                users[i][4]=Double.toString(balance);
                                System.out.println("User details edited successfully.");
                                found = true;
                                break;
                            }
                        }                       if (!found) {
                            System.out.println("User not found.");
                        }                                          }
                case 5 ->                     {
                        // نطلب من المستخدم ادخال رقم الحساب البنكي للمستخدم الذي يريد حذفه
// ونبحث في المصفوفة ونعرض المستخدم الذي يطابق رقم الحساب البنكي المدخل
// ونطلب من المستخدم التأكيد على الحذف
// ونقوم بحذف المستخدم من المصفوفة
// ونعرض رسالة لعدم و
                        System.out.print("Enter account number: ");
                        int accountNumber = input.nextInt();
                        boolean found = false;
                        int index = -1;
                        for (int i = 0; i <numUsers; i++) {
                            int a=Integer.parseInt(users[i][0]);
                            if (a==accountNumber) {
                                System.out.print("Are you sure you want to delete this user? (y/n) ");
                                char confirm = input.next().charAt(0);
                                if (confirm == 'y') {
                                    index = i;
                                    found = true;
                                    break;
                                }
                            }
                        }                       if (found) {
// لحذف المستخدم نقوم بنسخ المستخدمين الموجودين في المصفوفة من المستخدم الذي نريد حذفه وحتى المستخدم الأخير
// ونضعهم في مصفوفة جديدةونحذف المستخدم الذي نريد حذفه من المصفوفة القديمة
String[][] newArray=new String[10][5];
for (int i = 0; i < numUsers; i++) {
    for (int j = 0; j < 10; j++) {
         if (i != index) {
        newArray[i][j] = users[i][j];
    }
    }
}
users = newArray;
numUsers--;
System.out.println("User deleted successfully.");
                        } else {
                            System.out.println("User not found.");
                        }                                          }
                case 6 -> {
                    System.out.println("Thank you for using the program. Goodbye!\n");
                    break OUTER;
            }
                default -> {System.out.println("Error...");
            }
            }
        }
}

    private static void userMenu(String [][]users) {
        Scanner input=new Scanner(System.in);
        
        System.out.println("Enter account number:");
        int accountnumber=input.nextInt();
        OUTER:
        for (int i = 0; i <users.length; i++) {
       int a=Integer.parseInt(users[i][0]);
         if (a==accountnumber){
            System.out.println("1 - Show all user data\n" +
        "2- Withdraw money\n" +
        "3- Depositing funds\n" +
        "4 - Exit");
            System.out.println("\nEnter your choice:");
            int choice=input.nextInt();
            if(choice==1){
                for (int j = 0; j < users[i].length; j++) {
                    System.out.println(users[i][j]);
                    
                }
                System.out.println("1-Back to the user list..\n");
                System.out.println("2-Exit.\n");
                System.out.println("Enter your choice: ");
                int cho=input.nextInt();
                switch(cho){
                    case 1 -> {
                        break OUTER;
                    }
                    case 2 -> {
                        break;
                    }
                
            }}
            else if(choice==2){
                
                
                System.out.println("Enter the amount to be withdrawn:");
                double amount=input.nextDouble();
                double balan=Double.parseDouble(users[i][4]);
                
                if(amount<=balan){
                    
                    balan-=amount;
                    String ad=Double.toString(balan);
                  users[i][4]=ad ;
                    System.out.println("The withdrawal has been completed successfully...."); 
                    System.out.println("\n1. Repeat the process.\n" +"2. Exit");
                    System.out.println("Enter your choice:");
                    int choose=input.nextInt();
                    switch(choose){
                        case 1 -> {
                            break OUTER;
                    }
                        case 2 -> {
                            break OUTER;
                    }
}
                          
                    
                    }
                else{
                    System.out.println("The available balance is not enough...");
                    System.out.println("Go to the user page(y/n)...:");
                char ans=input.next().charAt(0);
                if(ans=='y'){
                break OUTER;}
                else{break;}
                }
                
                
                    
                }
            else if(choice==3){
                          
            
            
                System.out.println("Enter the amount of funds to be deposited:");
                double dep=input.nextDouble();          
                double balan = Double.parseDouble(users[i][4]);
                if(true){
                balan+=dep;
                String ac=Double.toString(balan);
                users[i][4]=ac;
                        
                    System.out.println("Deposit completed successfully...\n"+"the amount\n" +
"available in the account="+users[i][4]);
                  
                  
                }
                else{System.out.println("wrong message...");}
                
                
            break;
            
            }  
            
            }   
        }
        
        
       
    }
    
  }


