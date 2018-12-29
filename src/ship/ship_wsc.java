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
import com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_updateLocator;
import com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_PortType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "ship_wsc",targetNamespace = "http://ship")
public class ship_wsc {
    static final String USERNAME = "admin@shipgroup.net.partial";
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
                     //产品价格
                    case "upsertProductPrice":
                        response = soap.upsertProductPrice(request_body);
                    //出货单
                    case "upsertShipment":
                        response = soap.upsertShipment(request_body);
                     //销退单
                    case "upsertReturnOrder":
                        response = soap.upsertReturnOrder(request_body);
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
            }




        }else if(api_from.equals("sp"))
        {
            try {
                HttpYzEctestQjcloudsComWsdlApiProduct_updateLocator sp_locator = new HttpYzEctestQjcloudsComWsdlApiProduct_updateLocator();
                HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_PortType sp_wsc = sp_locator.getHttpYzEctestQjcloudsComWsdlApiProduct_updatePort();
                switch (api_name.toString())
                {
                    //产品
                    case "upsertProduct":
                        response = sp_wsc.product_update(request_body);
                        break;
                    //产品价格
                    case "upsertProductPrice":
                        response = sp_wsc.product_price_update(request_body);
                        break;
                    default:
                        //...;
                        break;
                }
            } catch ( javax.xml.rpc.ServiceException  e1) {
                e1.printStackTrace();
            }
            catch (java.rmi.RemoteException e2)
            {
                e2.printStackTrace();
            }
        }
        else
        {
            return "";
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

