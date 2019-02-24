/**
 * HttpDmsShipgroupNetWsdlApiOrder_updateLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sp2;

public class HttpDmsShipgroupNetWsdlApiOrder_updateLocator extends org.apache.axis.client.Service implements com.sp2.HttpDmsShipgroupNetWsdlApiOrder_update {

    public HttpDmsShipgroupNetWsdlApiOrder_updateLocator() {
    }


    public HttpDmsShipgroupNetWsdlApiOrder_updateLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HttpDmsShipgroupNetWsdlApiOrder_updateLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HttpDmsShipgroupNetWsdlApiOrder_updatePort
    private java.lang.String HttpDmsShipgroupNetWsdlApiOrder_updatePort_address = "http://_:80/index.php/wsdl/api/order_update";

    public java.lang.String getHttpDmsShipgroupNetWsdlApiOrder_updatePortAddress() {
        return HttpDmsShipgroupNetWsdlApiOrder_updatePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HttpDmsShipgroupNetWsdlApiOrder_updatePortWSDDServiceName = "http://dms.shipgroup.net/wsdl/api/order_updatePort";

    public java.lang.String getHttpDmsShipgroupNetWsdlApiOrder_updatePortWSDDServiceName() {
        return HttpDmsShipgroupNetWsdlApiOrder_updatePortWSDDServiceName;
    }

    public void setHttpDmsShipgroupNetWsdlApiOrder_updatePortWSDDServiceName(java.lang.String name) {
        HttpDmsShipgroupNetWsdlApiOrder_updatePortWSDDServiceName = name;
    }

    public com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType getHttpDmsShipgroupNetWsdlApiOrder_updatePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HttpDmsShipgroupNetWsdlApiOrder_updatePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHttpDmsShipgroupNetWsdlApiOrder_updatePort(endpoint);
    }

    public com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType getHttpDmsShipgroupNetWsdlApiOrder_updatePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updateBindingStub _stub = new com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updateBindingStub(portAddress, this);
            _stub.setPortName(getHttpDmsShipgroupNetWsdlApiOrder_updatePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHttpDmsShipgroupNetWsdlApiOrder_updatePortEndpointAddress(java.lang.String address) {
        HttpDmsShipgroupNetWsdlApiOrder_updatePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updateBindingStub _stub = new com.sp2.HttpDmsShipgroupNetWsdlApiOrder_updateBindingStub(new java.net.URL(HttpDmsShipgroupNetWsdlApiOrder_updatePort_address), this);
                _stub.setPortName(getHttpDmsShipgroupNetWsdlApiOrder_updatePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("http://dms.shipgroup.net/wsdl/api/order_updatePort".equals(inputPortName)) {
            return getHttpDmsShipgroupNetWsdlApiOrder_updatePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:http://dms.shipgroup.net/wsdl/api/order_update", "http://dms.shipgroup.net/wsdl/api/order_update");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:http://dms.shipgroup.net/wsdl/api/order_update", "http://dms.shipgroup.net/wsdl/api/order_updatePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HttpDmsShipgroupNetWsdlApiOrder_updatePort".equals(portName)) {
            setHttpDmsShipgroupNetWsdlApiOrder_updatePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
