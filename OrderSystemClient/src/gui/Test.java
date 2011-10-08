/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import ordersystemclient.model.ClientModel;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ClientOrderPanel panel = new ClientOrderPanel();
        Thread thread1 = new Thread(panel);
        thread1.start();
        frame.add(panel);

        frame.setSize(1000, 800);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
