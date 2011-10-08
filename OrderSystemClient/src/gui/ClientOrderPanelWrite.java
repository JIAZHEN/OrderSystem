/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import ordersystemclient.model.ClientModel;

/**
 *
 * @author JIAZHEN XIE
 */
public class ClientOrderPanelWrite extends JPanel implements Runnable {

    private ClientModel clientModel;
    private JPanel centrePanel;
    private JPanel leftPanel;
    private JLabel timeLabel;
    private JLabel spendLabel;

    public ClientOrderPanelWrite() {
        super();
        //this.clientModel = clientModel;
        configLeftPanel();
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.WEST, leftPanel);
    }

    /**
     * Create the left panel contains buttions
     * @return the left panel
     */
    private void configLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        // locate the panels and make a line of space between panels
        constraints.fill = GridBagConstraints.BOTH;
        //constraints.insets = new Insets(5, 5, 5, 5);
        // remainder means the end of line
        // date label
        timeLabel = new JLabel();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        leftPanel.add(timeLabel, constraints);
        // Expense amount label
        Font font = new Font("宋体", Font.PLAIN, 15);
        timeLabel.setFont(font);
        spendLabel = new JLabel("Total spending: 0 GBP");
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        leftPanel.add(spendLabel, constraints);
    }

    public void run() {
        while (true) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            timeLabel.setText(sdf.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                timeLabel.setText("出错错误，请重启程序");
            }
        }
    }
}
