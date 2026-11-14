import java.util.*;

interface AccessControl {
    String getRole();

    int getAccessLevel();

    boolean canAccess(int minLevel);
}

class Developer implements AccessControl {
    public String getRole() {
        return "Developer";
    }

    public int getAccessLevel() {
        return 1;
    }

    public boolean canAccess(int minLevel) {
        return getAccessLevel() >= minLevel;
    }
}

class Manager implements AccessControl {
    public String getRole() {
        return "Manager";
    }

    public int getAccessLevel() {
        return 2;
    }

    public boolean canAccess(int minLevel) {
        return getAccessLevel() >= minLevel;
    }
}

class Administrator implements AccessControl {
    public String getRole() {
        return "Administrator";
    }

    public int getAccessLevel() {
        return 3;
    }

    public boolean canAccess(int minLevel) {
        return getAccessLevel() >= minLevel;
    }
}

public class EmployeePermission {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int roleType = input.nextInt();
        int levelNeeded = input.nextInt();
        AccessControl user;
        if (roleType == 1) {
            user = new Developer();
        } else if (roleType == 2) {
            user = new Manager();
        } else {
            user = new Administrator();
        }
        System.out.println("Role: " + user.getRole());
        System.out.println("Access Level: " + user.getAccessLevel());
        System.out.println("Can Access: " + user.canAccess(levelNeeded));
        input.close();
    }
}
