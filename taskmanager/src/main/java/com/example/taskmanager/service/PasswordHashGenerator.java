package com.example.taskmanager.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // ここにハッシュ化したいパスワードを入れる
        String rawPassword = "1234";

        // パスワードをハッシュ化
        String encodedPassword = encoder.encode(rawPassword);

        // ハッシュ値を出力
        System.out.println(encodedPassword);
    }
}
