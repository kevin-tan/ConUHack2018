package com.program.window;

import com.data.DataRepository;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.TransitDetails;
import com.model.Courses;
import com.program.window.menu.MenuBar;
import com.program.window.menu.MenuItems;
import com.program.window.thread.DateThread;
import com.program.window.thread.DirectionRequestThread;
import com.request.direction.DirectionRequest;
import com.startup.constants.WeekdayId;
import com.utils.DateTimeUtils;
import com.utils.JLabelFactory;
import com.utils.StringUtils;
import com.windows.template.Window;
import org.joda.time.format.DateTimeFormat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProgramWindow extends Window {

    private final JMenuBar jMenuBar;
    private final DirectionRequest directionRequest;
    private Thread directionRequestThread, dateThread;
    private Map<WeekdayId, List<Courses>> map;

    public ProgramWindow(String title, int width, int height) {
        super(title, width, height);
        jMenuBar = new JMenuBar();
        directionRequestThread = null;
        dateThread = null;
        map = DataRepository.getDataRepository();
        directionRequest = new DirectionRequest(DataRepository.getUser());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        configure();
    }

    @Override
    protected void configure(JPanel... jPanels) {
        //File menu items
        JMenuItem exit = new JMenuItem(MenuItems.EXIT.toString());
        exit.addActionListener(actionListener -> System.exit(0));
        //TODO add functionality
        JMenuItem editCourse = new JMenuItem(MenuItems.EDIT_COURSES.toString());
        jMenuBar.add(createJMenu(MenuBar.FILE, editCourse, exit));

        //Edit menu items
        //TODO add functionality
        JMenuItem editAddress = new JMenuItem(MenuItems.EDIT_ADDRESS.toString());
        jMenuBar.add(createJMenu(MenuBar.EDIT, editAddress));

        add(jMenuBar, BorderLayout.NORTH);

        //Adding Google's Api for Direction (Showing the closest time to current)
        JPanel panel = new JPanel(new GridLayout(4, 1)); //TODO change layout of panel

        if (!map.get(DateTimeUtils.getEnum(DateTimeUtils.dateTime().getDayOfWeek())).isEmpty()) {
            try {
                DirectionsLeg directionsLegDeparture = directionRequest.getDirectionLeg(map
                        .get(DateTimeUtils.getEnum(DateTimeUtils.dateTime().getDayOfWeek()))
                        .get(0).getStartTime())[0];
                TransitDetails transitDetails = directionsLegDeparture.steps[1].transitDetails;
                JLabel bus = JLabelFactory.createJLabel(StringUtils
                        .appendStrings(transitDetails.headsign, transitDetails.line.name));
                JLabel departureFromHome = JLabelFactory.createJLabel(directionsLegDeparture.departureTime.toString(DateTimeFormat.shortTime()));
                JLabel departure = JLabelFactory.createJLabel(transitDetails.departureTime.toString(DateTimeFormat.shortTime()));
                JLabel arrival = JLabelFactory.createJLabel(directionsLegDeparture.arrivalTime.toString(DateTimeFormat.shortTime()));
                directionRequestThread = new DirectionRequestThread(this, directionRequest, map,
                        bus, departureFromHome, departure, arrival);
                panel.add(bus);
                panel.add(departureFromHome);
                panel.add(departure);
                panel.add(arrival);
            } catch (InterruptedException | ApiException | IOException e) {
                e.printStackTrace();
            }
        }
        add(panel, BorderLayout.CENTER);


    }

    public void addData() {
        //Data
        JPanel date = new JPanel(new FlowLayout());
        JLabel currentDate = new JLabel(DateTimeUtils.dateTime().toString(DateTimeFormat.mediumDate()));
        dateThread = new DateThread(map, this, currentDate);
        date.add(currentDate);
        if (!map.get(DateTimeUtils.getEnum(DateTimeUtils.dateTime().getDayOfWeek())).isEmpty()) {
            JLabel departureTime = new JLabel(map.get(DateTimeUtils.getEnum(DateTimeUtils.dateTime().getDayOfWeek()))
                    .get(0).getStartTime().toString(DateTimeFormat.mediumTime()));
            date.add(departureTime);
        }
        add(date, BorderLayout.EAST);
    }

    private JMenu createJMenu(MenuBar menuBar, JMenuItem... jMenuItems) {
        JMenu menu = new JMenu(menuBar.toString());
        for (JMenuItem items : jMenuItems)
            menu.add(items);
        return menu;
    }

    public void startDirectionRequestThread() {
        directionRequestThread.start();
    }

    public void stopDirectionRequestThread() throws InterruptedException {
        directionRequestThread.join();
    }

    public void startDateThread() {
        dateThread.start();
    }

    public void stopDateThread() throws InterruptedException {
        dateThread.join();
    }
}
