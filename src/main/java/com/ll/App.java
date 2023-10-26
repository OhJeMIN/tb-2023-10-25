package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    void run() {
        System.out.println("== 명언 앱 ==");
        int lastQuotationId = 0;
        List<Quotation> quotations = new ArrayList<>();
        while (true) {
            System.out.print("명령) ");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                lastQuotationId++;

                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                int id = lastQuotationId;
                Quotation quotation = new Quotation(id, content,author);
                quotations.add(quotation);
                System.out.println(lastQuotationId+"번 명언이 등록되었습니다.");
            }
            else if (cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                for(int i=quotations.size()-1;i>=0;i--){
                    Quotation quotation = quotations.get(i);
                    System.out.println(quotation.id +"/"+ quotation.author+"/"+quotation.content);
                }
            }
        }
    }
}
