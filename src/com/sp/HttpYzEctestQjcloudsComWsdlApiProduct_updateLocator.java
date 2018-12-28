/**
 * HttpYzEctestQjcloudsComWsdlApiProduct_updateLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sp;

public class HttpYzEctestQjcloudsComWsdlApiProduct_updateLocator extends org.apache.axis.client.Service implements com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_update {

    public HttpYzEctestQjcloudsComWsdlApiProduct_updateLocator() {
    }


    public HttpYzEctestQjcloudsComWsdlApiProduct_updateLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HttpYzEctestQjcloudsComWsdlApiProduct_updateLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HttpYzEctestQjcloudsComWsdlApiProduct_updatePort
    private java.lang.String HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_address = "http://yz.ectest.qjclouds.com:80/index.php/wsdl/api/product_update";

    public java.lang.String getHttpYzEctestQjcloudsComWsdlApiProduct_updatePortAddress() {
        return HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HttpYzEctestQjcloudsComWsdlApiProduct_updatePortWSDDServiceName = "http://yz.ectest.qjclouds.com/wsdl/api/product_updatePort";

    public java.lang.String getHttpYzEctestQjcloudsComWsdlApiProduct_updatePortWSDDServiceName() {
        return HttpYzEctestQjcloudsComWsdlApiProduct_updatePortWSDDServiceName;
    }

    public void setHttpYzEctestQjcloudsComWsdlApiProduct_updatePortWSDDServiceName(java.lang.String name) {
        HttpYzEctestQjcloudsComWsdlApiProduct_updatePortWSDDServiceName = name;
    }

    public com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_PortType getHttpYzEctestQjcloudsComWsdlApiProduct_updatePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHttpYzEctestQjcloudsComWsdlApiProduct_updatePort(endpoint);
    }

    public com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_PortType getHttpYzEctestQjcloudsComWsdlApiProduct_updatePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_updateBindingStub _stub = new com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_updateBindingStub(portAddress, this);
            _stub.setPortName(getHttpYzEctestQjcloudsComWsdlApiProduct_updatePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHttpYzEctestQjcloudsComWsdlApiProduct_updatePortEndpointAddress(java.lang.String address) {
        HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_updateBindingStub _stub = new com.sp.HttpYzEctestQjcloudsComWsdlApiProduct_updateBindingStub(new java.net.URL(HttpYzEctestQjcloudsComWsdlApiProduct_updatePort_address), this);
                _stub.setPortName(getHttpYzEctestQjcloudsComWsdlApiProduct_updatePortWSDDServiceName());
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
        if ("http://yz.ectest.qjclouds.com/wsdl/api/product_updatePort".equals(inputPortName)) {
            return getHttpYzEctestQjcloudsComWsdlApiProduct_updatePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:http://yz.ectest.qjclouds.com/wsdl/api/product_update", "http://yz.ectest.qjclouds.com/wsdl/api/product_update");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:http://yz.ectest.qjclouds.com/wsdl/api/product_update", "http://yz.ectest.qjclouds.com/wsdl/api/product_updatePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HttpYzEctestQjcloudsComWsdlApiProduct_updatePort".equals(portName)) {
            setHttpYzEctestQjcloudsComWsdlApiProduct_updatePortEndpointAddress(address);
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
