package com.mickenet.data;

import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.parse4j.callback.FindCallback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    private JPanel mPanel;
    private JLabel labelProject;
    private JComboBox projectCombo;
    private JButton btnExport;
    private JTextField pathExport;
    private ArrayList projects;


    public MainClass() {

        btnExport.addComponentListener(new ComponentAdapter() {
            public void actionPerformed(ActionEvent e) {
                //your actions
                setProject(projectCombo.getSelectedItem().toString());
            }
        });
    }
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    /***
     *
     * @return
     */
    private ArrayList<String> getProject(){
        final ArrayList<String> list  = new ArrayList<String>();

        ParseQuery<Projects> query = ParseQuery.getQuery(Projects.class);
        //query.whereLessThanOrEqualTo("rupees", ParseUser.getCurrentUser().get("rupees"));
        query.findInBackground(new FindCallback<Projects>() {
            @Override
            public void done(List<Projects> results, ParseException e) {
                for (Projects a : results) {
                    list.add(a.getName());
                }
            }
        });
return   list;
    }
    private void setProject(String mProj)
    {

    }
}

