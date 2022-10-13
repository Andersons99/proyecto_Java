/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import Class.*;
import Contoller.AeropuertoController;
import Contoller.AvionController;
import Model.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Anderson Sachez
 */
public final class Index extends javax.swing.JFrame {
    
 AeropuertoModel aeropuertoModel = new  AeropuertoModel();
 AvionModel avionModel = new  AvionModel();
 RutaModel rutaModel = new RutaModel();
 
 ArrayList<Aeropuerto> listaAeropuero = aeropuertoModel.Read();
 ArrayList<Avion> listaAviones = avionModel.Read();
 ArrayList<Ruta> listaRuta =  rutaModel.Read();

  public Index() {
        initComponents();
        cargarListaAeropuerto();
        cargarListaAvion();
        cargarListaRutas();
        cargarGraficoAeropuertoPie();
        cargarGraficoAvionPie();
   
    }  
  
  public void cargarGraficoAeropuertoPie() {
        ArrayList<Aeropuerto> lista_aeropuerto_p = aeropuertoModel.GetByPais();       
        DefaultPieDataset dataset = new DefaultPieDataset();
      
        for (Aeropuerto index : lista_aeropuerto_p) {
            dataset.setValue(index.getPais(), index.getCantidad());
        }
        JFreeChart chart = ChartFactory.createPieChart("Grafico de Aeropuertos por Ciudad", dataset, true, true, true);       
        ChartPanel panel = new ChartPanel(chart);
        panelPaises.setLayout(new java.awt.BorderLayout());
        panelPaises.add(panel);
        panelPaises.validate();
    }
  
  public void cargarGraficoAvionPie() {
        ArrayList<Avion> lista_Avion =  avionModel.GetByModelo();       
        DefaultPieDataset dataset = new DefaultPieDataset();
      
        for (Avion index : lista_Avion) {
            dataset.setValue(index.getModelo(), index.getCantidad());
        }
        JFreeChart chart = ChartFactory.createPieChart("Grafico aviones por Modelos", dataset, true, true, true);       
        ChartPanel panel = new ChartPanel(chart);
        graficoModelo.setLayout(new java.awt.BorderLayout());
        graficoModelo.add(panel);
        graficoModelo.validate();
    }
   
    public void cargarComboOrien(){
        comboOrigen.removeAllItems();
        comboOrigen.addItem("");
        ComboDestino.removeAllItems();
        ComboDestino.addItem("");
        for(Aeropuerto aeropuerto : listaAeropuero){
            comboOrigen.addItem(aeropuerto.getId() + "-" + aeropuerto.getNombre());
            ComboDestino.addItem(aeropuerto.getId() + "-" + aeropuerto.getNombre());
        }
        comboOrigen.setSelectedIndex(0);
        ComboDestino.setSelectedIndex(0);
        
    }
    public void cargarListaAeropuerto() {
        DefaultTableModel tab = new DefaultTableModel();
        String[] cabecera = {"Id", "Nombre","Ciudad","Pais" , "CoordX", "CoordY"};
        Object[] datos = new Object[cabecera.length];
        tab.setColumnIdentifiers(cabecera);
        for (int i = 0; i < listaAeropuero.size(); i++) {
            datos[0] = listaAeropuero.get(i).getId();
            datos[1] = listaAeropuero.get(i).getNombre();
            datos[2] = listaAeropuero.get(i).getCiudad();
            datos[3] = listaAeropuero.get(i).getPais();
            datos[4] = listaAeropuero.get(i).getCoord_x();
            datos[5] = listaAeropuero.get(i).getCoord_y();
            
            tab.addRow(datos);
        }
        tableAeropuerto.setModel(tab);
        cargarComboOrien();
    }
    
    public void limpiarListaAeropuerto(){
        txtidAeropuerto.setValue(0);
        txtNombreAeroperto.setText("");
        txtCiudadAeropuerto.setText("");
        txtPaisAeropuerto.setText("");
        txtCordenadaX.setValue(0);
        txtCodenadaY.setValue(0);
    }

     public void cargarListaAvion() {
        DefaultTableModel tab = new DefaultTableModel();
        String[] cabecera = {"Id", "Modelo","Numero Asientos","Numero de baños" ,"Capacidad maxima peso"};
        Object[] datos = new Object[cabecera.length];
        tab.setColumnIdentifiers(cabecera);
        for (int i = 0; i < listaAviones.size(); i++) {
            datos[0] = listaAviones.get(i).getId();
            datos[1] = listaAviones.get(i).getModelo();
            datos[2] = listaAviones.get(i).getNumero_asientos();
            datos[3] = listaAviones.get(i).getNumero_banos();
            datos[4] = listaAviones.get(i).getCapasiad_max_peso();
            
            tab.addRow(datos);
        }
        listAviones.setModel(tab);
    }
public void limpiarListaAvion(){
    
    txtIdAvion.setValue(0);
    txtModeloAvion.setText("");
    txtNoAsientos.setValue(0);
    txtNoBanos.setValue(0);
    txtCapMax.setValue(0);
  
    }
     
 public void cargarListaRutas() {
        DefaultTableModel tab = new DefaultTableModel();
        String[] cabecera = {"Id","Origen","Destino", "Tiempo Estimado"};
        Object[] datos = new Object[cabecera.length];
        tab.setColumnIdentifiers(cabecera);
        for (int i = 0; i < listaRuta.size(); i++) {
            datos[0] = listaRuta.get(i).getIdruta();
            datos[1] = listaRuta.get(i).getNombre_origen();
            datos[2] = listaRuta.get(i).getNombre_destino();
            datos[3] = listaRuta.get(i).getTiempo_estimado();
            tab.addRow(datos);
        }
        listRutas.setModel(tab);
    }
 
 


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNombreAeroperto1 = new javax.swing.JTextField();
        txtPaisAeropuerto1 = new javax.swing.JTextField();
        txtCiudadAeropuerto1 = new javax.swing.JTextField();
        txtCordenadaX1 = new javax.swing.JSpinner();
        txtidAeropuerto1 = new javax.swing.JSpinner();
        txtCodenadaY1 = new javax.swing.JSpinner();
        btnGuardarAeropuerto1 = new javax.swing.JButton();
        btnBuscarAeropueto1 = new javax.swing.JButton();
        btnEditarAeropuerto1 = new javax.swing.JButton();
        btnElimiarAeropueto1 = new javax.swing.JButton();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableRutas = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTimEstiimadoRuta = new javax.swing.JSpinner();
        txtTiempEsimado = new javax.swing.JTextField();
        btnBuscarRuta = new javax.swing.JButton();
        graficoAvion = new javax.swing.JPanel();
        GraficoRutas = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAeropuerto = new javax.swing.JTable();
        exporta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtIdAvion = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtModeloAvion = new javax.swing.JTextPane();
        jLabel18 = new javax.swing.JLabel();
        txtNoAsientos = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        txtNoBanos = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        txtCapMax = new javax.swing.JSpinner();
        btnGuardarAvion = new javax.swing.JButton();
        btnBusarAvion = new javax.swing.JButton();
        btnEditarAvion = new javax.swing.JButton();
        btnEliminarAvion = new javax.swing.JButton();
        taleAviones = new javax.swing.JScrollPane();
        listAviones = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listRutas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreAeroperto = new javax.swing.JTextField();
        txtPaisAeropuerto = new javax.swing.JTextField();
        txtCiudadAeropuerto = new javax.swing.JTextField();
        txtCordenadaX = new javax.swing.JSpinner();
        txtidAeropuerto = new javax.swing.JSpinner();
        txtCodenadaY = new javax.swing.JSpinner();
        btnGuardarAeropuerto = new javax.swing.JButton();
        btnBuscarAeropueto = new javax.swing.JButton();
        btnEditarAeropuerto = new javax.swing.JButton();
        btnElimiarAeropueto = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtIdRuta = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        btnEdiarRuta = new javax.swing.JButton();
        btnGuardarRuta = new javax.swing.JButton();
        btnElimiarRuta = new javax.swing.JButton();
        comboOrigen = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        ComboDestino = new javax.swing.JComboBox<>();
        BtnGuardarRuta = new javax.swing.JButton();
        txtTiempoRuta = new javax.swing.JSpinner();
        panelPaises = new javax.swing.JPanel();
        graficoModelo = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        exportarAvion = new javax.swing.JButton();

        jLabel9.setText("ID:");

        jLabel10.setText("NOMBRE:");

        jLabel11.setText("PAIS:");

        jLabel12.setText("CIUDAD:");

        jLabel13.setText("CORDENADA Y");

        jLabel15.setText("CORDENADA X");

        txtNombreAeroperto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAeroperto1ActionPerformed(evt);
            }
        });

        txtPaisAeropuerto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaisAeropuerto1ActionPerformed(evt);
            }
        });

        txtCiudadAeropuerto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadAeropuerto1ActionPerformed(evt);
            }
        });

        btnGuardarAeropuerto1.setText("Guardar");

        btnBuscarAeropueto1.setText("Buscar");

        btnEditarAeropuerto1.setText("Editar");

        btnElimiarAeropueto1.setText("Eliminar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCiudadAeropuerto1)
                            .addComponent(txtCodenadaY1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txtCordenadaX1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombreAeroperto1)
                                .addComponent(txtidAeropuerto1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                            .addComponent(txtPaisAeropuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarAeropueto1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarAeropuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarAeropuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElimiarAeropueto1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtidAeropuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNombreAeroperto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarAeropuerto1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtPaisAeropuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCiudadAeropuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCodenadaY1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtCordenadaX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarAeropueto1)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarAeropuerto1)
                        .addGap(18, 18, 18)
                        .addComponent(btnElimiarAeropueto1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Aeropuerto", jPanel2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        tableRutas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tableRutas);

        jTabbedPane2.addTab("tab1", jScrollPane5);

        jLabel21.setText("jLabel21");
        jTabbedPane5.addTab("tab1", jLabel21);

        jButton1.setText("Eliminar");

        txtTiempEsimado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempEsimadoActionPerformed(evt);
            }
        });

        btnBuscarRuta.setText("Guardar");
        btnBuscarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout graficoAvionLayout = new javax.swing.GroupLayout(graficoAvion);
        graficoAvion.setLayout(graficoAvionLayout);
        graficoAvionLayout.setHorizontalGroup(
            graficoAvionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );
        graficoAvionLayout.setVerticalGroup(
            graficoAvionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableAeropuerto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tableAeropuerto);

        exporta.setText("Exportar");
        exporta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(exporta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exporta)
                .addGap(43, 43, 43))
        );

        GraficoRutas.addTab("ListarAeropuerto", jPanel4);

        jLabel16.setText("ID:");

        jLabel17.setText("MODELO:");

        jScrollPane3.setViewportView(txtModeloAvion);

        jLabel18.setText("NUMERO DE ASIENTO");

        jLabel19.setText("NUMERO DE BAÑOS");

        jLabel20.setText("CAPACIDAD MAX PESO");

        btnGuardarAvion.setText("Guardar");
        btnGuardarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAvionActionPerformed(evt);
            }
        });

        btnBusarAvion.setText("Buscar");
        btnBusarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusarAvionActionPerformed(evt);
            }
        });

        btnEditarAvion.setText("Editar");
        btnEditarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAvionActionPerformed(evt);
            }
        });

        btnEliminarAvion.setText("Eliminar");
        btnEliminarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAvionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNoBanos, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtNoAsientos, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdAvion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCapMax)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGuardarAvion)
                        .addGap(18, 18, 18)
                        .addComponent(btnBusarAvion)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarAvion)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarAvion)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtIdAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNoAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtNoBanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtCapMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarAvion)
                    .addComponent(btnBusarAvion)
                    .addComponent(btnEditarAvion)
                    .addComponent(btnEliminarAvion))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        GraficoRutas.addTab("Avion", jPanel3);

        listAviones.setModel(new javax.swing.table.DefaultTableModel(
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
        taleAviones.setViewportView(listAviones);

        GraficoRutas.addTab("ListarAviones", taleAviones);

        listRutas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(listRutas);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        GraficoRutas.addTab("ListarRuta", jPanel6);

        jLabel1.setText("ID:");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("PAIS:");

        jLabel4.setText("CIUDAD:");

        jLabel5.setText("CORDENADA Y");

        jLabel7.setText("CORDENADA X");

        txtNombreAeroperto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAeropertoActionPerformed(evt);
            }
        });

        txtPaisAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaisAeropuertoActionPerformed(evt);
            }
        });

        txtCiudadAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadAeropuertoActionPerformed(evt);
            }
        });

        btnGuardarAeropuerto.setText("Buscar");
        btnGuardarAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAeropuertoActionPerformed(evt);
            }
        });

        btnBuscarAeropueto.setText("Guardar");
        btnBuscarAeropueto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAeropuetoActionPerformed(evt);
            }
        });

        btnEditarAeropuerto.setText("Editar");
        btnEditarAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAeropuertoActionPerformed(evt);
            }
        });

        btnElimiarAeropueto.setText("Eliminar");
        btnElimiarAeropueto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimiarAeropuetoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1)
                                .addGap(74, 74, 74)
                                .addComponent(txtidAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(txtCordenadaX, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(btnElimiarAeropueto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPaisAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarAeropueto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodenadaY, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditarAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombreAeroperto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCiudadAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardarAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreAeroperto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPaisAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarAeropueto)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCiudadAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardarAeropuerto)
                        .addGap(29, 29, 29)))
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodenadaY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditarAeropuerto)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCordenadaX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnElimiarAeropueto))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        GraficoRutas.addTab("Aeropuerto", jPanel1);

        jLabel22.setText("ID:");

        jLabel23.setText("TIEMPO ESTIMADO:");

        btnEdiarRuta.setText("Editar");
        btnEdiarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdiarRutaActionPerformed(evt);
            }
        });

        btnGuardarRuta.setText("Buscar");
        btnGuardarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRutaActionPerformed(evt);
            }
        });

        btnElimiarRuta.setText("Eliminar");
        btnElimiarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimiarRutaActionPerformed(evt);
            }
        });

        comboOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrigenActionPerformed(evt);
            }
        });

        jLabel24.setText("ORIGEN:");

        jLabel25.setText("DESTINO:");

        ComboDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboDestinoActionPerformed(evt);
            }
        });

        BtnGuardarRuta.setText("Guardar");
        BtnGuardarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25)
                                .addComponent(jLabel24)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(txtIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboOrigen, 0, 96, Short.MAX_VALUE)
                                    .addComponent(ComboDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTiempoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnGuardarRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdiarRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnElimiarRuta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarRuta, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(ComboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnGuardarRuta))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtTiempoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnGuardarRuta)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnElimiarRuta)
                    .addComponent(btnEdiarRuta))
                .addGap(18, 85, Short.MAX_VALUE))
        );

        GraficoRutas.addTab("Ruta", jPanel7);

        javax.swing.GroupLayout panelPaisesLayout = new javax.swing.GroupLayout(panelPaises);
        panelPaises.setLayout(panelPaisesLayout);
        panelPaisesLayout.setHorizontalGroup(
            panelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );
        panelPaisesLayout.setVerticalGroup(
            panelPaisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        GraficoRutas.addTab("GraficoPaises", panelPaises);

        javax.swing.GroupLayout graficoModeloLayout = new javax.swing.GroupLayout(graficoModelo);
        graficoModelo.setLayout(graficoModeloLayout);
        graficoModeloLayout.setHorizontalGroup(
            graficoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );
        graficoModeloLayout.setVerticalGroup(
            graficoModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        GraficoRutas.addTab("GraficoModelos", graficoModelo);

        jLabel8.setText("Sisteme gestion de Aerolineas");

        exportarAvion.setText("Exportar");
        exportarAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarAvionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exportarAvion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GraficoRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(GraficoRutas, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportarAvion)
                        .addGap(164, 164, 164))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCiudadAeropuerto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadAeropuerto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadAeropuerto1ActionPerformed

    private void txtPaisAeropuerto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisAeropuerto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisAeropuerto1ActionPerformed

    private void txtNombreAeroperto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAeroperto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAeroperto1ActionPerformed

    
    private void btnBuscarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRutaActionPerformed

    }//GEN-LAST:event_btnBuscarRutaActionPerformed

    private void txtTiempEsimadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempEsimadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempEsimadoActionPerformed

    private void BtnGuardarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarRutaActionPerformed
        int id =(int)txtIdRuta.getValue();

        String origen = comboOrigen.getSelectedItem().toString();
        String[] partes_origen = origen.split("-");
        int id_origen = Integer.parseInt(partes_origen[0]);
        String nombreOrigen = partes_origen[1];

        String destino = ComboDestino.getSelectedItem().toString();
        String[] partes_destino = destino.split("-");
        int id_destino= Integer.parseInt(partes_destino[0]);
        String nombreDestino = partes_destino[1];
        int tiempo =(int) txtTiempoRuta.getValue();

        if (origen.equals("") || destino.equals("") || id_origen == id_destino || tiempo == 0 ) {

            JOptionPane.showMessageDialog(this, "Error revise los campos");

        }

        else{

            Ruta ruta = new Ruta(id, id_origen, id_destino, tiempo, nombreOrigen, nombreDestino);
            int resoult = rutaModel.Create(ruta);
            ruta.setId(resoult);
            listaRuta.add(ruta);
            JOptionPane.showMessageDialog(this," La Ruta "+resoult +"fue creado correctamente");
            cargarListaRutas();

        }
    }//GEN-LAST:event_BtnGuardarRutaActionPerformed

    private void ComboDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboDestinoActionPerformed

    private void comboOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOrigenActionPerformed

    private void btnElimiarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimiarRutaActionPerformed
        int id = (int) txtIdRuta.getValue();
        boolean existe = false;
        for (int i = 0; i < listaRuta.size(); i++) {
            if (listaRuta.get(i).getIdruta()== id) {
                listaRuta.remove(listaRuta.get(i));
                JOptionPane.showMessageDialog(this,"Ruta eliminado");
                existe = true;
                cargarListaRutas();
                limpiarListaRutas();
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "La ruta no existe");
            limpiarListaRutas();
        }
    }//GEN-LAST:event_btnElimiarRutaActionPerformed

    private void btnGuardarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRutaActionPerformed
        int id = (int) txtidAeropuerto.getValue();
        String nombre = txtNombreAeroperto.getText();
        String ciudad = txtCiudadAeropuerto.getText();
        String pais = txtPaisAeropuerto.getText();
        int coord_x = (int) txtCordenadaX.getValue();
        int coord_y = (int) txtCodenadaY.getValue();

        if(id == 0 || nombre.equals("") || ciudad.equals("") || pais.equals("") || coord_x == 0 || coord_y == 0){
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");
        } else{
            Aeropuerto aero = new Aeropuerto(id, nombre, ciudad, pais, coord_x, coord_y);
            JOptionPane.showMessageDialog(this," El aeropuuerto fue creado correctamente");
            listaAeropuero.add(aero);
            cargarListaAeropuerto();
            aeropuertoModel.Create(aero);
            limpiarListaAeropuerto();

        }

    }//GEN-LAST:event_btnGuardarRutaActionPerformed

    private void btnEdiarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdiarRutaActionPerformed
        int id = (int) txtIdRuta.getValue(); // Spiner
        int EstiimadoRuta = (int) txtTimEstiimadoRuta.getValue();
        boolean existe = false;
        //Valido que los valores no esten vacios
        if(id == 0 || EstiimadoRuta == 0 ){
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");

        }else{
            for (int i = 0; i < listaRuta.size(); i++) {
                if (listaRuta.get(i).getIdruta()== id) {
                    listaRuta.get(i).setId(id);
                    listaRuta.get(i).setTiempo_estimado(EstiimadoRuta);

                    existe = true;
                    cargarListaAvion();
                    JOptionPane.showMessageDialog(this, "Ruta editda correctamente");
                    cargarListaRutas();
                    limpiarListaRutas();
                    break;
                }
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "La ruta no esta registrado");
        }

    }//GEN-LAST:event_btnEdiarRutaActionPerformed

    private void btnElimiarAeropuetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimiarAeropuetoActionPerformed
        int id = (int) txtidAeropuerto.getValue();
        boolean existe = false;
        for (int i = 0; i < listaAeropuero.size(); i++) {
            if (listaAeropuero.get(i).getId() == id) {
                int resultado = aeropuertoModel.Delete(id);

                if (resultado == 1){
                    listaAeropuero.remove(listaAeropuero.get(i));
                    JOptionPane.showMessageDialog(this,"Aropuerto eliminado");
                    cargarListaAeropuerto();

                }else{
                    JOptionPane.showMessageDialog(this,"El Aropuerto no puede ser eliminado");
                }

                existe = true;
                limpiarListaAeropuerto();
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El aeropuerto no existe");
            limpiarListaAeropuerto();
        }

    }//GEN-LAST:event_btnElimiarAeropuetoActionPerformed

    private void btnEditarAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAeropuertoActionPerformed
        int id = (int) txtidAeropuerto.getValue(); // Spiner

        String nombre = txtNombreAeroperto.getText(); // Text Field
        String ciudad = txtCiudadAeropuerto.getText();
        String pais = txtPaisAeropuerto.getText();
        int coord_x = (int) txtCordenadaX.getValue();
        int coord_y = (int) txtCodenadaY.getValue();
        boolean existe = false;
        //Valido que los valores no esten vacios
        if(id == 0 || nombre.equals("") || ciudad.equals("") || pais.equals("") || coord_x == 0 || coord_y == 0){
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");

        }else{
            for (int i = 0; i < listaAeropuero.size(); i++) {
                if (listaAeropuero.get(i).getId() == id) {
                    listaAeropuero.get(i).setNombre(nombre);
                    listaAeropuero.get(i).setCiudad(ciudad);
                    listaAeropuero.get(i).setPais(pais);
                    listaAeropuero.get(i).setCoord_x(coord_x);
                    listaAeropuero.get(i).setCoord_y(coord_y);
                    existe = true;
                    Aeropuerto aero = new Aeropuerto(id, nombre, ciudad, pais, coord_x, coord_y);
                    aeropuertoModel.Update(aero, id);
                    cargarListaAeropuerto();
                    JOptionPane.showMessageDialog(this, "Aeropuerto editado correctamente");
                    limpiarListaAeropuerto();
                    break;
                }
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El Aeropuerto no esta registrado");

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarAeropuertoActionPerformed

    private void btnBuscarAeropuetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAeropuetoActionPerformed
        int id = (int) txtidAeropuerto.getValue();
        String nombre = txtNombreAeroperto.getText();
        String ciudad = txtCiudadAeropuerto.getText();
        String pais = txtPaisAeropuerto.getText();
        int coord_x = (int) txtCordenadaX.getValue();
        int coord_y = (int) txtCodenadaY.getValue();

        if(id == 0 || nombre.equals("") || ciudad.equals("") || pais.equals("") || coord_x == 0 || coord_y == 0){
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");
        } else{
            Aeropuerto aero = new Aeropuerto(id, nombre, ciudad, pais, coord_x, coord_y);
            JOptionPane.showMessageDialog(this," El aeropuuerto fue creado correctamente");
            listaAeropuero.add(aero);
            cargarListaAeropuerto();
            aeropuertoModel.Create(aero);
            limpiarListaAeropuerto();

        }
    }//GEN-LAST:event_btnBuscarAeropuetoActionPerformed

    private void btnGuardarAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAeropuertoActionPerformed
        int id = (int) txtidAeropuerto.getValue();
        boolean existe = false;
        for (int i = 0; i < listaAeropuero.size(); i++) {
            if (listaAeropuero.get(i).getId() == id) {
                txtidAeropuerto.setValue(listaAeropuero.get(i).getId());
                txtNombreAeroperto.setText(listaAeropuero.get(i).getNombre());
                txtCiudadAeropuerto.setText(listaAeropuero.get(i).getCiudad());
                txtPaisAeropuerto.setText(listaAeropuero.get(i).getCiudad());
                txtCordenadaX.setValue(listaAeropuero.get(i).getCoord_x());
                txtCodenadaY.setValue(listaAeropuero.get(i).getCoord_y());
                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El aeropuerto no existe");
            limpiarListaAeropuerto();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarAeropuertoActionPerformed

    private void txtCiudadAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadAeropuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadAeropuertoActionPerformed

    private void txtPaisAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisAeropuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisAeropuertoActionPerformed

    private void txtNombreAeropertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAeropertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAeropertoActionPerformed

    private void btnEliminarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAvionActionPerformed
        int id = (int) txtIdAvion.getValue();
        boolean existe = false;
        for (int i = 0; i < listaAviones.size(); i++) {
            if (listaAviones.get(i).getId()== id) {
                int avi = avionModel.Delete(id);
                if(avi ==1){
                    listaAviones.remove(listaAviones.get(i));
                    JOptionPane.showMessageDialog(this,"Avion eliminado");
                    cargarListaAvion();
                }else{
                    JOptionPane.showMessageDialog(this,"El Avion no puede ser eliminado");
                }
                existe = true;
                limpiarListaAvion();
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El avion no existe");
            limpiarListaAvion();
        }

    }//GEN-LAST:event_btnEliminarAvionActionPerformed

    private void btnEditarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAvionActionPerformed
        int id = (int) txtIdAvion.getValue(); // Spiner
        String modelo = txtModeloAvion.getText(); // Text Field
        int NoAsientos = (int) txtNoAsientos.getValue();
        int NoBanos = (int) txtNoBanos.getValue();
        int CapMax = (int) txtCapMax.getValue();
        boolean existe = false;
        //Valido que los valores no esten vacios
        if(id == 0 || modelo.equals("") || NoAsientos == 0 || NoBanos == 0 || CapMax == 0){
            JOptionPane.showMessageDialog(null, "Error: debe llenar todos los campos");

        }else{
            for (int i = 0; i < listaAviones.size(); i++) {
                if (listaAviones.get(i).getId() == id) {
                    listaAviones.get(i).setId(id);
                    listaAviones.get(i).setModelo(modelo);
                    listaAviones.get(i).setNumero_asientos(NoAsientos);
                    listaAviones.get(i).setNumero_banos(NoBanos);
                    listaAviones.get(i).setCapasiad_max_peso(CapMax);
                    existe = true;
                    Avion avi = new Avion(id, modelo, NoAsientos, NoBanos, CapMax);
                    avionModel.Update(avi, id);
                    cargarListaAvion();
                    JOptionPane.showMessageDialog(this, "Avion editado correctamente");
                    limpiarListaAvion();
                    break;
                }
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El Aeropuerto no esta registrado");
        }
    }//GEN-LAST:event_btnEditarAvionActionPerformed

    private void btnBusarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusarAvionActionPerformed
        int id = (int) txtIdAvion.getValue();
        boolean existe = false;
        for (int i = 0; i < listaAviones.size(); i++) {
            if (listaAviones.get(i).getId() == id) {
                txtIdAvion.setValue(listaAviones.get(i).getId());
                txtModeloAvion.setText(listaAviones.get(i).getModelo());
                txtNoAsientos.setValue(listaAviones.get(i).getNumero_asientos());
                txtNoBanos.setValue(listaAviones.get(i).getNumero_banos());
                txtCapMax.setValue(listaAviones.get(i).getCapasiad_max_peso());

                existe = true;
                break;
            }
        }
        if (!existe) {
            JOptionPane.showMessageDialog(this, "El Avion no existe");
            limpiarListaAvion();
        }
    }//GEN-LAST:event_btnBusarAvionActionPerformed

    private void btnGuardarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAvionActionPerformed

    }//GEN-LAST:event_btnGuardarAvionActionPerformed

    private void exportaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportaActionPerformed
       AeropuertoController controlador_Aeropuerto = new AeropuertoController();
        try{
            controlador_Aeropuerto.ExportData();
            JOptionPane.showMessageDialog(this, "Informacion Exportada Correctamente");
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        } AvionController controlador_Avion = new AvionController();
        try{
            controlador_Avion.ExportData();
            JOptionPane.showMessageDialog(this, "Informacion Exportada Correctamente");
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }//GEN-LAST:event_exportaActionPerformed

    private void exportarAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarAvionActionPerformed
     AvionController controlador_Avion = new AvionController();
        try{
            controlador_Avion.ExportData();
            JOptionPane.showMessageDialog(this, "Informacion Exportada Correctamente");
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_exportarAvionActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardarRuta;
    private javax.swing.JComboBox<String> ComboDestino;
    private javax.swing.JTabbedPane GraficoRutas;
    private javax.swing.JButton btnBusarAvion;
    private javax.swing.JButton btnBuscarAeropueto;
    private javax.swing.JButton btnBuscarAeropueto1;
    private javax.swing.JButton btnBuscarRuta;
    private javax.swing.JButton btnEdiarRuta;
    private javax.swing.JButton btnEditarAeropuerto;
    private javax.swing.JButton btnEditarAeropuerto1;
    private javax.swing.JButton btnEditarAvion;
    private javax.swing.JButton btnElimiarAeropueto;
    private javax.swing.JButton btnElimiarAeropueto1;
    private javax.swing.JButton btnElimiarRuta;
    private javax.swing.JButton btnEliminarAvion;
    private javax.swing.JButton btnGuardarAeropuerto;
    private javax.swing.JButton btnGuardarAeropuerto1;
    private javax.swing.JButton btnGuardarAvion;
    private javax.swing.JButton btnGuardarRuta;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JButton exporta;
    private javax.swing.JButton exportarAvion;
    private javax.swing.JPanel graficoAvion;
    private javax.swing.JPanel graficoModelo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable listAviones;
    private javax.swing.JTable listRutas;
    private javax.swing.JPanel panelPaises;
    private javax.swing.JTable tableAeropuerto;
    private javax.swing.JTable tableRutas;
    private javax.swing.JScrollPane taleAviones;
    private javax.swing.JSpinner txtCapMax;
    private javax.swing.JTextField txtCiudadAeropuerto;
    private javax.swing.JTextField txtCiudadAeropuerto1;
    private javax.swing.JSpinner txtCodenadaY;
    private javax.swing.JSpinner txtCodenadaY1;
    private javax.swing.JSpinner txtCordenadaX;
    private javax.swing.JSpinner txtCordenadaX1;
    private javax.swing.JSpinner txtIdAvion;
    private javax.swing.JSpinner txtIdRuta;
    private javax.swing.JTextPane txtModeloAvion;
    private javax.swing.JSpinner txtNoAsientos;
    private javax.swing.JSpinner txtNoBanos;
    private javax.swing.JTextField txtNombreAeroperto;
    private javax.swing.JTextField txtNombreAeroperto1;
    private javax.swing.JTextField txtPaisAeropuerto;
    private javax.swing.JTextField txtPaisAeropuerto1;
    private javax.swing.JTextField txtTiempEsimado;
    private javax.swing.JSpinner txtTiempoRuta;
    private javax.swing.JSpinner txtTimEstiimadoRuta;
    private javax.swing.JSpinner txtidAeropuerto;
    private javax.swing.JSpinner txtidAeropuerto1;
    // End of variables declaration//GEN-END:variables
}
