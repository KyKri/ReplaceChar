import java.io.*;

public class ReplaceChar {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\user\\folder";
        
        checkDirectory(folderPath);
    }

    public static void checkDirectory(String folderPathToCheck) {
        File folder = new File(folderPathToCheck);

        File files[] = folder.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                if (files[i].getName().contains("\u2019")){
                    String newName = files[i].getName().replace("\u2019","");
                    File newFileName = new File(files[i].getParent() + "\\" + newName);
                    files[i].renameTo(newFileName);
                }                
            } else if (files[i].isDirectory()) {
                checkDirectory(files[i].getPath());
            }
        }
    }
}