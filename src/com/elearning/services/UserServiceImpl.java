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
        if (users.isEmpty()){
            System.out.println("=========================================================");
            System.out.println("               TIDAK ADA USER YANG TERDAFTAR             ");
            System.out.println("=========================================================");
            return;
        }
        for (User user : users) {
            System.out.println("=========================================================");
            System.out.println("                 INFORMASI PENGGUNA                      ");
            System.out.println("=========================================================");
            System.out.println("ID Pengguna  : " + user.getUserId());
            System.out.println("Username     : " + user.getUsername());
            System.out.println("Password     : " + user.getPassword());
            System.out.println("=========================================================");
        }
    }

    @Override
    public void editSelectedUser(String userName, String password) {
        if (users.isEmpty()) {
            System.out.println("User tidak terdaftar ada");
            return;
        } else {
            for (User user : users) {
                if (userName.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    System.out.println("=========================================================");
                    System.out.println("                 INFORMASI PENGGUNA                      ");
                    System.out.println("=========================================================");
                    System.out.println("ID Pengguna  : " + user.getUserId());
                    System.out.println("Username     : " + user.getUsername());
                    System.out.println("Password     : " + user.getPassword());
                    System.out.println("=========================================================");
                    System.out.println("[1] Username        [2] Password       [3] bukan akun ini");
                    System.out.println("=========================================================");
                    System.out.print("Apa yang ingin anda ubah :  ");
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

    }


    @Override
    public void showOwnedCourse(String username, String password) {
        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                System.out.println("=========================================================");
                System.out.println("                  COURSE MILIK " + user.getUsername() + "                  ");
                System.out.println("=========================================================");
                List<Course> userCourses = user.getOwnedCourse();
                if (userCourses.isEmpty()) {
                    System.out.println("Belum memiliki course.");
                    return;
                }
                for (Course course : userCourses) {
                    System.out.println("=========================================================");
                    System.out.println("ID Course   : " + course.getCourseId());
                    System.out.println("Judul       : " + course.getTittleCourse());
                    System.out.println("Deskripsi   : " + course.getDescCourse());
                    System.out.println("Harga       : " + course.getPriceCourse());
                    System.out.println("=========================================================");
                }
                return;
            }
        }
        System.out.println("=========================================================");
        System.out.println("                  VERIFIKASI GAGAL                       ");
        System.out.println("=========================================================");
    }

    @Override
    public void removeUser(int userId) {
        try {
            users.removeIf(user -> userId == user.getUserId());
            System.out.println("User berhasil di hapus");
        } catch (NumberFormatException e) {
            System.out.println("Harap masukan Id User");
        }
    }

    @Override

    public void addCourseToUser(String username, String password, Course course) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                user.setOwnedCourse(course);
            }
        }
    }

    public int idHandling() {
        return userIdHelper++;
    }

}
