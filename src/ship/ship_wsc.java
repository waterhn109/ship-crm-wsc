package ship;

import com.oa.WorkflowServiceXml;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sp.HttpDmsShipgroupNetWsdlApiProduct_updateLocator;
import com.sp.HttpDmsShipgroupNetWsdlApiProduct_updatePort_PortType;
import com.sp1.HttpDmsShipgroupNetWsdlApiCustomer_updateLocator;
import com.sp1.HttpDmsShipgroupNetWsdlApiCustomer_updatePort_PortType;
import com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updateLocator;
import com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

@WebService(serviceName = "ship_wsc",targetNamespace = "http://ship")
public class ship_wsc {
   //static final String USERNAME = "admin@shipgroup.net.partial";
    static final String USERNAME = "admin@shipgroup.net";
    static final String PASSWORD = "ship1246";
    static EnterpriseConnection connection;

    //public String request  (String request_body,String application ,String from) {
    @WebMethod
    public String send_request  (@WebParam(name = "request_body",targetNamespace="http://ship") String request_text) {
        String[] strings = request_text.split("@@jcc@@");
        String response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"找不到对接的系统\" /></Execution></Response>";

        if (strings.length != 4)
        // oa
        {
            try {
                request_text = request_text.replace("\\\"", "\"");
                request_text = request_text.replaceAll("\r|\n", "");
                System.out.println("oa接口调用");
                // byte[] data  = outPut(request_text);
                //  request_text = data.toString();
                if (request_text.indexOf("WorkflowRequestInfo") <= 0) {
                    response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"找不到对接的系统\" /></Execution></Response>";
                }
                com.oa.WorkflowServiceXmlPortType service = new WorkflowServiceXml().getWorkflowServiceXmlHttpPort();
                //invoke business method
                String erpid = request_text.substring(request_text.indexOf("<creatorId>") + 11, request_text.indexOf("</creatorId>"));
                String genid = service.getUserId("workcode", erpid);
                System.out.println("id转换：" + genid);
                //换成oa的USERID
                request_text.replace("<creatorId>" + erpid + "</creatorId>", "<creatorId>" + genid + "</creatorId>");
                String oa_rsp = service.doCreateWorkflowRequest(request_text, Integer.valueOf(genid));
                System.out.println(oa_rsp);
                Integer oa_id = Integer.valueOf(oa_rsp);
                if (oa_id > 0) {
                    response = "<Response><Execution><Status code=\"0\" sqlcode=\"1\" description=\"" + oa_rsp + "\" /></Execution></Response>";
                } else {
                    response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"oa流程创建失败，失败码:" + oa_rsp + "\" /></Execution></Response>";
                }
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
            }
        }
        else {
            String request_bodyb = strings[0].toString();
            String api_name = strings[1].toString();
            String api_from = strings[2].toString();
            String request_bodye = strings[3].toString();
            String request_body = request_bodyb + request_bodye;
            request_body = request_body.replace("\\\"", "\"");
            request_body = request_body.replaceAll("\r|\n", "");
            response = "<Response><Execution><Status code=\\\"-1\\\" sqlcode=\\\"1\\\" description=\\\"没有收到返回值\\\" /></Execution></Response>";
            if (api_from.equals("sf")) {
                ConnectorConfig config = new ConnectorConfig();
                config.setUsername(USERNAME);
                config.setPassword(PASSWORD);
                // config.setTraceMessage(true);
                try {

                    connection = Connector.newConnection(config);

                    // display some current settings
                    System.out.println("Auth EndPoint: " + config.getAuthEndpoint());
                    System.out.println("Service EndPoint: " + config.getServiceEndpoint());
                    System.out.println("Username: " + config.getUsername());
                    System.out.println("SessionId: " + config.getSessionId());

                    System.out.println("**********************************");

                    com.sforce.soap.ERPServiceInterface.SoapConnection soap = com.sforce.soap.ERPServiceInterface.Connector.newConnection("", "");
                    soap.setSessionHeader(config.getSessionId());

                    switch (api_name.toString()) {
                        //产品
                        case "upsertProduct":
                            response = soap.upsertProduct(request_body);
                            break;
                        //客户
                        case "upsertAccount":
                            response = soap.upsertAccount(request_body);
                            break;
                        //订单
                        case "upsertOrder":
                            response = soap.upsertOrder(request_body);
                            break;
                        //产品价格
                        case "upsertProductPrice":
                            response = soap.upsertProductPrice(request_body);
                            break;
                        //产品采购价格
                        case "upsertProductPurchasePrice":
                            response = soap.upsertProductPurchasePrice(request_body);
                            break;
                        //出货单
                        case "upsertShipment":
                            response = soap.upsertShipment(request_body);
                            break;
                        //销退单
                        case "upsertReturnOrder":
                            response = soap.upsertReturnOrder(request_body);
                            break;
                        //库存
                        case "upsertProductInventory":
                            response = soap.upsertProductInventory(request_body);
                            break;
                        default:
                            //...;
                            break;
                    }

                    // run the different examples
                    //queryContacts();
                    //createAccounts();
                    //updateAccounts();
                    //deleteAccounts();

                } catch (ConnectionException e1) {
                    e1.printStackTrace();
                    response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                }


            } else if (api_from.equals("sp")) {


                switch (api_name.toString()) {
                    //产品
                    case "upsertProduct":
                        try {
                            HttpDmsShipgroupNetWsdlApiProduct_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiProduct_updateLocator();
                            HttpDmsShipgroupNetWsdlApiProduct_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiProduct_updatePort();
                            response = sp_wsc.product_update(request_body);
                            break;
                        } catch (javax.xml.rpc.ServiceException e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                        } catch (java.rmi.RemoteException e2) {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e2.getLocalizedMessage() + "\" /></Execution></Response>";
                        }
                        break;
                    //产品价格
                    case "upsertProductPrice":
                        try {
                            HttpDmsShipgroupNetWsdlApiProduct_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiProduct_updateLocator();
                            HttpDmsShipgroupNetWsdlApiProduct_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiProduct_updatePort();
                            response = sp_wsc.product_price_update(request_body);
                            break;
                        } catch (javax.xml.rpc.ServiceException e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                        } catch (java.rmi.RemoteException e2) {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e2.getLocalizedMessage() + "\" /></Execution></Response>";
                        }

                        break;
                    //客户
                    case "upsertAccount":
                        try {
                            HttpDmsShipgroupNetWsdlApiCustomer_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiCustomer_updateLocator();
                            HttpDmsShipgroupNetWsdlApiCustomer_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiCustomer_updatePort();
                            response = sp_wsc.customer_update(request_body);
                            break;
                        } catch (javax.xml.rpc.ServiceException e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                        } catch (java.rmi.RemoteException e2) {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e2.getLocalizedMessage() + "\" /></Execution></Response>";
                        }

                        break;
                    //订单
                    case "upsertOrder":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_update(request_body);
                            break;
                        } catch (javax.xml.rpc.ServiceException e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                        } catch (java.rmi.RemoteException e2) {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e2.getLocalizedMessage() + "\" /></Execution></Response>";
                        }
                        break;

                    //出货单新增
                    case "upsertShipmentadd":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_delivery_add(request_body);
                            break;
                        } catch (javax.xml.rpc.ServiceException e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                        } catch (java.rmi.RemoteException e2) {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e2.getLocalizedMessage() + "\" /></Execution></Response>";
                        }
                        break;

                    //出货单删除或者修改
                    case "upsertShipment":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_delivery_update(request_body);
                            break;
                        } catch (javax.xml.rpc.ServiceException e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                        } catch (java.rmi.RemoteException e2) {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e2.getLocalizedMessage() + "\" /></Execution></Response>";
                        }
                        break;
                    //销退单新增
                    case "upsertReturnOrderadd":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_refund_add(request_body);
                            break;
                        } catch (javax.xml.rpc.ServiceException e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                        } catch (java.rmi.RemoteException e2) {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e2.getLocalizedMessage() + "\" /></Execution></Response>";
                        }
                        break;
                    //销退单删除或者修改
                    case "upsertReturnOrder":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_refund_update(request_body);
                            break;
                        } catch (javax.xml.rpc.ServiceException e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                        } catch (java.rmi.RemoteException e2) {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e2.getLocalizedMessage() + "\" /></Execution></Response>";
                        }
                        break;
                    default:
                        //...;
                        break;
                }

            } else  if (api_from.equals("mse")) {
                switch (api_name.toString()) {
                    //退料
                    case "Warehousetransfers":
                        try {
                            com.mse.Application_PortType service = new com.mse.WarehousetransfersLocator().getApplication();
                            if(request_body.indexOf("WarehousetransfersData") > 0) {

                                request_body = request_body.replace("&lt;","<").replace("<WarehousetransfersData>","").replace("</WarehousetransfersData>","@twmse@");
                                String [] strs = request_body.trim().split("@twmse@");
                                com.mse.WarehousetransfersData[] warehousetransfers = new com.mse.WarehousetransfersData[strs.length-1];
                                for(int i=0;i<strs.length-1;i++){
                                    com.mse.WarehousetransfersData warehousetransfersData = new com.mse.WarehousetransfersData();
                                    warehousetransfersData.setBarcode_no(subString(strs[i], "<barcode_no>", "</barcode_no>"));
                                    warehousetransfersData.setBatch_no(subString(strs[i], "<batch_no>", "</batch_no>"));
                                    warehousetransfersData.setDs_wh_id(subString(strs[i], "<ds_wh_id>", "</ds_wh_id>"));
                                    warehousetransfersData.setMaterial_id(subString(strs[i], "<material_id>", "</material_id>"));
                                    warehousetransfersData.setQty(subString(strs[i], "<qty>", "</qty>"));
                                    warehousetransfersData.setWh_id(subString(strs[i], "<wh_id>", "</wh_id>"));
                                    warehousetransfersData.setBin_id(subString(strs[i], "<bin_id>", "</bin_id>"));
                                    warehousetransfersData.setDs_bin_id(subString(strs[i], "<ds_bin_id>", "</ds_bin_id>"));
                                    warehousetransfersData.setMaterial_spec(subString(strs[i], "<material_spec>", "</material_spec>"));
                                    warehousetransfersData.setUnit_num(subString(strs[i], "<unit_num>", "</unit_num>"));
                                    warehousetransfers[i] = warehousetransfersData;
                                }
                                com.mse.ResultData ResultData = service.processData(warehousetransfers);
                                response =  "<Response><Execution><Status code=\""+ResultData.getCode()+"\" sqlcode=\"1\" description=\""+ResultData.getResult()+"\" /></Execution></Response>";
                            }
                            else
                            {
                                response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"请求xml不存在节点WarehousetransfersData\" /></Execution></Response>";
                                return response;
                            }
                        } catch (javax.xml.rpc.ServiceException e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e1.getLocalizedMessage() + "\" /></Execution></Response>";
                        } catch (java.rmi.RemoteException e2) {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"" + e2.getLocalizedMessage() + "\" /></Execution></Response>";
                        }
                        break;
                    default:
                        break;
                }
                return response;
            }
            else {
                return response;
            }
        }
            System.out.println(response);

            //  response.replace("\n","");
            // response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"参数 bn 不能为空\" /></Execution></Response>";

            response = response.replace("\\\"", "\"");
            response = response.replaceAll("\r|\n", "");
            response = response.replace("<![CDATA[", "");
            response = response.replace("]]>", "");
            response = response.replace("&lt;", '<' + "");
            response = "<![CDATA[" + response + "]]>";
            return response;
        }
    /**
     * 格式化XML输出.
     * @param xmlStr xml文本内容.
     * @return
     */
    public static byte[] outPut(String xmlStr) {

        byte[] data = null;
        StringReader stringReader = null;

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            stringReader =  new StringReader(xmlStr);
            InputSource is = new InputSource(stringReader);
            Document doc = db.parse(is);

            data = outPut(doc);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (stringReader != null) {
                stringReader.close();
            }

        }

        return data;
    }

    /**
     * 格式化输出.
     * @param node
     * @return
     */
    public static byte[] outPut(Node node) {

        ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] data = null;

        try {
            DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0");
            LSSerializer serializer = impl.createLSSerializer();

            DOMConfiguration domConfiguration = serializer.getDomConfig();
            boolean isSupport = domConfiguration.canSetParameter("format-pretty-print", true);
            if (isSupport) {
                domConfiguration.setParameter("format-pretty-print", true);
            }

            LSOutput output = impl.createLSOutput();
            output.setEncoding("UTF-8");
            byteArrayOutputStream = new ByteArrayOutputStream();
            output.setByteStream(byteArrayOutputStream);
            serializer.write(node, output);
            data = byteArrayOutputStream.toByteArray();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return data;

    }

    /**
     * 截取字符串str中指定字符 strStart、strEnd之间的字符串
     *
     * @return
     */
    public static String subString(String str, String strStart, String strEnd) {

        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);

        /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;
    }

}

