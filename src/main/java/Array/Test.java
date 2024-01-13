package Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Test {

    public static String filePath = "/Users/divya_paliwal/testFiles/US_Mac.zip";

    public static String basePath = "/Users/divya_paliwal/testFiles/US_Mac_New";

    public static String destPath = "/Users/divya_paliwal/testFiles/US_Mac_New.Zip";

    static List<String> filesListInDir = new ArrayList<>();

    public static void main(String[] args) {

        unzip(filePath, "/Users/divya_paliwal/testFiles/US_Mac_New");

        zipDirectory(new File(basePath), destPath);

        try {
            ZipFile zipFile = new ZipFile(destPath);
            List<String> allFiles = zipFile.stream().map(ZipEntry::getName).collect(Collectors.toList());

            System.out.println("list all files" + allFiles.size());
            System.out.println(allFiles);
        } catch (IOException e) {
            System.out.println("Failed to get zip files " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void unzip(final String zipFilePath, final String destDirectory) {
        File destDir = new File(destDirectory);

        // already exists
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipInputStream.getNextEntry();

            while (entry != null) {

                // from properties
                if (!entry.getName().startsWith("_") && !entry.getName().startsWith(".")) {

                    String filePath = destDirectory + "/" + entry.getName();
                    if (!entry.isDirectory()) {
                        // Create file
                        extractFile(zipInputStream, filePath);
                    } else {
                        // Create directory
                        (new File(filePath)).mkdir();
                    }

                }
                zipInputStream.closeEntry();
                entry = zipInputStream.getNextEntry();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void extractFile(final ZipInputStream zipInputStream, final String filePath) {

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read = 0;
            while ((read = zipInputStream.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipDirectory(File dir, String zipDirName) {
        try {
            populateFilesList(dir);
            System.out.println(filesListInDir);

            //now zip files one by one
            //create ZipOutputStream to write to the zip file
            FileOutputStream fos = new FileOutputStream(zipDirName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for(String filePath : filesListInDir){
                System.out.println("Zipping "+filePath);
                //for ZipEntry we need to keep only relative file path, so we used substring on absolute path
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);
                //read the file and write to ZipOutputStream
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method populates all the files in a directory to a List
     * @param dir
     * @throws IOException
     */
    private static void populateFilesList(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) {
                filesListInDir.add(file.getAbsolutePath());
            }
            else populateFilesList(file);
        }
    }

}














