package com.mickenet.data;

import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.ParseQuery;
import org.parse4j.callback.FindCallback;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class MainClass {

    private JPanel mPanel;
    private JLabel labelProject;
    private JComboBox projectCombo;
    private JButton btnExport;
    private JTextField pathExport;
    // --Commented out by Inspection (2017-11-20 21:28):private ArrayList projects;


    private MainClass() {

        btnExport.addComponentListener(new ComponentAdapter() {
// --Commented out by Inspection START (2017-11-20 21:28):
//            public void actionPerformed(ActionEvent e) {
//                //your actions
//                setProject(projectCombo.getSelectedItem().toString());
//            }
// --Commented out by Inspection STOP (2017-11-20 21:28)
        });
    }

// --Commented out by Inspection START (2017-11-20 21:29):
//    private void setProject(String s) {
//        //Hillolder
//    }
// --Commented out by Inspection STOP (2017-11-20 21:29)

    /***
     *
     */
    private void createUIComponents() {
    mPanel = new JPanel();
    mPanel.setSize(200,200);

        projectCombo = new JComboBox(getProject().toArray());
    pathExport = new JTextField( Paths.get(".").toAbsolutePath().normalize().toString(),20);
}
    /***
     *
     * @param args
     */
    public static void main(String[] args) {
        Defaults def = new Defaults();
        def.initializeParse();
        JFrame frame = new JFrame("MainClass");
        frame.setContentPane(new MainClass().mPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    /***
     *
     * @return
     */
    private ArrayList<String> getProject(){

        final ArrayList<String> list  = new ArrayList<>();

        ParseQuery<Project> query = ParseQuery.getQuery(Project.class);
        query.findInBackground(new FindCallback<Project>() {
            @Override
            public void done(List<Project> results, ParseException e) {
                for (Project a : results) {
                    list.add(a.getName());
                }
            }
        });
return   list;
    }
    
}

