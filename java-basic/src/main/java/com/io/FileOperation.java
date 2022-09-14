package com.io;

import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @author weenhall
 */
public class FileOperation {

    //创建文件
    public static void createNewFile() throws IOException {
        //distinguish windows and linux
        String fileSeparator = System.getProperty("file.separator");
        //absolute file name with path
        String absoluteFilePath = "C:" + fileSeparator + "Users" + fileSeparator + "xxh-hp" + fileSeparator + "test.txt";
        File file = new File(absoluteFilePath);
        if (file.createNewFile()) {
            System.out.println(absoluteFilePath + "文件创建成功");
        } else {
            System.out.println(absoluteFilePath + "文件已存在");
        }

        //file name only
        file = new File("test.txt");
        if (file.createNewFile()) {
            System.out.println("test.txt File created in Project root directory");
        } else {
            System.out.println("File test.txt already exists in the project root directory");
        }

        //relative path
        String relativePath = "tmp" + fileSeparator + "test.txt";
        file = new File(relativePath);
        if (file.createNewFile()) {
            System.out.println(relativePath + "File created in Project root directory");
        } else {
            System.out.println("File" + relativePath + "already exists in the project root directory");
        }
        System.out.println(fileSeparator);
    }

    //删除文件
    public static void deleteFile() {
        File file = new File("c:/User/xxh-hp/test.txt");
        if (file.delete()) {
            System.out.println("c:/User/xxh-hp/test.txt" + " deleted");
        } else {
            System.out.println("c:/User/xxh-hp/test.txt" + "doesn't exist");
        }
        //file name only
        file = new File("test.txt");
        if (file.delete()) {
            System.out.println("test.txt File deleted from Project root directory");
        } else System.out.println("File test.txt doesn't exist in the project root directory");

        //relative path
        file = new File("temp/test.txt");
        if (file.delete()) {
            System.out.println("temp/file.txt File deleted from Project root directory");
        } else System.out.println("File temp/test.txt doesn't exist in the project root directory");

        //delete empty directory
        file = new File("temp");
        if (file.delete()) {
            System.out.println("temp directory deleted from Project root directory");
        } else System.out.println("temp directory doesn't exist or not empty in the project root directory");

    }

    //文件分割符
    private static void fileSeparators() {
        System.out.println("File.separator = " + File.separator);
        System.out.println("File.separatorChar = " + File.separatorChar);
        System.out.println("File.pathSeparator = " + File.pathSeparator);
        System.out.println("File.pathSeparatorChar = " + File.pathSeparatorChar);
    }

    //递归删除某个目录下的文件
    private static void deleteFolderRecursively(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteFolderRecursively(f);
            }
        }
        file.delete();
        System.out.println("deleted file/folder : " + file.getAbsolutePath());
    }

    //获取文件size
    private static void getFileSize() {
        //using File class
        String filename = "C:\\devtool\\Sencha\\Cmd\\version.properties";
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            return;
        }
        System.out.println((double) file.length() / (1024 * 1024) + "mb");
        System.out.println((double) file.length() / (1024) + "kb");
        System.out.println((double) file.length() + "bytes");

        //using FileChannel class
        Path filePath = Paths.get(filename);
        FileChannel fileChannel;
        try {
            fileChannel = FileChannel.open(filePath);
            long fileSize = fileChannel.size();
            System.out.println(fileSize + " bytes");
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //using Apache Commons IO FileUtils
        long fileSize = FileUtils.sizeOf(file);
        System.out.println(fileSize + " bytes");
    }

    //获取文件类型
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    //检查文件是否存在
    private static void checkFileExists() {
        File file = new File("test.txt");
        File notExist = new File("test1.txt");
        try {
            System.out.println(file.getCanonicalPath() + " exists ? " + file.exists());
            System.out.println(notExist.getCanonicalPath() + " exists ? " + notExist.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //复制文件
    private static void fileCopy(File source, File destination) throws IOException {
        //using Stream
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(destination);
            byte[] buffer = new byte[1024];
            int lenth;
            while ((lenth = is.read(buffer)) > 0) {
                os.write(buffer, 0, lenth);
            }
        } finally {
            is.close();
            os.close();
        }

        //using NIO FileChannel
        FileChannel sourceCh = null;
        FileChannel destCh = null;
        try {
            sourceCh = new FileInputStream(source).getChannel();
            destCh = new FileOutputStream(destination).getChannel();
            destCh.transferFrom(sourceCh, 0, sourceCh.size());
        } finally {
            sourceCh.close();
            destCh.close();
        }

        //using Apache Common IO FileUtils
        FileUtils.copyFile(source, destination);
        //using Files class
        Files.copy(source.toPath(), destination.toPath());
    }

    //读取文本文件
    private static void readTextFile() throws IOException {
        String fileName = "c:/tmp/test.txt";
        //using NIO Files
        Path path = Paths.get(fileName);
        byte[] bytes = Files.readAllBytes(path);
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

        //using FileReader
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

        //using java.io.BufferedReader
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(isr);
        String lines;
        while ((lines = bufferedReader.readLine()) != null) {
            System.out.println(lines);
        }
        bufferedReader.close();

        //using scanner
        Scanner scanner = new Scanner(path);
        System.out.println("====Read text file using Scanner====");
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            System.out.println(line1);
        }
        scanner.close();
    }

    //打开文件
    private static void openFile() throws IOException {
        File file = new File("c:/tmp/test.txt");
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }

    //向已有文件中添加数据
    private static void appendDataToFile() throws IOException {
        String appendData = "this is a append message using FileWriter";
        File file = new File("c:/tmp/test.txt");
        //using FileWriter
        FileWriter fr = new FileWriter(file, true);
        fr.write(appendData);

        //using BufferedWriter
        BufferedWriter bw = new BufferedWriter(fr);
        appendData = "this is a append message using BufferedWriter";
        bw.write(appendData);

        //using PrintWriter
        PrintWriter pr = new PrintWriter(bw);
        appendData = "this is a append message using PrintWriter";
        pr.write(appendData);
        pr.close();
        bw.close();
        fr.close();

        //using FileOutputStream
        OutputStream os = new FileOutputStream(file, true);
        appendData = "this is a append message using FileOutputStream";
        os.write(appendData.getBytes(), 0, appendData.length());
        os.close();

    }

    //下载文件
    private static void downloadFileFromURL() throws IOException {
        String urlStr = "https://www.journaldev.com/sitemap.xml";
        //using NIO
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(new File("test.xml"));
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();

        //using Stream
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(new File("test1.xml"));
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    public static void main(String[] args) throws IOException {
//        createNewFile();
        //create file with data fill using FileOutputStream.write
        String fileData = "helloworld";
        FileOutputStream fos = new FileOutputStream("test.txt");
        fos.write(fileData.getBytes());
        fos.flush();
        fos.close();
        //create file with data fill using NIO
        Files.write(Paths.get("test.text"), fileData.getBytes());

//        fileSeparators();
        String folder = "c:/tmp";
//        deleteFolderRecursively(new File(folder));
//        getFileSize();
//        System.out.println(getFileExtension(new File("test.txt")));
//        checkFileExists();
//        File source=new File("c:/tmp/test.txt");
//        File destination=new File("c:/tmp/test1.txt");
//        fileCopy(source,destination);
//        readTextFile();
//        openFile();
//        appendDataToFile();
        downloadFileFromURL();
    }

}
