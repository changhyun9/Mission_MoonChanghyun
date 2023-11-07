package mission_1week;

import java.util.Scanner;
import mission_1week.domain.request.RequestObject;
import mission_1week.service.Service;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);
        Service service = new Service();

        while (true) {
            System.out.print("명령) ");
            String input = sc.nextLine();
            RequestObject requestObject = new RequestObject(input);

            String command = requestObject.getCommand();
            int index = requestObject.getIndex();

            if(command.equals("등록")){
                service.insertWordsList();
            }
            if(command.equals("수정")){
                // 수정 서비스 실행
            }
            if(command.equals("삭제")){
                // 삭제 서비스 실행
            }
            if(command.equals("목록")){
                service.printWordsList();
            }
            if(command.equals("종료")){
                //종료 서비스 실행
            }
        }
    }
}
