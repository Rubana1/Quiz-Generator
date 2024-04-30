package Services;

import java.util.HashMap;

public class LoginService {
    private static HashMap<String, String> users = new HashMap<>();

    public static boolean createUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; 
        }
        users.put(username, password);
        return true;
    }

    public static boolean authenticateUser(String username, String password) {
        if (!users.containsKey(username)) {
            return false; 
        }
        String storedPassword = users.get(username);
        return storedPassword.equals(password);
    }

    public static String isValidLogin(String name, String password) {
        if (authenticateUser(name, password)) {
            return "Login success";
        } else {
            return "Invalid username or password";
        }
    }
}
