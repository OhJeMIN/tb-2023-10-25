package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    Scanner scanner;
    int lastQuotationId;
    List<Quotation> quotations;

    App() {
        scanner = new Scanner(System.in);
        lastQuotationId = 0;
        quotations = new ArrayList<>();
    }

    void run() {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("명령) ");

            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWirte();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")) {
                actionRemove(cmd);
            } else if (cmd.startsWith("수정")) {
                actionModify(cmd);
            }
        }
    }

    void actionWirte() {
        lastQuotationId++;

        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        int id = lastQuotationId;
        Quotation quotation = new Quotation(id, content, author);
        quotations.add(quotation);
        System.out.println(lastQuotationId + "번 명언이 등록되었습니다.");
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        if (quotations.isEmpty()) System.out.println("등록된 명언이 없습니다.");
        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);
            System.out.println(quotation.id + "/" + quotation.author + "/" + quotation.content);
        }
    }

    void actionRemove(String cmd){

        int id = getParamAsInt(cmd, "id", 0);
        if(id == 0){
            System.out.println("id를 입력해주세요");
            return; // 함수를 끝낸다.
        }
        System.out.println(id+"번 명언을 삭제합니다.");
    }

    void actionModify(String cmd){

        int id = getParamAsInt(cmd, "id", 0);
        if(id == 0){
            System.out.println("id를 입력해주세요");
            return; // 함수를 끝낸다.
        }
        System.out.println(id+"번 명언을 수정합니다.");
    }

    int getParamAsInt(String cmd, String paramName, int defaultValue){
        String[] arr = cmd.split("\\?",2);

        String[] order = arr[1].split("&");
        for(String param : order){
            String _paramName = param.split("=")[0];
            String paramValue = param.split("=")[1];
            if(_paramName.equals(paramName)){
                try{
                    return Integer.parseInt(paramValue);
                }
                catch (NumberFormatException e){
                    return defaultValue;
                }
            }
        }
        return defaultValue;
    }
}
