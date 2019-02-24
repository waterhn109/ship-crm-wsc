/**
 * HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sp2;

public interface HttpDmsShipgroupNetWsdlApiOrder_updatePort_PortType extends java.rmi.Remote {
    public java.lang.String order_update(java.lang.String postXml) throws java.rmi.RemoteException;
    public java.lang.String order_delivery_add(java.lang.String postXml) throws java.rmi.RemoteException;
    public java.lang.String order_delivery_update(java.lang.String postXml) throws java.rmi.RemoteException;
    public java.lang.String order_delivery_delete(java.lang.String postXml) throws java.rmi.RemoteException;
    public java.lang.String order_refund_add(java.lang.String postXml) throws java.rmi.RemoteException;
    public java.lang.String order_refund_update(java.lang.String postXml) throws java.rmi.RemoteException;
    public java.lang.String order_refund_delete(java.lang.String postXml) throws java.rmi.RemoteException;
}
