package com.mickenet.data;

import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.ParseQuery;
import org.parse4j.callback.FindCallback;
import org.parse4j.callback.SaveCallback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class MainClass {

    private JPanel mPanel;
    private JComboBox projectCombo;
    private JButton btnExport;
    private JTextField fexportPath;
    private JButton bChangePath;
    private JPanel pPanel;
    private JButton bProject;
    private JLabel lProject;
    private JLabel lbPath;
    private JButton ChangePathButton;
    private ArrayList<String> projects;
    private Utils utils;
    JFileChooser chooser;
    List<List<String>> listOfLists = new ArrayList<List<String>>();

    public MainClass() {
        bProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null,
                        "Namnet på det nya projectet",
                        "Jokas WP Desktop",
                        JOptionPane.QUESTION_MESSAGE);

                setProject(name);
            }
        });
        utils = new Utils();
        btnExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Start export",
                        "Jokas WP Desktop",
                        JOptionPane.PLAIN_MESSAGE);
                createReport();
            }
        });
        bChangePath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Jokas Desktop");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                //
                // disable the "All files" option.
                //
                chooser.setAcceptAllFileFilterUsed(false);
                //
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): "
                            +  chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : "
                            +  chooser.getSelectedFile());
                    fexportPath.setText(chooser.getSelectedFile().toString());
                }
                else {
                    System.out.println("No Selection ");
                }
            }
        });
        bChangePath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    /***
     *
     * @param args
     */
    public static void main(String[] args) {
        Defaults def = new Defaults();
        def.initializeParse();
        JFrame frame = new JFrame("Jokas Desktop");
        frame.setContentPane(new MainClass().mPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /***
     *
     */
    private void createUIComponents() {
        String myDocumentPath = System.getProperty("user.home") + "/Documents";
        mPanel = new JPanel();
        btnExport = new JButton();
        projectCombo = new JComboBox();
        bChangePath = new JButton();
        lbPath = new JLabel();
        fexportPath = new JTextField(myDocumentPath, 20);

        mPanel.setSize(200, 200);
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
        btnExport.setEnabled(false);
    }

    /***
     *
     * @return
     */
    private ArrayList<String> getProject() {
        projects = new ArrayList<>();
        ParseQuery<Project> query = ParseQuery.getQuery(Project.class);
        query.findInBackground(new FindCallback<Project>() {
            @Override
            public void done(List<Project> results, ParseException e) {
                for (Project a : results) {
                    projects.add(a.getName());
                    listOfLists.add(new ArrayList<String>());
                }
                projectCombo.setModel(new DefaultComboBoxModel(projects.toArray()));
            }
        });
        return projects;
    }

    private void createReport() {
       final String fileName = fexportPath.getText() +"/" + projectCombo.getSelectedItem().toString() + ".dxf";
        final ArrayList<String> aReport = new ArrayList<>();
        ParseQuery<Waypoints> query = ParseQuery.getQuery(Waypoints.class);
        query.whereLessThanOrEqualTo("projid","");
        query.findInBackground(new FindCallback<Waypoints>() {
            @Override
            public void done(List<Waypoints> results, ParseException e) {
                for (Waypoints a : results) {
                    aReport.add(a.getLatitude() + "," + a.getLongitude());
                    System.out.println("Latitude "+ a.getLatitude());
                }
                utils.printFile(fileName, aReport);
            }
        });
    }

    private void setProject(String s) {
        final ParseObject mProjekt = new ParseObject("project");
        mProjekt.put("project_name", s);
        mProjekt.put("enabled", true);
        mProjekt.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException parseException) {
                System.out.println("saveInBackground(): objectId: " + mProjekt.getObjectId());
                //  System.out.println("saveInBackground(): objectId: " + mProjekt.get_name());
                System.out.println("saveInBackground(): createdAt: " + mProjekt.getCreatedAt());
                System.out.println("saveInBackground(): updatedAt: " + mProjekt.getUpdatedAt());
            }
        });

    }
}

