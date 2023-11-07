package mission_1week;

import java.util.Scanner;
import mission_1week.domain.request.RequestObject;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();
            RequestObject requestObject = new RequestObject(input);

            String command = requestObject.getCommand();
            int index = requestObject.getIndex();

            if(command.equals("등록")){
                // 등록 서비스 실행
            }
            if(command.equals("수정")){
                // 수정 서비스 실행
            }
            if(command.equals("삭제")){
                // 삭제 서비스 실행
            }
            if(command.equals("목록")){
                // 목록 서비스 실행
            }
            if(command.equals("종료")){
                //종료 서비스 실행
            }
        }
    }
}
