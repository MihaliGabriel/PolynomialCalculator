package app;

import controller.HomeworkController;
import model.HomeworkModel;
import View.*;

public class main {
    public static void main(String[] args) {
        HomeworkModel model = new HomeworkModel();
        HomeworkView view = new HomeworkView();
        HomeworkController controller = new HomeworkController(model, view);
    }
}
