/**
Encircular

给你一串指令 command，G走一格，R右转，L左转。指令无限循环，判断机器人是否只在某个圈内不会走出去。

Sol: 走四次指令，走完每一次指令后判断坐标和方向，与起始时一样就可以。
*/

public String encircular(String command) {
    if (command == null || command.length() == 0) {
        return "No";
    }
    // Default east
    int direction = 1;
    int[] pos = new int[2];
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < command.length(); j++) {
            if (command.charAt(j) == 'G') {
                if (direction == 1) {
                    pos[0]++;
                } else if (direction == 2) {
                    pos[1]--;
                } else if (direction == 3) {
                    pos[0]--;
                } else {
                    pos[1]++;
                }
            }
            if (command.charAt(j) == 'R') {
                direction++;
                direction %= 4;
            }
            if (command.charAt(j) == 'L') {
                direction--;
                if (direction < 0) {
                    direction += 4;
                }
                direction %= 4;
            }
        }
        if (pos[0] == 0 && pos[1] == 0 && direction == 1) {
            return "Yes";
        }
    }
    return "No";
}