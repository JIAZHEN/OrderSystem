/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystemclient.model;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

/**
 * a class which is a thread and will deal with user's input
 * 
 * @author jxx084
 */
public class HostInputThread extends Thread {
    // to receive the xml object

    private ObjectInputStream recievedCommand;
    private HostModel hostModel;

    /**
     * create such a thread
     *
     * @param recieveMessage
     *            the data stream from server
     * @param clientModel
     *            the underlying client model
     * @param recievedCommand
     *            the object stream from server
     */
    public HostInputThread(DataInputStream recieveMessage,
            HostModel hostModel, ObjectInputStream recievedCommand) {
        super();
        this.hostModel = hostModel;
        this.recievedCommand = recievedCommand;
    }

    public void run() {
        try {
            while (true) {
                Document doc = (Document) recievedCommand.readObject();
                Element command = doc.getRootElement().getChild("command");
                if (command.getAttributeValue("type").equals("stop")) {
                    break;
                } else if (command.getAttributeValue("type").equals("NewClientHasLogin")) {
                    String clientId = command.getChildText("clientId");
                    hostModel.openTable(clientId);
                }else if (command.getAttributeValue("type").equals("getBrandListS")) {
                    System.out.println("ssss");
                    List<Element> brandElementList = doc.getRootElement().getChild("command").getChildren();
                    //use to set the arraylist
                    List<Brand> brandListInter = new ArrayList<Brand>();
                    if (brandElementList != null) {
                        for (int i = 0; i < brandElementList.size(); i++) {
                            Element element = brandElementList.get(i);
                            int brandId = Integer.valueOf(element.getChildText("brandId"));
                            String brandEName = element.getChildText("brandEName");
                            String brandCName = element.getChildText("brandCName");
                            System.out.println(brandId + " : " + brandEName + brandCName);
                            Brand brand = new Brand();
                            brand.setBrandId(brandId);
                            brand.setBrandEName(brandEName);
                            brand.setBrandCName(brandCName);
                            brandListInter.add(brand);
                        }
                        hostModel.setBrandCEList(brandListInter);
                    }

                }
                else if (command.getAttributeValue("type").equals("getCateListS")) {
                    System.out.println("ssss");
                    List<Element> brandElementList = doc.getRootElement().getChild("command").getChildren();
                    //use to set the arraylist
                    List<Category> cateListInter = new ArrayList<Category>();
                    if (brandElementList != null) {
                        for (int i = 0; i < brandElementList.size(); i++) {
                            Element element = brandElementList.get(i);
                            int cateId = Integer.valueOf(element.getChildText("cateId"));
                            String cateEName = element.getChildText("cateEName");
                            String cateCName = element.getChildText("cateCName");
                           // System.out.println(brandId + " : " + brandEName + brandCName);
                            Category category = new Category();
                            category.setCateId(cateId);
                            category.setCateEName(cateEName);
                            category.setCateCName(cateCName);
                            cateListInter.add(category);
                        }
                        hostModel.setCategCEList(cateListInter);
                    }

                }
            }
            System.out.println("HostInputThread break");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
