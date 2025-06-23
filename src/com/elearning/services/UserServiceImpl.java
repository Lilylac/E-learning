package com.elearning.services;

import com.elearning.module.Course;
import com.elearning.module.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    List<User> users = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    int userIdHelper = 2024320000;


    @Override
    public void register(int userId, String username, String password) {
        User user = new User(userId, username, password);
        users.add(user);
    }

    @Override
    public boolean loginUser(String username, String password) {
        boolean helperLoginUser = false;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                helperLoginUser = true;
                break;
            }
        }
        return helperLoginUser;
    }

    @Override
    public boolean checkUsernameAvailable(String username, String password) {
        boolean helperRegister = true;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                helperRegister = false;
                System.out.println(user.getUsername().equals(username));
                break;
            }
        }
        return helperRegister;

    }

    @Override
    public void showAllUsers() {
        for (User user : users) {
            System.out.println("-----------------------------");
            System.out.println("id     : " + user.getUserId());
            System.out.println("Username : " + user.getUsername());
            System.out.println("Password     : " + user.getPassword());
        }
    }

    @Override
    public void showSelectedUser(int IdUser) {


    }

    @Override
    public void editSelectedUser(String userName, String password) {
        if (users.isEmpty()) {
            System.out.println("User tidak terdaftar ada");
        }
        for (User user : users) {
            if (userName.equals(user.getUsername()) && password.equals(user.getPassword())) {
                System.out.println("-----------------------------");
                System.out.println("id     : " + user.getUserId());
                System.out.println("Username : " + user.getUsername());
                System.out.println("Password     : " + user.getPassword());

                System.out.println("[1] Username [2] Password [3] bukan akun ini ");
                System.out.print("--- Apa yang ingin anda ubah :  ");
                int choose = Integer.parseInt(scan.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("Masukkan username baru :");
                        String newUsername = String.valueOf(scan.nextLine());
                        user.setUsername(newUsername);
                        System.out.println("Username sudah diubah");
                        break;
                    case 2:
                        System.out.println("Masukkan password baru :");
                        String newPassword = String.valueOf(scan.nextLine());
                        user.setPassword(newPassword);
                        System.out.println("Password sudah diubah");
                        break;
                    case 3:
                        System.out.println("Sunting User dibatalkan");
                        break;
                    default:
                        System.out.println("Anda salah input nomor!");
                        break;
                }
            }
        }
    }

    @Override
    public void showOwnedCourse(int idCoruse) {
        for (User user : users) {
            if (idCoruse == user.getUserId()) {
                System.out.println("== Course milik user: " + user.getUsername() + " ==");
                List<Course> userCourses = user.getOwnedCourse();
                if (userCourses.isEmpty()) {
                    System.out.println("Belum memiliki course.");
                    return;
                }

                for (Course course : userCourses) {
                    System.out.println("hi");
                    System.out.println("ID Course   : " + course.getCourseId());
                    System.out.println("Judul       : " + course.getTittleCourse());
                    System.out.println("Deskripsi   : " + course.getDescCourse());
                    System.out.println("Harga       : " + course.getPriceCourse());
                    System.out.println("---------------------------");
                }
                return;
            }
        }
        System.out.println("User dengan ID " + id + " tidak ditemukan.");
    }

    @Override
    public void removeUser(int idUser) {
        try {
            users.removeIf(user -> idUser == user.getUserId());
            System.out.println("User berhasil di hapus");
        } catch (NumberFormatException e) {
            System.out.println("Harap masukan Id User");
        }
    }

    @Override
    public void addCourseToUser(int idUser, Course course) {
        for(User user : users){
            if(user.getUserId() == idUser){
                user.setOwnedCourse(course);
            }
        }
    }


    public int idHandling() {
        return userIdHelper++;
    }
}
