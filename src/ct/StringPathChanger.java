package ct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringPathChanger {

    public static void main(String[] args) {
        StringPathChanger sol = new StringPathChanger();
        String res = sol.changeDirectoryString("/test/task/java", "cd /test/task");
        System.out.println(res);
    }

    public String changeDirectoryString(String currentDirectory, String command) {
        String res = "";
        String[] commands = command.split(" ");
        if (commands.length < 2 || !commands[0].equals("cd")) {
            throw new IllegalStateException("커맨드 명령어가 잘못됨");
        }

        if (commands[1].equals("/")) {
            return "/";
        }

        List<String> currentDirList = Arrays.stream(currentDirectory.split("/")).collect(Collectors.toList());
        String[] changeDirStrings = commands[1].split("/");

        for (int i = 0; i < changeDirStrings.length; i++) {
            String cmd = changeDirStrings[i];

            if (cmd.equals("..")) {
                if (currentDirList.size() > 1) {
                    currentDirList.remove(currentDirList.size() - 1);
                }
            } else if (cmd.equals("") && i == 0) {
                while (currentDirList.size() > 1) {
                    currentDirList.remove(currentDirList.size() - 1);
                }
            } else {
                currentDirList.add(cmd);
            }
        }

        System.out.println(currentDirList);
        for (String str : currentDirList) {
            res += str + "/";
        }

        if (!res.equals("/")) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }
}