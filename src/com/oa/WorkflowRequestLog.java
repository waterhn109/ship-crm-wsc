
package com.oa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WorkflowRequestLog complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="WorkflowRequestLog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agentor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="agentorDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annexDocHtmls" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nodeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operateDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receivedPersons" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remarkSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signDocHtmls" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signWorkFlowHtmls" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowRequestLog", propOrder = {
    "agentor",
    "agentorDept",
    "annexDocHtmls",
    "id",
    "nodeId",
    "nodeName",
    "operateDate",
    "operateTime",
    "operateType",
    "operatorDept",
    "operatorId",
    "operatorName",
    "operatorSign",
    "receivedPersons",
    "remark",
    "remarkSign",
    "signDocHtmls",
    "signWorkFlowHtmls"
})
public class WorkflowRequestLog {

    @XmlElementRef(name = "agentor", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> agentor;
    @XmlElementRef(name = "agentorDept", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> agentorDept;
    @XmlElementRef(name = "annexDocHtmls", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> annexDocHtmls;
    @XmlElementRef(name = "id", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> id;
    @XmlElementRef(name = "nodeId", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nodeId;
    @XmlElementRef(name = "nodeName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nodeName;
    @XmlElementRef(name = "operateDate", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operateDate;
    @XmlElementRef(name = "operateTime", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operateTime;
    @XmlElementRef(name = "operateType", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operateType;
    @XmlElementRef(name = "operatorDept", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operatorDept;
    @XmlElementRef(name = "operatorId", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operatorId;
    @XmlElementRef(name = "operatorName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operatorName;
    @XmlElementRef(name = "operatorSign", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operatorSign;
    @XmlElementRef(name = "receivedPersons", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receivedPersons;
    @XmlElementRef(name = "remark", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remark;
    @XmlElementRef(name = "remarkSign", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remarkSign;
    @XmlElementRef(name = "signDocHtmls", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signDocHtmls;
    @XmlElementRef(name = "signWorkFlowHtmls", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signWorkFlowHtmls;

    /**
     * ��ȡagentor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAgentor() {
        return agentor;
    }

    /**
     * ����agentor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAgentor(JAXBElement<String> value) {
        this.agentor = value;
    }

    /**
     * ��ȡagentorDept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAgentorDept() {
        return agentorDept;
    }

    /**
     * ����agentorDept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAgentorDept(JAXBElement<String> value) {
        this.agentorDept = value;
    }

    /**
     * ��ȡannexDocHtmls���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAnnexDocHtmls() {
        return annexDocHtmls;
    }

    /**
     * ����annexDocHtmls���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAnnexDocHtmls(JAXBElement<String> value) {
        this.annexDocHtmls = value;
    }

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setId(JAXBElement<String> value) {
        this.id = value;
    }

    /**
     * ��ȡnodeId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNodeId() {
        return nodeId;
    }

    /**
     * ����nodeId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNodeId(JAXBElement<String> value) {
        this.nodeId = value;
    }

    /**
     * ��ȡnodeName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNodeName() {
        return nodeName;
    }

    /**
     * ����nodeName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNodeName(JAXBElement<String> value) {
        this.nodeName = value;
    }

    /**
     * ��ȡoperateDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperateDate() {
        return operateDate;
    }

    /**
     * ����operateDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperateDate(JAXBElement<String> value) {
        this.operateDate = value;
    }

    /**
     * ��ȡoperateTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperateTime() {
        return operateTime;
    }

    /**
     * ����operateTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperateTime(JAXBElement<String> value) {
        this.operateTime = value;
    }

    /**
     * ��ȡoperateType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperateType() {
        return operateType;
    }

    /**
     * ����operateType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperateType(JAXBElement<String> value) {
        this.operateType = value;
    }

    /**
     * ��ȡoperatorDept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperatorDept() {
        return operatorDept;
    }

    /**
     * ����operatorDept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperatorDept(JAXBElement<String> value) {
        this.operatorDept = value;
    }

    /**
     * ��ȡoperatorId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperatorId() {
        return operatorId;
    }

    /**
     * ����operatorId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperatorId(JAXBElement<String> value) {
        this.operatorId = value;
    }

    /**
     * ��ȡoperatorName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperatorName() {
        return operatorName;
    }

    /**
     * ����operatorName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperatorName(JAXBElement<String> value) {
        this.operatorName = value;
    }

    /**
     * ��ȡoperatorSign���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperatorSign() {
        return operatorSign;
    }

    /**
     * ����operatorSign���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperatorSign(JAXBElement<String> value) {
        this.operatorSign = value;
    }

    /**
     * ��ȡreceivedPersons���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceivedPersons() {
        return receivedPersons;
    }

    /**
     * ����receivedPersons���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceivedPersons(JAXBElement<String> value) {
        this.receivedPersons = value;
    }

    /**
     * ��ȡremark���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemark() {
        return remark;
    }

    /**
     * ����remark���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemark(JAXBElement<String> value) {
        this.remark = value;
    }

    /**
     * ��ȡremarkSign���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemarkSign() {
        return remarkSign;
    }

    /**
     * ����remarkSign���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemarkSign(JAXBElement<String> value) {
        this.remarkSign = value;
    }

    /**
     * ��ȡsignDocHtmls���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSignDocHtmls() {
        return signDocHtmls;
    }

    /**
     * ����signDocHtmls���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSignDocHtmls(JAXBElement<String> value) {
        this.signDocHtmls = value;
    }

    /**
     * ��ȡsignWorkFlowHtmls���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSignWorkFlowHtmls() {
        return signWorkFlowHtmls;
    }

    /**
     * ����signWorkFlowHtmls���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSignWorkFlowHtmls(JAXBElement<String> value) {
        this.signWorkFlowHtmls = value;
    }

}
