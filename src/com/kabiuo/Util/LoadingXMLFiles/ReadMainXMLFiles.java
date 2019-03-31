package com.kabiuo.Util.LoadingXMLFiles;

import com.kabiuo.Entity.ConfigFileseEntity;
import org.jdom.xpath.XPath;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadMainXMLFiles {
    static List<ConfigFileseEntity> configFileseEntityList = new ArrayList<ConfigFileseEntity>();

  /*
  test load xml file

   public static void main(String[] args){
        List<ConfigFileseEntity> configFileseEntities = (List<ConfigFileseEntity>) readXml("D:\\JavaWeb_Study\\Mine-Clearance\\config\\m.xml");

        System.out.println(configFileseEntities);

        for (ConfigFileseEntity cfe: configFileseEntities
             ) {
            System.out.println(cfe.getDefaultValue());
            System.out.println(cfe.getSaveName());
            System.out.println(cfe.getDownloadPath());
            System.out.println(cfe.getSavePath());
        }
    }*/

    public static List<ConfigFileseEntity> readXml(String path){
        ConfigFileseEntity configFileseEntity;

        try {
            SAXBuilder sBuilder = new SAXBuilder();
            Document doc = sBuilder.build(new FileInputStream(path));
            Element root = doc.getRootElement();
            List CFE = XPath.selectNodes(root, "//xmlFile");
//            System.out.println(CFE);
            Element cf;

            for (int i = 0; i < CFE.size(); i++) {
                cf = (Element) CFE.get(i);

                configFileseEntity = new ConfigFileseEntity();

                configFileseEntity.setDefaultValue(cf.getAttributeValue("id"));
                configFileseEntity.setSaveName(cf.getChildText("saveName"));
                configFileseEntity.setDownloadPath(cf.getChildText("downloadPath"));
                configFileseEntity.setSavePath(cf.getChildText("savePath"));
                configFileseEntity.setMd5(cf.getChildText("md5"));

                configFileseEntityList.add(configFileseEntity);
            }
        }catch (Exception e){
            return null;
        }

        return configFileseEntityList;
    }
}
