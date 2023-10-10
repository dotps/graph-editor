package grapher.repository;

import java.io.*;
import java.util.List;

import grapher.interactor.data.SaveData;
import grapher.interactor.data.ShapeData;
import grapher.utils.debug;

public class FileSaveLoad implements ISaveLoad {
    public static final String SHAPE_SAVE_FILE = "D:\\save.txt";

    public boolean saveShapeData(ShapeData data) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(SHAPE_SAVE_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(data);
            objectOutputStream.close();
        }
        catch (IOException ioException) {
            debug.error(ioException.getMessage());
            return false;
        }

        return true;
    }

    public ShapeData loadShapeData() {

        try {
            FileInputStream fileInputStream = new FileInputStream(SHAPE_SAVE_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ShapeData data = (ShapeData) objectInputStream.readObject();
            objectInputStream.close();

            return data;
        }
        catch (IOException | ClassNotFoundException ioException) {
            debug.error(ioException.getMessage());
            return null;
        }
    }

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

            SaveData data = (SaveData) objectInputStream.readObject();
            objectInputStream.close();

            return data.shapes;
        }
        catch (IOException | ClassNotFoundException ioException) {
            debug.error(ioException.getMessage());
            return null;
        }
    }
}
