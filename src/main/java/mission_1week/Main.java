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
                service.modifyWords(index);
            }
            if(command.equals("삭제")){
                service.deleteWords(index);
            }
            if(command.equals("목록")){
                service.printWordsList();
            }
            if(command.equals("종료")){
                //종료 전 파일에 저장하는 로직 실행
                break;
            }
        }
    }
}
