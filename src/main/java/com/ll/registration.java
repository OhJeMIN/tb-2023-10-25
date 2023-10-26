package com.ll;

import java.util.*;

public class registration {
    void register(int id){
        Scanner scanner = new Scanner(System.in);
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        System.out.println(id+"번 명언이 등록되었습니다.");
    }
}
