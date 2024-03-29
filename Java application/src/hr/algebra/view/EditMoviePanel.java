/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view;

import hr.algebra.MainWindow;
import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Movie;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import hr.algebra.vm.MovieTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Korsnik
 */
public class EditMoviePanel extends javax.swing.JPanel {

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private static final String DIR = "assets";

    private Repository repository;
    private MovieTableModel moviesTableModel;

    private Movie selectedMovie;
    /**
     * Creates new form NewJPanel
     */
    public EditMoviePanel() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfTitle = new javax.swing.JTextField();
        tfDirector = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lbIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMovies = new javax.swing.JTable();
        tfPicturePath = new javax.swing.JTextField();
        btnChoosePicture = new javax.swing.JButton();
        lbTitleError = new javax.swing.JLabel();
        lbGenreError = new javax.swing.JLabel();
        lbDescriptionError = new javax.swing.JLabel();
        lbDirectorError = new javax.swing.JLabel();
        tfGenre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfActor = new javax.swing.JTextField();
        lbActorError = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(1100, 900));
        setMinimumSize(new java.awt.Dimension(1100, 900));
        setPreferredSize(new java.awt.Dimension(1240, 776));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Title");

        jLabel2.setText("Genre");

        jLabel3.setText("Director");

        jLabel4.setText("Description");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        lbIcon.setPreferredSize(new java.awt.Dimension(480, 300));

        tbMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMoviesMouseClicked(evt);
            }
        });
        tbMovies.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbMoviesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbMovies);

        tfPicturePath.setEditable(false);
        tfPicturePath.setBackground(new java.awt.Color(204, 204, 204));
        tfPicturePath.setName(""); // NOI18N

        btnChoosePicture.setText("Choose image");
        btnChoosePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoosePictureActionPerformed(evt);
            }
        });

        lbTitleError.setForeground(java.awt.Color.red);

        lbGenreError.setForeground(java.awt.Color.red);

        lbDescriptionError.setForeground(java.awt.Color.red);

        lbDirectorError.setForeground(java.awt.Color.red);

        jLabel5.setText("Actor");

        lbActorError.setForeground(java.awt.Color.red);

        taDescription.setColumns(20);
        taDescription.setRows(5);
        jScrollPane2.setViewportView(taDescription);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfActor, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(276, 276, 276)
                        .addComponent(lbGenreError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDescriptionError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChoosePicture))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(451, 451, 451)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDirectorError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbActorError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(2340, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescriptionError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(lbDirectorError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGenreError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfActor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnChoosePicture)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbActorError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(755, 755, 755))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(724, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (formValid()) {
            String localPicturePath = null;
            try {
                localPicturePath = uploadPicture();
            } catch (IOException ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            Movie movie = new Movie(
                tfTitle.getText().trim(),
                tfDirector.getText().trim(),
                taDescription.getText().trim(),
                tfGenre.getText().trim(),
                tfActor.getText().trim(),
                    localPicturePath
            );
            try {
                repository.createMovie(movie);
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                moviesTableModel.setMovies(repository.selectMovies());
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            clearForm();

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedMovie == null) {
                    MessageUtils.showInformationMessage("Wrong operation", "Please choose article to update");
                    return;
                }
                if (formValid()) {
                    try {
                        if (!tfPicturePath.getText().trim().equals(selectedMovie.getPicturePath())) {
                            if (selectedMovie.getPicturePath() != null) {
                                Files.deleteIfExists(Paths.get(selectedMovie.getPicturePath()));
                            }
                            String localPicturePath = uploadPicture();
                            selectedMovie.setPicturePath(localPicturePath);
                        }

                        selectedMovie.setTitle(tfTitle.getText().trim());
                        selectedMovie.setActor(tfActor.getText().trim());
                        selectedMovie.setDescription(taDescription.getText().trim());
                        selectedMovie.setDirector(tfDirector.getText().trim());
                        selectedMovie.setGenre(tfGenre.getText().trim());
                        

                        repository.updateMovie(selectedMovie.getId(), selectedMovie);
                        moviesTableModel.setMovies(repository.selectMovies());

                        clearForm();
                    } catch (Exception ex) {
                        Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
                        MessageUtils.showErrorMessage("Error", "Unable to update article!");
                    }
                }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose article to delete");
            return;
        }
        if (MessageUtils.showConfirmDialog(
                "Delete article",
                "Do you really want to delete article?") == JOptionPane.YES_OPTION) {
            try {
                if (selectedMovie.getPicturePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedMovie.getPicturePath()));
                }
                repository.deleteMovie(selectedMovie.getId());
                moviesTableModel.setMovies(repository.selectMovies());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete article!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMoviesMouseClicked
        showMovie();
    }//GEN-LAST:event_tbMoviesMouseClicked

    private void tbMoviesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbMoviesKeyReleased

    }//GEN-LAST:event_tbMoviesKeyReleased

    private void btnChoosePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoosePictureActionPerformed
        Optional<File> file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (!file.isPresent()) {
            return;
        }
        tfPicturePath.setText(file.get().getAbsolutePath());
        setIcon(lbIcon, file.get());
    }//GEN-LAST:event_btnChoosePictureActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChoosePicture;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbActorError;
    private javax.swing.JLabel lbDescriptionError;
    private javax.swing.JLabel lbDirectorError;
    private javax.swing.JLabel lbGenreError;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitleError;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTable tbMovies;
    private javax.swing.JTextField tfActor;
    private javax.swing.JTextField tfDirector;
    private javax.swing.JTextField tfGenre;
    private javax.swing.JTextField tfPicturePath;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

     private boolean formValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");
        }

        return ok;
    }

    private void clearForm() {
        validationFields.forEach(e -> e.setText(""));
        errorLabels.forEach(e -> e.setText(""));

        selectedMovie = null;
    }
    
    private void initValidation() {
        validationFields = Arrays.asList(tfTitle, tfActor, taDescription, tfGenre, tfDirector);
        errorLabels = Arrays.asList(lbTitleError, lbActorError, lbDescriptionError, lbGenreError, lbDirectorError );
    }
    
    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }
    
    private void init() {
        try {
            initValidation();
            initRepository();
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(EditMoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }
    
     private void initTable() throws Exception {
        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovies.setAutoCreateRowSorter(true);
        tbMovies.setRowHeight(25);
        moviesTableModel = new MovieTableModel(repository.selectMovies());
        tbMovies.setModel(moviesTableModel);
    }

    private String uploadPicture() throws IOException {
        String picturePath = tfPicturePath.getText().trim();
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to set icon!");
        }
    }
    
    private void fillForm(Movie movie) {
        if (movie.getPicturePath() != null && Files.exists(Paths.get(movie.getPicturePath()))) {
            tfPicturePath.setText(movie.getPicturePath());
            setIcon(lbIcon, new File(movie.getPicturePath()));
        }
        tfTitle.setText(movie.getTitle());
        tfActor.setText(movie.getActor());
        taDescription.setText(movie.getDescription());
        tfDirector.setText(movie.getDirector());
        tfGenre.setText(movie.getGenre());
        tfPicturePath.setText(movie.getPicturePath());
        
    }
    
    public void showMovie() {
        clearForm();
        int selectedRow = tbMovies.getSelectedRow();
        int rowIndex = tbMovies.convertRowIndexToModel(selectedRow);
        int selectedMovieId = (int) moviesTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Movie> optMovie = repository.selectMovie(selectedMovieId);
            if (optMovie.isPresent()) {
                selectedMovie = optMovie.get();
                fillForm(selectedMovie);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to show article!");
        }
    }
    
    
    
    
}
