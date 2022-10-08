import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Save {

    public Save() {

    }

    public static void start(String disk) {
        GameProgress save1 = new GameProgress(100, 1, 3, 1.1);
        GameProgress save2 = new GameProgress(86, 5, 10, 10.3);
        GameProgress save3 = new GameProgress(99, 3, 5, 4.3);

        String firstSave = disk + ":\\Games\\savegames\\save1.dat";
        String twoSave = disk + ":\\Games\\savegames\\save2.dat";
        String threeSave = disk + ":\\Games\\savegames\\save3.dat";

        saveGame(save1, save2, save3, firstSave, twoSave, threeSave);
        zipFiles(firstSave, twoSave, threeSave, disk);

        File delete = new File(firstSave);
        delete.delete();
        File delete2 = new File(twoSave);
        delete2.delete();
        File delete3 = new File(threeSave);
        delete3.delete();
        System.out.println("Лишнии файлы удалены");
    }

    private static void zipFiles(String firstSave, String twoSave, String threeSave, String disk) {
        try (ZipOutputStream zout1 = new ZipOutputStream(new FileOutputStream(disk + ":\\Games\\savegames\\zip1.zip"));
             ZipOutputStream zout2 = new ZipOutputStream(new FileOutputStream(disk + ":\\Games\\savegames\\zip2.zip"));
             ZipOutputStream zout3 = new ZipOutputStream(new FileOutputStream(disk + ":\\Games\\savegames\\zip3.zip"));
             FileInputStream fis1 = new FileInputStream(firstSave);
             FileInputStream fis2 = new FileInputStream(twoSave);
             FileInputStream fis3 = new FileInputStream(threeSave)) {
            ZipEntry entry1 = new ZipEntry("save1.dat");
            ZipEntry entry2 = new ZipEntry("save1.dat");
            ZipEntry entry3 = new ZipEntry("save1.dat");
            zout1.putNextEntry(entry1);
            zout2.putNextEntry(entry2);
            zout3.putNextEntry(entry3);
            byte[] buffer1 = new byte[fis1.available()];
            byte[] buffer2 = new byte[fis1.available()];
            byte[] buffer3 = new byte[fis1.available()];
            fis1.read(buffer1);
            fis2.read(buffer2);
            fis3.read(buffer3);
            zout1.write(buffer1);
            zout2.write(buffer2);
            zout3.write(buffer3);
            zout1.closeEntry();
            zout2.closeEntry();
            zout3.closeEntry();
            System.out.println("Сохранение добавлено в архив");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void saveGame(GameProgress save1, GameProgress save2, GameProgress save3, String firstSave, String twoSave, String threeSave) {
        try (FileOutputStream fos = new FileOutputStream(firstSave, true);
             FileOutputStream fos2 = new FileOutputStream(twoSave, true);
             FileOutputStream fos3 = new FileOutputStream(threeSave, true);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
             ObjectOutputStream oos3 = new ObjectOutputStream(fos3)) {
            oos.writeObject(save1);
            System.out.println("save1 Create");
            oos2.writeObject(save2);
            System.out.println("save2 Create");
            oos3.writeObject(save3);
            System.out.println("save3 Create");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}