package ship;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.DeleteResult;
       import com.sforce.soap.enterprise.EnterpriseConnection;
      import com.sforce.soap.enterprise.Error;
         import com.sforce.soap.enterprise.QueryResult;
       import com.sforce.soap.enterprise.SaveResult;
       import com.sforce.soap.enterprise.sobject.Account;
       import com.sforce.soap.enterprise.sobject.Contact;
       import com.sforce.ws.ConnectionException;
       import com.sforce.ws.ConnectorConfig;
import com.sp.HttpDmsShipgroupNetWsdlApiProduct_updateLocator;
import com.sp.HttpDmsShipgroupNetWsdlApiProduct_updatePort_PortType;
import com.sp1.HttpDmsShipgroupNetWsdlApiCustomer_updateLocator;
import com.sp1.HttpDmsShipgroupNetWsdlApiCustomer_updatePort_PortType;
import com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updateLocator;
import com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "ship_wsc",targetNamespace = "http://ship")
public class ship_wsc {
  //  static final String USERNAME = "admin@shipgroup.net.partial";
    static final String USERNAME = "admin@shipgroup.net";
    static final String PASSWORD = "ship1246";
    static EnterpriseConnection connection;

    //public String request  (String request_body,String application ,String from) {
    @WebMethod
    public String send_request  (@WebParam(name = "request_body",targetNamespace="http://ship") String request_text) {
        String[] strings = request_text.split("@@jcc@@");
        if (strings.length != 4) { return  "";}
        String request_bodyb = strings[0].toString();
        String api_name = strings[1].toString();
        String api_from = strings[2].toString();
        String request_bodye = strings[3].toString();
        String request_body = request_bodyb+request_bodye;
        request_body = request_body.replace("\\\"","\"");
        request_body = request_body.replaceAll("\r|\n","");
        String response = "<Response><Execution><Status code=\\\"-1\\\" sqlcode=\\\"1\\\" description=\\\"没有收到返回值\\\" /></Execution></Response>";
        if(api_from.equals("sf"))
        {
            ConnectorConfig config = new ConnectorConfig();
            config.setUsername(USERNAME);
            config.setPassword(PASSWORD);
            // config.setTraceMessage(true);
            try {

                connection = Connector.newConnection(config);

                // display some current settings
                System.out.println("Auth EndPoint: " + config.getAuthEndpoint());
                System.out.println("Service EndPoint: "
                        + config.getServiceEndpoint());
                System.out.println("Username: " + config.getUsername());
                System.out.println("SessionId: " + config.getSessionId());

                System.out.println("**********************************");

                com.sforce.soap.ERPServiceInterface.SoapConnection soap =    com.sforce.soap.ERPServiceInterface.Connector.newConnection("","");
                soap.setSessionHeader(config.getSessionId());

                switch (api_name.toString())
                {
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
                response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e1.getLocalizedMessage()+"\" /></Execution></Response>";
            }




        }else if(api_from.equals("sp"))
        {


                switch (api_name.toString())
                {
                    //产品
                    case "upsertProduct":
                        try {
                            HttpDmsShipgroupNetWsdlApiProduct_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiProduct_updateLocator();
                            HttpDmsShipgroupNetWsdlApiProduct_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiProduct_updatePort();
                        response = sp_wsc.product_update(request_body);
                            break;
                        } catch ( javax.xml.rpc.ServiceException  e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e1.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        catch (java.rmi.RemoteException e2)
                        {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e2.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        break;
                    //产品价格
                    case "upsertProductPrice":
                        try {
                            HttpDmsShipgroupNetWsdlApiProduct_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiProduct_updateLocator();
                            HttpDmsShipgroupNetWsdlApiProduct_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiProduct_updatePort();
                            response = sp_wsc.product_price_update(request_body);
                            break;
                        } catch ( javax.xml.rpc.ServiceException  e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e1.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        catch (java.rmi.RemoteException e2)
                        {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e2.getLocalizedMessage()+"\" /></Execution></Response>";
                        }

                        break;
                    //客户
                    case "upsertAccount":
                        try {
                            HttpDmsShipgroupNetWsdlApiCustomer_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiCustomer_updateLocator();
                            HttpDmsShipgroupNetWsdlApiCustomer_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiCustomer_updatePort();
                            response = sp_wsc.customer_update(request_body);
                            break;
                        } catch ( javax.xml.rpc.ServiceException  e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e1.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        catch (java.rmi.RemoteException e2)
                        {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e2.getLocalizedMessage()+"\" /></Execution></Response>";
                        }

                        break;
                    //订单
                    case "upsertOrder":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_update(request_body);
                            break;
                        } catch ( javax.xml.rpc.ServiceException  e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e1.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        catch (java.rmi.RemoteException e2)
                        {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e2.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        break;

                    //出货单新增
                    case "upsertShipmentadd":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_delivery_add(request_body);
                            break;
                        } catch ( javax.xml.rpc.ServiceException  e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e1.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        catch (java.rmi.RemoteException e2)
                        {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e2.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        break;

                        //出货单删除或者修改
                    case "upsertShipment":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_delivery_update(request_body);
                            break;
                        } catch ( javax.xml.rpc.ServiceException  e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e1.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        catch (java.rmi.RemoteException e2)
                        {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e2.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        break;
                    //销退单新增
                    case "upsertReturnOrderadd":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_refund_add(request_body);
                            break;
                        } catch ( javax.xml.rpc.ServiceException  e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e1.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        catch (java.rmi.RemoteException e2)
                        {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e2.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        break;
                        //销退单删除或者修改
                    case "upsertReturnOrder":
                        try {
                            HttpDmsShipgroupNetWsdlApiOrder_updateLocator sp_locator = new HttpDmsShipgroupNetWsdlApiOrder_updateLocator();
                            HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType sp_wsc = sp_locator.getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
                            response = sp_wsc.order_refund_update(request_body);
                            break;
                        } catch ( javax.xml.rpc.ServiceException  e1) {
                            e1.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e1.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        catch (java.rmi.RemoteException e2)
                        {
                            e2.printStackTrace();
                            response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\""+e2.getLocalizedMessage()+"\" /></Execution></Response>";
                        }
                        break;
                    default:
                        //...;
                        break;
                }

        }
        else
        {
            return response;
        }

       System.out.println(response);

      //  response.replace("\n","");
       // response = "<Response><Execution><Status code=\"-1\" sqlcode=\"1\" description=\"参数 bn 不能为空\" /></Execution></Response>";

        response = response.replace("\\\"","\"");
        response = response.replaceAll("\r|\n","");
        response = response.replace("<![CDATA[","");
        response = response.replace("]]>","");
        response = response.replace("&lt;", '<' + "");
        response = "<![CDATA["+response+"]]>";
        return response;
    }
}

