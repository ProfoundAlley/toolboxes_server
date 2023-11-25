package cn.toolboxes.common;

public class StringCommon {
    public static boolean arrayEquals(String string, String... strings){
        boolean flag = false;
        for (String item : strings) {
            if (item.equalsIgnoreCase(string)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


}
