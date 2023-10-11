package grapher.repository;

import java.io.*;
import java.util.List;

import grapher.interactor.data.SaveData;
import grapher.interactor.data.ShapeData;
import grapher.utils.debug;

public class FileSaveLoad implements ISaveLoad {
    public static final String SHAPE_SAVE_FILE = "D:\\save.txt";

    @Override
    public boolean save(List<ShapeData> shapesData) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(SHAPE_SAVE_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(shapesData);
            objectOutputStream.close();
        }
        catch (IOException ioException) {
            debug.error(ioException.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<ShapeData> load() {

        try {
            FileInputStream fileInputStream = new FileInputStream(SHAPE_SAVE_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            List<ShapeData> data = (List<ShapeData>) objectInputStream.readObject();
            objectInputStream.close();

            return data;
        }
        catch (IOException | ClassNotFoundException ioException) {
            debug.error(ioException.getMessage());
            return null;
        }
    }
}
