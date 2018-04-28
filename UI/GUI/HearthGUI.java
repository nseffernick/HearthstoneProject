package UI.GUI;

import Game.BoardState;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class HearthGUI extends Application implements Observer {

        private BoardState model;
        private Stage primaryStage;
        private TextArea appointmentsList;
        public String parameters;

        // Empty Constructor
        public HearthGUI() {}

        /**
         * Initial implementation before program is actually ran
         * @throws Exception
         */
        @Override
        public void init() throws Exception {
            System.out.println("Initializing UI...");
            parameters = getParameters().getUnnamed().toString();
            parameters = parameters.substring(1,parameters.length()-1);
            this.model = new BoardState(parameters);
            this.model.addObserver(this);
            }

        /**
         * Stops at a specified point
         * @throws Exception
         */
        @Override
        public void stop() throws Exception {
            super.stop();
        }

        /**
         * Primary method needed to launch the UI
         *
         * @param primaryStage
         * @throws Exception
         */
        @Override
        public void start(Stage primaryStage) throws Exception {
            Scene scene1 = new Scene(this.constructCalendar(5));
            primaryStage.setScene(scene1);
            primaryStage.setTitle("HearthProject");
            this.primaryStage = primaryStage;

            primaryStage.show();
        }

        /**
         * Updates UI when called.
         * Redraws based on information given, handles called etc..
         * @param o
         * @param arg
         */
        @Override
        public void update(Observable o, Object arg) {
            /*
            int i = 0;
            String textIter = "";
            while(i < model.appointmentsOn(model.currDate).size())  {
                textIter += model.appointmentsOn(model.currDate).get(i).toString()
                        + "\n";
                i += 1;
            }
            this.appointmentsList.setText(textIter);
            this.appointmentsList.setEditable(false);
            */
        }

        public static void main(String[] args) throws Exception {
            // If there is no file make a standard month
            HearthGUI.launch(args);
        }

        /**
         * Constructs the calendar and all its underlying Panes.
         * @param arg
         * @return
         */
        private BorderPane constructCalendar(int arg) {

            BorderPane calendarMain = new BorderPane();

            calendarMain.setLeft(setSideBar());
            calendarMain.setRight(this.appointmentsList(arg));
            //calendarMain.setCenter(setDates(model.numDays()));

            TextArea instructions = new TextArea("Click a date to see your " +
                    "appointments on that date.");
            instructions.setPrefHeight(10);
            instructions.setEditable(false);
            calendarMain.setBottom(instructions);

            return calendarMain;
        }

        /**
         * Constructs the Date portion
         * In a grid Pane
         * @param numDays
         * @return
         */
        private GridPane setDates(int numDays) {

            double numWeeks = Math.ceil(numDays / 7.0);
            final double numCol = 7;
            GridPane dates = new GridPane();


            double day = 1;
            while (day <= numDays) {
                for (int row = 0; row < numWeeks; row++) {
                    for (int col = 0; col < numCol; col++) {
                        if (day > numDays) {
                            break;
                        }
                        Button aDay = new Button(String.valueOf((int)day));
                        aDay.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                System.out.println(aDay.getId());
                                int id = Integer.parseInt(aDay.getId());
                                //////model.dateChanged(id);
                                model.notifyObservers(Integer.parseInt(aDay.getId()));
                            }
                        });
                        aDay.setMinWidth(35);
                        aDay.setMinHeight(35);
                        String newId = String.valueOf((int)day);
                        aDay.setId(newId);
                        dates.add(aDay, col, row);
                        day += 1;
                    }
                }
            }

            dates.setVgap(5);
            dates.setHgap(5);
            dates.setPrefWidth(300);
            dates.setPrefHeight(150);
            dates.setAlignment(Pos.BASELINE_CENTER);

            return dates;
        }

        /**
         * Sets the sidebar with several important buttons
         * @return
         */
        private VBox setSideBar() {

            Button save = new Button("Save?");

            Button add = new Button("Add");
            EventHandler<MouseEvent> clickEvent1;
            //add.setOnMouseClicked(clickEvent1);

            Button remove = new Button("Remove");
            EventHandler<MouseEvent> clickEvent2;
            //remove.setOnMouseClicked(clickEvent2);

            VBox sideBar = new VBox(save, add, remove);


            sideBar.setSpacing(25);
            sideBar.setPrefWidth(75);

            for(Node buttons: sideBar.getChildren()) {
                if (buttons instanceof Button) {
                    ((Button) buttons).setMinHeight(35);
                    ((Button) buttons).setMinWidth(75);
                }
            }

            return sideBar;
        }

        /**
         * The textArea that shows all appointments on the
         * selected day. Modified by observer/observable
         * @param day
         * @return
         */
        private TextArea appointmentsList(int day) {

            this.appointmentsList = new TextArea("");
            this.appointmentsList.setPrefWidth(250);

            /*
            if (day == 0) {
                this.appointmentsList.setEditable(false);
                return appointmentsList;
            }
            else {
                if (model.appointmentsOn(day).isEmpty()) {
                    this.appointmentsList.setText("You have no " +
                            "Appointments on " + day);
                    this.appointmentsList.setEditable(false);
                    return appointmentsList;
                }
                else {
                    int i = 0;
                    while(i < model.appointmentsOn(day).size())  {
                        this.appointmentsList.setText(
                                model.appointmentsOn(day).get(i).toString() + "\n");
                        this.appointmentsList.setEditable(false);
                        i += 1;
                    }
                    return appointmentsList;
                }
            }
            */
            return new TextArea();
        }
}
