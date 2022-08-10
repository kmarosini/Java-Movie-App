/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view;

import hr.algebra.MainWindow;
import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Actor;
import hr.algebra.model.ActorTransferable;
import hr.algebra.model.Director;
import hr.algebra.model.DirectorTransferable;
import hr.algebra.model.Movie;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.COPY;

/**
 *
 * @author Korsnik
 */
public class DragDropDirectors extends javax.swing.JPanel {

    private Repository repository;

     private final DefaultListModel<Director> destinationModel = new DefaultListModel<>();
    /**
     * Creates new form DragDropDirectors
     */
    public DragDropDirectors() throws Exception {
        initComponents();
        init();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lsDestination = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsSource = new javax.swing.JList<>();
        cbMovies = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnRemoveDirector = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 800));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(1050, 800));

        lsDestination.setPreferredSize(new java.awt.Dimension(258, 130));
        jScrollPane1.setViewportView(lsDestination);

        jScrollPane2.setMaximumSize(new java.awt.Dimension(1050, 800));

        lsSource.setPreferredSize(new java.awt.Dimension(258, 130));
        jScrollPane2.setViewportView(lsSource);

        cbMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMoviesActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Movie:");

        btnRemoveDirector.setBackground(new java.awt.Color(255, 51, 51));
        btnRemoveDirector.setText("Remove Director from Movie");
        btnRemoveDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDirectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnRemoveDirector))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(223, 223, 223)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(245, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(cbMovies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveDirector)
                    .addComponent(jLabel1)
                    .addComponent(cbMovies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMoviesActionPerformed
       loadDirectorsForMovie();
    }//GEN-LAST:event_cbMoviesActionPerformed

    private void btnRemoveDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDirectorActionPerformed
        Movie movie = (Movie) cbMovies.getSelectedItem();
        Director director = lsDestination.getSelectedValue();
        
        try {
            repository.DeleteDirectorFromMovie(movie.getId(), director.getId());
            loadDirectorsForMovie();
        
        } catch (Exception ex) {
            Logger.getLogger(DragDropActorsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemoveDirectorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemoveDirector;
    private javax.swing.JComboBox<Movie> cbMovies;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Director> lsDestination;
    private javax.swing.JList<Director> lsSource;
    // End of variables declaration//GEN-END:variables
private void init() throws Exception {
        initRepository();
        initLists();
        initDragNDrop();
        loadDirectorsForMovie();
    }

    private void initLists() throws Exception {
        
        LoadDirectors();
        LoadMovies();
    }

    private void initDragNDrop() {
        lsSource.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsSource.setDragEnabled(true);
        lsSource.setTransferHandler(new ExportTransferHandler());

        lsDestination.setDropMode(DropMode.ON);
        lsDestination.setTransferHandler(new ImportTransferHandler());
    }

    private void LoadDirectors() throws Exception {
        List<Director> directors = repository.selectDirectors();
        
        DefaultComboBoxModel<Movie> movieModel = new DefaultComboBoxModel<>();
        DefaultListModel<Director> sourceModel = new DefaultListModel<>();
        
        for (Director director : directors) {
            sourceModel.addElement(director);
        }
        
        lsSource.setModel(sourceModel);
        lsDestination.setModel(destinationModel);
    }

    private void LoadMovies() throws Exception {
        List<Movie> movies = repository.selectMovies();
        for (Movie movie : movies) {
            cbMovies.addItem(movie);
        }
    }

    private void loadDirectorsForMovie() {
        Movie movie = (Movie) cbMovies.getSelectedItem();
        
        List<Director> directors;
        try {
            DefaultListModel<Director> destinationModel = new DefaultListModel<>();
            directors = repository.GetDirectorForMovieById(movie.getId());
            directors.forEach((director) -> {
                destinationModel.addElement(director);
            });
            lsDestination.setModel(destinationModel);
        } catch (Exception ex) {
            Logger.getLogger(DragDropDirectors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class ExportTransferHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            // defines icon shown in target before drop
            return COPY;
            //return MOVE;
        }

        @Override
        public Transferable createTransferable(JComponent c) {
            return new DirectorTransferable(lsSource.getSelectedValue());
        }
    }

    private class ImportTransferHandler extends TransferHandler {

        // we define whether we can import stringFlavor that we need for JList<String>
        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(DirectorTransferable.DIRECTOR_FLAVOR);
        }

        // we import the data
        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            Transferable transferable = support.getTransferable();
            try {
                Director data = (Director) transferable.getTransferData(DirectorTransferable.DIRECTOR_FLAVOR);

                if (!destinationModel.contains(data)) {
                    destinationModel.addElement(data);
                    lsDestination.setModel(destinationModel);
                    repository.DirectorToMovie(((Movie)cbMovies.getSelectedItem()).getId(), data.getId());
                    // we remove the item from the source, in case of MOVE
                    //((DefaultListModel<String>)lsSource.getModel()).remove(lsSource.getSelectedIndex());
                    return true;
                }

            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(DragDropDirectors.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }
    
    private void initRepository() throws Exception {
    repository = RepositoryFactory.getRepository();
    }

}