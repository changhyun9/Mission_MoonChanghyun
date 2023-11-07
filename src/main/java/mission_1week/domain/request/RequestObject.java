package mission_1week.domain.request;

public class RequestObject {
    public static final int DEFAULT_INDEX = 0;

    private String command;
    private int index;

    public RequestObject(String input) {
        matchPattern(input);
        String[] split = input.split("\\?");
        if (split.length >= 2) {
            this.command = split[0];
            String[] subSplit = split[1].split("=");
            this.index = Integer.valueOf(subSplit[1]);
        }
        else if (split.length == 1) {
            this.command = input;
            this.index = DEFAULT_INDEX;
        }
    }

    private boolean matchPattern(String input) {
        if (input.matches("[ㄱ-ㅎ|가-힣]*\\?id=[0-9]*")) {
            return true;
        }
        if (input.matches("[ㄱ-ㅎ|가-힣]*")) {
            return true;
        }
        throw new IllegalArgumentException("입력형식이 잘못되었습니다.");
    }

    public String getCommand() {
        return command;
    }

    public int getIndex() {
        return index;
    }
}
