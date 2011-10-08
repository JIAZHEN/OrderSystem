/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystemclient;

import java.io.File;

/**
 *
 * @author Administrator
 */
class MyCustomFilter extends javax.swing.filechooser.FileFilter {

    public boolean accept(File f) {
        String tmp = f.getName().toLowerCase();
        if (f.isDirectory()) {
            return true;
        }
        if (tmp.endsWith(".jpg") || tmp.endsWith(".gif") || tmp.endsWith(".png")) {
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "图像文件(*.jpg,*.gif,*.png)";
    }
}
