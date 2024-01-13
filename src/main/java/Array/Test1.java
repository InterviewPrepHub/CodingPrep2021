package Array;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Test1 {

    public static String basePath = "/Users/divya_paliwal/testFiles/US_Mac.zip";

    public static String destPath = "/Users/divya_paliwal/testFiles/US_Mac_New";

    public static void main(String[] args) {

        unzip(basePath, destPath);

    }

    private static List<String> getLocales(final List<String> allFiles) {
        return allFiles.stream()
                .filter(a -> !a.startsWith("resources"))
                //gets all folder name at 1st level
                .map(a -> (a.split(File.separator)[0]))
                .distinct()
                .collect(Collectors.toList());
    }

    private static void unzip(String basePath, String destPath) {

        File file = new File(basePath);
        String res = file.getParent();
        
        try {
            FileInputStream fis = new FileInputStream(basePath);
            ZipInputStream zis = new ZipInputStream(fis);

            ZipEntry ze = zis.getNextEntry();
            ZipFile zipFile = new ZipFile(basePath);
            Set<String> set = zipFile.stream().map(ZipEntry::getName).collect(Collectors.toSet());

            List<String> list = zipFile.stream().map(ZipEntry::getName).collect(Collectors.toList());

            List<String> l = getLocales(list);


            byte[] buffer = new byte[(int) ze.getSize()];
            if (!set.contains("en_US/mac/manifest.json")) {

                addingManifestJsonFile(destPath, zis, buffer);

                addingAllFilesInZipToNewFolder(destPath, fis, zis, ze, buffer);

                String[] path = destPath.split("/");
                String lastFolder = path[path.length - 1];

                zis.closeEntry();
                zis.close();
                fis.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addingAllFilesInZipToNewFolder(String destPath, FileInputStream fis, ZipInputStream zis, ZipEntry ze, byte[] buffer) throws IOException {
        while (ze !=null) {

            String fileName = ze.getName();
            File newFile = new File(destPath + File.separator + fileName);

            System.out.println("Unzipping to : "+newFile.getAbsolutePath());

            if (ze.isDirectory()) {
                newFile.mkdirs();
            } else {
                if (!newFile.exists()) {
                    System.out.println("creating file as it doesnt exists");
                    newFile.getParentFile().mkdirs();
                    newFile.createNewFile();

                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer,0,len);
                    }
                    fos.close();
                    zis.closeEntry();
                }
            }

            ze = zis.getNextEntry();

        }

    }

    private static void addingManifestJsonFile(String destPath, ZipInputStream zis, byte[] buffer) {
        try {
            File newFile = new File(destPath + File.separator + "en_US/mac/manifest.json");
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();

            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
