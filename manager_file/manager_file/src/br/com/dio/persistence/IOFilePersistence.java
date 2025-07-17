package br.com.dio.persistence;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class IOFilePersistence implements FielPersistence{

    private final String currentDir = System.getProperty("user.dir");

    private final String storeDir = "/manager_file/IO/";

    private final String fileName;

    public IOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storeDir);
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");

        clearFile();
    }

    @Override
    public String write(String data) {
        try (
                var fileWriter = new FileWriter(currentDir + storeDir + fileName, true);
                var bufferedWrite = new BufferedWriter(fileWriter);
                var printWriter = new PrintWriter(bufferedWrite);
        ) {
            printWriter.print(data + "\n");
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean removeContent(String sentence) {
        var contentList = getStrings();
        if (contentList.contains(sentence)) return false;
        clearFile();
        contentList.stream().filter(c -> !c.contains(sentence)).forEach(this::write);
        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var contentList = getStrings();
        if (contentList.contains(oldContent)) return "";
        clearFile();
        contentList.stream().map(c -> c.contains(oldContent) ? newContent : c).forEach(this::write);
        return newContent;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(currentDir + storeDir + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.substring(0, content.length() - 1);
    }

    @Override
    public String findBy(String sentence) {
        try (var reader = new BufferedReader(new FileReader(currentDir + storeDir + fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(sentence)) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void clearFile() {
        var filePath = currentDir + storeDir + fileName;
        try (OutputStream out = new FileOutputStream(filePath)) {
            System.out.printf("Inicializando recursos (%s)\n", filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<String> getStrings() {
        return Arrays.stream(findAll().split("\n")).toList();
    }
}
