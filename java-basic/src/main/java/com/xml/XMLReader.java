package com.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by ween on 2019/4/28
 */
public class XMLReader {

    public static void parseSoapXml(String xml){
        try {
            Document document=DocumentHelper.parseText(xml);
            Element root=document.getRootElement();
           getChild(root);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void getChild(Element root){
        if(root.elements()!=null){
            List<Element> list=root.elements();
            for(Element e:list){
                if(e.elements().size()>0){
                    getChild(e);
                }
                if(e.elements().size()==0){
                    System.out.println(e.getName()+"--"+e.getTextTrim());
                }
            }
        }
    }

    public static void main(String[] args) {
        String str= "<?xml version=\"1.0\" encoding=\"UTF-16\"?>\n<soap:Body xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://haulinterface.overhaul.webservice.beans.webclient.psdi\"><ns1:getOverhaulTypeByYearResponse xmlns=\"\" xmlns:ns1=\"http://haulinterface.overhaul.webservice.beans.webclient.psdi\"><out>[{\"typea\":\"\",\"typeb\":\"\",\"typec\":\"\",\"inspection\":\"\",\"overhaul\":\"\",\"others\":\"\",\"typea_complate\":\"\",\"typeb_complate\":\"\",\"typec_complate\":\"\",\"inspection_complate\":\"\",\"overhaul_complate\":\"\",\"others_complate\":\"\"}]</out></ns1:getOverhaulTypeByYearResponse></soap:Body>";
        parseSoapXml(str);
    }
}
