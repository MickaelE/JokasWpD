package com.mickenet.data;

import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.parse4j.callback.FindCallback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class MainClass {

    private JPanel mPanel;
    private JLabel labelProject;
    private JComboBox projectCombo;
    private JButton btnExport;
    private JTextField pathExport;
    private JButton ChangePathButton;
    private ArrayList<String> projects;

    /*private MainClass() {

       btnExport.addComponentListener(new ComponentAdapter() {

            public void actionPerformed(ActionEvent e) {
               //your actions
                setProject(projectCombo.getSelectedItem().toString());
            }

        });
    }*/
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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void setProject(String s) {
        //Hillolder
    }
    /***
     *
     */
    private void createUIComponents() {
    mPanel = new JPanel();
     btnExport = new JButton();
    projectCombo = new JComboBox();
     ChangePathButton = new JButton();

    mPanel.setSize(200,200);
        getProject();

        projectCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //
                // Get the source of the component, which is our combo
                // box.
                //
                JComboBox comboBox = (JComboBox) event.getSource();

                Object selected = comboBox.getSelectedItem();
                setProject(selected.toString());

            }
        });

ComponentBorder cb = new ComponentBorder(ChangePathButton);
        cb.install(pathExport);
       btnExport.setEnabled(false);
    pathExport = new JTextField( Paths.get(".").toAbsolutePath().normalize().toString(),20);
}

    /***
     *
     * @return
     */
    private ArrayList<String> getProject(){
        projects = new ArrayList<>();
        ParseQuery<Project> query = ParseQuery.getQuery(Project.class);
        query.findInBackground(new FindCallback<Project>() {
            @Override
            public void done(List<Project> results, ParseException e) {
                for (Project a : results) {
                    projects.add(a.getName());
                }
                projectCombo.setModel(new DefaultComboBoxModel(projects.toArray()));
            }
        });
        return projects;
    }
}

