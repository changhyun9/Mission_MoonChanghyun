package mission_1week;

import java.io.IOException;
import java.util.Scanner;
import mission_1week.domain.request.RequestObject;
import mission_1week.service.Service;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);
        Service service = null;
        try {
            service = new Service();
            service.fileBuild();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                System.out.print("명령) ");
                String input = sc.nextLine();
                RequestObject requestObject = new RequestObject(input);

                String command = requestObject.getCommand();
                int index = requestObject.getIndex();

                if (command.equals("등록")) {
                    service.insertWordsList();
                }
                if (command.equals("수정")) {
                    service.modifyWords(index);
                }
                if (command.equals("삭제")) {
                    service.deleteWords(index);
                }
                if (command.equals("목록")) {
                    service.printWordsList();
                }
                if (command.equals("종료")) {
                    service.fileStore();
                    break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
