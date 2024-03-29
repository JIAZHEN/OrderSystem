/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DishesView.java
 *
 * Created on 2011-10-1, 6:28:19
 */
package ordersystemclient;

import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ordersystemclient.model.Brand;
import ordersystemclient.model.Category;
import ordersystemclient.model.HostModel;

/**
 *
 * @author Administrator
 */
public class DishesView extends javax.swing.JPanel {

    private HostModel hostModel;
    private boolean ifBrandFirst=false;
    private boolean ifCateFirst=false;

    /** Creates new form DishesView */
    public DishesView(HostModel hostModel) {
        this.hostModel = hostModel;
        ifBrandFirst=false;
        ifCateFirst=false;
        initComponents();
        fullfillBrand();

        // for(int i=0;i<hostModel.getBrandList().size();i++){
        //    Brand brand=(Brand)hostModel.getBrandList().get(i); 
        //    String brandEName=brand.getBrandEName();
        //   sltBrand.addItem(brandEName);
        //   }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        banner = new javax.swing.JLabel();
        chinesePanel = new javax.swing.JPanel();
        cDishNameLabel = new javax.swing.JLabel();
        cDishNameText = new javax.swing.JTextField();
        cCatalogLabel = new javax.swing.JLabel();
        cbbCCategory = new javax.swing.JComboBox();
        cPriceLabel = new javax.swing.JLabel();
        cPriceText = new javax.swing.JTextField();
        cPicLabel = new javax.swing.JLabel();
        cPicText = new javax.swing.JTextField();
        cFileSelection = new javax.swing.JButton();
        cIntrodLabel = new javax.swing.JLabel();
        cScrollPane1 = new javax.swing.JScrollPane();
        cIntrodTextArea = new javax.swing.JTextArea();
        lblBrand = new javax.swing.JLabel();
        cbbCBrand = new javax.swing.JComboBox();
        lblBrandName = new javax.swing.JLabel();
        lblPriceUnit = new javax.swing.JLabel();
        englishPanel = new javax.swing.JPanel();
        eDishNameLabel = new javax.swing.JLabel();
        eDishNameText = new javax.swing.JTextField();
        cbbECategory = new javax.swing.JComboBox();
        eCatalogLabel = new javax.swing.JLabel();
        ePriceLabel = new javax.swing.JLabel();
        ePriceText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ePicLabel = new javax.swing.JLabel();
        ePicText = new javax.swing.JTextField();
        eFileSelection = new javax.swing.JButton();
        eIntrodLabel = new javax.swing.JLabel();
        eScrollPane1 = new javax.swing.JScrollPane();
        eIntrodTextArea = new javax.swing.JTextArea();
        lblEBrand = new javax.swing.JLabel();
        cbbEBrand = new javax.swing.JComboBox();
        eDishNameLabel1 = new javax.swing.JLabel();
        btnPanel = new javax.swing.JPanel();
        submitBtn = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        fileChooser.setFileFilter(new MyCustomFilter());
        fileChooser.setName("fileChooser"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ordersystemclient.OrderSystemClientApp.class).getContext().getResourceMap(DishesView.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N

        banner.setBackground(resourceMap.getColor("banner.background")); // NOI18N
        banner.setIcon(resourceMap.getIcon("banner.icon")); // NOI18N
        banner.setText(resourceMap.getString("banner.text")); // NOI18N
        banner.setName("banner"); // NOI18N

        chinesePanel.setBackground(resourceMap.getColor("chinesePanel.background")); // NOI18N
        chinesePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("chinesePanel.border.title"))); // NOI18N
        chinesePanel.setName("chinesePanel"); // NOI18N

        cDishNameLabel.setText(resourceMap.getString("cDishNameLabel.text")); // NOI18N
        cDishNameLabel.setName("cDishNameLabel"); // NOI18N

        cDishNameText.setText(resourceMap.getString("cDishNameText.text")); // NOI18N
        cDishNameText.setName("cDishNameText"); // NOI18N
        cDishNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDishNameTextActionPerformed(evt);
            }
        });

        cCatalogLabel.setText(resourceMap.getString("cCatalogLabel.text")); // NOI18N
        cCatalogLabel.setName("cCatalogLabel"); // NOI18N

        cbbCCategory.setName("cbbCCategory"); // NOI18N
        cbbCCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbCCategoryItemStateChanged(evt);
            }
        });

        cPriceLabel.setText(resourceMap.getString("cPriceLabel.text")); // NOI18N
        cPriceLabel.setName("cPriceLabel"); // NOI18N

        cPriceText.setName("cPriceText"); // NOI18N
        cPriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPriceTextActionPerformed(evt);
            }
        });

        cPicLabel.setText(resourceMap.getString("cPicLabel.text")); // NOI18N
        cPicLabel.setName("cPicLabel"); // NOI18N

        cPicText.setName("cPicText"); // NOI18N
        cPicText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPicTextActionPerformed(evt);
            }
        });

        cFileSelection.setText(resourceMap.getString("cFileSelection.text")); // NOI18N
        cFileSelection.setName("cFileSelection"); // NOI18N
        cFileSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cFileSelectionActionPerformed(evt);
            }
        });

        cIntrodLabel.setText(resourceMap.getString("cIntrodLabel.text")); // NOI18N
        cIntrodLabel.setName("cIntrodLabel"); // NOI18N

        cScrollPane1.setName("cScrollPane1"); // NOI18N

        cIntrodTextArea.setColumns(20);
        cIntrodTextArea.setRows(5);
        cIntrodTextArea.setName("cIntrodTextArea"); // NOI18N
        cScrollPane1.setViewportView(cIntrodTextArea);

        lblBrand.setName("lblBrand"); // NOI18N

        cbbCBrand.setName("cbbCBrand"); // NOI18N
        cbbCBrand.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbCBrandItemStateChanged(evt);
            }
        });

        lblBrandName.setText(resourceMap.getString("lblBrandName.text")); // NOI18N
        lblBrandName.setName("lblBrandName"); // NOI18N

        lblPriceUnit.setText(resourceMap.getString("lblPriceUnit.text")); // NOI18N
        lblPriceUnit.setName("lblPriceUnit"); // NOI18N

        javax.swing.GroupLayout chinesePanelLayout = new javax.swing.GroupLayout(chinesePanel);
        chinesePanel.setLayout(chinesePanelLayout);
        chinesePanelLayout.setHorizontalGroup(
            chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chinesePanelLayout.createSequentialGroup()
                .addComponent(lblBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBrandName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cDishNameLabel))
                .addGap(398, 398, 398))
            .addGroup(chinesePanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cCatalogLabel)
                    .addComponent(cPriceLabel)
                    .addComponent(cPicLabel)
                    .addComponent(cIntrodLabel))
                .addGap(18, 18, 18)
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cDishNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbCBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(244, 244, 244))
            .addGroup(chinesePanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chinesePanelLayout.createSequentialGroup()
                        .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cPriceText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbCCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, 130, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lblPriceUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(chinesePanelLayout.createSequentialGroup()
                        .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addGroup(chinesePanelLayout.createSequentialGroup()
                                .addComponent(cPicText, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cFileSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(111, 111, 111))))
        );
        chinesePanelLayout.setVerticalGroup(
            chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chinesePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cDishNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cDishNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBrandName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbCBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cCatalogLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbCCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPriceUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cPicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cPicText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cFileSelection))
                .addGroup(chinesePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chinesePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cIntrodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chinesePanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(cScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        englishPanel.setBackground(resourceMap.getColor("englishPanel.background")); // NOI18N
        englishPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("englishPanel.border.title"))); // NOI18N
        englishPanel.setName("englishPanel"); // NOI18N

        eDishNameLabel.setText(resourceMap.getString("eDishNameLabel.text")); // NOI18N
        eDishNameLabel.setName("eDishNameLabel"); // NOI18N

        eDishNameText.setName("eDishNameText"); // NOI18N
        eDishNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eDishNameTextActionPerformed(evt);
            }
        });

        cbbECategory.setName("cbbECategory"); // NOI18N
        cbbECategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbECategoryItemStateChanged(evt);
            }
        });

        eCatalogLabel.setText(resourceMap.getString("eCatalogLabel.text")); // NOI18N
        eCatalogLabel.setName("eCatalogLabel"); // NOI18N

        ePriceLabel.setText(resourceMap.getString("ePriceLabel.text")); // NOI18N
        ePriceLabel.setName("ePriceLabel"); // NOI18N

        ePriceText.setName("ePriceText"); // NOI18N
        ePriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ePriceTextActionPerformed(evt);
            }
        });

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        ePicLabel.setText(resourceMap.getString("ePicLabel.text")); // NOI18N
        ePicLabel.setName("ePicLabel"); // NOI18N

        ePicText.setName("ePicText"); // NOI18N
        ePicText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ePicTextActionPerformed(evt);
            }
        });

        eFileSelection.setText(resourceMap.getString("eFileSelection.text")); // NOI18N
        eFileSelection.setName("eFileSelection"); // NOI18N
        eFileSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eFileSelectionActionPerformed(evt);
            }
        });

        eIntrodLabel.setText(resourceMap.getString("eIntrodLabel.text")); // NOI18N
        eIntrodLabel.setName("eIntrodLabel"); // NOI18N

        eScrollPane1.setName("eScrollPane1"); // NOI18N

        eIntrodTextArea.setColumns(20);
        eIntrodTextArea.setRows(5);
        eIntrodTextArea.setName("eIntrodTextArea"); // NOI18N
        eScrollPane1.setViewportView(eIntrodTextArea);

        lblEBrand.setName("lblEBrand"); // NOI18N

        cbbEBrand.setName("cbbEBrand"); // NOI18N
        cbbEBrand.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbEBrandItemStateChanged(evt);
            }
        });

        eDishNameLabel1.setText(resourceMap.getString("eDishNameLabel1.text")); // NOI18N
        eDishNameLabel1.setName("eDishNameLabel1"); // NOI18N

        javax.swing.GroupLayout englishPanelLayout = new javax.swing.GroupLayout(englishPanel);
        englishPanel.setLayout(englishPanelLayout);
        englishPanelLayout.setHorizontalGroup(
            englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(englishPanelLayout.createSequentialGroup()
                .addGroup(englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(englishPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eIntrodLabel)
                            .addComponent(ePicLabel)
                            .addComponent(ePriceLabel)
                            .addComponent(eCatalogLabel)
                            .addComponent(eDishNameLabel1)
                            .addComponent(eDishNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbECategory, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eDishNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbEBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(englishPanelLayout.createSequentialGroup()
                                .addComponent(ePriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(englishPanelLayout.createSequentialGroup()
                                .addComponent(ePicText, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eFileSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(eScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(englishPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblEBrand)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        englishPanelLayout.setVerticalGroup(
            englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(englishPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eDishNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eDishNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eDishNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbEBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eCatalogLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbECategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ePriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ePriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ePicText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eFileSelection))
                .addGap(18, 18, 18)
                .addGroup(englishPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eIntrodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnPanel.setBackground(resourceMap.getColor("btnPanel.background")); // NOI18N
        btnPanel.setName("btnPanel"); // NOI18N

        submitBtn.setText(resourceMap.getString("submitBtn.text")); // NOI18N
        submitBtn.setName("submitBtn"); // NOI18N
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        reset.setText(resourceMap.getString("reset.text")); // NOI18N
        reset.setName("reset"); // NOI18N
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        exit.setText(resourceMap.getString("exit.text")); // NOI18N
        exit.setName("exit"); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addContainerGap(606, Short.MAX_VALUE)
                .addComponent(submitBtn)
                .addGap(18, 18, 18)
                .addComponent(reset)
                .addGap(18, 18, 18)
                .addComponent(exit)
                .addGap(106, 106, 106))
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(submitBtn)
                    .addComponent(exit))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chinesePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(englishPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addComponent(banner, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(banner, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(englishPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chinesePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chinesePanel, englishPanel});

    }// </editor-fold>//GEN-END:initComponents

    private void cDishNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDishNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cDishNameTextActionPerformed

    private void eDishNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eDishNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eDishNameTextActionPerformed

    private void cPriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPriceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPriceTextActionPerformed

    private void ePriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ePriceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ePriceTextActionPerformed

    private void cPicTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPicTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPicTextActionPerformed

    private void cFileSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cFileSelectionActionPerformed
        // TODO add your handling code here:
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // What to do with the file, e.g. display it in a TextArea
            String path = file.getAbsolutePath();
            cPicText.setText(path);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_cFileSelectionActionPerformed

    private void ePicTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ePicTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ePicTextActionPerformed

    private void eFileSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eFileSelectionActionPerformed
        // TODO add your handling code here:
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // What to do with the file, e.g. display it in a TextArea
            String path = file.getAbsolutePath();
            ePicText.setText(path);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_eFileSelectionActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        cDishNameText.setText("");
        eDishNameText.setText("");
        cIntrodTextArea.setText("");
        eIntrodTextArea.setText("");
        cPicText.setText("");
        ePicText.setText("");
        cPriceText.setText("");
        ePriceText.setText("");
    }//GEN-LAST:event_resetActionPerformed

private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
    String dishName = cDishNameText.getText();
    String dishIntroduction = cIntrodTextArea.getText();
    String dishPrice = cPriceText.getText();
    String picPath = cPicText.getText();
    String dishCategory = cbbCCategory.getSelectedItem().toString();
    if (dishName.isEmpty() || dishIntroduction.isEmpty() || dishPrice.isEmpty() || picPath.isEmpty() || cbbCCategory.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(null, "dish name/introduction/price/picture/category should be completed");
    } else if (hostModel.addNewDish(dishName, dishCategory, dishPrice, picPath, dishIntroduction)) {
        final SuccessPanel successPanel = new SuccessPanel();
        final JFrame jFrame = new JFrame();
        jFrame.add(successPanel);
        jFrame.setVisible(true);
//            hostModel.addObserver(orderDishMainForm);
        // orderDishMainForm.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(400, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                jFrame.dispose();
            }
        });
//            JFrame test = new JFrame();
//            DishesView dishesView = new DishesView();
//            test.add(dishesView);
//            test.setVisible(true);
//        
    }
}//GEN-LAST:event_submitBtnActionPerformed

private void cbbCBrandItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbCBrandItemStateChanged
    if (evt.getStateChange() == ItemEvent.SELECTED) {
        int ie=cbbEBrand.getSelectedIndex();
        if(evt.getSource().equals(cbbCBrand)){
            int i=cbbCBrand.getSelectedIndex();
            cbbEBrand.setSelectedIndex(i); 
        }
    }
   
}//GEN-LAST:event_cbbCBrandItemStateChanged

private void cbbEBrandItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbEBrandItemStateChanged

    if(ifBrandFirst){
    if (evt.getStateChange() == ItemEvent.SELECTED) {
       cbbCBrand.setSelectedIndex(cbbEBrand.getSelectedIndex());
         
    }
    }
    else{
        ifBrandFirst=true;
    }
}//GEN-LAST:event_cbbEBrandItemStateChanged

private void cbbECategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbECategoryItemStateChanged
//  if(ifFirst){
    if (evt.getStateChange() == ItemEvent.SELECTED) {
        Object[] ss=cbbCCategory.getSelectedObjects();
        Object[] sss=cbbECategory.getSelectedObjects();
        cbbCCategory.setSelectedIndex(cbbECategory.getSelectedIndex());
        System.out.println("");
    }
//    }
//    else{
//        ifFirst=true;
//    }
}//GEN-LAST:event_cbbECategoryItemStateChanged

private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
       
}//GEN-LAST:event_exitActionPerformed

private void cbbCCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbCCategoryItemStateChanged
  
    if (evt.getStateChange() == ItemEvent.SELECTED) {
         if(ifCateFirst){
        int dd=cbbECategory.getSelectedIndex();
        Object[] ss=cbbCCategory.getSelectedObjects();
        cbbECategory.setSelectedIndex(cbbCCategory.getSelectedIndex());
        }
         else{
             ifCateFirst=true;
       // cbbECategory.setSelectedIndex(cbbCCategory.getSelectedIndex());
    }
    }
}//GEN-LAST:event_cbbCCategoryItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banner;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JLabel cCatalogLabel;
    private javax.swing.JLabel cDishNameLabel;
    private javax.swing.JTextField cDishNameText;
    private javax.swing.JButton cFileSelection;
    private javax.swing.JLabel cIntrodLabel;
    private javax.swing.JTextArea cIntrodTextArea;
    private javax.swing.JLabel cPicLabel;
    private javax.swing.JTextField cPicText;
    private javax.swing.JLabel cPriceLabel;
    private javax.swing.JTextField cPriceText;
    private javax.swing.JScrollPane cScrollPane1;
    private javax.swing.JComboBox cbbCBrand;
    private javax.swing.JComboBox cbbCCategory;
    private javax.swing.JComboBox cbbEBrand;
    private javax.swing.JComboBox cbbECategory;
    private javax.swing.JPanel chinesePanel;
    private javax.swing.JLabel eCatalogLabel;
    private javax.swing.JLabel eDishNameLabel;
    private javax.swing.JLabel eDishNameLabel1;
    private javax.swing.JTextField eDishNameText;
    private javax.swing.JButton eFileSelection;
    private javax.swing.JLabel eIntrodLabel;
    private javax.swing.JTextArea eIntrodTextArea;
    private javax.swing.JLabel ePicLabel;
    private javax.swing.JTextField ePicText;
    private javax.swing.JLabel ePriceLabel;
    private javax.swing.JTextField ePriceText;
    private javax.swing.JScrollPane eScrollPane1;
    private javax.swing.JPanel englishPanel;
    private javax.swing.JButton exit;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblBrandName;
    private javax.swing.JLabel lblEBrand;
    private javax.swing.JLabel lblPriceUnit;
    private javax.swing.JButton reset;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables

    private void fullfillBrand() {
        //   hostModel.getBrandList();
        List<Brand> brandList = hostModel.getBrandCEList();
        if (brandList != null) {
            for (int i = 0; i < brandList.size(); i++) {
                cbbEBrand.addItem(brandList.get(i).getBrandEName());
                cbbCBrand.addItem(brandList.get(i).getBrandCName());
            }
        }
        List<Category> cateList = hostModel.getCategCEList();
        if (cateList != null) {
            for (int i = 0; i < cateList.size(); i++) {
                cbbCCategory.addItem(cateList.get(i).getCateCName());
                cbbECategory.addItem(cateList.get(i).getCateEName());
            }
        }
        cbbEBrand.setSelectedIndex(0);
        cbbCBrand.setSelectedIndex(0);
        cbbCCategory.setSelectedIndex(0);
        cbbECategory.setSelectedIndex(0);
    }
}
