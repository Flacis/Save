import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Install {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите диск на который будет сделана установка");
        String disk = scanner.nextLine();
        File Games = new File(disk + "://Games");
        File src = new File(disk + "://Games//src");
        File res = new File(disk + "://Games//res");
        File saveGames = new File(disk + "://Games//savegames");
        File temp = new File(disk + "://Games//temp");
        File main = new File(src, "main");
        File test = new File(src, "test");
        File Main = new File(main, "Main.java");
        File Utils = new File(main, "Utils.java");
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        File tempTxt = new File(temp, "temp.txt");
        StringBuilder log = new StringBuilder();

        extracted(disk, Games, src, res, saveGames, temp, main, test, Main, Utils, drawables, vectors, icons, tempTxt, log);
        Save.start(disk);
    }

    private static void extracted(String disk, File Games, File src, File res, File saveGames, File temp, File main, File test, File Main, File Utils, File drawables, File vectors, File icons, File tempTxt, StringBuilder log) {
        if (Games.mkdir()) {
            log.append("Добавлена папка ").append(Games.getName()).append("\n");
        }
        if (src.mkdir()) {
            log.append("Добавлена папка ").append(src.getName()).append("\n");
        }
        if (res.mkdir()) {
            log.append("Добавлена папка ").append(res.getName()).append("\n");
        }
        if (saveGames.mkdir()) {
            log.append("Добавлена папка ").append(saveGames.getName()).append("\n");
        }
        if (temp.mkdir()) {
            log.append("Добавлена папка ").append(temp.getName()).append("\n");
        }
        if (main.mkdir()) {
            log.append("Добавлена папка ").append(main.getName()).append("\n");
        }
        if (test.mkdir()) {
            log.append("Добавлена папка ").append(test.getName()).append("\n");
        }
        try {
            if (Main.createNewFile()) {
                log.append("Добавлен файл ").append(Main.getName()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (Utils.createNewFile()) {
                log.append("Добавлен файл ").append(Utils.getName()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (drawables.mkdir()) {
            log.append("Добавлена папка ").append(drawables.getName()).append("\n");
        }
        if (vectors.mkdir()) {
            log.append("Добавлена папка ").append(vectors.getName()).append("\n");
        }
        if (icons.mkdir()) {
            log.append("Добавлена папка ").append(icons.getName()).append("\n");
        }
        try {
            if (tempTxt.createNewFile()) {
                log.append("Добавлен файл ").append(tempTxt.getName()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(disk + "://Games//temp//temp.txt", true)) {
            writer.write(String.valueOf(log));
            System.out.println("Выполнено");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}