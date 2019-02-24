/**
 * HttpDmsShipgroupNetWsdlApiProduct_updateLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sp;

public class HttpDmsShipgroupNetWsdlApiProduct_updateLocator extends org.apache.axis.client.Service implements com.sp.HttpDmsShipgroupNetWsdlApiProduct_update {

    public HttpDmsShipgroupNetWsdlApiProduct_updateLocator() {
    }


    public HttpDmsShipgroupNetWsdlApiProduct_updateLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HttpDmsShipgroupNetWsdlApiProduct_updateLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HttpDmsShipgroupNetWsdlApiProduct_updatePort
    private java.lang.String HttpDmsShipgroupNetWsdlApiProduct_updatePort_address = "http://_:80/index.php/wsdl/api/product_update";

    public java.lang.String getHttpDmsShipgroupNetWsdlApiProduct_updatePortAddress() {
        return HttpDmsShipgroupNetWsdlApiProduct_updatePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HttpDmsShipgroupNetWsdlApiProduct_updatePortWSDDServiceName = "http://dms.shipgroup.net/wsdl/api/product_updatePort";

    public java.lang.String getHttpDmsShipgroupNetWsdlApiProduct_updatePortWSDDServiceName() {
        return HttpDmsShipgroupNetWsdlApiProduct_updatePortWSDDServiceName;
    }

    public void setHttpDmsShipgroupNetWsdlApiProduct_updatePortWSDDServiceName(java.lang.String name) {
        HttpDmsShipgroupNetWsdlApiProduct_updatePortWSDDServiceName = name;
    }

    public com.sp.HttpDmsShipgroupNetWsdlApiProduct_updatePort_PortType getHttpDmsShipgroupNetWsdlApiProduct_updatePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HttpDmsShipgroupNetWsdlApiProduct_updatePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHttpDmsShipgroupNetWsdlApiProduct_updatePort(endpoint);
    }

    public com.sp.HttpDmsShipgroupNetWsdlApiProduct_updatePort_PortType getHttpDmsShipgroupNetWsdlApiProduct_updatePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sp.HttpDmsShipgroupNetWsdlApiProduct_updateBindingStub _stub = new com.sp.HttpDmsShipgroupNetWsdlApiProduct_updateBindingStub(portAddress, this);
            _stub.setPortName(getHttpDmsShipgroupNetWsdlApiProduct_updatePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHttpDmsShipgroupNetWsdlApiProduct_updatePortEndpointAddress(java.lang.String address) {
        HttpDmsShipgroupNetWsdlApiProduct_updatePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sp.HttpDmsShipgroupNetWsdlApiProduct_updatePort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sp.HttpDmsShipgroupNetWsdlApiProduct_updateBindingStub _stub = new com.sp.HttpDmsShipgroupNetWsdlApiProduct_updateBindingStub(new java.net.URL(HttpDmsShipgroupNetWsdlApiProduct_updatePort_address), this);
                _stub.setPortName(getHttpDmsShipgroupNetWsdlApiProduct_updatePortWSDDServiceName());
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
        if ("http://dms.shipgroup.net/wsdl/api/product_updatePort".equals(inputPortName)) {
            return getHttpDmsShipgroupNetWsdlApiProduct_updatePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:http://dms.shipgroup.net/wsdl/api/product_update", "http://dms.shipgroup.net/wsdl/api/product_update");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:http://dms.shipgroup.net/wsdl/api/product_update", "http://dms.shipgroup.net/wsdl/api/product_updatePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HttpDmsShipgroupNetWsdlApiProduct_updatePort".equals(portName)) {
            setHttpDmsShipgroupNetWsdlApiProduct_updatePortEndpointAddress(address);
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
