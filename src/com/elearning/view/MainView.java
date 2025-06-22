package com.elearning.view;



import java.util.Scanner;



public class MainView {
    Scanner scan = new Scanner(System.in);
    LoginView authService = new LoginView();


    public void show(){

        try {
        System.out.println("--------------WELCOME TO ADITYA COURSE-----------");
        System.out.println("-------------------------------------------------");
        System.out.println("--- " + "1. Login    " + "2. Daftar    " + "3. Keluar");
        System.out.println("-------------------------------------------------");
        System.out.print("--- " + "Masukan Pilihan : ");
        int choose = Integer.valueOf(scan.nextLine());
        System.out.print("---");
        System.out.println("-------------------------------------------------");
            if (choose == 1){
                authService.showLogin();
            } else if (choose == 2){
                authService.showRegister();
            } else if (choose == 3 ) {
                System.out.println("semoga sukses");
                return;
            }
        } catch (NumberFormatException e ){
            System.out.println("Maaf Menu tidak tersedia");
        }
        show();
    }

}
