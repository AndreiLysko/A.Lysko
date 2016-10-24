package by.tc.nb.utils.check;

public class Validate {

    public static boolean question(int subjectID, String searchString) {

        if (searchString == null || searchString.equals("") || subjectID < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean loginParameters(String username, String password){
        if(username == null || username.equals("") || password == null || password.equals("")) {
            return false;
        }
        else{
            return true;
        }
    }

}
